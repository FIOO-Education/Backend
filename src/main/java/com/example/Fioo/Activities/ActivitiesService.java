package com.example.Fioo.Activities;

import com.example.Fioo.Activities.Dto.ActivitiesRequestDto;
import com.example.Fioo.Activities.Model.Activities;
import com.example.Fioo.Alternatives.AlternativesRepository;
import com.example.Fioo.Alternatives.AlternativesService;
import com.example.Fioo.Alternatives.Model.Alternatives;
import com.example.Fioo.ApiResponse;
import com.example.Fioo.MessageRequest;
import com.example.Fioo.Questions.Model.Questions;
import com.example.Fioo.Questions.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class ActivitiesService {
    private final ActivitiesRepository activitiesRepository;
    private final QuestionsRepository questionsRepository;
    private AlternativesRepository alternativesRepository;
    @Autowired
    public ActivitiesService(ActivitiesRepository activitiesRepository, QuestionsRepository questionsRepository, AlternativesRepository alternativesRepository) {
        this.activitiesRepository = activitiesRepository;
        this.questionsRepository = questionsRepository;
        this.alternativesRepository = alternativesRepository;
    }
    public ApiResponse<List<Activities>> getAll() {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), activitiesRepository.findAll());
        } catch (HttpServerErrorException.InternalServerError err) {
            err.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(),  null);
        }
    }

    public ApiResponse<Activities> postActivities(ActivitiesRequestDto activitiesRequestDto) {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), activitiesRepository.save(new Activities(activitiesRequestDto)));
        } catch (HttpClientErrorException.BadRequest err) {
            err.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(), null);
        } catch (HttpServerErrorException.InternalServerError err) {
            err.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }

    public ApiResponse<List<Activities>> getActivitiesByCodClass(Long codClass) {
        List<Activities> payload = activitiesRepository.findAllByCodClass(codClass);
        try {
            if(payload.size() > 0) {
                for(Activities activities: payload) {
                    System.out.println(activities.getCodActivity());
                    List<Questions> questions = questionsRepository.getAllByCodActivity(activities.getCodActivity());
                    activities.setQuestionsList(questions);

                    for(Questions question: questions) {
                        List<Alternatives> alternatives = alternativesRepository.findAllByCodQuestion(question.getCodQuestion());
                        question.setAlternatives(alternatives);
                    }
                }

                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), payload);
            } else {
                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS_NULL.getMessage(), null);
            }
        } catch (HttpClientErrorException.BadRequest err) {
            err.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(), null);
        } catch (HttpServerErrorException.InternalServerError err) {
            err.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }
}
