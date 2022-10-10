package com.main.models;

import com.postgre.models.enums.AccountRole;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false, unique = true)
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Email cannot be empty")
	private String email;

	@Column(nullable = false)
	private String password;

	@Column
	private String dateOfBirth;

	@Column
	private String userCountry;

	@Column
	private int userZipCode;

	@Column
	private int phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AccountRole accountRole;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date created_at;
	
	
    private Set<Shipments> shipments = new LinkedHashSet<>();

    
    public Set<Shipments> getShipments() {
        return shipments;
    }
    
    public void setShipments(Set<Shipments> shipments) {
        this.shipments = shipments;
    }
	
	public User() {

	}

}
