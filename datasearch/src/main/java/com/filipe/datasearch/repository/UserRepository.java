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
	
	
	@Query(value = "SELECT * "
				+ " FROM S_USER u "
				+ " WHERE u.NAME LIKE %:name% ", nativeQuery = true)
	List<User> findNameLike(@Param("name") String name);


	List<User> findByNameContaining(String entries);

}
