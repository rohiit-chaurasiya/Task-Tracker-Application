package FullStackProject.TaskTrackerBackend.repository;

import FullStackProject.TaskTrackerBackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Role findByName(String name);
} 
