package fr.but3.tp7;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Etudiant
{
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String prenom;
	private Integer age;
	private String groupe;
}
