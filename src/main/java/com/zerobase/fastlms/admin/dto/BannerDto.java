package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BannerDto {
    Long id;

    String bannerName;
    String linkPath;
    String openOption;
    Long rangeNumber;
    boolean isPublic;

    LocalDateTime regDt;

    String filename;
    String urlFilename;

    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .linkPath(banner.getLinkPath())
                .openOption(banner.getOpenOption())
                .rangeNumber(banner.getRangeNumber())
                .isPublic(banner.isPublic())
                .regDt(banner.getRegDt())
                .filename(banner.getFileName())
                .urlFilename(banner.getUrlFileName())
                .build();
    }

}
