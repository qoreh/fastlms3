package com.zerobase.fastlms.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bannerName;
    private String alterText;
    private String linkPath;
    private String openOption;
    private Long rangeNumber;
    private boolean isPublic;

    @CreatedDate
    private LocalDateTime regDt;


    private String fileName;
    private String urlFileName;

}
