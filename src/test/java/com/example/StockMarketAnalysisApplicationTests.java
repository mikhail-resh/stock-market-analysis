package com.example;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StockMarketAnalysisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockMarketAnalysisApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private BuildProperties buildProperties;

	private TestRestTemplate restTemplate = new TestRestTemplate();
	private HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGETAbout() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/about"),
				HttpMethod.GET, entity, String.class);
		
		String appName = buildProperties.getName();
		String appVersion = buildProperties.getVersion();
		String expected = "{\"appName\":\""+appName+"\",\"version\":\""+appVersion+"\"}";
		try {
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testPOSTProfit() {
		String companyName="NKE";
		
		List<String> companies = new ArrayList<String>();
		companies.add(companyName);
		HttpEntity<List<String>> entity = new HttpEntity<List<String>>(companies, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURL("/maxprofits"),
				HttpMethod.POST, entity, String.class);
		
		try {
			JSONObject responseProfit = new JSONObject(response.getBody());
			String responseProfitAmount = responseProfit.getString("profitAmount");
					
			String urlBegin = "https://api.iextrading.com/1.0/stock/";
			
			String urlCurrent = urlBegin+companyName+"/price";
			String currentResult = restTemplate.getForObject(urlCurrent, String.class);	
			float currentPrice = Float.valueOf(currentResult);
			
			String urlYesturday = urlBegin+companyName+"/previous";
			String yesterdayResult = restTemplate.getForObject(urlYesturday, String.class);	
			JSONObject yesterdayInfo = new JSONObject(yesterdayResult);
			float yesturdayPrice = Float.valueOf(yesterdayInfo.getString("high"));
			
			float expectedProfit = currentPrice-yesturdayPrice;
			String expectedProfitStr = String.valueOf(expectedProfit);
			
			assertEquals(expectedProfitStr, responseProfitAmount);	
		} catch (JSONException e1) {
			e1.printStackTrace();
		}		
	}
	
 String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}

}

