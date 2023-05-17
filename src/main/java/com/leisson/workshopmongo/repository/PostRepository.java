package com.leisson.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.leisson.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//	****Simple query with query methods****
	// 	https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	
	//  ****Simple query with @Query****
	// 	https://www.mongodb.com/docs/manual/reference/operator/query/
	@Query("{ 'title': { $regex: ?0 , $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	
	//  ****Query with multiple criteria****
	// 	https://www.mongodb.com/docs/manual/reference/operator/query/
	@Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0 , $options: 'i' } }, { 'body': { $regex: ?0 , $options: 'i' } }, { 'comments.text': { $regex: ?0 , $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
