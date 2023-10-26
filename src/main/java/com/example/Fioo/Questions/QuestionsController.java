package com.example.Fioo.Questions;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Questions.Model.Questions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
    private final QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }
    @GetMapping("/{codActivity}")
    public ApiResponse<List<Questions>> getAllByCodActivity(@PathVariable Long codActivity) {
        return questionsService.getAllByCodActivity(codActivity);
    }
}
