package com.LexeuSuperLeague.LexeuSuperLeague.JwtSecurity.repository;

import com.LexeuSuperLeague.LexeuSuperLeague.JwtSecurity.models.ERole;
import com.LexeuSuperLeague.LexeuSuperLeague.JwtSecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
