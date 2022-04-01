package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.exam.ruzana.dto.StorageDto;

@Mapper
public interface StorageDtoRepository {
    @Select("select * from storage where name = #{name} and category_id = #{categoryId}")
    StorageDto findByNameAndCategoryIdAndProducerId(String name, Long categoryId, Long producerId);

    StorageDto buyStorage(Long id, int quantity);
}
