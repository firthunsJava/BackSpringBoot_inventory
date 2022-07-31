package com.example.backspringboot_inventory.model;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;

@Data // nos ahorra poner los getter y setters
@Entity
@Table(name = "category")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4310027227752446841L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

}
