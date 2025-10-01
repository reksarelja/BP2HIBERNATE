package me.baze2.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "RDJ15823_POZAJMICA")
public class Pozajmica {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "poz_seq", sequenceName = "RDJ15823_POZSEQ", allocationSize = 1)
	@Column(name = "POZAJMICA_BROJ", nullable = false)
	private int id;

	@Column(name = "POZAJMICA_UZETO", nullable = false)
	private LocalDate pozajmicaUzeto;

	@Column(name = "POZAJMICA_VRACENO")
	private LocalDate pozajmicaVraceno;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "\"ČLAN_CLAN_JMBG\"", nullable = false)
	private Clan clanClan;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "KNJIGA_KNJIGA_ID", nullable = false)
	private Knjiga knjigaKnjiga;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Clan getClanClan() {
		return clanClan;
	}

	public void setClanClan(Clan clanClan) {
		this.clanClan = clanClan;
	}

	public Knjiga getKnjigaKnjiga() {
		return knjigaKnjiga;
	}

	public void setKnjigaKnjiga(Knjiga knjigaKnjiga) {
		this.knjigaKnjiga = knjigaKnjiga;
	}

	@Override
	public String toString() {
		return "Pozajmica { " +
				"id = " + id +
				", pozajmicaUzeto = " + pozajmicaUzeto +
				", pozajmicaVraceno = " + pozajmicaVraceno +
				", članClanJmbg = " + clanClan +
				", knjigaKnjiga = " + knjigaKnjiga +
				'}';
	}
}