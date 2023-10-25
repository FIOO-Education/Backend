package com.example.Fioo.Guardian;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Guardian.Dto.PostGuardianDTO;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuardianService {
    private GuardianRepository repo;

    @Autowired
    public GuardianService(GuardianRepository guardianRepository) {
        this.repo = guardianRepository;
    }
    public ApiResponse<Guardian> insertGuardian(PostGuardianDTO guardian) {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.save(new Guardian(guardian)));
        } catch (HttpClientErrorException.BadRequest e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }

    public Optional<Guardian> getGuardianByEmail(String email) {
        Optional<Guardian> payload = repo.getGuardianByEmail(email);
        return payload;
    }

    public ApiResponse<List<Guardian>> getAllGuardians() {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }
}
