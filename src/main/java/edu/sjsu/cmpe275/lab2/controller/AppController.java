package edu.sjsu.cmpe275.lab2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import edu.sjsu.cmpe275.lab2.dao.UserDAO;
import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;
import edu.sjsu.cmpe275.lab2.service.PhoneService;
import edu.sjsu.cmpe275.lab2.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}
	
	@RequestMapping(value="/user/{userId}", method = RequestMethod.GET)
	public ModelAndView getUserById(@PathVariable("userId") String id, Model model) {
		System.out.println("I am in createNewUser "+id);
		ModelAndView view= new ModelAndView("hello");
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return view;
	}
	
	/*@RequestMapping(value="/user/{userId}", method = RequestMethod.GET)
	public String getUserById(@PathVariable("userId") String id, Model model) {
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "viewUser";
	}*/
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public String createNewUser(@RequestParam(value="firstName", required=false) String firstName,
			@RequestParam(value="lastName", required=false) String lastName,
			@RequestParam(value="title", required=false) String title, 
			@RequestParam(value="street", required=false) String street,
			@RequestParam(value="city", required=false) String city,
			@RequestParam(value="state", required=false) String state,
			@RequestParam(value="zip", required=false) String zip,
			UriComponentsBuilder ucBuilder, Model model) {
		Address address = new Address();
		User user = new User();
		address.setCity(city);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zip);
		user.setAddress(address);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setTitle(title);
		userService.saveUser(user);//It should return user to get id.
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
		model.addAttribute("headers", headers);
		model.addAttribute("httpStatus", HttpStatus.CREATED);
		return "viewUser";
	}
	
	@RequestMapping(value="/user/{userId}", method = RequestMethod.PUT)
	public String updateUser(@RequestParam(value="firstName", required=false) String firstName,
			@RequestParam(value="lastName", required=false) String lastName,
			@RequestParam(value="title", required=false) String title, 
			@RequestParam(value="street", required=false) String street,
			@RequestParam(value="city", required=false) String city,
			@RequestParam(value="state", required=false) String state,
			@RequestParam(value="zip", required=false) String zip,
			@PathVariable("userId") String id, Model model) {
		User user = userService.findUserById(id);
		if(user == null){
	        System.out.println("Unable to update as user with id "+id+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return "viewUser";
	    }
		Address address = new Address();
		if(city.isEmpty())
			address.setCity(city);			
		if(state.isEmpty())
			address.setState(state);
		if(street.isEmpty())
			address.setStreet(street);
		if(zip.isEmpty())
			address.setZip(zip);
		if(address != null)
			user.setAddress(address);
		if(firstName.isEmpty())
			user.setFirstName(firstName);
		if(lastName.isEmpty())
			user.setLastName(lastName);
		if(title.isEmpty())
			user.setTitle(title);
		if(user != null){
			userService.updateUser(user);
			model.addAttribute("httpStatus", HttpStatus.OK);
		}
		return "viewUser";
	}
	
	@RequestMapping(value="/user/{userId}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable("userId") String id, Model model) {
		if(userService.findUserById(id) == null){
	        System.out.println("A user with id "+id+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return "viewUser";
	    }
		userService.deleteUserById(id);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "viewUser";
	}
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		List<User> userList = userService.findAllUsers();
		model.addAttribute("httpStatus", HttpStatus.OK);
		model.addAttribute("userList", userList);
		return "viewUser";
	}
	
	@RequestMapping(value="/phone/{phoneId}", method = RequestMethod.GET)
	public String getPhoneById(@PathVariable("phoneId") String id, Model model) {
		Phone phone = phoneService.findPhoneById(id);
		model.addAttribute("phone", phone);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "viewPhone";
	}
	
	@RequestMapping(value="/phone", method = RequestMethod.POST)
	public String createNewPhone(@RequestParam(value="number", required=false) String number,
			@RequestParam(value="description", required=false) String description,
			@RequestParam(value="street", required=false) String street,
			@RequestParam(value="city", required=false) String city,
			@RequestParam(value="state", required=false) String state,
			@RequestParam(value="zip", required=false) String zip,
			UriComponentsBuilder ucBuilder, Model model) {
		Address address = new Address();
		Phone phone = new Phone();
		address.setCity(city);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zip);
		phone.setAddress(address);
		phone.setNumber(number);
		phone.setDescription(description);
		phoneService.savePhone(phone);
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/phone/{id}").buildAndExpand(phone.getPhoneId()).toUri());
		model.addAttribute("headers", headers);
		model.addAttribute("httpStatus", HttpStatus.CREATED);
		return "viewPhone";
	}
	
	@RequestMapping(value="/phone", method = RequestMethod.PUT)
	public String updatePhone(@RequestParam(value="number", required=false) String number,
			@RequestParam(value="description", required=false) String description,
			@RequestParam(value="street", required=false) String street,
			@RequestParam(value="city", required=false) String city,
			@RequestParam(value="state", required=false) String state,
			@RequestParam(value="zip", required=false) String zip,
			@PathVariable("phoneId") String id, Model model) {
		Phone phone = phoneService.findPhoneById(id);
		if(phone == null){
	        System.out.println("Unable to update as phone with id "+id+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return "viewPhone";
	    }
		Address address = new Address();
		if(city.isEmpty())
			address.setCity(city);			
		if(state.isEmpty())
			address.setState(state);
		if(street.isEmpty())
			address.setStreet(street);
		if(zip.isEmpty())
			address.setZip(zip);
		if(address != null)
			phone.setAddress(address);
		if(number.isEmpty())
			phone.setNumber(number);
		if(description.isEmpty())
			phone.setDescription(description);
		if(phone != null){
			phoneService.updatePhone(phone);
			model.addAttribute("httpStatus", HttpStatus.OK);
		}
		return "viewPhone";
	}
	
	@RequestMapping(value="/phone/{phoneId}", method = RequestMethod.DELETE)
	public String deletePhoneById(@PathVariable("phoneId") String id, Model model) {
		if(phoneService.findPhoneById(id) == null){
	        System.out.println("An phone with id "+id+" doesnot exist");
	        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND);
			return "viewPhone";
	    }
		phoneService.deletePhoneById(id);
		model.addAttribute("httpStatus", HttpStatus.OK);
		return "viewPhone";
	}
	
	@RequestMapping(value="/phone", method = RequestMethod.GET)
	public String getAllPhones(Model model) {
		List<Phone> phoneList = phoneService.findAllPhones();
		model.addAttribute("httpStatus", HttpStatus.OK);
		model.addAttribute("phoneList", phoneList);
		return "viewPhone";
	}
}
