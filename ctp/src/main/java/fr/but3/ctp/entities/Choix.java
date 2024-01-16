package fr.but3.ctp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(columnDefinition = "integer default 0")
	private Integer nbchoix;
}
