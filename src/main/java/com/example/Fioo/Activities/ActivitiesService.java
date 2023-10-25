package com.example.Fioo.Activities;

import com.example.Fioo.Activities.Dto.ActivitiesRequestDto;
import com.example.Fioo.Activities.Model.Activities;
import com.example.Fioo.ApiResponse;
import com.example.Fioo.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class ActivitiesService {
    private ActivitiesRepository activitiesRepository;
    @Autowired
    public ActivitiesService(ActivitiesRepository activitiesRepository) {
        this.activitiesRepository = activitiesRepository;
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
