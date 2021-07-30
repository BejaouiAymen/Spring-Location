package org.location.dao;




import java.util.Date;

import org.location.entities.Logement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LogementDAO extends JpaRepository<Logement, Long> {


	
	//find by adresse
	@Query("select e from Logement e where e.adresseLog like:x")
	public Page<Logement> findByAdresseLog(@Param("x") String adr,Pageable pageable);
	
	//find by key word
	@Query("select e from Logement e where (e.nomLog like:x) or (e.adresseLog like:x) or (e.descriptionLog like:x)")
	public Page<Logement> findbyKw(@Param("x")String mc,Pageable pageable);
	
	//find by price
	@Query("select e from Logement e where e.prix >:x	and e.prix <:y")
	public Page<Logement> findByPrice(@Param("x")double p1,@Param("y")double p2,Pageable pageable);
	
	//find by type
	@Query("select e from Logement e where e.typelog=x")
	public Page<Logement> findByType(@Param("x")Long idt,Pageable pageable);
	
	//dispo aujourd'hui
	Date d=new Date();
	@Query("select e from Logement e , Contrat c where e.idLog=c.logement and (d between c.dateDeb and c.dateFin)  ")
	public Page<Logement> findBydispo(@Param("d")Date d,Pageable pageable);
	//find between 2 date
	@Query("select e from Logement e , Contrat c where e.idLog=c.logement and (c.dateDeb>d2 or c.dateFin<d1)")
	public Page<Logement> findbetween2date(@Param("d1")Date d1,@Param("d2")Date d2,Pageable pageable);


	
	
	
	
	
}
