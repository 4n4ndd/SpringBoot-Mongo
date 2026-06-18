package com.coding.mongoDB.repository;

import com.coding.mongoDB.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends MongoRepository<UserDetails,String> {
}
