package com.bintics.todolist.repository;

import com.bintics.todolist.entity.ItemEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ItemsRepository extends ReactiveCrudRepository<ItemEntity, String> {

    @Query("INSERT INTO items (id, name) VALUES (:id, :name)")
    Mono<ItemEntity> insert(@Param("id") String id, @Param("name") String nombre);

}
