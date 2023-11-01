package com.example.Fioo.Alternatives;

import com.example.Fioo.Alternatives.Model.Alternatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlternativesRepository extends JpaRepository<Alternatives, Long> {
    @Query("SELECT a FROM Alternatives a LEFT JOIN Questions q ON a.codQuestion = q.codQuestion LEFT JOIN Activities ac ON q.codActivity = :codActivity")
    List<Alternatives> findAllByCodActivity(Long codActivity);
}
