package com.example.Fioo.Curriculum;

import com.example.Fioo.Curriculum.Model.Curriculum;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
    private CurriculumService curriculumService;
    @Autowired
    public CurriculumController(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }
    @GetMapping("")
    public ResponseEntity<List<Curriculum>> getCurriculums() {
        return ResponseEntity.ok(curriculumService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curriculum>> getCurriculumByID(@PathVariable Long id) {
        Optional<Curriculum> payload = curriculumService.getCurriculumByID(id);
        if(payload.isPresent()) {
            return ResponseEntity.ok(payload);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getStudentCurriculum/{id}")
    public ResponseEntity<Curriculum> getStudentCurriculum(@PathVariable Long id) {
        return ResponseEntity.ok(curriculumService.getStudentCurriculum(id));
    }

    @GetMapping("/getConsecutiveDays/{id}")
    public ResponseEntity<Integer> getStudentConsecutiveDays(@PathVariable Long id) {
        return ResponseEntity.ok(curriculumService.getConsecutiveDays(id));
    }
}
