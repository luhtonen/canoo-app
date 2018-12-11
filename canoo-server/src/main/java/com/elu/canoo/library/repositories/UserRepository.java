package com.elu.canoo.library.repositories;

import com.elu.canoo.library.models.CanooUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface UserRepository extends MongoRepository<CanooUser, String> {
    CanooUser findByUsername(String username);
}
