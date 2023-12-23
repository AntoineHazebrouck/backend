package fr.but3.tp6b;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AuteurRowMapper implements RowMapper<Auteur>
{

	@Override
	public Auteur mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Auteur auteur = new Auteur();
		auteur.setId(rs.getInt("id"));
		auteur.setEmail(rs.getString("email"));
		auteur.setNom(rs.getString("nom"));
		auteur.setPrenom(rs.getString("prenom"));
		return auteur;
	}

}
