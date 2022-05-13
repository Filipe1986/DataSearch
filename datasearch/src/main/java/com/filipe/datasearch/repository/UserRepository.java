package com.filipe.datasearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filipe.datasearch.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>  {

	List<User> findByName(String name);
	
	@Query("SELECT u FROM User u "
			+ "WHERE u.name LIKE %:name% "
			+ "or u.password LIKE %:name%")
	List<User> findNameLike(@Param("name") String name);


	List<User> findByNameContaining(@Param("name") String name);


}
