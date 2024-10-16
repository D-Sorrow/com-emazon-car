package com.emazon.car.adapters.driven.jpa.mysql.mapper;

import com.emazon.car.adapters.driven.jpa.mysql.entity.ItemEntity;
import com.emazon.car.domain.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IItemEntityMapper {

    ItemEntity toItemEntity(Item item);
}
