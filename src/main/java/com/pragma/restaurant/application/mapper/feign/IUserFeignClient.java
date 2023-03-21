package com.pragma.restaurant.application.mapper.feign;

import com.pragma.restaurant.application.dto.request.feign.UsersRequestDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="UsersFeign", url="localhost:8081/api/v1")
public interface IUserFeignClient {

    @GetMapping(value = "/users/{id}")
    UserResponseDto getUser(@PathVariable("id") Long id,
                            @RequestHeader(value = "Authorization", required = true) String authorization);

    @GetMapping(value = "/users/byEmail/{email}")
    UserResponseDto getUserByEmail(@PathVariable("email") String email,
                            @RequestHeader(value = "Authorization", required = true) String authorization);


    @PostMapping(value = "/users/")
    UserResponseDto saveUser(@RequestBody UsersRequestDto usersRequestDto,
                            @RequestHeader(value = "Authorization", required = true) String authorization);

}
