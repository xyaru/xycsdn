package com.example.demo;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TVSeriesController {

	@PostMapping("/filter")
    public String resig(HttpServletRequest request, HttpServletResponse response) {
    	String username = request.getQueryString();
    	System.out.println(username);
    	return "test" ;
    }
	/*@RequestMapping("/filter")
    public String resig1(HttpServletRequest request) {
		Enumeration<String> name;
		name = request.getParameterNames();
		//if(request == null)
    	System.out.print(name.toString());
    	return "hlm";
   }
	class User{
		String username;
		String password;
		
		String getUsername() {
			return username;
		}
	}*/
	
}
	
	
