package com.example.Fioo.Curriculum;

import com.example.Fioo.Curriculum.Model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
    //@Query(value = "SELECT * FROM curriculum WHERE codStudent = ?1", nativeQuery = true)
    //public Curriculum getStudentGrade(Long id);
    List<Curriculum> findAllByCodStudent(Long codStudent);
    List<Curriculum> findAllByCodStudentOrderByRealizationDateDesc(Long codStudent);

    Curriculum findByCodActivityAndCodStudent(Long codActivity, Long codStudent);
}
