package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.AssingOrdersDto;
import com.pragma.restaurant.application.dto.request.Dishes_OrdersRequestDto;
import com.pragma.restaurant.application.dto.request.OrdersRequestDto;
import com.pragma.restaurant.application.dto.request.OrdersUpdateRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.application.dto.response.ResponsePagedDto;
import com.pragma.restaurant.application.dto.response.Restaurant_EmployeeResponseDto;
import com.pragma.restaurant.application.dto.response.dishes.DishesResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsOwnerResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsResponseDto;
import com.pragma.restaurant.application.handler.*;
import com.pragma.restaurant.infraestructure.exception.NoValidNumber;
import com.pragma.restaurant.infraestructure.output.response.Response;
import com.pragma.restaurant.infraestructure.pagination.Pagination;
import com.pragma.restaurant.infraestructure.utilities.IUtilities;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2/v1/orders")
@RequiredArgsConstructor
@Api(value = "Orders Actions")
public class OrdersRestController {
    private final IDishesHandler dishesHandler;
    private final IDishes_OrdersHandler dishesOrdersHandler;
    private final IOrdersHandler ordersHandler;
    private final IRestaurantsHandler restaurantsHandler;
    private final IRestaurant_EmployeeHandler restaurant_employeeHandler;
    private IUtilities utilities;

