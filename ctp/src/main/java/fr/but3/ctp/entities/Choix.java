package fr.but3.ctp.entities;

import java.util.Optional;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "choix")
public class Choix
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	private String libchoix;
	private Boolean statut;
	private Integer nbchoix;
	@ManyToOne
	private Question question;

	public Integer getNbchoix() {
		return Optional.ofNullable(nbchoix).orElse(0);
	}

	
}
