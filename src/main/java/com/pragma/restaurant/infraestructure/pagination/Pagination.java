package com.pragma.restaurant.infraestructure.pagination;

import com.pragma.restaurant.application.dto.response.ResponsePagedDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class Pagination<T> {
    public ResponsePagedDto<T> paginate(int page, Page<T> objectDto) {

        ResponsePagedDto<T> responsePagedDto;
        responsePagedDto = new ResponsePagedDto<>();

        responsePagedDto.setResult(objectDto.getContent());
        responsePagedDto.setCurrentPage(page);
        responsePagedDto.setTotalPages(objectDto.getTotalPages());
        responsePagedDto.setTotalItems(objectDto.getTotalElements());
        responsePagedDto.setRecords(objectDto.getContent().size());

        return responsePagedDto;
    }
}
