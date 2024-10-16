package com.emazon.car.domain.exception;

public class NotStockEnoughException extends RuntimeException {
    public NotStockEnoughException(String message) {
        super(message);
    }
}
