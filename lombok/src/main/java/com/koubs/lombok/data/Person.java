package com.koubs.lombok.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.lombok.BaseEntity;

/**
 * @author koubs
 * @date 2021/4/11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity {

    private String name;

    private Integer age;

    private Pet pet;
}
