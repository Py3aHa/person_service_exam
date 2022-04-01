package ru.exam.ruzana.service;

import ru.exam.ruzana.dto.PurchasesDto;
import ru.exam.ruzana.dto.StorageDto;

import java.util.List;

public interface PurchasesService extends BasicCRUDService<PurchasesDto>{
    List<PurchasesDto> getByPersonId(Long id);

    List<PurchasesDto> getByItemId(Long id);

    List<PurchasesDto> getByPersonAndItemIds(Long personId, Long itemId);

    String buyStorage(StorageDto storageDto);
}
