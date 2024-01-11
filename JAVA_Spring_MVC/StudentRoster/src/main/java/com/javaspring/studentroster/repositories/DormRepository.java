package com.javaspring.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.studentroster.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {
	List<Dorm> findAll();
}
