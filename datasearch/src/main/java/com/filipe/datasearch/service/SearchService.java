package com.filipe.datasearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.filipe.datasearch.domain.User;
import com.filipe.datasearch.repository.UserRepository;


@Service
public class SearchService {
	
	private UserRepository userRepository;

	public SearchService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> find(String entry) {
		if(entry == null || "".equals(entry)) {
			return userRepository.findAll();
		}
		return userRepository.findNameLike(entry);
	}
	
	
	
	

}
