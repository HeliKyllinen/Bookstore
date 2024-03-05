package K24.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import K24.Bookstore.domain.AppUser;
import K24.Bookstore.domain.AppUserRepository;

@Controller
public class AppUserController {
	
	@Autowired
	private AppUserRepository arepository;
	
	//Näytä kaikki käyttäjät
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
    
    //Näytä kaikki käyttäjät
    @RequestMapping(value="/appuserlist")
    public String appuserList(Model model) {
  	
        model.addAttribute("appusers", arepository.findAll());
        return "appuserlist";
    }   
    
    //Restful service 
    @RequestMapping(value="/appusers")
    public @ResponseBody List<AppUser> appuserlistRest() {	
        return (List<AppUser>) arepository.findAll();
    }
    
	// RESTful service to get user by id
    @RequestMapping(value="/appuser/{userid}", method = RequestMethod.GET)
    public @ResponseBody Optional<AppUser> findStudentRest(@PathVariable("userid") Long userid) {	
    	return arepository.findById(userid);
    }    
    
    // Add new user
    @RequestMapping(value = "/add")
    public String addAppUser(Model model){
    	model.addAttribute("appuser", new AppUser());
        return "adduser";
    }  
    
}
