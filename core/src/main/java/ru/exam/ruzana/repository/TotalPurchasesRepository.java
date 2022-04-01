package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.exam.ruzana.model.TotalPurchases;

@Mapper
public interface TotalPurchasesRepository {
    void insert(TotalPurchases totalPurchases);

    @Select("select * from total_purchases")
    void findAll();
}
