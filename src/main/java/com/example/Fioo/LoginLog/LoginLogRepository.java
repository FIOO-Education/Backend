package com.example.Fioo.LoginLog;

import com.example.Fioo.LoginLog.Model.Loginlog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginLogRepository extends JpaRepository<Loginlog, Long> {
//    List<LoginLog> getLoginLogsByActDate_DayAndActDate_MonthAndActDateYearAndActNameIs(int day, int month, int year, String action);
    List<Loginlog> getLoginLogsByActName(String actName);
}
