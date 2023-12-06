package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.admin.entity.LoginHistory;
import com.zerobase.fastlms.admin.service.LoginHistoryService;
import com.zerobase.fastlms.member.service.MemberService;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
@Configuration
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final LoginHistoryService loginHistoryService;
    private final MemberService memberService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String userId = userDetails.getUsername();
        String userAgent = RequestUtils.getUserAgent(request);
        String userIp = RequestUtils.getUserIp(request);

        LoginHistory loginHistory = LoginHistory.builder()
                .userId(userId)
                .userAgent(userAgent)
                .accessIp(userIp)
                .build();

        loginHistoryService.saveLoginHistory(loginHistory); //로그인 log 기능
        memberService.updateLastLoginDt(userId); // member의 lastLoginDt 업데이트

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
