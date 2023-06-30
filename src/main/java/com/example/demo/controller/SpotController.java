package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Pref;
import com.example.demo.entity.Spot;
import com.example.demo.repository.PrefRepository;
import com.example.demo.repository.SpotRepository;

@Controller
public class SpotController {
	
	@Autowired
	PrefRepository prefRepository;
	
	@Autowired
	SpotRepository spotRepository;

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
		
		List<Spot> spots = spotRepository.findAllByPrefId(id);
		
		m.addAttribute("pref", pref);
		m.addAttribute("spots", spots);
		
		return "pref";
	}
	
//	@GetMapping("/pref")
//	public String index(
//			Model model) {
//		return "pref";
//	}
	
}
