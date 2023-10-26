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

    @GetMapping("/cadastro")
    public ApiResponse<List<Loginlog>> getCadastroLog(){
        return loginLogService.getCadastroLogs();
    }

    @PostMapping
    public ApiResponse<Loginlog> insertLoginLog(@RequestBody @Valid LoginLogInsertDto logInsertDto){
        return loginLogService.registerLoginLog(logInsertDto);
    }
}
