package com.leisson.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leisson.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	// see https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	

}
