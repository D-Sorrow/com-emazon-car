package com.emazon.car.configuration;

import com.emazon.car.adapters.driven.feign.IFeignClientStock;
import com.emazon.car.adapters.driven.feign.IFeignClientTransaction;
import com.emazon.car.adapters.driven.feign.adapters.TransactionAdapter;
import com.emazon.car.adapters.driven.feign.adapters.ValidationStockAdapter;
import com.emazon.car.adapters.driven.jpa.mysql.adapter.CarAdapter;
import com.emazon.car.adapters.driven.jpa.mysql.mapper.ICarEntityMapper;
import com.emazon.car.adapters.driven.jpa.mysql.mapper.IItemEntityMapper;
import com.emazon.car.adapters.driven.jpa.mysql.repository.ICarRepository;
import com.emazon.car.configuration.security.AuthenticatedUserManager;
import com.emazon.car.domain.api.ICarServicePort;
import com.emazon.car.domain.api.usecase.CarUseCase;
import com.emazon.car.domain.spi.IAuthenticationManager;
import com.emazon.car.domain.spi.ICarPersistencePort;
import com.emazon.car.domain.spi.ITransactionDatePort;
import com.emazon.car.domain.spi.IValidationStockPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICarEntityMapper itemEntityMapper;
    private final IItemEntityMapper itemMapper;
    private final ICarRepository itemRepository;
    private final  IFeignClientStock feignClient;
    private final IFeignClientTransaction feignClientTransaction;

    @Bean
    public IAuthenticationManager authenticationManager() {
        return new AuthenticatedUserManager();
    }

    @Bean
    public ICarPersistencePort itemPersistencePort() {
        return new CarAdapter(itemEntityMapper,itemMapper, itemRepository);
    }

    @Bean
    public IValidationStockPort validationStockPort() {
        return new ValidationStockAdapter(feignClient);
    }

    @Bean
    public ITransactionDatePort transactionDatePort() {
        return new TransactionAdapter(feignClientTransaction);
    }

    @Bean
    public ICarServicePort itemServicePort() {
        return new CarUseCase(itemPersistencePort(), validationStockPort(),transactionDatePort(), authenticationManager());
    }
}
