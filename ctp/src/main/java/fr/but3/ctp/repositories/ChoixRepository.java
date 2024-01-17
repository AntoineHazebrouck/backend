package fr.but3.ctp.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import fr.but3.ctp.entities.Choix;

public interface ChoixRepository extends CrudRepository<Choix, Integer>
{
	List<Choix> findAll();
}
