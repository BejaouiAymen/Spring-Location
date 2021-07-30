package org.location.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	@NotEmpty
	private String nomC;
	@Email
	private String email;
	private String tel;
	@Column(unique=true)
	private String username;
	private String password;
	private String role;
	
	
	@OneToMany(mappedBy="client")
	private Collection<Contrat> contrats;
	
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Collection<Contrat> getContrats() {
		return contrats;
	}
	public void setContrats(Collection<Contrat> contrats) {
		this.contrats = contrats;
	}

	
	
	
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public Client(@NotEmpty String nomC, @Email String email, String tel, String username, String password,
			String role) {
		super();
		this.nomC = nomC;
		this.email = email;
		this.tel = tel;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//nice

}
