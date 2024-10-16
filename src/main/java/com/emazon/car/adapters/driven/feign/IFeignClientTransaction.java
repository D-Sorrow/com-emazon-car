package com.emazon.car.adapters.driven.feign;

import com.emazon.car.configuration.feign.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@FeignClient(name = "transaction-api", url = "http://localhost:8082/transaction",configuration = FeignClientConfig.class)
public interface IFeignClientTransaction {

    @GetMapping("/dateToUpdateStock/{articleId}")
    Date dateToUpdateStock(Long articleId);
}