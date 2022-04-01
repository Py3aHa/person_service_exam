package ru.exam.ruzana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasesDto {
    private Long personId;

    private Long itemId;

    private int quantity;

    private int pricePerUnit;

    private boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
