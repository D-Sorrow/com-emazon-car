package com.emazon.car.adapters.driven.jpa.mysql.repository;

import com.emazon.car.adapters.driven.jpa.mysql.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<CarEntity, Long> {

    CarEntity findByUserEmail(String email);

}
