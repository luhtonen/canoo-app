package com.elu.canoo.library.repositories;

import com.elu.canoo.library.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
