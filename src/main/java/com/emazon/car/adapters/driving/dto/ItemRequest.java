package com.emazon.car.adapters.driving.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

    @NonNull
    @NotEmpty
    private Long articleId;

    @NonNull
    @NotEmpty
    private Integer quantity;
}
