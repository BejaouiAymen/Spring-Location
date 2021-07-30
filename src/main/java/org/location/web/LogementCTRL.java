package org.location.web;




import java.util.Optional;

import javax.validation.Valid;

import org.location.dao.LogementDAO;

import org.location.entities.Logement;
import org.location.entities.TypeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class LogementCTRL {

	
	@Autowired
	private LogementDAO logement;

	
	

	@RequestMapping(value="/consulter")
	public String consulter_logement(Model model,@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="motCle",defaultValue="") String mc) {
	Page <Logement> log=logement.findbyKw("%"+mc+"%", PageRequest.of(p, 5));
	int pageCount=log.getTotalPages();
	int[]pages=new int[pageCount];
	for(int i=0;i<pageCount;i++)pages[i]=i;
	model.addAttribute("pages", pages);
	model.addAttribute("PageLogement", log);
	model.addAttribute("pageCourante", p);
	model.addAttribute("motCle", mc);
	return "consulter_log";
}
	
	//formulaire logement
	@RequestMapping(value="/admin/ajoutlog",method=RequestMethod.GET)
	public String formLogement(Model model	) {
		model.addAttribute("logement", new Logement());
		model.addAttribute("TypeLoge",TypeLog.values());
		
		
		
		return"formLogement";
	}


	//save logement
	@RequestMapping(value="/admin/SaveLogement",method=RequestMethod.POST)
	public String save(Model model ,@Valid Logement log ,BindingResult br) {
		
		if(br.hasErrors()) {
			model.addAttribute("logement", new Logement());
			model.addAttribute("TypeLoge",TypeLog.values());
			return "formLogement";
		}
		
		logement.save(log);
		model.addAttribute("log", log);
		return"comfirmation";
	}

	
	@RequestMapping(value="/admin/delete",method=RequestMethod.GET)
	public String delete(Long id) {
		logement.deleteById(id);
		return "redirect:/consulter";
	}

	
	@RequestMapping(value="/admin/edit",method=RequestMethod.GET)
	public String edit(Model model,Long id) {
		
		Optional<Logement> loge=logement.findById(id);
		model.addAttribute("logement",loge );
		model.addAttribute("TypeLoge",TypeLog.values());
		
		return "editLogement";
	}

	@RequestMapping(value="/")
	public String home() {
		

		return "redirect:/consulter";
	}
	
	



	
}
