package com.mardeveloper.cadastro.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.mardeveloper.cadastro.dto.RestaurantDto;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_restaurant")
public class Restaurant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	
	public static Restaurant create(RestaurantDto restaurantDto) {
		return new ModelMapper().map(restaurantDto, Restaurant.class);		
	}

}
