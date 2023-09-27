package com.dws.challenge.domain;

import lombok.Data;
import java.math.BigDecimal;
@Data
public class FundTransferRequest {
    private String accountFrom;
    private String accountTo;
    private BigDecimal amount;
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}
	public String getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
    
    
    
}
