package com.example.Fioo.LoginLog;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.LoginLog.Dto.LoginLogInsertDto;
import com.example.Fioo.LoginLog.Model.Loginlog;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loginlog")
public class LoginLogController {
    private LoginLogService loginLogService;
    public LoginLogController(LoginLogService service){
        this.loginLogService = service;
    }

    @GetMapping("/login")
    public ApiResponse<List<Loginlog>> getLoginLogs(){
        return loginLogService.getLoginLogs();
    }

//    @GetMapping("/login/{day}-{month}-{year}")
//    public ApiResponse<List<LoginLog>> getLoginLogsPerDay(@PathVariable("day") int day, @PathVariable("month") int month, @PathVariable("year") int year){
//        return loginLogService.getLoginServicePerDay(day, month, year);
//    }

    @GetMapping("/cadastro")
    public ApiResponse<List<Loginlog>> getCadastroLog(){
        return loginLogService.getCadastroLogs();
    }

//    @GetMapping("/cadastro/{day}-{month}-{year}")
//    public ApiResponse<List<LoginLog>> getCadastroLogsPerDay(@PathVariable("day") int day, @PathVariable("month") int month, @PathVariable("year") int year){
//        return loginLogService.getCadastroLogsPerDay(day, month, year);
//    }

    @PostMapping
    public ApiResponse<Loginlog> insertLoginLog(@RequestBody @Valid LoginLogInsertDto logInsertDto){
        return loginLogService.registerLoginLog(logInsertDto);
    }
}
