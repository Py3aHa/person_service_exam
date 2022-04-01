package ru.exam.ruzana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageDto {
    private Long id;

    private String name;

    private int quantity;

    private int pricePerUnit;

    private Long producerId;

    private Long categoryId;
}
