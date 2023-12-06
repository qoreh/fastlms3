package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {
    private final BannerMapper bannerMapper;
    private final BannerRepository bannerRepository;

    public List<BannerDto> list(BannerParam parameter) {
        long totalCount = bannerMapper.selectListCount(parameter);

        List<BannerDto> list = bannerMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
        return list;
    }

    @Override
    public boolean set(BannerInput parameter) {
        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());
        if (!optionalBanner.isPresent()) {
            return false;
        }

        Banner banner = optionalBanner.get();

        banner.setBannerName(parameter.getBannerName());
        banner.setAlterText(parameter.getBannerName() + " 배너의 대체 텍스트 입니다.");
        banner.setLinkPath(parameter.getLinkPath());
        banner.setOpenOption(parameter.getOpenOption());
        banner.setRangeNumber(parameter.getRangeNumber());
        banner.setPublic(parameter.isPublic());
        banner.setFileName(parameter.getFilename());
        banner.setUrlFileName(parameter.getUrlFilename());

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean add(BannerInput parameter) {
        Banner banner = Banner.builder()
                .bannerName(parameter.getBannerName())
                .alterText(parameter.getBannerName() + " 배너의 대체 텍스트 입니다.")
                .linkPath(parameter.getLinkPath())
                .openOption(parameter.getOpenOption())
                .rangeNumber(parameter.getRangeNumber())
                .isPublic(parameter.isPublic())
                .fileName(parameter.getFilename())
                .urlFileName(parameter.getUrlFilename())
                .build();

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public boolean del(String idList) {
        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return true;
    }

    @Override
    public List<BannerDto> publicList(BannerParam parameter) {
        List<Banner> banners = bannerRepository.findAllByIsPublicTrueOrderByRangeNumber();
        if (CollectionUtils.isEmpty(banners)) {
            return null;
        }
        return BannerDto.of(banners);
    }

}
