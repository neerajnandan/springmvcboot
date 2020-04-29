package com.telusko.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telusko.springmvcboot.dao.AlienDao;
import com.telusko.springmvcboot.model.Alien;

@Controller
public class HomeController {

	/* Using HttpServletRequest and HttpSession */

//@RequestMapping("add")  //because for action name=add.
//public String add(HttpServletRequest req) {			// HttpServletRequest is used to take input from the user.
//	int i=Integer.parseInt(req.getParameter("num1"));
//	int j=Integer.parseInt(req.getParameter("num2"));
//	int num3= i+j;
//	
//	
//	HttpSession session=req.getSession();// session created to pass the value of num 3 to result.jsp
//	session.setAttribute("num3", num3); // Here "num3" is the variable name in result.jsp and the value of num3 is passed to "num3"
//	return "result.jsp";
//}

	/* Using RequestMapping */

//@RequestMapping("add")  //because for action name=add.
//public String add(@RequestParam("num1") int i, @RequestParam("num2")int j, HttpSession session) {
//	//Instead of using HttpServletRequest for taking the values from the user, we use the above method.
//	//@RequestParam("num1") int i means the value of num1 is passed to integer i.
//	int num3= i+j;
//	session.setAttribute("num3", num3); // Here "num3" is the variable name in result.jsp and the value of num3 is passed to "num3"
//	return "result.jsp";
//}

	/* Using ModelAndView */

//@RequestMapping("add")  //because for action name=add.
//public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2")int j) {
//	ModelAndView mv=new ModelAndView();
//	mv.setViewName("result");
//	int num3= i+j;
//	mv.addObject("num3",num3);
//	return mv;
//}

	/* Using only Model */

//@RequestMapping("add")  //because for action name=add.
//public String add(@RequestParam("num1") int i, @RequestParam("num2")int j, Model m) {
//	
//	int num3= i+j;
//	m.addAttribute("num3",num3);
//	return "result";
//}
//
//@RequestMapping("addAlien")  //because for action name=add.
//public String add(@RequestParam("aid") int aid, @RequestParam("aname")String aname, Model m) {
//	
//	Alien a=new Alien();
//	a.setAid(aid);
//	a.setAname(aname);
//	m.addAttribute("alien",a);
//	return "result";
//}

	/* Using Alien object and avoiding RequestParam */
//@RequestMapping("add")  //because for action name=add.
//public String add(@RequestParam("num1") int i, @RequestParam("num2")int j, Model m) {
//	
//	int num3= i+j;
//	m.addAttribute("num3",num3);
//	return "result";
//}
	
	@Autowired
	private AlienDao dao;
	
	@ModelAttribute
	public void modelData(Model m) 
	{
	m.addAttribute("name","Aliens");
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m)
	{
		//List<Alien> aliens= Arrays.asList(new Alien(101,"Navin"), new Alien(102,"Rose"));
		m.addAttribute("result",dao.getAliens());
		return "showAliens";
		
	}
	
	@PostMapping(value="addAlien")
	public String addAlien(@ModelAttribute Alien a)
	{
		
	
		return "result";
		
	}

}
