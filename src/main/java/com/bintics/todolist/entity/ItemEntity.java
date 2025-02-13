package com.bintics.todolist.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("items")
public class ItemEntity {

    @Id
    private String id;

    private String name;

}
