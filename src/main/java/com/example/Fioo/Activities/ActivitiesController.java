package com.example.Fioo.Activities;

import com.example.Fioo.Activities.Model.Activities;
import com.example.Fioo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Fioo.Activities.Dto.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {
    private ActivitiesService activitiesService;
    @Autowired
    public ActivitiesController(ActivitiesService activitiesService) {
        this.activitiesService = activitiesService;
    }
    @GetMapping
    public ApiResponse<List<Activities>> getActivities() {
        return activitiesService.getAll();
    }

    @PostMapping
    public ApiResponse<Activities> postActivities(@RequestBody ActivitiesRequestDto activitiesRequestDto) {
        return activitiesService.postActivities(activitiesRequestDto);
    }

    @GetMapping("/{codClass}")
    public ApiResponse<List<Activities>> getActivitiesByCodClass(@PathVariable Long codClass) {
        return activitiesService.getActivitiesByCodClass(codClass);
    }

    @GetMapping("/null")
    public ApiResponse<List<Activities>> getActivitiesWhereCodClassIsNull() {
        return activitiesService.getActivitiesWhereCodClassIsNull();
    }
}
