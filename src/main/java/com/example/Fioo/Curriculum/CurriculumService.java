package com.example.Fioo.Curriculum;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Curriculum.Model.Curriculum;
import com.example.Fioo.MessageRequest;
import com.sun.net.httpserver.HttpServer;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
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
            List<Curriculum> payload = curriculumRepository.findAllByCodStudentOrderByRealizationDateDesc(id);
            if(payload.size() > 0) {
                Integer days = 0;
                LocalDate comparationDate = payload.get(0).getRealizationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if(!comparationDate.equals(LocalDate.now()) && !comparationDate.equals(LocalDate.now().minusDays(1))) {
                    return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), 0);
                }
                for (Curriculum c : payload) {
                    LocalDate localDate = c.getRealizationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    if(localDate.equals(comparationDate.minusDays(days))) {
                        days+=1;
                    }
                }
                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), days);
            } else {
                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), 0);
            }
        } catch (HttpServerErrorException.InternalServerError e) {
            e.printStackTrace();
            return new ApiResponse<>(500, MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }
}
