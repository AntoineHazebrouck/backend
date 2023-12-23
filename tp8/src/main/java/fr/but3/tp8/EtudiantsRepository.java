package fr.but3.tp8;

import org.springframework.data.repository.CrudRepository;

public interface EtudiantsRepository extends CrudRepository<Etudiant, Integer> {
	Iterable<Etudiant> findByGroupeOrderByNom(String groupe);
}
