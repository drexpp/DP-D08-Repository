package controllers.user;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AnnouncementService;
import services.RendeService;

import controllers.AbstractController;
import domain.Announcement;
import domain.Rende;


@Controller
@RequestMapping("announcement/user")
public class AnnouncementUserController extends AbstractController {

	
	//Services
	@Autowired
	AnnouncementService announcementService;
	
	@Autowired
	RendeService rendeService;
	
	//Constructor
	public AnnouncementUserController(){
		
	}
	
	//Edit
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView result;
		Announcement announcement;
		
		announcement = this.announcementService.create();
		
		result = this.createEditModelAndView(announcement);
		
		return result;
	}
	
	//Save
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Announcement announcement, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(announcement);
		else
			try {
				this.announcementService.save(announcement);
				result = new ModelAndView("redirect:../list.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(announcement, "announcement.commit.error");
			}
		return result;

	}

	
	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final Announcement announcement) {
		ModelAndView result;
		
		result = this.createEditModelAndView(announcement, null);
		
		return result;
	}

	protected ModelAndView createEditModelAndView(final Announcement announcement, final String message) {
		final ModelAndView result;
		Collection<Rende> rendes;
		
		rendes = this.rendeService.findRSVPSByUser();
		result = new ModelAndView("announcement/edit");
		result.addObject("announcement", announcement);
		result.addObject("rendes", rendes);
		result.addObject("message", message);
		
		return result;
	}
	
}