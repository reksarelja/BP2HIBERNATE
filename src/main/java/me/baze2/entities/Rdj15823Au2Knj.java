package me.baze2.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "RDJ15823_AU_2_KNJ")
public class Rdj15823Au2Knj {
	@EmbeddedId
	private Rdj15823Au2KnjId id;

	@MapsId("autorAutorJmbg")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "AUTOR_AUTOR_JMBG", nullable = false)
	private Rdj15823Autor autorAutorJmbg;

	@MapsId("knjigaKnjigaId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "KNJIGA_KNJIGA_ID", nullable = false)
	private Rdj15823Knjiga knjigaKnjiga;

	public Rdj15823Au2KnjId getId() {
		return id;
	}

	public void setId(Rdj15823Au2KnjId id) {
		this.id = id;
	}

	public Rdj15823Autor getAutorAutorJmbg() {
		return autorAutorJmbg;
	}

	public void setAutorAutorJmbg(Rdj15823Autor autorAutorJmbg) {
		this.autorAutorJmbg = autorAutorJmbg;
	}

	public Rdj15823Knjiga getKnjigaKnjiga() {
		return knjigaKnjiga;
	}

	public void setKnjigaKnjiga(Rdj15823Knjiga knjigaKnjiga) {
		this.knjigaKnjiga = knjigaKnjiga;
	}


}