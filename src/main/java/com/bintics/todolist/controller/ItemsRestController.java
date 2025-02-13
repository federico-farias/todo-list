package com.bintics.todolist.controller;

import com.bintics.todolist.entity.ItemEntity;
import com.bintics.todolist.model.ItemRequest;
import com.bintics.todolist.repository.ItemsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemsRestController {

    private final ItemsRepository repository;

    @GetMapping
    public Flux<ItemEntity> getAll() {
        return this.repository.findAll();
    }

    @PostMapping
    public Mono<ItemEntity> create(@RequestBody ItemRequest request) {
        var id = UUID.randomUUID().toString();
        return this.repository.insert(id, request.name());
    }

}
