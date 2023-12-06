package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;

import java.util.List;

public interface BannerService {
    /**
     * 배너 목록
     * @param parameter
     * @return
     */
    public List<BannerDto> list(BannerParam parameter);

    /**
     * 배너 정보 수정
     * @param parameter
     * @return
     */
    public boolean set(BannerInput parameter);

    /**
     * 배너 등록
     * @param parameter
     * @return
     */
    public boolean add(BannerInput parameter);

    /**
     * 강좌 상세정보
     * @param id
     * @return
     */
    public BannerDto getById(long id);
}
