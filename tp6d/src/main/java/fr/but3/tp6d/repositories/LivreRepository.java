package fr.but3.tp6d.repositories;

import org.springframework.data.repository.CrudRepository;
import fr.but3.tp6d.entities.Livre;

public interface LivreRepository extends CrudRepository<Livre, Integer>
{

}
