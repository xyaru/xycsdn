package com.krry.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krry.entity.User;
import com.krry.repository.UserRepository;


@Controller
@RequestMapping(value="/index")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MongoTemplate mongoTemplate;


	/**
	 * 首页
	 */
	@RequestMapping(value="/index")
	public String index(Model model,HttpServletRequest request){

		User user = (User) request.getAttribute("user");

		if(user == null){
//    		System.out.println(user);
			User usero = new User("##errors##","1234");
			model.addAttribute("user", usero);
		}

		return "index";
	}

	/**
	 * 打开登录界面
	 */
	@RequestMapping(value="/oplogin")
	public String oplogin(){

		return "login";
	}

	/**
	 * 登录
	 */
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request){

		String username = request.getParameter("username");
		String password = request.getParameter("password");



		User user = userRepository.findByUsername(username);


		if(user!=null){

			if(password.equals(user.getPassword())){

				request.setAttribute("user", user);

				return "index";

			}else{

				System.out.println("密码错误");
				return "ferror";
			}
		}else{

			System.out.println("用户不存在");
			return "ferror";
		}
	}



	/**
	 * 打开注册界面
	 */
	@RequestMapping("/resgi")
	public String resgi(){

		return "resgi";
	}


	/**
	 * 注册控制层
	 */
	@RequestMapping(value="/rege")
	public String resig(HttpServletRequest request){

		String username = request.getParameter("username");
		String password = request.getParameter("password");


		User user = userRepository.findByUsername(username);


		if(user != null){
			return "ferror";
		}


		User newUser = new User(username,password);

		userRepository.save(newUser);


		request.setAttribute("user", newUser);

		return "index";
	}

	@ResponseBody
	@RequestMapping("/findByName")
	public User findByName(){

		return userRepository.findByUsername("krryxq");
	}

	@ResponseBody
	@RequestMapping("/find")
	public List<User> find(){

		return mongoTemplate.findAll(User.class);
	}
}
