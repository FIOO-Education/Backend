package com.example.Fioo.Questions;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.MessageRequest;
import com.example.Fioo.Questions.Model.Questions;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
public class QuestionsService {
    private final QuestionsRepository questionsRepository;

    @Autowired
    public QuestionsService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    public ApiResponse<List<Questions>> getAllByCodActivity(Long codActivity) {
        try {
            List<Questions> payload = questionsRepository.getAllByCodActivity(codActivity);
            if (payload.size() > 0) {
                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), payload);
            }
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS_NULL.getMessage(), null);
        } catch (HttpServerErrorException.InternalServerError err) {
            err.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }
}
