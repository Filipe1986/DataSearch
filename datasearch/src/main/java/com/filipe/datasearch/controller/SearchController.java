package com.filipe.datasearch.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.datasearch.constants.Constants.Url;
import com.filipe.datasearch.dto.SearchResponseDTO;
import com.filipe.datasearch.service.SearchService;



@RestController
@RequestMapping(Url.SEARCH_PATH)
public class SearchController {
		

	private SearchService service;
	
	public SearchController(SearchService service) {
		this.service = service;
	}


	@GetMapping()
	public ResponseEntity<SearchResponseDTO> fizzbuzz(@RequestParam(required = false) List<Integer> entry) {
		return ResponseEntity.ok(service.process(entry));
	}

}
