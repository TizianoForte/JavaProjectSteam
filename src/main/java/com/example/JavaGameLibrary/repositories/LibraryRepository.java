package com.example.JavaGameLibrary.repositories;

import com.example.JavaGameLibrary.entities.Game;
import com.example.JavaGameLibrary.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    @Query(value = "select game.title from game join library on game.id = library.game_id where library.account_id = ?1", nativeQuery = true)
    Iterable<String> getAllGamesByUserId(long id);

    @Modifying
    @Transactional
    @Query(value = "delete from library where game_id = :idGame and account_id = :idAccount", nativeQuery = true)
    void deleteGameFromLibrary(long idGame, long idAccount);
}
