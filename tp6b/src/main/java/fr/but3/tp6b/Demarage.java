package fr.but3.tp6b;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Demarage implements ApplicationRunner
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private AuteurRowMapper auteurRowMapper;

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		List<Auteur> result = jdbcTemplate.query("SELECT * FROM auteur", auteurRowMapper);

		result.forEach(auteur -> System.out.println(auteur));
	}

}
