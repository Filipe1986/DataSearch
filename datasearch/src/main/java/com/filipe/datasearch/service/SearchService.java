package com.filipe.datasearch.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.filipe.datasearch.domain.User;
import com.filipe.datasearch.repository.UserRepository;


@Service
public class SearchService {
	
	private UserRepository userRepository;

	public SearchService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Page<User> find(String entry, Integer page, Integer size) {
		
		page = page == null ? 0 : page;
		size = size == null || size == 0 ? 10 : size;
		
		Pageable pageSortedByName = 
		  PageRequest.of(page, size, Sort.by("name"));
	
		if(entry == null || "".equals(entry)) {
			return (Page<User>) userRepository.findAll(pageSortedByName);
		}
		

		
		return userRepository.findNameLike(entry, pageSortedByName);
	}
	
	
	
	

}
