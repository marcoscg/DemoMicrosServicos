package com.mardeveloper.pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mardeveloper.pedido.entity.Client;
import com.mardeveloper.pedido.entity.Menu;
import com.mardeveloper.pedido.entity.Order;
import com.mardeveloper.pedido.exception.NotFoundException;
import com.mardeveloper.pedido.repository.ClientRepository;
import com.mardeveloper.pedido.repository.MenuRepository;
import com.mardeveloper.pedido.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ClientRepository clientRepository;

    private final MenuRepository menuRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, MenuRepository menuRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.menuRepository = menuRepository;
    }

    public Order saveOrder(Order order) throws NotFoundException {

        System.out.println(order);

        final Optional<Client> client = clientRepository.findByIdClient(order.getIdClient());

        if (client.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }

        System.out.println(order.getIdMenu());
        System.out.println(order.getIdRestaurant());
        final Optional<Menu> menu = menuRepository.findByIdMenuAndIdRestaurant(order.getIdMenu(), order.getIdRestaurant());

        if (menu.isEmpty()) {
            throw new NotFoundException("Menu ou restaurantes não encontrados");
        }

        return orderRepository.save(order);
    }
}
