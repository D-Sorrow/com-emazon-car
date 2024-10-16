package com.emazon.car.adapters.driven.feign;

import com.emazon.car.configuration.feign.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "stock-api", url = "http://localhost:8080/article",configuration = FeignClientConfig.class)
public interface IFeignClientStock {

    @GetMapping("/validStockArticle/{articleId}/{quantity}")
    Boolean validationStock(@PathVariable Long articleId, @PathVariable Integer quantity);

    @GetMapping("/validLimitCategory/{articleId}")
    Boolean validationLimitCategory(@PathVariable Long articleId);
}
