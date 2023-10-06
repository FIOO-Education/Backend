package com.example.Fioo.LoginLog;


import com.example.Fioo.ApiResponse;
import com.example.Fioo.LoginLog.Dto.LoginLogInsertDto;
import com.example.Fioo.LoginLog.Model.Loginlog;
import com.example.Fioo.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
public class LoginLogService {
    private LoginLogRepository repo;

    @Autowired(required = true)
    public LoginLogService(LoginLogRepository repo) {
        this.repo = repo;
    }
    protected ApiResponse<List<Loginlog>> getLoginLogs(){
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.getLoginLogsByActName("login"));
        } catch (HttpServerErrorException.InternalServerError e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }

    protected ApiResponse<List<Loginlog>> getCadastroLogs() {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.getLoginLogsByActName("cadastro"));
        } catch (HttpServerErrorException.InternalServerError e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }

    protected ApiResponse<Loginlog> registerLoginLog(LoginLogInsertDto logInsertDto){
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.save(new Loginlog(logInsertDto)));
        } catch (HttpClientErrorException.BadRequest e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }
}
