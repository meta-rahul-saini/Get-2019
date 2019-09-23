package com.metacube.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.mvc.dao.EmployeeRepository;
import com.metacube.mvc.model.Employee;
import com.metacube.mvc.model.Login;
import com.metacube.mvc.model.Vehicle;
import com.metacube.mvc.util.UploadImage;

/**
 * this is our controller class, which handles the url
 * @author Rahul
 *
 */
@Controller
@SessionAttributes({ "empId", "vehicleType", "vehicleId", "amount", "login" })
public class EmployeeController {

	List<String> organizationList = null;

	List<String> vehicleTypeList = null;

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeController() {
		super();
		// adding organizations in organization list
		organizationList = new ArrayList<>();
		organizationList.add("Metacube");
		organizationList.add("Github");
		organizationList.add("Oracle");

		// adding vehicle Type
		vehicleTypeList = new ArrayList<>();
		vehicleTypeList.add("cycle");
		vehicleTypeList.add("twoWheeler");
		vehicleTypeList.add("fourWheeler");
	}

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping("/")
	public String employeeRegister(Model model) {

		// add employee attribute
		model.addAttribute(new Employee());

		// have organization list
		model.addAttribute("organizationList", organizationList);

		return "employeeRegisterationForm";
	}

	@RequestMapping("/login")
	public String login(Model model) {

		model.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping("/registerEmployee")
	public String registerEmployee(@Validated @ModelAttribute Employee employee, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("organizationList", organizationList);
			return "employeeRegisterationForm";
		} else {

			// save employee in db and get emp ID

			int empId = employeeRepository.saveEmployee(employee);

			model.addAttribute("empId", empId);
			// add empID in model and use in vehicle form

			model.addAttribute("vehicle", new Vehicle());
			model.addAttribute("vehicleTypeList", vehicleTypeList);
			return "vehicleForm";
		}
	}

