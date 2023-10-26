package com.example.Fioo.Curriculum;

import com.example.Fioo.Curriculum.Model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
    //@Query(value = "SELECT * FROM curriculum WHERE codStudent = ?1", nativeQuery = true)
    //public Curriculum getStudentGrade(Long id);
    List<Curriculum> findAllByCodStudent(Long codStudent);
    List<Curriculum> findAllByCodStudentOrderByRealizationDateDesc(Long codStudent);

    @Query("SELECT c FROM Curriculum c WHERE c.grade > :minGrade")
    List<Curriculum> findCurriculumWithGradeGreaterThan(@Param("minGrade") double minGrade);
    @Query("SELECT c FROM Curriculum c WHERE c.activity.codActivity = :codActivity AND c.codStudent = :codStudent")
    Curriculum findByCodActivityAndCodStudent(@Param("codActivity") Long codActivity, @Param("codStudent") Long codStudent);
}
