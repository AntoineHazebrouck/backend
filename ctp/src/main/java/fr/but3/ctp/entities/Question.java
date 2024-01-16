package fr.but3.ctp.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "question")
public class Question
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qno;
	private String libquest;
	@Column(columnDefinition = "boolean default false")
	private Boolean active = false;
	@OneToMany
	@JoinColumn(name = "qno", nullable = false)
	private List<Choix> choix;
}
