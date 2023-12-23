package fr.but3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@ToString(exclude = "auteur")
@Data
@Entity
public class Livre
{
	@Id
	private Integer id;
	private String categorie;
	private String titre;

	@ManyToOne
	private Auteur auteur;
}
