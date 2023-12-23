package fr.but3.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Auteur
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	@Column(nullable = false, length = 20)
	private String nom;
	private String prenom;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "auteur")
	private List<Livre> livres;
}
