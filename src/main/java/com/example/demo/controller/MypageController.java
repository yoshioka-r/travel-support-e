package com.example.demo.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.Optional;

@Controller
public class MypageController {
	
	@Autowired
	UserRepository userRepository;
    
	//マイページの表示
    @GetMapping("/mypage/{name}")
    String showmypage(
//    		@RequestParam(name="name", required=true)String name,
    		@PathVariable("name")String name,
    		Model model) {
    	System.out.println(name);
    	Optional<User> userInfo = userRepository.findByName(name);
    	model.addAttribute("userInfo", userInfo.get());
    	
        return "mypage";
    }
    
//    @GetMapping("/editaccount")
//    String jumppage(
//    		
//    		Model model){
//    	return "editInfo";
//    }
//    
//    @PostMapping("/editaccount")
//    String editinfo(
//    		@RequestParam(name = "name", required = false) String name,
//    		@RequestParam(name = "address", required = false) String address,
//    		@RequestParam(name = "tel", required = false) String tel,
//    		@RequestParam(name = "email", required = false) String email,
//    		@RequestParam(name = "password", required = false) String password,
//    		Model model){
//    	model.addAttribute("name", name);
//    	model.addAttribute("address", address);
//    	model.addAttribute("tel", tel);
//    	model.addAttribute("email", email);
//    	model.addAttribute("password", password);
//    	
//    	return "editInfo";
//    }

    
}