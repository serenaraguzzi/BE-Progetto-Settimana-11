package it.gestionesegreteria.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import it.gestionesegreteria.model.CorsoLaurea;
import it.gestionesegreteria.model.DummyDB;
import it.gestionesegreteria.model.Studente;

@Controller
public class StudenteController {

	@Autowired
	private ApplicationContext ctx;

	private DummyDB getDummyDb() {
		return ctx.getBean(DummyDB.class);
	}

	//metodo per visualizzare gli studenti
	@GetMapping("/studenti")
	public ModelAndView visualizzaStudenti() {
		DummyDB db = getDummyDb();
		return new ModelAndView("visualizzaStudenti", "dummydb", db);
	}

	//metodi per aggiungere uno studente
	@GetMapping("/mostraformaggiungi/{matricola}")
	public ModelAndView aggiungiStudente() {
		DummyDB db = getDummyDb();
		List<CorsoLaurea> corsi = db.getCorsi();
		ModelAndView mav = new ModelAndView("aggiungiStudente", "studente", new Studente());
		mav.addObject("corsi", corsi);
		return mav;
	}

	@PostMapping("/aggiungiStudente")
	public ModelAndView aggiungiStudente(@Valid @ModelAttribute("studente") Studente studente, BindingResult result,
			ModelMap model) {
		DummyDB db = getDummyDb();
		db.aggiungiStudente(studente);
		return visualizzaStudenti();
	}

	//metodo per eliminare uno studente
	@GetMapping("/eliminastudente/{matricola}")
	public ModelAndView eliminaStudente(@PathVariable String matricola, Model model) {
		DummyDB db = getDummyDb();
		db.eliminaStudente(matricola);
		return visualizzaStudenti();
	}

	//metodi per aggiornare uno studente
	@GetMapping("/mostraformaggiorna/{matricola}")
	public ModelAndView aggiornaStudente(@PathVariable String matricola, Model model) {
		DummyDB db = getDummyDb();
		Studente s = db.getStudenteByMatricola(matricola);
		List<CorsoLaurea> corsi = db.getCorsi();
		ModelAndView mav = new ModelAndView("aggiornaStudente", "studente", new Studente());
		mav.addObject("studente", s);
		mav.addObject("corsi", corsi);
		return mav;
	}

	@PostMapping("/aggiornaStudente/{matricola}")
	public ModelAndView aggiornaStudente(@Valid @ModelAttribute("studente") Studente studente, BindingResult result,
			Model model, @PathVariable String matricola) {
		DummyDB db = getDummyDb();
		studente.setMatricola(matricola);
		db.eliminaStudente(studente.getMatricola());
		db.aggiungiStudente(studente);
		return visualizzaStudenti();
	}

}