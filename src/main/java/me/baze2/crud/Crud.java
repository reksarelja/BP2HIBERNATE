package me.baze2.crud;

import jakarta.persistence.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import me.baze2.entities.Rdj15823Clan;
import me.baze2.entities.Rdj15823Knjiga;
import me.baze2.entities.Rdj15823Pozajmica;
import me.baze2.utils.PersistenceEntityManager;

import java.time.LocalDate;
import java.util.List;

public class Crud {

	private final PersistenceEntityManager pem = PersistenceEntityManager.getInstance("default");

	public ObservableList<Rdj15823Clan> listClan(){
		EntityManager em = pem.getEntityManager();
		TypedQuery<Rdj15823Clan> tq = em.createQuery("Select s from Rdj15823Clan s", Rdj15823Clan.class);
		List<Rdj15823Clan> list = tq.getResultList();
		ObservableList<Rdj15823Clan> l = FXCollections.observableList(list);
		em.close();
		return l;
	}
	public ObservableList<Rdj15823Knjiga> listKnjiga(){
		EntityManager em = pem.getEntityManager();
		TypedQuery<Rdj15823Knjiga> tq = em.createQuery("Select s from Rdj15823Knjiga s", Rdj15823Knjiga.class);
		List<Rdj15823Knjiga> list = tq.getResultList();
		ObservableList<Rdj15823Knjiga> l = FXCollections.observableList(list);
		em.close();
		return l;
	}
	public ObservableList<Rdj15823Knjiga> listKnjigeFromClan(Rdj15823Clan clan){
		EntityManager em = pem.getEntityManager();
		TypedQuery<Rdj15823Knjiga> tq = em.createQuery("Select k from Rdj15823Knjiga k " +
				"inner join Rdj15823Pozajmica p " +
				"on k = p.knjigaKnjiga " +
				"inner join Rdj15823Clan c " +
				"on p.clanClan = c " +
				"where c = :c and extract(year from p.pozajmicaUzeto) = 2024", Rdj15823Knjiga.class);
		tq.setParameter("c", clan);
		ObservableList<Rdj15823Knjiga> l = FXCollections.observableList(tq.getResultList());
		em.close();
		return l;
	}
	public void insertClan(Long jmbg, String ime, String prezime){
		try(EntityManager em = pem.getEntityManager()) {

			Rdj15823Clan clan = new Rdj15823Clan();
			clan.setId(jmbg);
			clan.setClanIme(ime);
			clan.setClanPrezime(prezime);
			em.getTransaction().begin();
			em.persist(clan);
			em.getTransaction().commit();

		} catch(PersistenceException e) {
			new Alert(Alert.AlertType.ERROR, "Jmbg already exists!", ButtonType.OK).showAndWait();
		}
	}
	public void deleteClan(Rdj15823Clan clan){
		EntityManager em = pem.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.contains(clan) ? clan : em.merge(clan));
		em.getTransaction().commit();
		em.close();
	}
	public void addPozajmica(Long id, Rdj15823Clan clan, Rdj15823Knjiga knjiga, LocalDate date){
		try(EntityManager em = pem.getEntityManager()) {
			Rdj15823Pozajmica pozajmica = new Rdj15823Pozajmica();
			pozajmica.setId(id);
			pozajmica.setClanClan(clan);
			pozajmica.setKnjigaKnjiga(knjiga);
			pozajmica.setPozajmicaUzeto(date);
			em.getTransaction().begin();
			em.persist(pozajmica);
			em.getTransaction().commit();
		} catch(PersistenceException e) {
			new Alert(Alert.AlertType.ERROR, "Out of book copies or Pozajmica number already exists", ButtonType.OK).showAndWait();
		}
	}
	public String maxPozId(){
		EntityManager em = pem.getEntityManager();
		Query q = em.createQuery("Select max(id + 1) from Rdj15823Pozajmica");
		return q.getResultList().getFirst().toString();

	}
	public void updateKnjiga(Rdj15823Clan clan){
		EntityManager em = pem.getEntityManager();
		TypedQuery<Long[]> q = em.createQuery("Select k.id, count(k.id) " +
				"from Rdj15823Knjiga k " +
				"inner join Rdj15823Pozajmica p " +
				"on k = p.knjigaKnjiga " +
				"where p.clanClan = :c " +
				"group by k.id", Long[].class);
		q.setParameter("c", clan);
		q.getResultList().forEach(t -> {
			em.getTransaction().begin();
			Rdj15823Knjiga temp = em.find(Rdj15823Knjiga.class, t[0]);
			temp.setKnjigaBrPrim(temp.getKnjigaBrPrim() + t[1]);
			em.merge(temp);
			em.getTransaction().commit();
		});
		em.close();
	}


}