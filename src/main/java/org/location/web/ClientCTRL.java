package org.location.web;

import java.security.Principal;

import javax.validation.Valid;

import org.location.dao.ClientDAO;
import org.location.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/")
public class ClientCTRL {
	@Autowired
	ClientDAO clientDAO;
	
	BCryptPasswordEncoder encoder = passwordEncoder();
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String formLogement(Model model	) {
		model.addAttribute("client", new Client());
		return"inscription";
	}
	
	//save Client
	@RequestMapping(value="/SaveClient",method=RequestMethod.POST)
	public String save(@Valid Client client,BindingResult bindingresult ) {
		
		if(bindingresult.hasErrors()) {
			return "inscription";
		}
		
		
		
		client.setPassword(encoder.encode(client.getPassword()));
		clientDAO.save(client);
		return"redirect:/consulter";
	}
	

	@RequestMapping(value="/loginpage")
	public String login() {
		return "login";
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
	    return new BCryptPasswordEncoder();
	}
	

}
