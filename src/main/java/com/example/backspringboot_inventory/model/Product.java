package com.example.backspringboot_inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7461389651533509262L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int price;
	
	private int account;
//	N:1 ->
	@ManyToOne(fetch= FetchType.LAZY) //propiedad, lectura demorada de asociaciones
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"}) //Relación entre dos tablas, se generan nuevas propiedades, con las propiedades indicadas entre llaves, hacemos que se ingnoren
	private Category category;
	
	@Lob //Indicamos q se trata de un objeto pesado
	@Basic(fetch = FetchType.LAZY)
	@Column( name ="picture")
	private byte[] picture;
	
	

}
