package com.ishan.sampleweb.service;

import com.ishan.sampleweb.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
