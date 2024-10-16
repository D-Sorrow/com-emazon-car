package com.emazon.car.adapters.driven.feign.adapters;

import com.emazon.car.adapters.driven.feign.IFeignClientStock;
import com.emazon.car.domain.spi.IValidationStockPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidationStockAdapter implements IValidationStockPort {

    private final IFeignClientStock feignClient;

    @Override
    public Boolean validateStock(Long articleId, Integer quantity) {

        return feignClient.validationStock(articleId, quantity);
    }

    @Override
    public Boolean validationLimitCategory(Long articleId) {
        return feignClient.validationLimitCategory(articleId);
    }
}
