package me.baze2.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "RDJ15823_AU_2_KNJ")
public class Au2Knj {
	@EmbeddedId
	private Au2KnjId id;

	@MapsId("autorAutorJmbg")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "AUTOR_AUTOR_JMBG", nullable = false)
	private Autor autorAutorJmbg;

	@MapsId("knjigaKnjigaId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "KNJIGA_KNJIGA_ID", nullable = false)
	private Knjiga knjigaKnjiga;

	public Au2KnjId getId() {
		return id;
	}

	public void setId(Au2KnjId id) {
		this.id = id;
	}

	public Autor getAutorAutorJmbg() {
		return autorAutorJmbg;
	}

	public void setAutorAutorJmbg(Autor autorAutorJmbg) {
		this.autorAutorJmbg = autorAutorJmbg;
	}

	public Knjiga getKnjigaKnjiga() {
		return knjigaKnjiga;
	}

	public void setKnjigaKnjiga(Knjiga knjigaKnjiga) {
		this.knjigaKnjiga = knjigaKnjiga;
	}


}