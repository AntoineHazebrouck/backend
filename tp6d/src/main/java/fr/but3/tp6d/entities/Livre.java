package fr.but3.tp6d.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Livre
{
	@Id
	private Integer id;
	private String categorie;
	private String titre;
	@ManyToOne
	// @JoinColumn(name = "auteur_id")
	private Auteur auteur;
}
