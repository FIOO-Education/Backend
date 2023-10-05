package com.example.Fioo.Curriculum;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Curriculum.Model.Curriculum;
import com.example.Fioo.MessageRequest;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class CurriculumService {
    private CurriculumRepository curriculumRepository;
    @Autowired
    public CurriculumService(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }
    public ApiResponse<List<Curriculum>> getAll() {
        try {
            return new ApiResponse(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), curriculumRepository.findAll());
        } catch (HttpServerErrorException.InternalServerError error) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }

    public ApiResponse<Curriculum> getCurriculumByID(Long id) {
        try {
            Optional<Curriculum> curriculum = curriculumRepository.findById(id);
            if(curriculum.isPresent()){
                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), curriculum.get());
            }
            else {
                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), null);
            }
        }
        catch (HttpClientErrorException.BadRequest e){
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(),null);
        }
        catch (HttpServerErrorException.InternalServerError e){
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }

    public ApiResponse<List<Curriculum>> getStudentCurriculum(Long id) {
        List<Curriculum> arr = curriculumRepository.findAllByCodStudent(id);
        if(arr.size() > 0) {
            try {
                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), arr);
            } catch (HttpClientErrorException.NotFound e) {
                return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), MessageRequest.DATA_NOT_FOUND.getMessage(), null);
            } catch (HttpClientErrorException.BadRequest e) {
                return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(), null);
            } catch (Exception e) {
                return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
            }
        } else {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCESS_NULL.getMessage(), arr);
        }

    }
    //ConsecutiveDaysReponse
    public ApiResponse<Integer> getConsecutiveDays(Long id) {
        try {
            List<Curriculum> payload = curriculumRepository.findAllByCodStudentOrderByRealizationDate(id);
            int consecutive = 0;

            if (payload.get(0).getRealizationDate().getMonth() + 1 == LocalDate.now().getMonthValue() && LocalDate.now().getYear() == payload.get(0).getRealizationDate().getYear()) {
                consecutive = 1;
                for (Curriculum c : payload) {
                    if (c.getRealizationDate().getDay() + 1 == c.getRealizationDate().getDay() + 1) {
                        consecutive += 1;
                    }
                }
            }
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), consecutive);
        }
        catch (HttpServerErrorException.InternalServerError e) {
            e.printStackTrace();
            return new ApiResponse<>(500, MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }

    }
}
