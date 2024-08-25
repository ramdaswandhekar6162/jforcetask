package com.jforce.pollsystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jforce.pollsystem.entity.Poll;
import com.jforce.pollsystem.entity.User;
import com.jforce.pollsystem.services.PollService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/leaf")
public class ViewPollController {
	
	@Autowired
	PollService pollService;

	
	@GetMapping("/home")
	public String homePage(HttpSession session) {
		
		User user = (User) session.getAttribute("validUser");
		
		if(user != null) {
			return "Home";
		} else {
			return "redirect:/leaf/login";
		}
				
		
	}
	
	
	@GetMapping("/polls")
	public String listPolls(Model model)
	{
		List<Poll> polls = pollService.findAllPollsd();
		model.addAttribute("polls",polls);
		
		return "PollList";
	}
	
	@GetMapping("/polls/{id}")
	public String viewPoll(@PathVariable Long id, Model model) {
	    Poll poll = pollService.findByPoll(id);

	    // Filter out empty options from the poll's option list
	    poll.setOption(
	        poll.getOption().stream()
	            .filter(option -> option != null && !option.trim().isEmpty())
	            .collect(Collectors.toList())
	    );

	    model.addAttribute("poll", poll);
	    return "PollView";
	}

	
	@PostMapping("/poll/submit/{id}")
    public String submitPoll(@PathVariable Long id, Model model) {
        
        return "Confirmation";
    }
	
	
	
	
}
