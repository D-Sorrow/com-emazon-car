package com.emazon.car.adapters.driving.controller;

import com.emazon.car.adapters.driving.dto.ItemRequest;
import com.emazon.car.adapters.driving.mapper.IItemRequestMapper;
import com.emazon.car.domain.api.ICarServicePort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {

    private final ICarServicePort itemService;
    private final IItemRequestMapper itemRequestMapper;


    @PostMapping("/addItemToCar")
    public ResponseEntity<Void> addItemToCar (@RequestBody ItemRequest itemRequest){
        itemService.addItem(itemRequestMapper.toItem(itemRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
