package com.example.profit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.UserEmail;

@RestController
public class ProfitController {

	@Autowired
	private ProfitService profitService;
	
	@RequestMapping(method=RequestMethod.POST, value = "/maxprofits")
	public Profit getMaxProfit(@RequestBody List<String> companies) {
		return profitService.getMaxProfit(companies);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/maxprofitsbyemail")
	public Profit getMaxProfitByEmail(@RequestBody UserEmail userEmail) {
		return profitService.getMaxProfitByEmail(userEmail);
	}
	
}
