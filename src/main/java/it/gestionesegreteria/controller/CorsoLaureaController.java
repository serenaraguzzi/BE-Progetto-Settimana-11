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

@Controller
public class CorsoLaureaController {

	@Autowired
	private ApplicationContext ctx;

	private DummyDB getDummyDb() {
		return ctx.getBean(DummyDB.class);
	}
	
	//ritorna alla homepage
	@GetMapping("/index")
	public String Homepage() {
		return "redirect:/"; 
	}

	//metodo per visualizzare i corsi
	@GetMapping("/corsi")
	public ModelAndView visualizzaCorsi() {
		DummyDB db = getDummyDb();
		List<CorsoLaurea> corsi = db.getCorsi();
		return new ModelAndView("visualizzaCorsi", "corsi", corsi);
	}
	
	//metodo per eliminare un corso
	@GetMapping("/eliminacorso/{codice}")
	public ModelAndView eliminaStudente(Model model, @PathVariable String codice) {
		DummyDB db = getDummyDb();
		db.eliminaCorso(codice);
		return visualizzaCorsi();
	}

	//metodi per aggiungere un corso
	@GetMapping("/aggiungiCorsoform")
	public ModelAndView aggiungiCorso() {
		ModelAndView mav = new ModelAndView("aggiungiCorso", "corso", new CorsoLaurea());
		return mav;
	}

	@PostMapping("/aggiungiCorso")
	public ModelAndView aggiungiCorso(@Valid @ModelAttribute("corso") CorsoLaurea corso, BindingResult result,
			ModelMap model) {
		DummyDB db = getDummyDb();
		db.aggiungiCorso(corso);
		return visualizzaCorsi();
	}

	//metodi per aggiornare un corso
	@GetMapping("/aggiornaCorsoform/{codice}")
	public ModelAndView aggiornaCorsoform(@PathVariable String codice, Model model) {
		DummyDB db = getDummyDb();
		CorsoLaurea c = db.getCorsoByCodice(codice);
		ModelAndView mav = new ModelAndView("aggiornaCorso", "corso", new CorsoLaurea());
		mav.addObject("corso", c);
		return mav;
	}

	@PostMapping("/aggiornaCorso/{codice}")
	public ModelAndView aggiornaStudente(@Valid @ModelAttribute("corso") CorsoLaurea corso, BindingResult result,
			ModelMap model, @PathVariable String codice) {
		DummyDB db = getDummyDb();
		corso.setCodice(codice);
		db.eliminaCorso(codice);
		db.aggiungiCorso(corso);
		return visualizzaCorsi();
	}

}