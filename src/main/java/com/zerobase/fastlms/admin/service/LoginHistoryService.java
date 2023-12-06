package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.admin.entity.LoginHistory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LoginHistoryService {

    public List<LoginHistoryDto> getUserLoginHistories(String userId);

    public void saveLoginHistory(LoginHistory loginHistory);
}
