/*
 * REST Client
 
package com.tfseven.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tfseven.pojo.BankAccountClient;
import com.tfseven.pojo.Company;

@Controller
@RequestMapping("/acct")
public class CustomerAccountController {
	// Get REST URL
	
	@Value("#{props.bank_rest_url}")
	private String URL;

	@GetMapping(value = "/{path}")
	public String showForm(@PathVariable String path, BankAccountClient a) {
		System.out.println("in show form ");
		return "/acct/" + path;
	}

	// req handling method to send REST request to fetch a/c summary
	// RESTful client
	@PostMapping(value = "/summary")
	public String getAccountSummary(RestTemplate restClnt, RedirectAttributes attrs, @Valid BankAccountClient a,
			BindingResult res) {
		System.out.println("in process summary form" + a);
		if (res.hasFieldErrors("acctID") || res.hasFieldErrors("pin")) {
			System.out.println("p.l errs : processing summary form " + res);
			return "/acct/summary";
		}
		// invoke a call to RESTful server
		
		 * public <T> T getForObject(String url,Class<T> responseType,Object...
		 * urlVariables) throws RestClientException
		 
		try {
			BankAccountClient acct = restClnt.getForObject(URL.concat("/{id}/{pin}"), BankAccountClient.class, a.getAcctId(),
					a.getPin());
			System.out.println("Rest clnt a/c summary " + acct);
			attrs.addFlashAttribute("acct_summary", "A/C Summary " + acct);
		} catch (HttpClientErrorException e) {
			attrs.addFlashAttribute("acct_summary", e.getStatusText() + " " + e.getResponseBodyAsString());
		}

		return "redirect:/cust/valid";
	}

	// req handling method to send REST request to create a/c
	// RESTful client
	@PostMapping(value = "/create")
	public String createAccount(RestTemplate restClnt, RedirectAttributes attrs, @Valid BankAccountClient a,
			BindingResult res) {
		System.out.println("in process create form" + a);
		if (res.hasFieldErrors("type") || res.hasFieldErrors("balance") || res.hasFieldErrors("pin")) {
			System.out.println("p.l errs : create a/c  " + res);
			return "/acct/create";
		}
		// invoke a call to RESTful server
		
		 * public <T> T postForObject(String url,Object request,Class<T>
		 * responseType,Object... urlVariables) throws RestClientException
		 
		try {
			BankAccountClient acct = restClnt.postForObject(URL, a, BankAccountClient.class);
			System.out.println("Rest clnt create a/c  " + acct);
			attrs.addFlashAttribute("acct_summary", "A/C Created " + acct);
		} catch (HttpClientErrorException e) {
			attrs.addFlashAttribute("acct_summary", e.getStatusText() + " " + e.getResponseBodyAsString());
		}

		return "redirect:/cust/valid";
	}

	// req handling method to send REST request to create a/c
	// RESTful client
	@PostMapping(value = "/update")
	public String updateAccount(@RequestParam double amount, RestTemplate restClnt, RedirectAttributes attrs,
			@Valid BankAccountClient a, BindingResult res) {
		System.out.println("in process update form" + a);
		if (res.hasFieldErrors("acctId") || res.hasFieldErrors("pin")) {
			System.out.println("p.l errs : update a/c  " + res);
			return "/acct/update";
		}
		// invoke a call to RESTful server
		
		 * public void putForObject(String url,Class<T> responseType,Object...
		 * urlVariables) throws RestClientException
		 
		try {
			restClnt.put(URL.concat("/{amount}"), a, amount);
			System.out.println("Rest clnt update a/c  ");
			attrs.addFlashAttribute("acct_summary", "A/C Updated ");
		} catch (HttpClientErrorException e) {
			attrs.addFlashAttribute("acct_summary", e.getStatusText() + " " + e.getResponseBodyAsString());
		}

		return "redirect:/cust/valid";
	}
	// req handling method to send REST request to fetch a/c summary
		// RESTful client
		@PostMapping(value = "/close")
		public String closeAccount(RestTemplate restClnt, RedirectAttributes attrs, @Valid BankAccountClient a,
				BindingResult res) {
			System.out.println("in close a/c" + a);
			if (res.hasFieldErrors("acctID") || res.hasFieldErrors("pin")) {
				System.out.println("p.l errs : close a/c " + res);
				return "/acct/summary";
			}
			// invoke a call to RESTful server
			
			 * public <T> T getForObject(String url,Class<T> responseType,Object...
			 * urlVariables) throws RestClientException
			 
			try {
				restClnt.delete(URL.concat("/{id}/{pin}"), a.getAcctId(),a.getPin());
						
						
				System.out.println("Rest clnt close ");
				attrs.addFlashAttribute("acct_summary", "Closed A/C With ID  " +a.getAcctId());
			} catch (HttpClientErrorException e) {
				attrs.addFlashAttribute("acct_summary", e.getStatusText() + " " + e.getResponseBodyAsString());
			}

			return "redirect:/cust/valid";
		}

}
*/