package cn.jerio.controller;

import cn.jerio.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Franky on 2018/08/02.
 */
@Controller
public class IndexController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("files", fileService.findAll());
        return "/index";
    }


    @GetMapping("/error")
    public String error(){
        return "/error";
    }
}
