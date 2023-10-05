package com.example.Fioo.Guardian;

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
    public ResponseEntity<Guardian> insertGuardian(@RequestBody @Valid PostGuardianDTO postGuardianDTO) {
        try {
            return ResponseEntity.ok(guardianService.insertGuardian(postGuardianDTO));
        } catch (Exception err) {
            return ResponseEntity.badRequest().body(new Guardian(postGuardianDTO));
        }

    }

    @GetMapping("")
    public ResponseEntity<List<Guardian>> getGuardians() {
        try {
            return ResponseEntity.ok(guardianService.getAllGuardians());
        } catch (Exception err) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/teste")
    public ResponseEntity<List<GetGuardianDTO>> getGuardiansDto() {
        return ResponseEntity.ok(guardianService.getGuardians());
    }
}
