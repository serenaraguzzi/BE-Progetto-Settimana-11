package it.gestionesegreteria.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import it.gestionesegreteria.model.CorsoLaurea;
import it.gestionesegreteria.model.DummyDB;
import it.gestionesegreteria.model.Studente;

@Component
public class DummyDBLoader implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		DummyDB dummyDb = ctx.getBean(DummyDB.class);
		valorizzaDb(dummyDb);
	}

	//creo i corsi
	public void valorizzaDb(DummyDB db) {
		CorsoLaurea c1 = CorsoLaurea.builder().codice("c10").nome("Informatica BE").indirizzo("via Rosso 1")
				.numeroEsami(11).build();
		CorsoLaurea c2 = CorsoLaurea.builder().codice("c21").nome("Informatica FE").indirizzo("via Bianco 12")
				.numeroEsami(13).build();
		CorsoLaurea c3 = CorsoLaurea.builder().codice("c32").nome("Informatica FS").indirizzo("via Giallo 23")
				.numeroEsami(15).build();
		CorsoLaurea c4 = CorsoLaurea.builder().codice("c43").nome("Chimica").indirizzo("via Nero 34").numeroEsami(17)
				.build();
		CorsoLaurea c5 = CorsoLaurea.builder().codice("c54").nome("Enologia").indirizzo("via Grigio 45").numeroEsami(19)
				.build();
		CorsoLaurea c6 = CorsoLaurea.builder().codice("c65").nome("Giurisprudenza").indirizzo("via Blu 56")
				.numeroEsami(18).build();
		CorsoLaurea c7 = CorsoLaurea.builder().codice("c76").nome("Ingegneria").indirizzo("via Lilla 67")
				.numeroEsami(16).build();
		CorsoLaurea c8 = CorsoLaurea.builder().codice("c87").nome("Economia").indirizzo("via Arancione 78")
				.numeroEsami(14).build();
		CorsoLaurea c9 = CorsoLaurea.builder().codice("c98").nome("Medicina").indirizzo("via Beige 89").numeroEsami(12)
				.build();

		//creo gli studenti
		Studente s1 = Studente.builder().matricola("a109").nome("Serena").cognome("Raguzzi").dataNascita("1989-06-16")
				.email("rag.sere@hotmail.it").indirizzo("via san luca 12").citta("Villafranca").corsoLaurea(c4).build();
		Studente s2 = Studente.builder().matricola("b1110").nome("Simone").cognome("Guidi").dataNascita("1992-04-22")
				.email("simo4president@gmail.com").indirizzo("via a caso 56").citta("Genova").corsoLaurea(c7).build();
		Studente s3 = Studente.builder().matricola("c1211").nome("Pasquale").cognome("Torcasio")
				.dataNascita("1996-04-29").email("pachino@gmail.it").indirizzo("via del campo 78").citta("Lamezia")
				.corsoLaurea(c5).build();
		Studente s4 = Studente.builder().matricola("d1312").nome("Riccardo").cognome("Anaclerio")
				.dataNascita("1993-09-21").email("sanrick@yahoo.it").indirizzo("via cattedrale 99").citta("Cremona")
				.corsoLaurea(c3).build();
		Studente s5 = Studente.builder().matricola("e1413").nome("Alessio").cognome("Tabolacci")
				.dataNascita("1989-05-14").email("tabman@hotmail.com").indirizzo("via le mani dalla testa 13")
				.citta("Roma").corsoLaurea(c9).build();
		Studente s6 = Studente.builder().matricola("f1514").nome("Giuliano").cognome("Scassaioli")
				.dataNascita("1987-12-17").email("r3frain@gmail.it").indirizzo("via de la che te porto de qua 24")
				.citta("Roma").corsoLaurea(c2).build();
		Studente s7 = Studente.builder().matricola("g1615").nome("Francesco").cognome("Viglianisi")
				.dataNascita("1998-03-02").email("fra.vi98@yahoo.it").indirizzo("via nn me la ricordo 35")
				.citta("Milano").corsoLaurea(c8).build();
		Studente s8 = Studente.builder().matricola("h1716").nome("Antonello").cognome("Pagnozzi")
				.dataNascita("1993-07-31").email("amnendar@gmail.com").indirizzo("via che ne so 46").citta("Roma")
				.corsoLaurea(c6).build();
		Studente s9 = Studente.builder().matricola("i1817").nome("Cataldo").cognome("Aprea").dataNascita("1993-04-18")
				.email("scirox@hotmail.it").indirizzo("via non ho piu idee 57").citta("Palermo").corsoLaurea(c1)
				.build();

		db.aggiungiCorso(c1);
		db.aggiungiCorso(c2);
		db.aggiungiCorso(c3);
		db.aggiungiCorso(c4);
		db.aggiungiCorso(c5);
		db.aggiungiCorso(c6);
		db.aggiungiCorso(c7);
		db.aggiungiCorso(c8);
		db.aggiungiCorso(c9);

		db.aggiungiStudente(s1);
		db.aggiungiStudente(s2);
		db.aggiungiStudente(s3);
		db.aggiungiStudente(s4);
		db.aggiungiStudente(s5);
		db.aggiungiStudente(s6);
		db.aggiungiStudente(s7);
		db.aggiungiStudente(s8);
		db.aggiungiStudente(s9);
	}

}