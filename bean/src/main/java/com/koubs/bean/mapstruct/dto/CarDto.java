package com.koubs.bean.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KouBeisi
 * @since 2021/7/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private String make;
    private int seatCount;
    private String type;

    //constructor, getters, setters etc.
}
