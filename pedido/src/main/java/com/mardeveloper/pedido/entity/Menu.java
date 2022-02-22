package com.mardeveloper.pedido.entity;

import lombok.*;
import org.modelmapper.ModelMapper;

import com.mardeveloper.pedido.dto.MenuOrderDto;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idMenu;
    private String name;
    private Double price;
    private Long idRestaurant;

    public static Menu create(MenuOrderDto menuOrderDto) {
        return new ModelMapper().map(menuOrderDto, Menu.class);
    }

}
