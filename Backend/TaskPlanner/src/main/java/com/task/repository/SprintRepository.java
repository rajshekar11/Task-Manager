package com.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer> {

	public Optional<Sprint> findBySprintName(String sprintName);
}
