package ru.exam.ruzana.service;

import java.util.List;

public interface BasicCRUDService<T> {
    /**
     * Accepts an object of any entity that is in the database
     * and all the requirements of the entity parameters are met.
     *
     * @param object
     */
    void save(T object);

    /**
     * Performs a search by the primary key of the object.
     *
     * @param id is unique key of the entity object that is being searched for
     * @return If the object is found, then the object is returned, otherwise null
     */
    T findById(Long id);

    /**
     * Searches for all objects of the database entity.
     *
     * @return entity objects as a list. If there is no object, then an empty list is returned
     */
    List<T> findAll();

    /**
     * Modifies the database entity object.
     *
     * @param object with unique key that is in the database entity
     */
    void update(T object);

    /**
     * Allows to delete an entity object that is in the database.
     *
     * @param id is unique key of the database entity object that is being searched for
     */
    void delete(Long id);
}
