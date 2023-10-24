package com.example.Fioo.Alternatives;
import com.example.Fioo.Alternatives.Model.Alternatives;
import com.example.Fioo.ApiResponse;
import com.example.Fioo.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
public class AlternativesService {
    private AlternativesRepository alternativesRepository;
    @Autowired
    public AlternativesService(AlternativesRepository alternativesRepository) {
        this.alternativesRepository = alternativesRepository;
    }
    public ApiResponse<List<Alternatives>> getAll() {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), alternativesRepository.findAll());
        } catch (HttpServerErrorException.InternalServerError err) {
            err.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }

    public ApiResponse<List<Alternatives>> getAlternativesByCodQuestion(Long codQuestion) {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), alternativesRepository.findAllByCodQuestion(codQuestion));
        } catch (HttpClientErrorException.BadRequest err) {
            err.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(), null);
        } catch (HttpServerErrorException.InternalServerError err) {
            err.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }
}
