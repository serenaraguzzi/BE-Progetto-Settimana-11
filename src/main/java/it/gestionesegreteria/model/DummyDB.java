package it.gestionesegreteria.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import lombok.Getter;

@Component
@Getter
public class DummyDB {

	private List<Studente> studenti = new ArrayList<>();
	private List<CorsoLaurea> corsi = new ArrayList<>();

	public void aggiungiStudente(Studente s) {
		studenti.add(s);
	}

	public void aggiungiCorso(CorsoLaurea c) {
		corsi.add(c);
	}

	public boolean eliminaStudente(String matricola) {
		for (int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getMatricola().equals(matricola)) {
				studenti.remove(i);
				return true;
			}
		}
		return false;
	}

	public Studente getStudenteByMatricola(String matricola) {
		for (Studente s : studenti) {
			if (s.getMatricola().equals(matricola))
				return s;
		}
		return null;
	}

	public CorsoLaurea getCorsoByCodice(String codice) {
		for (CorsoLaurea c : corsi) {
			if (c.getCodice().equals(codice))
				return c;
		}
		return null;
	}

	public boolean eliminaCorso(String codice) {
		for (int i = 0; i < corsi.size(); i++) {
			if (corsi.get(i).getCodice().equals(codice)) {
				corsi.remove(i);
				return true;
			}
		}
		return false;
	}

}