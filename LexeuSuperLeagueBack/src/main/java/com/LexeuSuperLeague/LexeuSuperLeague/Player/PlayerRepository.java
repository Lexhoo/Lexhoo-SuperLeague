package com.LexeuSuperLeague.LexeuSuperLeague.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findBylastnameContaining(String lastname);

    Optional<Player> findById(Long id);

}
