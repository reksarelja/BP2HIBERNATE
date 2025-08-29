package me.baze2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RDJ15823_AUTOR")
public class Rdj15823Autor {
	@Id
	@Column(name = "AUTOR_JMBG", nullable = false)
	private Long id;

	@Column(name = "AUTOR_IME", nullable = false, length = 32)
	private String autorIme;

	@Column(name = "AUTOR_PREZIME", nullable = false, length = 32)
	private String autorPrezime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutorIme() {
		return autorIme;
	}

	public void setAutorIme(String autorIme) {
		this.autorIme = autorIme;
	}

	public String getAutorPrezime() {
		return autorPrezime;
	}

	public void setAutorPrezime(String autorPrezime) {
		this.autorPrezime = autorPrezime;
	}

	@Override
	public String toString() {
		return "Rdj15823Autor {" +
				"id = " + id +
				", autorIme = " + autorIme +
				", autorPrezime = " + autorPrezime +
				'}';
	}
}