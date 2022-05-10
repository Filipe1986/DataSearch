package com.filipe.datasearch.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.filipe.datasearch.dto.SearchResponseDTO;


@Service
public class SearchService {
	
	

	public SearchService() {
		
	}
	
	public SearchResponseDTO process(List<Integer> entries) {

	    SearchResponseDTO response = new SearchResponseDTO(); 
	    
	    response.setOutputs(new HashMap<String, String>());

		return response;
	}
	
	
	
	

}
