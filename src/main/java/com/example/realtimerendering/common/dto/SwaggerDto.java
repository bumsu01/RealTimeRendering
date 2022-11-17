package com.example.realtimerendering.common.dto;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@ApiModel(value = "SwaggerDto",description = "서버 데이터 반환 class")
public class SwaggerDto<T> {

    @ApiModelProperty(value = "결과 코드 : 성공 0 ; 실페 1")
    private Integer resultCode;

    @ApiModelProperty(value = "결과 메세지")
    private String resultMsg;

    @ApiModelProperty(value = "error 메세지")
    private String errorMsg;

    @ApiModelProperty(value = "결과 대상")
    private T result;

    @ApiModelProperty(value = "list 결과 대상")
    private List<T> resultList;

    @ApiModelProperty(value = "page 결과 대상")
    private PageInfo<T> resultPage;

}
