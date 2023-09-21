package com.example.Fioo.Student;

import com.example.Fioo.Student.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository repo;

    @Autowired(required = true)
    public StudentService(StudentRepository studentRepository) {
        this.repo = studentRepository;
    }

    public ResponseEntity<String> registerUser(Student student){
        try {
            repo.save(student);
        } catch (Exception err) {
            throw err;
        }
        return ResponseEntity.ok("Aluno inserido com sucesso!");
    }

    public List<Student> getUsers() {
        try {
            List<Student> students = repo.findAll();
            return students;
        } catch (Exception err) {
            throw err;
        }
    }

    public Student getUserByEmail(String email) {
        try {
            //Optional<Student> payload = repo.findById(id);
            return new Student();
        } catch (Exception err) {
            throw err;
        }
    }
}
