package com.example.Fioo.Alternatives;

import com.example.Fioo.Alternatives.Model.Alternatives;
import com.example.Fioo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlternativesController {
    private AlternativesService alternativesService;

    @Autowired
    public AlternativesController(AlternativesService alternativesService) {
        this.alternativesService = alternativesService;
    }
    @GetMapping
    public ApiResponse<List<Alternatives>> getAll() {
        return alternativesService.getAll();
    }

    @GetMapping("/{codQuestion}")
    public ApiResponse<List<Alternatives>> getAlterativesByCodQuestion(@PathVariable Long codQuestion) {
        return alternativesService.getAlternativesByCodQuestion(codQuestion);
    }
}
