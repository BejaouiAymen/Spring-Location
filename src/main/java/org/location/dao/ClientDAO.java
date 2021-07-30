package org.location.dao;



import org.location.entities.Client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientDAO extends JpaRepository<Client, Long> {
	
	
	
	//find by email
	@Query("select e from Client e where e.email like:x")
	public Page<Client> ChercherClientmail(@Param("x") String mail,Pageable pageable);
	
	//find by phone
	@Query("select e from Client e where e.tel like:y")
	public Page<Client> ChercherClienttel(@Param("y") String tel,Pageable pageable);
	
	
	
/*
	public void modifier_client(Client c);
	public void supprimer_client(Long idc);
	*/
	
}
