package com.example.profit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.UserEmail;

@RestController
public class ProfitController {

	private final ProfitService profitService;
	
	@Autowired
	public ProfitController(ProfitService profitService) {
		this.profitService = profitService;
	}
	
	@RequestMapping(value = "/maxprofits/{companies}")
	public Profit getMaxProfit(@PathVariable List<String> companies) {
		return profitService.getMaxProfit(companies);
	}
	
	@RequestMapping(value = "/maxprofitsbyemail/{userEmail}")
	public Profit getMaxProfitByEmail(@PathVariable UserEmail userEmail) {
		return profitService.getMaxProfitByEmail(userEmail);
	}
	
}
