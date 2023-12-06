package com.zerobase.fastlms.admin.model;

import lombok.Data;

@Data
public class BannerInput {
    Long id;
    String bannerName;
    String linkPath;
    String openOption;
    Long rangeNumber;
    boolean isPublic;

    // delete
    String idList;

    //file
    String filename;
    String urlFilename;
}
