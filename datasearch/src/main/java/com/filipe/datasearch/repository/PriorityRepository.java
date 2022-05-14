package com.filipe.datasearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filipe.datasearch.domain.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, String>  {
}
