package spring.hexagonal_architecture.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import spring.hexagonal_architecture.core.enums.TicketType;

public class CalculatedTicket {

	String code;
	BigDecimal originalValue; 
	BigDecimal interestValue;
	BigDecimal value;
	LocalDate dueDate;
	LocalDate paymentDate;
	TicketType type;
	
	public CalculatedTicket(String code, BigDecimal originalValue, BigDecimal interestValue, BigDecimal value,
			LocalDate dueDate, LocalDate paymentDate, TicketType type) {
		this.code = code;
		this.originalValue = originalValue;
		this.interestValue = interestValue;
		this.value = value;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.type = type;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(BigDecimal originalValue) {
		this.originalValue = originalValue;
	}
	public BigDecimal getInterestValue() {
		return interestValue;
	}
	public void setInterestValue(BigDecimal interestValue) {
		this.interestValue = interestValue;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public TicketType getType() {
		return type;
	}
	public void setType(TicketType type) {
		this.type = type;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	
	
}
