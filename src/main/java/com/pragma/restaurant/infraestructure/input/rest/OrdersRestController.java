package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.Dishes_OrdersRequestDto;
import com.pragma.restaurant.application.dto.request.OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.application.dto.response.dishes.DishesResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsOwnerResponseDto;
import com.pragma.restaurant.application.handler.IDishesHandler;
import com.pragma.restaurant.application.handler.IDishes_OrdersHandler;
import com.pragma.restaurant.application.handler.IOrdersHandler;
import com.pragma.restaurant.application.handler.IRestaurantsHandler;
import com.pragma.restaurant.infraestructure.exception.NoValidNumber;
import com.pragma.restaurant.infraestructure.output.response.Response;
import com.pragma.restaurant.infraestructure.utilities.IUtilities;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2/v1/orders")
@RequiredArgsConstructor
@Api(value = "Orders CRUD")
public class OrdersRestController {

    private final IDishesHandler dishesHandler;

    private final IDishes_OrdersHandler dishesOrdersHandler;
    private final IOrdersHandler ordersHandler;

    private final IRestaurantsHandler restaurantsHandler;

    private IUtilities utilities;
    @Autowired
    public void setUtilities(IUtilities utilities) { this.utilities = utilities;}

    @ApiOperation(value = "Save an Order")
    @PostMapping("/")
    public ResponseEntity<Response> saveOrders(@ApiParam(value = "require a JSON format Object to save an order", required = true)
                                               @RequestBody OrdersRequestDto ordersRequestDto,
                                               @RequestHeader(value="Authorization") String authorization) {

        if(!utilities.getRol(authorization).equals("CLIENTE")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserResponseDto user = dishesHandler.getUserByEmail(utilities.getEmail(authorization), authorization);

        if(user==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El Usuario no existe"));
        }

        UserResponseDto chef = dishesHandler.getUser(ordersRequestDto.getId_chef(), authorization);

        if(chef==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El chef " + ordersRequestDto.getId_chef() + " no existe"));
        }

        UserResponseDto cliente = dishesHandler.getUser(ordersRequestDto.getId_client(), authorization);

        if(cliente==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El cliente " + ordersRequestDto.getId_client() + " no existe"));
        }

        List<OrdersResponseDto> ordersClientResponseDto = ordersHandler.getOrdersByClientAndStatus(ordersRequestDto.getId_client());

        if(ordersClientResponseDto.size()>0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El cliente tiene pedido en estado " + ordersClientResponseDto.get(0).getStatus()));
        }

        RestaurantsOwnerResponseDto restaurant = restaurantsHandler.getRestaurantsOwnerById(ordersRequestDto.getId_restaurant());

        if(restaurant==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El restaurante " + ordersRequestDto.getId_restaurant() + " no existe"));
        }

        if(ordersRequestDto.getDishes_OrdersRequestDto().size() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Para realizar un pedido debe incluir al menos un plato"));
        }

        for(Dishes_OrdersRequestDto dish: ordersRequestDto.getDishes_OrdersRequestDto()){
            DishesResponseDto dishesResponseDto = dishesHandler.getDishesById(dish.getId_dish());

            if(dish.getUnits() == 0){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El plato " + dish.getId_dish() + " tiene 0 unidades"));
            }

            if(dishesResponseDto == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El plato " + dish.getId_dish() + " no existe"));
            }

            if(dishesResponseDto.getId_restaurant() != restaurant.getId()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El plato " + dish.getId_dish() + " no pertenece al resturante"));
            }
        }

        OrdersResponseDto ordersResponseDto = ordersHandler.saveOrders(ordersRequestDto);

        for(Dishes_OrdersRequestDto dish: ordersRequestDto.getDishes_OrdersRequestDto()){
            dish.setId_order(ordersResponseDto.getId());
        }

        dishesOrdersHandler.saveDishes_Orders(ordersRequestDto.getDishes_OrdersRequestDto());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all orders", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<OrdersResponseDto>> getAllOrders() {
        return ResponseEntity.ok(ordersHandler.getAllOrders());
    }

    @ApiOperation(value = "Get an order by client and status en_preparacion, pendiente or listo", response = OrdersResponseDto.class)
    @GetMapping("/orderbyclient/{id}")
    public ResponseEntity<List<OrdersResponseDto>> getOrdersByClientAndStatus(@ApiParam(value = "id to search for a Order pendiente", required = true) @PathVariable("id") Long id) {
        return ResponseEntity.ok(ordersHandler.getOrdersByClientAndStatus(id));
    }

}
