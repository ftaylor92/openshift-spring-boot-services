package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
