package com.example.Fioo.Guardian;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Guardian.Dto.PostGuardianDTO;
import com.example.Fioo.Guardian.Model.Guardian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/guardian")
public class GuardianController {
    @Autowired
    private GuardianService guardianService;
    @PostMapping("")
    public ApiResponse<Guardian> insertGuardian(@RequestBody @Valid PostGuardianDTO postGuardianDTO) {
        return guardianService.insertGuardian(postGuardianDTO);
    }

    @GetMapping("")
    public ApiResponse<List<Guardian>> getGuardians() {
        return guardianService.getAllGuardians();
    }
}
