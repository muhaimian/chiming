package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Serializable {

    @Id
    private String id;
    private String title; //名称
    private String score; //分数
    private String broadcast; //播音
    private String author; //作者
    private String brief; //简介
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @Column(name = "publicTime")
    private Date publicTime; // 发布日期
    private String count; //集数
    @Column(name = "coverImg")
    private String coverImg; //封面
    private String status; //状态

    @Transient
    private List<Chapter> children;
}
