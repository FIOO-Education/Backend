package com.example.Fioo.Alternatives;

import com.example.Fioo.Alternatives.Model.Alternatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlternativesRepository extends JpaRepository<Alternatives, Long> {
    List<Alternatives> findAllByCodQuestion(Long codQuestion);
}
