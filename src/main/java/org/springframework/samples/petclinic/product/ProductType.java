package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ProductTypes")
public class ProductType {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name = "name", unique = true)
    @Min(3)
    @Max(50)
    @NotEmpty
    String name;
}
