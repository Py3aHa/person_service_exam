package ru.exam.ruzana.controller;

import ru.exam.ruzana.dto.PurchasesDto;
import ru.exam.ruzana.dto.StorageDto;

import java.util.List;

public interface PurchasesController {
    void save(PurchasesDto purchasesDto);

    void update(PurchasesDto purchasesDto);

    void delete(Long id);

    PurchasesDto getById(Long id);

    List<PurchasesDto> getAll();

    List<PurchasesDto> getAllByPersonId(Long id);

    List<PurchasesDto> getAllByItemId(Long id);

    List<PurchasesDto> getAllByPersonIdAndItemId(Long personId, Long itemId);

    String buyStorage(StorageDto storageDto);
}
