package ru.exam.ruzana.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.exam.ruzana.model.PersonDataEntity;

import java.util.List;

@Mapper
public interface PersonDataRepository {
    /**
     * Searches for a person data by primary key in the "person_data" table of the database.
     *
     * @param personId is a unique key of the PersonDataEntity object
     * @return object of the PersonDataEntity
     */
    @Select("select * from person_data where id = #{personId}")
    PersonDataEntity findById(Long personId);

    /**
     * Searches for a person data by email in the "person_data" table of the database.
     *
     * @param email is a unique value of the PersonDataEntity object
     * @return object of the PersonDataEntity
     */
    @Select("select * from person_data where email = #{email}")
    PersonDataEntity findByEmail(String email);

    /**
     * Searches for all objects of the "person_data" table.
     *
     * @return all objects of the PersonDataEntity as a list
     */
    @Select("select * from person_data")
    List<PersonDataEntity> findAll();

    /**
     * Saves the person data in the "person_data" table in the database.
     *
     * @param personDataEntity is object of the PersonDataEntity with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     */
    void insert(PersonDataEntity personDataEntity);

    /**
     * Modifies person data data in the "person_data" table.
     *
     * @param personDataEntity is an instance of a class PersonDataEntity
     *                      with a primary key that is stored in a table
     */
    void update(PersonDataEntity personDataEntity);

    /**
     * Updates an object from the "person_data" table as disabled = true.
     *
     * @param id is a primary key of the PersonDataEntity object.
     *           If the object was not found in the table, then deletion does not occur
     */
    void deleteById(@Param("id") Long id);
}
