package com.emazon.car.domain.spi;

public interface IValidationStockPort {

    Boolean validateStock(Long articleId, Integer quantity);

    Boolean validationLimitCategory(Long articleId);
}
