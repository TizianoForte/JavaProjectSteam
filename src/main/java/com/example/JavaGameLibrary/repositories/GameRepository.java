package com.example.JavaGameLibrary.repositories;

import com.example.JavaGameLibrary.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Iterable<Game> findByTitleLike(String title);
}
