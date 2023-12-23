package fr.but3.tp6d.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Auteur
{
	@Id
	private Integer id;
	private String email;
	private String nom;
	private String prenom;
}
