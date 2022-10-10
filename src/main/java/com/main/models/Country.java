package com.main.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name="countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long countryId;
	
	@Column(nullable = false)
	private String countryName;
	
	@Column(nullable = false)
	private Long fee;
	
	@Column(nullable = false)	
	private int countryCode;
	
	private Set<Country> countrySet;

}
