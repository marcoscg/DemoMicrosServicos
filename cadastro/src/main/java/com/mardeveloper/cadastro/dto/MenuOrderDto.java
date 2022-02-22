package com.mardeveloper.cadastro.dto;

import com.mardeveloper.cadastro.entity.Menu;

import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
public class MenuOrderDto {

    private Long idMenu;
    private String name;
    private Double price;
    private Long idRestaurant;

    public static MenuOrderDto create(Menu menu) {
        return new ModelMapper().map(menu, MenuOrderDto.class);
    }
}
