package com.koubs.lombok;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author koubs
 * @date 2021/4/11
 */
@Data
public class BaseEntity {

    private Boolean isDelete;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
