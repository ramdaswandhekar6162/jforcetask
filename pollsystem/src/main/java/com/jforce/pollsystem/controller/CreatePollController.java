package com.jforce.pollsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jforce.pollsystem.entity.Poll;
import com.jforce.pollsystem.services.PollService;

@Controller
@RequestMapping("/leaf")
public class CreatePollController {
	
	@Autowired
	private PollService pollService;
	
	@GetMapping("/poll/create")
	public String createPoll(Model model) {
		
		model.addAttribute("poll", new Poll());
		
		return "PollForm";
	}
	
	@PostMapping("/poll/submit")
	public String submitPollForm(@ModelAttribute("pollform") Poll pollForm) {
		
		pollService.savePoll(pollForm);
		
		return "redirect:/leaf/home";
	}
	
	
	
}
