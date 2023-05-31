/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.controller;

import com.rest.model.Book;
import com.rest.service.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpatarroyo
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping()
    public List<Book> getBooks() {
        return service.getAll();
    }

    @PostMapping()
    public Book save(@RequestBody Book book) {
        return service.save(book);
    }

    @GetMapping(path = "/{id}")
    public Optional<Book> getById(@PathVariable("id") Long id) {
        return this.service.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id) {
        return this.service.eliminarUsuario(id)
                ? "The book with the id " + id + " was succesfully deleted"
                : "The book with the id " + id + " could not be removed";
    }
}
