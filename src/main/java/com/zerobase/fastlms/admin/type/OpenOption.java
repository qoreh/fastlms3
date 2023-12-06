package com.zerobase.fastlms.admin.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OpenOption {
    NEW_WINDOW("새 창"),
    CUR_WINDOW("현재 창");

    private final String optionVal;

}
