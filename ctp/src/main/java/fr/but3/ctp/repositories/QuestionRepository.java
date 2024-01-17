package fr.but3.ctp.repositories;

import org.springframework.data.repository.CrudRepository;
import fr.but3.ctp.entities.Question;
import java.util.List;


public interface QuestionRepository extends CrudRepository<Question, Integer>
{
	List<Question> findAll();
	List<Question> findByActive(Boolean active);
}
