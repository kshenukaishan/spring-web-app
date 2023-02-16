package com.ishan.sampleweb.repository;

import com.ishan.sampleweb.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
