package com.example.demo.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.Optional;

@Controller
public class MypageController {
	
	@Autowired
	UserRepository userRepository;
    
	//「マイページ」の表示
    @GetMapping("/mypage/{name}")
    String index(
    		@PathVariable("name")String name,
    		Model model) {
    	Optional<User> userInfo = userRepository.findByName(name);
    	model.addAttribute("userInfo", userInfo.get());
    	
        return "mypage";
    }
    
    //「アカウント情報の編集」画面の表示
    @GetMapping("/editaccount/{name}")
    String show(
    		@PathVariable("name")String name,
    		Model model){
    	Optional<User> userInfo = userRepository.findByName(name);
    	model.addAttribute("userInfo", userInfo.get());
    	return "editInfo";
    }
    
    //アカウントの編集
    @PostMapping("/editaccount/{uname}")
    String update(
    		@PathVariable("uname")String uname,
    		@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "address", required = false) String address,
			@RequestParam(name = "tel", required = false) String tel,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password,
    		Model model){
    	
    	List<String> messages = new ArrayList<>();

		if (name == null || name.equals("")) {
			messages.add("名前は必須です");
		}

		if (address == null || address.equals("")) {
			messages.add("住所は必須です");
		}

		if (tel == null || tel.equals("")) {
			messages.add("電話番号は必須です");
		}

		if (email == null || email.equals("")) {
			messages.add("メールアドレスは必須です");
		} else {
			Optional<User> registored = userRepository.findByEmail(email);

			if (!registored.isEmpty()) {
				messages.add("登録済みのメールアドレスです");
			}
		}

		if (password == null || password.equals("")) {
			messages.add("パスワードは必須です");
		}

		if (messages.size() > 0) {
			model.addAttribute("messages", messages);

			model.addAttribute("name", name);
			model.addAttribute("address", address);
			model.addAttribute("tel", tel);
			model.addAttribute("email", email);
			return "editInfo";
		}
    	
		User newUserInfo = new User(name, address, tel, email, password);
		userRepository.save(newUserInfo);

		return "mypage";
    }
    
}