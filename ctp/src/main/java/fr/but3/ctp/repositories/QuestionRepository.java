package fr.but3.ctp.repositories;

import org.springframework.data.repository.CrudRepository;
import fr.but3.ctp.entities.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer>
{

}
