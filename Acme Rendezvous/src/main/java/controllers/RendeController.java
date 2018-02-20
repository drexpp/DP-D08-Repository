
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.RendeService;
import services.UserService;
import domain.Rende;

@Controller
@RequestMapping("/rende")
public class RendeController extends AbstractController {

	// Services

	@Autowired
	private RendeService	rendeService;
	@Autowired
	private UserService		userService;


	// Constructors

	public RendeController() {
		super();
	}

	// Listing
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Rende> rendes;
		rendes = this.rendeService.selectNotAdultRendes();
		result = new ModelAndView("rende/list");
		result.addObject("rendes", rendes);
		return result;
	}
}
