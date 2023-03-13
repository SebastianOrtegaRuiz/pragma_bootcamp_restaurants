package com.pragma.restaurant.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponsePagedDto<T> {
    private List<T> result;
    private int currentPage;
    private Long totalItems;
    private int totalPages;
    private int records;

}
