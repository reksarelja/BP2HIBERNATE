package me.baze2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class Rdj15823Au2KnjId implements java.io.Serializable {
	private static final long serialVersionUID = 5669262795591504499L;
	@Column(name = "AUTOR_AUTOR_JMBG", nullable = false)
	private Long autorAutorJmbg;

	@Column(name = "KNJIGA_KNJIGA_ID", nullable = false)
	private Long knjigaKnjigaId;

	public Long getAutorAutorJmbg() {
		return autorAutorJmbg;
	}

	public void setAutorAutorJmbg(Long autorAutorJmbg) {
		this.autorAutorJmbg = autorAutorJmbg;
	}

	public Long getKnjigaKnjigaId() {
		return knjigaKnjigaId;
	}

	public void setKnjigaKnjigaId(Long knjigaKnjigaId) {
		this.knjigaKnjigaId = knjigaKnjigaId;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Rdj15823Au2KnjId entity = (Rdj15823Au2KnjId) o;
		return Objects.equals(this.autorAutorJmbg, entity.autorAutorJmbg) &&
				Objects.equals(this.knjigaKnjigaId, entity.knjigaKnjigaId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(autorAutorJmbg, knjigaKnjigaId);
	}

}