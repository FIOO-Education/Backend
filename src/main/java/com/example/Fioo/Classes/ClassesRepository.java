package com.example.Fioo.Classes;

import com.example.Fioo.Classes.Model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes,Long> {
    List<Classes> getAllBySubject(String subject);
}
