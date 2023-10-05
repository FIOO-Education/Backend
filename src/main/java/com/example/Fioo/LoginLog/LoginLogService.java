package com.example.Fioo.LoginLog;


import com.example.Fioo.ApiResponse;
import com.example.Fioo.LoginLog.Dto.LoginLogInsertDto;
import com.example.Fioo.LoginLog.Model.Loginlog;
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

//    protected ApiResponse<List<LoginLog>> getLoginServicePerDay(int day, int month, int year){
//        try {
//            return new ApiResponse<>(HttpStatus.OK.value(), "Success", repo.getLoginLogsByActDate_DayAndActDate_MonthAndActDateYearAndActNameIs(day, month, year, "login"));
//        } catch (HttpServerErrorException.InternalServerError e) {
//            e.printStackTrace();
//            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", null);
//        }
//    }

    protected ApiResponse<List<Loginlog>> getLoginLogs(){
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), "Success", repo.getLoginLogsByActName("login"));
        } catch (HttpServerErrorException.InternalServerError e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", null);
        }
    }

    protected ApiResponse<List<Loginlog>> getCadastroLogs() {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), "Success", repo.getLoginLogsByActName("cadastro"));
        } catch (HttpServerErrorException.InternalServerError e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", null);
        }
    }

//    protected ApiResponse<List<LoginLog>> getCadastroLogsPerDay(int day, int month, int year) {
//        try {
//            return new ApiResponse<>(HttpStatus.OK.value(), "Success", repo.getLoginLogsByActDate_DayAndActDate_MonthAndActDateYearAndActNameIs(day, month, year, "cadastro"));
//        } catch (HttpServerErrorException.InternalServerError e) {
//            e.printStackTrace();
//            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", null);
//        }
//    }

    protected ApiResponse<Loginlog> registerLoginLog(LoginLogInsertDto logInsertDto){
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), "Success", new Loginlog(logInsertDto));
        } catch (HttpClientErrorException.BadRequest e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", null);
        }
    }
}
