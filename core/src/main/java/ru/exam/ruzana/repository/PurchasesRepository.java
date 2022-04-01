package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.exam.ruzana.model.Purchases;

import java.util.List;

@Mapper
public interface PurchasesRepository {
    void insertPurchase(Purchases purchases);

    void updatePurchase(Purchases purchases);

    void deletePurchase(Purchases purchases);

    @Select("select * from purchases")
    List<Purchases> findAll();

    @Select("select * from purchases where id = #{id} ;")
    Purchases findById(Long id);

    @Select("select * from purchases where person_id = #{id} order by updated_at desc")
    List<Purchases> findByPersonId(Long id);

    @Select("select * from purchases where item_id = #{id} order by updated_at desc")
    List<Purchases> findByItemId(Long id);

    @Select("select * from purchases " +
            "where person_id = #{personId} and item_id = #{itemId} " +
            "order by updated_at desc")
    List<Purchases> findByPersonAndItem(Long personId, Long itemId);

}
