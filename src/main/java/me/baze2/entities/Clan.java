package me.baze2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"RDJ15823_ČLAN\"")
public class Clan {
	@Id
	@Column(name = "CLAN_JMBG", nullable = false)
	private Long id;

	@Column(name = "CLAN_IME", nullable = false, length = 32)
	private String clanIme;

	@Column(name = "CLAN_PREZIME", nullable = false, length = 32)
	private String clanPrezime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClanIme() {
		return clanIme;
	}

	public void setClanIme(String clanIme) {
		this.clanIme = clanIme;
	}

	public String getClanPrezime() {
		return clanPrezime;
	}

	public void setClanPrezime(String clanPrezime) {
		this.clanPrezime = clanPrezime;
	}

	@Override
	public String toString() {
		return "Clan { " +
				"id = " + id +
				", clanIme = " + clanIme +
				", clanPrezime = " + clanPrezime +
				'}';
	}
}