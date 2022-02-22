package com.mardeveloper.pedido.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import com.mardeveloper.pedido.dto.OrderDto;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "menu_id", nullable = false)
    private Long idMenu;

    @Column(name = "client_id", nullable = false)
    private Long idClient;

    @Column(name = "restaurant_id", nullable = false)
    private Long idRestaurant;

    @Column(nullable = false)
    private Double price;

    @Column(name = "date_order", nullable = false)
    private Date dateOrder;

//    public Order(Long idMenu, Long idClient, Long idRestaurant, Long idProduct, Double price, Date date) {
//    }

    public static Order create(OrderDto orderDto) {
        return new ModelMapper().map(orderDto, Order.class);
    }

}
