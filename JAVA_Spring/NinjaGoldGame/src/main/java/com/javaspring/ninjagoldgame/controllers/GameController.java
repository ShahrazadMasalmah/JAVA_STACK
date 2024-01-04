package com.javaspring.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class GameController {
	@RequestMapping("/")
	public String home(HttpSession session) {
		int gold;
		if(session.getAttribute("gold") == null) {
			gold = 0;
			session.setAttribute("gold", gold);
		}
		else {
			gold = (int) session.getAttribute("gold");
		}
		if(session.getAttribute("activities") == null) {
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("activities", activities);
		}
		
		if(gold < 0) {
			//session.setAttribute("gold", 0);
			return "redirect:/prison";
		}
		
		return "home.jsp";
	}
	
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String process(HttpSession session, @RequestParam(value="building") String building) {
		if(building.equals("farm")) {
			int gold = this.increaseGold(10, 21, session);
			this.addActivity("You entered a farm and earned " + gold + " gold. ", session);
		}
		else if(building.equals("cave")) {
			int gold = this.increaseGold(5, 11, session);
			this.addActivity("You entered a cave and earned " + gold + " gold. ", session);
		}
		else if(building.equals("house")) {
			int gold = this.increaseGold(2, 6, session);
			this.addActivity("You entered a house and earned " + gold + " gold. ", session);
		}
		else if(building.equals("quest")) {
			Random randGold = new Random();
			boolean add = randGold.nextBoolean();
			int value = randGold.nextInt(0, 51);
			int gold = (int) session.getAttribute("gold");
			if(add) {
				gold += value;
				this.addActivity("You completed a quest and earned " + value + " gold. ", session);
			}
			else {
				gold -= value;
				this.addActivity("You failed a quest and lost " + value + " gold...Ouch. ", session);
			}
			session.setAttribute("gold", gold);
		}
		else if(building.equals("spa")) {
			Random randGold = new Random();
			int value = randGold.nextInt(5, 21);
			int gold = (int) session.getAttribute("gold");
			gold -= value;
			this.addActivity("You failed a spa and lost " + value + " gold...Ouch. ", session);
			session.setAttribute("gold", gold);
		}
		//System.out.println(building);
		return "redirect:/";
	}
	
	@RequestMapping("/destroy")
	public String destroy(HttpSession session) {
		session.setAttribute("gold", 0);
		ArrayList<String> activities = new ArrayList<String>();
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	
	@RequestMapping("/prison")
	public String goToPrison() {
		return "prison.jsp";
	}
	
	public int increaseGold(int lowerBound, int upperBound, HttpSession session) {
		int gold = (int) session.getAttribute("gold");
		Random randGold = new Random();
		int change = randGold.nextInt(lowerBound, upperBound);
		//System.out.println(change);
		gold += change;
		session.setAttribute("gold", gold);
		return change;
	}
	
	public void addActivity(String activity, HttpSession session) {
		ArrayList<String> events= (ArrayList<String>) session.getAttribute("activities");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMMMMMM dd YYYY hh:mm a");
		String currenDate = dateFormat.format(date);
		events.add(activity + " (" + currenDate +")");
		session.setAttribute("activities", events);
	}
}
