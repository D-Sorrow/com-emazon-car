package com.emazon.car.adapters.driven.feign.adapters;

import com.emazon.car.adapters.driven.feign.IFeignClientStock;
import com.emazon.car.adapters.driven.feign.IFeignClientTransaction;
import com.emazon.car.domain.spi.ITransactionDatePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
public class TransactionAdapter implements ITransactionDatePort {

    private final IFeignClientTransaction feignClient;

    @Override
    public Date dateToUpdateStock(Long articleId) {
        return feignClient.dateToUpdateStock(articleId);
    }
}
