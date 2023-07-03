package com.example.demo.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BookingController {
    
    @GetMapping("/bookingdetail")
    String detail(Model model) {
    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
    	LocalDate ldt = LocalDate.now();
    	String basedate = ldt.format(dtf);
    	LocalDate today = LocalDate.parse(basedate, dtf);
    	LocalDate promisingfuture = today.plusYears(1);
    	LocalDate schedule = null;
    	String result = null;
    	model.addAttribute("today", today);
    	model.addAttribute("promisingfuture", promisingfuture);
    	model.addAttribute("schedule", schedule);
    	
    	model.addAttribute("result", result);
    	
        return "bookingDetail";
    }
    @PostMapping("/bookingdetail")
    String showplan(
    		@RequestParam(name="schedule", required=false) LocalDate schedule,
    		Model model) {
    	model.addAttribute("schedule", schedule);
    	
        return "bookingDetail";
    }
    @PostMapping("/bookingcomplete")
    String showcomplete(
    		@RequestParam(name="schedule", required=false) LocalDate schedule,
    		Model model) {
    	String result = "完了";
    	String booking = schedule.toString();
    	model.addAttribute("booking", booking);
    	model.addAttribute("result", result);

        return "bookingDetail";
    }
}