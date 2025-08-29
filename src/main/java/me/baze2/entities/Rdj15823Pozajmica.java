package me.baze2.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "RDJ15823_POZAJMICA")
public class Rdj15823Pozajmica {
	@Id
	@Column(name = "POZAJMICA_BROJ", nullable = false)
	private Long id;

	@Column(name = "POZAJMICA_UZETO", nullable = false)
	private LocalDate pozajmicaUzeto;

	@Column(name = "POZAJMICA_VRACENO")
	private LocalDate pozajmicaVraceno;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "\"ČLAN_CLAN_JMBG\"", nullable = false)
	private Rdj15823Clan clanClan;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "KNJIGA_KNJIGA_ID", nullable = false)
	private Rdj15823Knjiga knjigaKnjiga;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPozajmicaUzeto() {
		return pozajmicaUzeto;
	}

	public void setPozajmicaUzeto(LocalDate pozajmicaUzeto) {
		this.pozajmicaUzeto = pozajmicaUzeto;
	}

	public LocalDate getPozajmicaVraceno() {
		return pozajmicaVraceno;
	}

	public void setPozajmicaVraceno(LocalDate pozajmicaVraceno) {
		this.pozajmicaVraceno = pozajmicaVraceno;
	}

	public Rdj15823Clan getClanClan() {
		return clanClan;
	}

	public void setClanClan(Rdj15823Clan clanClan) {
		this.clanClan = clanClan;
	}

	public Rdj15823Knjiga getKnjigaKnjiga() {
		return knjigaKnjiga;
	}

	public void setKnjigaKnjiga(Rdj15823Knjiga knjigaKnjiga) {
		this.knjigaKnjiga = knjigaKnjiga;
	}

	@Override
	public String toString() {
		return "Rdj15823Pozajmica { " +
				"id = " + id +
				", pozajmicaUzeto = " + pozajmicaUzeto +
				", pozajmicaVraceno = " + pozajmicaVraceno +
				", članClanJmbg = " + clanClan +
				", knjigaKnjiga = " + knjigaKnjiga +
				'}';
	}
}