package com.koubs.json.jackson.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KouBeisi
 * @since 2022/1/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Long id;

    private String name;

    private Integer age;

    @JsonProperty("sex")
    private Integer gender;

}
