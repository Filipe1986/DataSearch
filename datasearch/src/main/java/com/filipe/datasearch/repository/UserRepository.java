package com.filipe.datasearch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filipe.datasearch.domain.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String>  {

	Page<User> findByName(String name, Pageable pageable);
	
	@Query("SELECT u FROM User u "
			+ "WHERE u.name LIKE %:name% "
			+ "or u.password LIKE %:name%")
	Page<User> findNameLike(@Param("name") String name, Pageable pageable);


	Page<User> findByNameContaining(@Param("name") String name, Pageable pageable);


}
