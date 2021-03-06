package com.filipe.datasearch.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.datasearch.constants.Constants.Url;
import com.filipe.datasearch.domain.User;
import com.filipe.datasearch.service.SearchService;


@RestController
@RequestMapping(Url.SEARCH_PATH)
public class SearchController {
		
	private SearchService service;
	
	public SearchController(SearchService service) {
		this.service = service;
	}

	@GetMapping()
	public ResponseEntity<Page<User>> find(@RequestParam(required = false) String entry,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size) {
		
		return ResponseEntity.ok(service.find(entry, page, size));
	}

}
