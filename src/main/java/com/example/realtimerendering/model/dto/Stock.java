package com.example.realtimerendering.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@ApiModel(value = "stock",description = "종목 정보")
public class Stock {

    @ApiModelProperty(value = "종목 id")
    private Integer id;
    @ApiModelProperty(value = "종목 코드")
    private String code;
    @ApiModelProperty(value = "종목 이름")
    private String name;
    @ApiModelProperty(value = "시작 가격")
    private Integer startPrice;
    @ApiModelProperty(value = "현재 가격")
    private Integer nowPrice;
    @ApiModelProperty(value = "마지막 가격")
    private Integer endPrice;
    @ApiModelProperty(value = "조회 수")
    private Integer viewCount;
    @ApiModelProperty(value = "거래 횟수")
    private Integer tradeCount;
    @ApiModelProperty(value = "삭제 표시 flag")
    private Integer deleteFlag;
    @ApiModelProperty(value = "createTime")
    private Date createTime;
    @ApiModelProperty(value = "updateTime")
    private Date updateTime;
    @ApiModelProperty(value = "createId")
    private Integer createId;
    @ApiModelProperty(value = "updateId")
    private Integer updateId;

}
