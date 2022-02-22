package com.mardeveloper.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mardeveloper.pedido.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
