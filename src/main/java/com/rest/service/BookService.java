/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service;

import com.rest.model.Book;
import com.rest.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpatarroyo
 */
@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public List<Book> getAll() {
        return (List<Book>) repository.findAll();
    }
    
    public Book save(Book book){
        return repository.save(book);
    }
    
    public Optional<Book> getById(Long id){
        return repository.findById(id);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            repository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
