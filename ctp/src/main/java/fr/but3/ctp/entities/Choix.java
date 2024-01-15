package fr.but3.ctp.entities;

import java.util.List;
import org.hibernate.annotations.ColumnDefault;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	// @ColumnDefault(value = "0")
	// @Column(name = "nbchoix", columnDefinition = "nbchoix int default 0")
	private Integer nbchoix;
	// @ManyToOne(targetEntity = Question.class)
	// @JoinColumn(name = "qno", nullable = false)
	// private Question qno;
}
