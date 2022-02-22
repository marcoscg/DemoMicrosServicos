package com.mardeveloper.pedido.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long idMenu;
    private Long idClient;
    private Long idRestaurant;
    private Double price;

}