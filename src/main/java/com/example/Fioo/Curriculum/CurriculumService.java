package com.example.Fioo.Curriculum;

import com.example.Fioo.Curriculum.Model.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CurriculumService {
    private CurriculumRepository curriculumRepository;
    @Autowired
    public CurriculumService(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }
    public List<Curriculum> getAll() {
        return curriculumRepository.findAll();
    }

    public Optional<Curriculum> getCurriculumByID(Long id) {
        return curriculumRepository.findById(id);
    }

    public Curriculum getStudentCurriculum(Long id) {
        return curriculumRepository.getCurriculumByCodStudent(id);
    }

    public int getConsecutiveDays(Long id) {
        List<Curriculum> payload = curriculumRepository.findAllByCodStudentOrderByRealizationData(id);
        Date first = payload.get(0).getRealizationData();
        System.out.println(first.getMonth());
        System.out.println(LocalDate.now().getMonthValue());
        if(first.getMonth() + 1 == LocalDate.now().getMonthValue()) {
            int consecutive = 1;
            for(Curriculum c: payload) {
                if(c.getRealizationData().getDay() + 1 == first.getDay() + 1) {
                    consecutive+=1;
                }
            }
        }

        return 0;
    }
}
