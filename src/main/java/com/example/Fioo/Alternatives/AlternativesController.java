package com.example.Fioo.Alternatives;

import com.example.Fioo.Alternatives.Model.Alternatives;
import com.example.Fioo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alternatives")
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

    @GetMapping("/{codActivity}")
    public ApiResponse<List<Alternatives>> getAlterativesByCodQuestion(@PathVariable Long codActivity) {
        return alternativesService.getAlternativesByCodActivity(codActivity);
    }
}
