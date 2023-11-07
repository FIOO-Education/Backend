package com.example.Fioo.Actions;

import com.example.Fioo.Actions.Dto.PostActionDto;
import com.example.Fioo.Actions.Model.Action;
import com.example.Fioo.ApiResponse;
import com.example.Fioo.Curriculum.Model.Curriculum;
import com.example.Fioo.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class ActionService {
    private ActionRepository repo;
    @Autowired
    public ActionService(ActionRepository actionRepository) {
        this.repo = actionRepository;
    }
    public ApiResponse<Integer> getConsecutiveDays(Long id) {
        try {
            List<Action> payload = repo.findAllByCodStudentOrderByActionDateDesc(id);
            if(payload.size() > 0) {
                Integer days = 0;
                LocalDate comparationDate = payload.get(0).getActionDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if(!comparationDate.equals(LocalDate.now()) && !comparationDate.equals(LocalDate.now().minusDays(1))) {
                    return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), 0);
                }
                for (Action c : payload) {
                    LocalDate localDate = c.getActionDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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

    public ApiResponse<List<Action>> getAll() {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }

    public ApiResponse<Action> insertAction(PostActionDto postActionDto) {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.save(new Action(postActionDto)));
        } catch (HttpClientErrorException.BadRequest e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }

    public ApiResponse<List<Action>> getRecentGamesOrderByDate(Long id) {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.findAllByCodStudentAndCodClassIsNullOrderByActionDateDesc(id));
        } catch (HttpClientErrorException.BadRequest e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }
}
