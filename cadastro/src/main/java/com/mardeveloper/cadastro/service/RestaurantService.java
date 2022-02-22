package com.mardeveloper.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mardeveloper.cadastro.entity.Restaurant;
import com.mardeveloper.cadastro.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Restaurant insertRepository(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	public Restaurant updateRepository(Restaurant restaurant) {
		
		Optional<Restaurant> objRestaurant = restaurantRepository.findById(restaurant.getId());
		
		if (objRestaurant.isPresent()) {
			return restaurantRepository.save(restaurant);			
		} else {
			return null; 			
		}
	}
	
	public boolean deleteRepository(Long id) {
		
		Optional<Restaurant> objRestaurant = restaurantRepository.findById(id);
		
		if (objRestaurant.isPresent()) {
			restaurantRepository.delete(objRestaurant.get());
			return true;
		} else {
			return false; 			
		}
	}
	
	public Optional<Restaurant> findById(Long id) {
		
		Optional<Restaurant> objRestaurant = restaurantRepository.findById(id);
		
		return objRestaurant;
	}
	
	public List<Restaurant> findAll() {
		
		List<Restaurant> list = restaurantRepository.findAll();
		
		return list;
	}	

}
