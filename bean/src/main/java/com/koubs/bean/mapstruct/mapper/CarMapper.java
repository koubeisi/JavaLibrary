package com.koubs.bean.mapstruct.mapper;

import com.koubs.bean.mapstruct.dto.CarDto;
import com.koubs.bean.mapstruct.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author KouBeisi
 * @since 2021/7/25
 */
@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
}
