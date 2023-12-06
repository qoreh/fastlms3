package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.entity.Course;
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
    String alterText;
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
                .alterText(banner.getAlterText())
                .linkPath(banner.getLinkPath())
                .openOption(banner.getOpenOption())
                .rangeNumber(banner.getRangeNumber())
                .isPublic(banner.isPublic())
                .regDt(banner.getRegDt())
                .filename(banner.getFileName())
                .urlFilename(banner.getUrlFileName())
                .build();
    }
    public static List<BannerDto> of(List<Banner> banners) {
        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();
        for(Banner b : banners) {
            bannerList.add(BannerDto.of(b));
        }

        return bannerList;
    }

}
