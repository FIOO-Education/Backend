package com.example.Fioo.Curriculum;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Curriculum.Model.Curriculum;
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
            return new ApiResponse(200, "success", curriculumRepository.findAll());
        } catch (HttpServerErrorException.InternalServerError error) {
            return new ApiResponse<>(500, "Internal Server Error", null);
        }
    }

    public Optional<Curriculum> getCurriculumByID(Long id) {
        return curriculumRepository.findById(id);
    }

    public ApiResponse<List<Curriculum>> getStudentCurriculum(Long id) {
        List<Curriculum> arr = curriculumRepository.findAllByCodStudent(id);
        if(arr.size() > 0) {
            try {
                return new ApiResponse<>(HttpStatus.OK.value(), "Success", arr);
            } catch (HttpClientErrorException.NotFound e) {
                return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Not found", null);
            } catch (HttpClientErrorException.BadRequest e) {
                return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Invalid id type", null);
            } catch (Exception e) {
                return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", null);
            }
        } else {
            return new ApiResponse<>(HttpStatus.OK.value(), "Data not found :(", arr);
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
                    if (c.getRealizationDate().getDay() + 1 == first.getDay() + 1) {
                        consecutive += 1;
                    }
                }
            }

            return new ApiResponse<>(HttpStatus.OK.value(), "Success", consecutive);
        }
        catch (HttpServerErrorException.InternalServerError e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "Internal Server Error", null);
        }

    }
}
