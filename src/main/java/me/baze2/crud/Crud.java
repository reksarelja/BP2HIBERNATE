package me.baze2.crud;

import jakarta.persistence.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import me.baze2.entities.Clan;
import me.baze2.entities.Knjiga;
import me.baze2.entities.Pozajmica;
import me.baze2.utils.PersistenceEntityManager;

import java.time.LocalDate;
import java.util.List;

public class Crud {

	private final PersistenceEntityManager pem = PersistenceEntityManager.getInstance("default");

	public ObservableList<Clan> listClan(){
		try(EntityManager em = pem.getEntityManager()) {
			TypedQuery<Clan> tq = em.createQuery("Select s from Clan s", Clan.class);
			List<Clan> list = tq.getResultList();
			return FXCollections.observableList(list);
		} catch(Exception e) {

			return FXCollections.emptyObservableList();
		}
	}
	public ObservableList<Knjiga> listKnjiga(){
		try(EntityManager em = pem.getEntityManager()) {
			TypedQuery<Knjiga> tq = em.createQuery("Select s from Knjiga s", Knjiga.class);
			List<Knjiga> list = tq.getResultList();
			return FXCollections.observableList(list);
		} catch(Exception e) {
			return FXCollections.emptyObservableList();
		}
	}
	public ObservableList<Knjiga> listKnjigeFromClan(Clan clan){
		try(EntityManager em = pem.getEntityManager()) {
			TypedQuery<Knjiga> tq = em.createQuery("Select k from Knjiga k " +
					"inner join Pozajmica p " +
					"on k = p.knjigaKnjiga " +
					"inner join Clan c " +
					"on p.clanClan = c " +
					"where c = :c and extract(year from p.pozajmicaUzeto) = 2024", Knjiga.class);
			tq.setParameter("c", clan);
			return FXCollections.observableList(tq.getResultList());
		} catch(Exception e) {
			return FXCollections.emptyObservableList();
		}

	}
	public void insertClan(Long jmbg, String ime, String prezime){
		EntityManager em = pem.getEntityManager();
			Clan clan = new Clan();
			clan.setId(jmbg);
			clan.setClanIme(ime);
			clan.setClanPrezime(prezime);
			em.getTransaction().begin();
			em.persist(clan);
		try{
			em.getTransaction().commit();
		} catch(PersistenceException e) {
			new Alert(Alert.AlertType.ERROR, "Jmbg already exists!", ButtonType.OK).showAndWait();
			rollBack(em);
		}finally{
			em.close();
		}
	}
	public void deleteClan(Clan clan){
		EntityManager em = pem.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.contains(clan) ? clan : em.merge(clan));
		try {
			em.getTransaction().commit();
		} catch(Exception e) {
			rollBack(em);
		}
		finally {
			em.close();
		}
	}
	public void addPozajmica(Clan clan, Knjiga knjiga, LocalDate date){
		EntityManager em = pem.getEntityManager();
			Pozajmica pozajmica = new Pozajmica();
			pozajmica.setClanClan(clan);
			pozajmica.setKnjigaKnjiga(knjiga);
			pozajmica.setPozajmicaUzeto(date);
			em.getTransaction().begin();
		try {
			em.persist(pozajmica);
			em.getTransaction().commit();
		} catch(PersistenceException e) {
			new Alert(Alert.AlertType.ERROR, "Out of book copies or Pozajmica number already exists", ButtonType.OK).showAndWait();
			rollBack(em);
		}
		finally{
			em.close();
		}
	}
	public String maxPozId(){
		EntityManager em = pem.getEntityManager();
		try {
			Query q = em.createQuery("Select max(id + 1) from Pozajmica");
			return q.getResultList().getFirst().toString();
		} catch(Exception e) {
			rollBack(em);
			return null;
		}
		finally{
			em.close();
		}
	}
	public void updateKnjiga(Clan clan){
		try(EntityManager em = pem.getEntityManager()) {
			TypedQuery<Long[]> q = em.createQuery("Select k.id, count(k.id) " +
					"from Knjiga k " +
					"inner join Pozajmica p " +
					"on k = p.knjigaKnjiga " +
					"where p.clanClan = :c " +
					"group by k.id", Long[].class);
			q.setParameter("c", clan);
			q.getResultList().forEach(t -> {
				em.getTransaction().begin();
				Knjiga temp = em.find(Knjiga.class, t[0]);
				temp.setKnjigaBrPrim(temp.getKnjigaBrPrim() + t[1]);
				em.merge(temp);
				try {
					em.getTransaction().commit();
				} catch(Exception e) {
					rollBack(em);
				}
			});
		}
	}
	public void rollBack(EntityManager em){
		em.getTransaction().rollback();
	}

}