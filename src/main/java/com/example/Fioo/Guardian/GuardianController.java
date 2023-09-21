package com.example.Fioo.Guardian;

import com.example.Fioo.Guardian.Model.Guardian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guardian")
public class GuardianController {
    private GuardianService guardianService;
    @GetMapping("/{email}")
    public ResponseEntity<Guardian> getGuardianByEmail(@PathVariable String email) {
        return guardianService.getGuardianByEmail(email);
    }
}
