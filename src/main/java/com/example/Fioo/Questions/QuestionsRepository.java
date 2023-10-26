package com.example.Fioo.Questions;

import com.example.Fioo.Questions.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    List<Questions> getAllByCodActivity(Long codActivity);
}
