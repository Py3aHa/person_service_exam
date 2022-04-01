package ru.exam.ruzana.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchases {
    private Long id;

    private Long personId;

    private Long itemId;

    private int quantity;

    private int pricePerUnit;

    private boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
