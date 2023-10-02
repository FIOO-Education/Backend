package com.example.Fioo.Guardian;

import com.example.Fioo.Guardian.Dto.GuardianInsertDto;
import com.example.Fioo.Guardian.Model.Guardian;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guardian")
public class GuardianController {
    @Autowired
    private GuardianService guardianService;
    @PostMapping("")
    public ResponseEntity<Guardian> insertGuardian(@RequestBody GuardianInsertDto guardianInsertDto) {
        try {
            return ResponseEntity.ok(guardianService.insertGuardian(guardianInsertDto));
        } catch (Exception err) {
            return ResponseEntity.badRequest().body(new Guardian(guardianInsertDto));
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
}
