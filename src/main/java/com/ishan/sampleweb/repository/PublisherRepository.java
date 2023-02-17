package com.ishan.sampleweb.repository;

import com.ishan.sampleweb.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
