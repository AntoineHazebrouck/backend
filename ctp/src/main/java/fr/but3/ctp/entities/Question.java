package fr.but3.ctp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
