package com.sliit.sample.dal.repository;

import com.sliit.sample.dal.model.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMongoRepository extends MongoRepository<PostModel,String> {
}
