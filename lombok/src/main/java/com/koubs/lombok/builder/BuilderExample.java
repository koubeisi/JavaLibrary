package com.koubs.lombok.builder;

import lombok.Builder;
import lombok.Data;

/**
 * @author koubs
 * @date 2021/4/11
 */
@Builder
@Data
public class BuilderExample {

    private String username;
    private String email;
    private String age;

}
