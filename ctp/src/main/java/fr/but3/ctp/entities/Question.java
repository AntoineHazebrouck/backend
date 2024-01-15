package fr.but3.ctp.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Question
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer qno;
	private String libquest;
	private Boolean active;
	@OneToMany
	// @JoinColumn(name = "qno", nullable = false)
	private List<Choix> choix;
}
