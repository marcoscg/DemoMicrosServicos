package com.mardeveloper.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

	private String name;
	private Double price;
	private Long restaurant;	
	
}
