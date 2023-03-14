package com.pragma.restaurant.application.mapper.feign;

import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="UsersFeign", url="localhost:8081/api/v1")
public interface IUserFeignClient {

    @GetMapping(value = "/users/{id}")
    UserResponseDto getUser(@PathVariable("id") Long id,
                            @RequestHeader(value = "Authorization", required = true) String authorization);

}
