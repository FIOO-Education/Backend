package com.example.Fioo.Curriculum;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Curriculum.Model.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

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
    public ApiResponse<List<Curriculum>> getCurriculums() {
        return curriculumService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse<Curriculum> getCurriculumByID(@PathVariable Long id) {
        return curriculumService.getCurriculumByID(id);
    }

    @GetMapping("/student/{id}")
    public ApiResponse<List<Curriculum>> getStudentCurriculum(@PathVariable Long id) {
        return curriculumService.getStudentCurriculum(id);
    }

    @GetMapping("/consecutiveDays/{id}")
    public ApiResponse<Integer> getStudentConsecutiveDays(@PathVariable Long id) {
        return curriculumService.getConsecutiveDays(id);
    }
}
