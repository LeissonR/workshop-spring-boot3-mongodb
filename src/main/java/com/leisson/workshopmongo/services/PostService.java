package com.leisson.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leisson.workshopmongo.domain.Post;
import com.leisson.workshopmongo.repository.PostRepository;
import com.leisson.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	/*  ****Simple query with query methods****
	 *	public List<Post> findByTitle(String text){
	 *	return repo.findByTitleContainingIgnoreCase(text);
	 *	}
	 */
	
	//  ****Simple query with @Query****
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 999);
		return repo.fullSearch(text, minDate, maxDate);
	}

}

