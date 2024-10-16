package com.emazon.car.adapters.driven.jpa.mysql.mapper;

import com.emazon.car.adapters.driven.jpa.mysql.entity.CarEntity;
import com.emazon.car.domain.model.ShoppingCar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICarEntityMapper {

    CarEntity toCarEntity(ShoppingCar shoppingCar);
}
