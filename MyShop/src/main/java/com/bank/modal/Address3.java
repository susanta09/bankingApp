package com.bank.modal;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address3 {
	@EmbeddedId
    private AddressId id;
	@Column(name = "dist")
	private String dist;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
//	@ManyToOne(targetEntity = Registration.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name = "rid")
//	private Registration registration;
	
	@OneToMany(mappedBy = "address3",cascade = CascadeType.ALL)
	private Set<Registration2> registrations2;

	public AddressId getId() {
		return id;
	}

	public void setId(AddressId id) {
		this.id = id;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Registration2> getRegistrations2() {
		return registrations2;
	}

	public void setRegistrations2(Set<Registration2> registrations2) {
		this.registrations2 = registrations2;
	}
    
}
