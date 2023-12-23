package fr.but3.tp6c;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Auteur
{
	@Id
	private Integer id;
	private String email;
	private String nom;
	private String prenom;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	@Override
	public String toString()
	{
		return "Auteur [id=" + id + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}
}
