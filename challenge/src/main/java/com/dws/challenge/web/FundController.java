package com.dws.challenge.web;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.dws.challenge.domain.Accounts;
import com.dws.challenge.service.AccountServices;
import com.dws.challenge.service.NotificationService;




public class FundController {

	@Autowired
	private AccountServices accountService;
	Logger log = LogManager.getLogger(FundController.class);
	NotificationService notification;
	Accounts acc;
	
	// transferAmount
		@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
		public void transferAmount(@PathVariable int accountFrom, @PathVariable int accountTo, @PathVariable int amount) throws Exception {
			int initBalSender = getBalance(accountFrom);
			int initBalReceiver = getBalance(accountTo);
					
			if (amount < 0) {
	            throw new Exception();
	        }
			else {
			accountService.transferAmount(accountFrom, accountTo, amount);
			log.info("Transferred Success", initBalSender, initBalReceiver - amount);
			}
            acc.setAcctID(accountFrom);
			notification.notifyAboutTransfer(acc, "");
			log.info("Amount Sent Successfully {}", accountFrom);
			
		}
		
		// checkBalance
		@GetMapping("/account/{acctID}/balance")
		public int getBalance(@PathVariable int acctID) {
			return accountService.getBalance(acctID);
		}
}
