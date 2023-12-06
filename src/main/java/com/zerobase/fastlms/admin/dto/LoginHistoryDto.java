package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.LoginHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistoryDto {

    private String userId;
    private String userAgent;
    private String accessIp;
    private LocalDateTime loginDt;
    Long seq;

    public static LoginHistoryDto fromEntity(LoginHistory loginHistory) {
        return LoginHistoryDto.builder()
                .userId(loginHistory.getUserId())
                .userAgent(loginHistory.getUserAgent())
                .accessIp(loginHistory.getAccessIp())
                .loginDt(loginHistory.getLoginDt())
                .build();
    }
}
