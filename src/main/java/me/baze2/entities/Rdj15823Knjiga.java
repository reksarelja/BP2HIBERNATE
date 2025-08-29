package me.baze2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RDJ15823_KNJIGA")
public class Rdj15823Knjiga {
	@Id
	@Column(name = "KNJIGA_ID", nullable = false)
	private Long id;

	@Column(name = "KNJIGA_NAZIV", nullable = false, length = 32)
	private String knjigaNaziv;

	@Column(name = "KNJIGA_GOD_IZD", nullable = false)
	private Long knjigaGodIzd;

	@Column(name = "KNJIGA_BR_PRIM", nullable = false)
	private Long knjigaBrPrim;

	@Column(name = "KNJIGA_KATEG", nullable = false, length = 32)
	private String knjigaKateg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKnjigaNaziv() {
		return knjigaNaziv;
	}

	public void setKnjigaNaziv(String knjigaNaziv) {
		this.knjigaNaziv = knjigaNaziv;
	}

	public Long getKnjigaGodIzd() {
		return knjigaGodIzd;
	}

	public void setKnjigaGodIzd(Long knjigaGodIzd) {
		this.knjigaGodIzd = knjigaGodIzd;
	}

	public Long getKnjigaBrPrim() {
		return knjigaBrPrim;
	}

	public void setKnjigaBrPrim(Long knjigaBrPrim) {
		this.knjigaBrPrim = knjigaBrPrim;
	}

	public String getKnjigaKateg() {
		return knjigaKateg;
	}

	public void setKnjigaKateg(String knjigaKateg) {
		this.knjigaKateg = knjigaKateg;
	}

	@Override
	public String toString() {
		return "Rdj15823Knjiga { " +
				"id = " + id +
				", knjigaNaziv = " + knjigaNaziv +
				", knjigaGodIzd = " + knjigaGodIzd +
				", knjigaBrPrim = " + knjigaBrPrim +
				", knjigaKateg = "  + knjigaKateg +
				'}';
	}
}