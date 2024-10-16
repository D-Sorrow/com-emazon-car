package com.emazon.car.adapters.driving.mapper;

import com.emazon.car.adapters.driving.dto.ItemRequest;
import com.emazon.car.domain.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IItemRequestMapper {

    public Item toItem(ItemRequest itemRequest);
}
