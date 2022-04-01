package ru.exam.ruzana.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.exam.ruzana.controller.BaseUserDataController;
import ru.exam.ruzana.controller.PurchasesController;
import ru.exam.ruzana.dto.PurchasesDto;
import ru.exam.ruzana.dto.StorageDto;
import ru.exam.ruzana.service.PurchasesService;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchasesControllerImpl extends BaseUserDataController implements PurchasesController {
    @Autowired
    private PurchasesService purchasesService;

    @Override
    @PostMapping(path = "/")
    public void save(@RequestBody PurchasesDto purchasesDto) {
        purchasesService.save(purchasesDto);
    }

    @Override
    @PatchMapping(path = "/")
    public void update(@RequestBody PurchasesDto purchasesDto) {
        purchasesService.update(purchasesDto);
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        purchasesService.delete(id);
    }

    @Override
    @GetMapping(path = "/{id}")
    public PurchasesDto getById(@PathVariable Long id) {
        return purchasesService.findById(id);
    }

    @Override
    @GetMapping(path = "/")
    public List<PurchasesDto> getAll() {
        return purchasesService.findAll();
    }

    @Override
    @GetMapping(path = "/by-person/{id}")
    public List<PurchasesDto> getAllByPersonId(@PathVariable Long id) {
        return purchasesService.getByPersonId(id);
    }

    @Override
    @GetMapping(path = "/by-item/{id}")
    public List<PurchasesDto> getAllByItemId(@PathVariable Long id) {
        return purchasesService.getByItemId(id);
    }

    @Override
    @GetMapping(path = "/by-person-item")
    public List<PurchasesDto> getAllByPersonIdAndItemId(@RequestParam(name = "personId") Long personId, @RequestParam(name = "itemId") Long itemId) {
        return purchasesService.getByPersonAndItemIds(personId, itemId);
    }

    @Override
    @PostMapping(path = "/buy")
    public String buyStorage(@RequestBody StorageDto storageDto) {
        return purchasesService.buyStorage(storageDto);
    }
}
