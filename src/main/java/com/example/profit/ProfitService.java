package com.example.profit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.User;
import com.example.user.UserEmail;
import com.example.user.UserService;

@Service
public class ProfitService {
	
	private final String urlBegin = "https://api.iextrading.com/1.0/stock/";
	private final String urlYesterdayEnd = "/previous";
	private final String urlCurrentEnd = "/price";
	
	@Autowired
	private UserService userService;
	
	public Profit getMaxProfit(List<String> companies) {
		if (companies==null || companies.isEmpty()) return null;
		
		Profit maxProfit = null;
		for(String company: companies){
			Profit profit = createProfit(company);
			if (maxProfit==null) {
				maxProfit=profit;
			}else{
				float maxProfitAmount = Float.valueOf(maxProfit.getProfitAmount());
				float profitAmount = Float.valueOf(profit.getProfitAmount());
				if (maxProfitAmount<profitAmount) maxProfit = profit;
			}
		}
		
		return maxProfit;
	}

	public Profit getMaxProfitByEmail(UserEmail userEmail) {
		String email = userEmail.getEmail();
		User user = userService.getUserByEmail(email);
		if (user==null) return null;
		return getMaxProfit(user.getFavorites());
	}
	
	private Profit createProfit(String name) {	
		RestTemplate restTemplate = new RestTemplate();
		
		final String urlCurrent = String.format("%1$s%2$s%3$s",urlBegin, name, urlCurrentEnd);
		String currentResult = restTemplate.getForObject(urlCurrent, String.class);
		
		final String urlYesturday = String.format("%1$s%2$s%3$s",urlBegin,name,urlYesterdayEnd);
		CompanyStockYesterdayInfo yesterdayResult = restTemplate.getForObject(urlYesturday, CompanyStockYesterdayInfo.class);
		
		Profit profit = new Profit(name, String.valueOf(Float.valueOf(currentResult)-yesterdayResult.getHigh()));
		return profit;
	}
	

}
