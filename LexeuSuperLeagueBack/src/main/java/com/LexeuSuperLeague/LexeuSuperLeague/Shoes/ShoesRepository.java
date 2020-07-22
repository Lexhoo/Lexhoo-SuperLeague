package com.LexeuSuperLeague.LexeuSuperLeague.Shoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Long> {

    Shoes findBynameContaining(String name);

    Optional<Shoes> findById(Long id);

}
