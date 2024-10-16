package com.emazon.car.domain.spi;

import java.time.LocalDateTime;
import java.util.Date;

public interface ITransactionDatePort {

    Date dateToUpdateStock(Long articleId);
}
