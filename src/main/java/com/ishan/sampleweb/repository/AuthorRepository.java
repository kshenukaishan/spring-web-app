package com.ishan.sampleweb.repository;

import com.ishan.sampleweb.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