	@RequestMapping("/submitVehicleForm")
	public String submitVehicleForm(@Validated @ModelAttribute Vehicle vehicle,
			@SessionAttribute("empId") Integer empId, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "vehicleForm";
		} else {
			// save vehicle in db and get vehicle type

			vehicle.setEmployeeId(empId);

			int vehicleId = employeeRepository.saveVehicle(vehicle);

			// adding vehicleId to session
			model.addAttribute("vehicleId", vehicleId);

			// adding vehicle type to the session
			model.addAttribute("vehicleType", vehicle.getVehicleType());

			// fetch the prices for above vehicle type and use in passDetail form
			Map priceMap = employeeRepository.getPriceList(vehicle.getVehicleType());

			// ArrayList priceList = new ArrayList<String>();
			// model.addAttribute("priceList", priceList);

			model.addAttribute("priceMap", priceMap);
			model.addAttribute("vehicle", new Vehicle());
			model.addAttribute("vehicleTypeList", vehicleTypeList);
			return "priceList";
		}
	}

	@GetMapping("/GeneratePass")
	public String generatePass(HttpServletRequest req, Model model) {
		return "home";

	}

	@PostMapping("/GeneratePass")
	public String generatePass(@SessionAttribute("empId") Integer empId,
			@SessionAttribute("vehicleId") Integer vehicleId, HttpServletRequest req, Model model) {

		String plan = req.getParameter("plan");
		String amount = req.getParameter("amount");

		employeeRepository.savePassDetail(empId, vehicleId, plan, amount);

		Employee employee = employeeRepository.getEmployeeProfile(empId);

		model.addAttribute("employee", employee);
		model.addAttribute("empId", empId);
		
		List vehicleList = employeeRepository.getVehicleList(empId);

		model.addAttribute("vehicleList", vehicleList);
		
		return "home";

	}

	@GetMapping("/processCredentials")
	public String getProcessCredentials() {
		return "home";
	}

	@PostMapping("/processCredentials")
	public String processCredentials(@Validated @ModelAttribute("login") Login login, BindingResult bindingResult,
			Model model) {
		model.addAttribute("login", login);
		String email = login.getEmail();
		String password = login.getPassword();
		int empId = employeeRepository.isValid(email, password);

		if (bindingResult.hasErrors()) {
			return "login";
		} else if (empId == -1) {
			login.setEmail("");
			login.setPassword("");
			bindingResult.rejectValue("credentials", "error.login", "Invalid Credentials....");
			return "login";
		} else {
			
			model.addAttribute("empId", empId);
			List vehicleList = employeeRepository.getVehicleList(empId);

			model.addAttribute("vehicleList", vehicleList);
			return "home";
		}
	}

	@GetMapping("/about")
	public String about(@SessionAttribute("empId") int empId, Model model) {

		Employee employee = employeeRepository.getEmployeeProfile(empId);

		model.addAttribute("employee", employee);

		return "about";

	}

	@GetMapping("/home")
	public String home(@SessionAttribute("empId") int empId, Model model) {
		if (empId == 0) {
			return "redirect:login";
		} else {

			return "home";
		}
	}

	@RequestMapping("/friends")
	public String showFriends(@SessionAttribute("empId") int empId, Model model) {
		model.addAttribute("friendsList", employeeRepository.getFriendsList(empId));
		return "friends";
	}
	
	@RequestMapping("/coworkers")
	public String showCoworkers(@SessionAttribute("empId") int empId, Model model) {
		model.addAttribute("coworkersList", employeeRepository.getCoworkerssList(empId));
		return "coworkers";
	}


	@RequestMapping("/addVehicle")
	public String addVehicle(@SessionAttribute("empId") int empId, Model model) {
		model.addAttribute("vehicle", new Vehicle());
		model.addAttribute("vehicleTypeList", vehicleTypeList);
		return "vehicleForm";
	}

	@RequestMapping("/edit")
	public String edit(@SessionAttribute("empId") int empId, Model model) {
		Employee employee = employeeRepository.getEmployeeProfile(empId);
		model.addAttribute("employee", employee);
		model.addAttribute("organizationList", organizationList);
		return "editProfile";
	}

	@RequestMapping("/updateProfile")
	public String updateProfile(@SessionAttribute("empId") int empId, @ModelAttribute("employee") Employee employee,
			Model model) {
		employee.setEmpId(empId);
		int row = employeeRepository.updateProfile(employee);
		return "updateMessage";

	}

	// upload image page
	@RequestMapping(value = "/updateImage", method = RequestMethod.GET)
	public String fileUploadPage(Model model) {
		model.addAttribute(new UploadImage());
		return "uploadImage";
	}

	@Autowired
	ServletContext context;

	
	/**function used to upload the file (image)
	 * @param file
	 * @param employeeId
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateImage", method = RequestMethod.POST)
	public String fileUpload(@Validated UploadImage file, @SessionAttribute("empId") int employeeId, ModelMap model)
			throws IOException {

		System.out.println("Fetching file");

		MultipartFile multipartFile = file.getFile();

		String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator;

		// Now do something with file...
		FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath + file.getFile().getOriginalFilename()));

		String fileName = multipartFile.getOriginalFilename();
		if (employeeRepository.addImage(employeeId, fileName) > 0) {
			model.addAttribute("fileName", fileName);
			return "redirect:/home";
		} else {
			model.addAttribute(new UploadImage());
			return "uploadImage";
		}
	}

	
	@RequestMapping("/logout")
	public String logout(@SessionAttribute("empId") int empId, @ModelAttribute("employee") Employee employee,
			Model model) {
		
		// setting the empId = null 
		model.addAttribute("empId", null);
		return "login";
	}
	
	
	// getters and setters
	public List<String> getOrganizationList() {
		return organizationList;
	}

	public void setOrganizationList(List<String> organizationList) {
		this.organizationList = organizationList;
	}

	public List<String> getVehicleTypeList() {
		return vehicleTypeList;
	}

	public void setVehicleTypeList(List<String> vehicleTypeList) {
		this.vehicleTypeList = vehicleTypeList;
	}

}
