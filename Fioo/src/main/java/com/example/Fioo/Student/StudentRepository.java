package com.example.Fioo.Student;

import com.example.Fioo.Student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
