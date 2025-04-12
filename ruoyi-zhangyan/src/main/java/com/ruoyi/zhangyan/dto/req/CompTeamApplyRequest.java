package com.ruoyi.zhangyan.dto.req;

import lombok.Data;

/**
 * @author : hswang7
 * @date : 2025/4/12
 * @description :
 */
@Data
public class CompTeamApplyRequest {

    private Long teamId;

    private Long userId;

    private String applyMessage;
}
