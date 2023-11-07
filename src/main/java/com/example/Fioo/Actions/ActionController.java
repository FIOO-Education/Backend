package com.example.Fioo.Actions;

import com.example.Fioo.Actions.Dto.PostActionDto;
import com.example.Fioo.Actions.Model.Action;
import com.example.Fioo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/action")
public class ActionController {
    private ActionService actionService;
    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }
    @GetMapping("consecutiveDays/{id}")
    public ApiResponse<Integer> getConsecutiveDays(@PathVariable Long id) {
        return actionService.getConsecutiveDays(id);
    }

    @GetMapping
    public ApiResponse<List<Action>> getAll() {
        return actionService.getAll();
    }

    @PostMapping
    public ApiResponse<Action> insertAction(@RequestBody @Valid PostActionDto postActionDto) {
        return actionService.insertAction(postActionDto);
    }

    @GetMapping("/{id}")
    public ApiResponse<List<Action>> getRecentGamesOrderByDate(@PathVariable Long id) {
        return actionService.getRecentGamesOrderByDate(id);
    }
}