    private final Pagination<OrdersResponseDto> pagination;

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
    @GetMapping("/{page}/{records}/{id_restaurant}/{status}")
    public ResponseEntity<ResponsePagedDto<OrdersResponseDto>> getAllOrders(@ApiParam(value = "require an int for specified the page thats needs ", required = true) @PathVariable("page") int page,
                                                                            @ApiParam(value = "require an int for specified the number of records per page", required = true) @PathVariable("records") int records,
                                                                            @ApiParam(value = "require an string for specified the restaurant for filter", required = true) @PathVariable("id_restaurant") Long id_restaurant,
                                                                            @ApiParam(value = "require an string for specified the filter to applied", required = true) @PathVariable("status") String status,
                                                                            @RequestHeader(value="Authorization") String authorization) {

        if(!utilities.getRol(authorization).equals("EMPLEADO")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserResponseDto user = dishesHandler.getUserByEmail(utilities.getEmail(authorization), authorization);

        Restaurant_EmployeeResponseDto restaurant_EmployeeResponseDto = restaurant_employeeHandler.getRestaurant_EmployeeById_Person(user.getId(), id_restaurant);

        if(restaurant_EmployeeResponseDto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Page<OrdersResponseDto> ordersDto = ordersHandler.getAllOrders(page, records, status);

        ResponsePagedDto<OrdersResponseDto> responsePagedDto = pagination.paginate(page, ordersDto);

        return ResponseEntity.ok(responsePagedDto);
    }

    @ApiOperation(value = "Get an order by client and status en_preparacion, pendiente or listo", response = OrdersResponseDto.class)
    @GetMapping("/orderbyclient/{id}")
    public ResponseEntity<List<OrdersResponseDto>> getOrdersByClientAndStatus(@ApiParam(value = "id to search for a Order pendiente", required = true)
                                                                              @PathVariable("id") Long id) {
        return ResponseEntity.ok(ordersHandler.getOrdersByClientAndStatus(id));
    }

    @ApiOperation(value = "Get an order by id", response = OrdersResponseDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<OrdersResponseDto> getOrdersById(@ApiParam(value = "id to search for a Order", required = true)
                                                                              @PathVariable("id") Long id) {
        return ResponseEntity.ok(ordersHandler.getOrdersById(id));
    }

    @ApiOperation(value = "assingOrders to a employee", response = OrdersResponseDto.class)
    @PutMapping("/assingOrders")
    public ResponseEntity<Response> assingOrders(@ApiParam(value = "dto with the id's to assing", required = true)
                                             @RequestBody List<AssingOrdersDto> assingOrdersDto,
                                             @RequestHeader(value="Authorization") String authorization) {

        if(!utilities.getRol(authorization).equals("EMPLEADO")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserResponseDto user = dishesHandler.getUserByEmail(utilities.getEmail(authorization), authorization);

        if(user==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El Usuario no existe"));
        }

        Restaurant_EmployeeResponseDto restaurant_EmployeeResponseDto =  restaurant_employeeHandler.getRestaurant_EmployeeById(user.getId());

        if(restaurant_EmployeeResponseDto==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El usuario no existe como empleado"));
        }

        System.out.println(restaurant_EmployeeResponseDto.getId_restaurant());

        for(AssingOrdersDto assingOrder: assingOrdersDto){
            OrdersResponseDto ordersResponseDto = ordersHandler.getOrdersById(assingOrder.getId_order());

            if(ordersResponseDto==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El pedido " + assingOrder.getId_order() + " no existe"));
            }else if(ordersResponseDto.getId_restaurant()!=restaurant_EmployeeResponseDto.getId_restaurant()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El pedido no pertenece a su restaurante"));
            }else{
                OrdersUpdateRequestDto ordersUpdateRequestDto = new OrdersUpdateRequestDto();
                ordersUpdateRequestDto.setId(ordersResponseDto.getId());
                ordersUpdateRequestDto.setStatus(ordersResponseDto.getStatus());
                ordersUpdateRequestDto.setDate(ordersResponseDto.getDate());
                ordersUpdateRequestDto.setId_chef(user.getId());
                ordersUpdateRequestDto.setId_restaurant(ordersResponseDto.getId_restaurant());
                ordersUpdateRequestDto.setId_client(ordersResponseDto.getId_client());
                ordersHandler.updateOrders(ordersUpdateRequestDto);
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "change the status to a Order", response = OrdersResponseDto.class)
    @PutMapping("/changeStatus/{id}/{status}/{pin}")
    public ResponseEntity<Response> changeStatus(@ApiParam(value = "id of the order", required = true) @PathVariable("id") Long id,
                                                 @ApiParam(value = "status to set to the order", required = true) @PathVariable("status") String status,
                                                 @ApiParam(value = "security pin to authorice the change of the status", required = true) @PathVariable("pin") String pin,
                                                 @RequestHeader(value="Authorization") String authorization) {

        if(!utilities.getRol(authorization).equals("EMPLEADO") &&
           !utilities.getRol(authorization).equals("CLIENTE")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserResponseDto user = dishesHandler.getUserByEmail(utilities.getEmail(authorization), authorization);

        if(user==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El Usuario no existe"));
        }

        OrdersResponseDto ordersResponseDto = ordersHandler.getOrdersById(id);
        OrdersUpdateRequestDto ordersUpdateRequestDto = new OrdersUpdateRequestDto();
        ordersUpdateRequestDto.setId(ordersResponseDto.getId());
        ordersUpdateRequestDto.setStatus(ordersResponseDto.getStatus());
        ordersUpdateRequestDto.setDate(ordersResponseDto.getDate());
        ordersUpdateRequestDto.setId_chef(ordersResponseDto.getId_chef());
        ordersUpdateRequestDto.setId_restaurant(ordersResponseDto.getId_restaurant());
        ordersUpdateRequestDto.setId_client(ordersResponseDto.getId_client());

        if(status.equals("entregado") && ordersResponseDto.getStatus().equals("listo")){
            ordersUpdateRequestDto.setStatus(status);
        }else if(status.equals("listo") && ordersResponseDto.getStatus().equals("entregado")){
            ordersUpdateRequestDto.setStatus(status);
        }else if(status.equals("cancelado") && ordersResponseDto.getStatus().equals("pendiente")) {
            ordersUpdateRequestDto.setStatus(status);
        } else if(status.equals("cancelado") && !ordersResponseDto.getStatus().equals("pendiente")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(" Lo sentimos, tu pedido ya está en preparación y no puede cancelarse"));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("El pedido " + id + " tiene estado "
                                                                      + ordersResponseDto.getStatus() + " no puede ser cambiado a " + status));
        }

        ordersHandler.updateOrders(ordersUpdateRequestDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
