package FullStackProject.TaskTrackerBackend.repository;


import FullStackProject.TaskTrackerBackend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long>{

    
} 
