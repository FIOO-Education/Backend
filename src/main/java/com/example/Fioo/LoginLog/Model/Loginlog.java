package com.example.Fioo.LoginLog.Model;

import com.example.Fioo.LoginLog.Dto.LoginLogInsertDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "loginlog")
public class Loginlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codloginlog")
    private Long codLoginLog;

    @Column(name = "codstudent")
    private Long codStudent;

    @Column(name = "actname")
    private String actName;

    @Column(name = "actdate")
    @Transient
    private LocalDateTime actDate;

    public Loginlog(LoginLogInsertDto liDto) {
        this.codStudent = liDto.codStudent();
        this.actName = liDto.actName();
    }
}
