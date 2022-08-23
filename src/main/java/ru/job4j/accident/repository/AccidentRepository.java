package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accident acc set " +
            "acc.name = :name, " +
            "acc.type.id = :type_id, " +
            "acc.text = :text, " +
            "acc.address = :address " +
            "where acc.id =:id")
    void updates(
            @Param("name") String name,
            @Param("type_id") int type_id,
            @Param("text") String text,
            @Param("address") String address,
            @Param("id") int id
    );

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Accident acc where acc.id = :id")
    void delete(@Param("id") int id);
}
