package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.admin.entity.LoginHistory;
import com.zerobase.fastlms.admin.repository.LoginHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    @Override
    public List<LoginHistoryDto> getUserLoginHistories(String userId) {

        List<LoginHistoryDto> loginHistories = loginHistoryRepository
                .findLoginHistoriesByUserIdOrderByLoginDtAsc(userId)
                .stream()
                .map(LoginHistoryDto::fromEntity)
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(loginHistories)) {
            int i = 0;
            int total = loginHistories.size();
            for (LoginHistoryDto history : loginHistories) {
                history.setSeq((long) (total - i));
                i++;
            }
        }

        return loginHistories;
    }

    @Override
    public void saveLoginHistory(LoginHistory loginHistory) {
        loginHistoryRepository.save(loginHistory);
    }
}
