package ru.exam.ruzana.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.exam.ruzana.dto.PurchasesDto;
import ru.exam.ruzana.dto.StorageDto;
import ru.exam.ruzana.model.Purchases;
import ru.exam.ruzana.model.TotalPurchases;
import ru.exam.ruzana.repository.PurchasesRepository;
import ru.exam.ruzana.repository.StorageDtoRepository;
import ru.exam.ruzana.repository.TotalPurchasesRepository;
import ru.exam.ruzana.service.PurchasesService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchasesServiceImpl implements PurchasesService {
    @Autowired
    private PurchasesRepository purchasesRepository;

    @Autowired
    private StorageDtoRepository storageDtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TotalPurchasesRepository totalPurchasesRepository;

    @Scheduled(fixedRate = 86400000)
    public void addToDatabase(){
        int total = purchasesRepository.sum();
        TotalPurchases totalPurchases = new TotalPurchases(null, total, LocalDateTime.now());
        totalPurchasesRepository.insert(totalPurchases);
    }

    @Override
    public void save(PurchasesDto object) {
        Purchases purchases = modelMapper.map(object, Purchases.class);
        purchases.setActive(true);
        purchases.setCreatedAt(LocalDateTime.now());
        purchases.setUpdatedAt(LocalDateTime.now());
        purchasesRepository.insertPurchase(purchases);
    }

    @Override
    public PurchasesDto findById(Long id) {
        Purchases purchases = purchasesRepository.findById(id);
        return modelMapper.map(purchases, PurchasesDto.class);
    }

    @Override
    public List<PurchasesDto> findAll() {
        List<Purchases> purchases = purchasesRepository.findAll();
        List<PurchasesDto> purchasesDtos = purchases.stream()
                .map(item -> modelMapper.map(item, PurchasesDto.class))
                .collect(Collectors.toList());
        return purchasesDtos;
    }

    @Override
    public void update(PurchasesDto object) {
        Purchases purchase = modelMapper.map(object, Purchases.class);
        purchase.setUpdatedAt(LocalDateTime.now());
        purchasesRepository.updatePurchase(purchase);
    }

    @Override
    public void delete(Long id) {
        Purchases purchases = purchasesRepository.findById(id);
        purchases.setActive(false);
        purchases.setUpdatedAt(LocalDateTime.now());
        purchasesRepository.deletePurchase(purchases);
    }

    @Override
    public List<PurchasesDto> getByPersonId(Long id) {
        List<Purchases> purchases = purchasesRepository.findByPersonId(id);
        List<PurchasesDto> purchasesDtos = purchases.stream()
                .map(item -> modelMapper.map(item, PurchasesDto.class))
                .collect(Collectors.toList());
        return purchasesDtos;
    }

    @Override
    public List<PurchasesDto> getByItemId(Long id) {
        List<Purchases> purchases = purchasesRepository.findByItemId(id);
        List<PurchasesDto> purchasesDtos = purchases.stream()
                .map(item -> modelMapper.map(item, PurchasesDto.class))
                .collect(Collectors.toList());
        return purchasesDtos;
    }

    @Override
    public List<PurchasesDto> getByPersonAndItemIds(Long personId, Long itemId) {
        List<Purchases> purchases = purchasesRepository.findByPersonAndItem(personId, itemId);
        List<PurchasesDto> purchasesDtos = purchases.stream()
                .map(item -> modelMapper.map(item, PurchasesDto.class))
                .collect(Collectors.toList());
        return purchasesDtos;
    }

    @Override
    public String buyStorage(StorageDto storageDto) {
        StorageDto storage = storageDtoRepository.findByNameAndCategoryIdAndProducerId(storageDto.getName(), storageDto.getCategoryId(), storageDto.getProducerId());
        if(storage == null){
            return "Product was not found";
        } else{
            int new_count = storage.getQuantity() - storageDto.getQuantity();
            if(new_count < 0) return "There are not enough items in storage to buy";
            else{
                storageDtoRepository.buyStorage(storage.getId(), new_count);
            }
        }
        return null;
    }


}
