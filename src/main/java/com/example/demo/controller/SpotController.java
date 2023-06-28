package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Pref;
import com.example.demo.repository.PrefRepository;

@Controller
public class SpotController {
	
	@Autowired
	PrefRepository prefRepository;

	//スポット画面を表示
	@GetMapping("/pref/{id}")
	public String show(
			@PathVariable("id") Integer id,
			Model m) {
		
		Pref pref = null;
		
		Optional<Pref> record = prefRepository.findById(id);
		
		if (record.isEmpty() == false) {
			pref = record.get();
		}
		
		m.addAttribute("pref", pref);
		
		return "pref";
	}
	
//	@GetMapping("/pref")
//	public String index(
//			Model model) {
//		return "pref";
//	}
	


//	// ログイン処理
//	@PostMapping("/login")
//	public String login(
//			@RequestParam(name = "EMAIL", required = false) String email,
//			@RequestParam(name = "PASSWORD", required = false) String password,
//			Model m) {
//
//		List<String> message = new ArrayList<>();
//
//		if (email == null || email.equals("")) {
//			message.add("メールアドレスを入力してください");
//		}
//
//		if (password == null || password.equals("")) {
//			message.add("パスワードを入力してください");
//		}
//
//		email = email == null ? "" : email;
//		password = password == null ? "" : password;
//		
//		if (!email.equals("") && !password.equals("")) {
//			// メールアドレスとパスワードが一致しなかった場合エラーとする
//			Optional<User> optionalUser = userRepository.findByEmailAndPassword(email, password);
//
//			if (optionalUser.isEmpty() == false) {
//				User user = optionalUser.get();
//				account.setName(user.getName());
//				return "sanin";
//
//			} else {
//				message.add("新規登録してください");
//			}
//		}
//
//
//		Optional<User> record = userRepository.findByEmail(email);
//
//		if (record.isEmpty() == false) {
//			User user = record.get();
//
//			if (!user.getPassword().equals(password)) {
//				message.add("パスワードが異なります");
//			}
//		}
//
//		m.addAttribute("message", message);
//		m.addAttribute("email", email);
//		m.addAttribute("password", password);
//
//		return "login";
//	}
//
//	@GetMapping("/register")
//	public String show() {
//		return "register";
//	}
//
//	//新規登録
//	@PostMapping("/register")
//	public String store(
//			@RequestParam(name = "NAME", required = false) String name,
//			@RequestParam(name = "ADDRESS", required = false) String address,
//			@RequestParam(name = "TEL", required = false) String tel,
//			@RequestParam(name = "EMAIL", required = false) String email,
//			@RequestParam(name = "PASSWORD", required = false) String password,
//			Model m) {
//
//		List<String> messages = new ArrayList<>();
//
//		if (name == null || name.equals("")) {
//			messages.add("名前は必須です");
//		}
//
//		if (address == null || address.equals("")) {
//			messages.add("住所は必須です");
//		}
//
//		if (tel == null || tel.equals("")) {
//			messages.add("電話番号は必須です");
//		}
//
//		if (email == null || email.equals("")) {
//			messages.add("メールアドレスは必須です");
//		} else {
//			Optional<User> registored = userRepository.findByEmail(email);
//
//			if (!registored.isEmpty()) {
//				messages.add("登録済みのメールアドレスです");
//			}
//		}
//
//		if (password == null || password.equals("")) {
//			messages.add("パスワードは必須です");
//		}
//
//		if (messages.size() > 0) {
//			m.addAttribute("messages", messages);
//
//			m.addAttribute("name", name);
//			m.addAttribute("address", address);
//			m.addAttribute("tel", tel);
//			m.addAttribute("email", email);
//			return "register";
//		}
//
//		User user = new User(name, address, tel, email, password);
//		userRepository.save(user);
//
//		return "redirect:/login";

//	}
}