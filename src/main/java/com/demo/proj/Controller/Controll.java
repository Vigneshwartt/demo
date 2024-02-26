package com.demo.proj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.proj.Entity.Student;
import com.demo.proj.Entity.interfcae.Userdao;

@Controller
public class Controll {
	@Autowired
	Userdao userdao;
	
	@RequestMapping("home")
	public String user()
	{
		return"home.jsp";
	}
 
	@RequestMapping("addUser")
	public String home(Student student)
	{
		userdao.save(student);
		return "home.jsp";
	}
	
	@RequestMapping("getUser")
	public ModelAndView get(@RequestParam int id)
	{
		ModelAndView mav=new ModelAndView("showUser.jsp");
		Student student=userdao.findById(id).orElse(new Student());
		mav.addObject(student);
		return mav;
	}
	@RequestMapping("deleteUser")
	public ModelAndView gets(@RequestParam int id)
	{
		ModelAndView mav=new ModelAndView("delete.jsp");
		Student student=userdao.findById(id).orElse(new Student());
		userdao.deleteById(id);
		mav.addObject(student);
		return mav;
	}
	@RequestMapping("updateUser")
	public ModelAndView getu(Student student)
	{
		ModelAndView mav=new ModelAndView("update.jsp");
	    student=userdao.findById(student.getId()).orElse(new Student());
		userdao.deleteById(student.getId());
		mav.addObject(student);
		return mav;
	}

	
}
	
	
	
	
	
	
	
	
	
	
	
	

