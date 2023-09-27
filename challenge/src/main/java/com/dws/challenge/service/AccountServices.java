package com.dws.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dws.challenge.repository.AccountsRepositorys;


@Service
public class AccountServices {
	@Autowired
	private AccountsRepositorys accountRepository;

	

	public int getBalance(int acctID) {
		return accountRepository.findBalanceByAcctID(acctID);
	}

	

	public void transferAmount(int acctID, int destAcctID, int amount) {
		accountRepository.withdrawAmountByAcctID(acctID, amount);
		accountRepository.saveBalanceByAcctID(destAcctID, amount);
	}

}