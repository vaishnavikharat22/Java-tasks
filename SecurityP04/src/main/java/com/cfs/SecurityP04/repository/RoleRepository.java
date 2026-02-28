package com.cfs.SecurityP04.repository;

import com.cfs.SecurityP04.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long>
{
    Optional<Role> findByName(String name);

}
