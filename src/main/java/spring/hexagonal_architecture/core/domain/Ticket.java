package spring.hexagonal_architecture.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import spring.hexagonal_architecture.core.enums.ExceptionType;
import spring.hexagonal_architecture.core.enums.TicketType;
import spring.hexagonal_architecture.core.exception.ApplicationException;

public class Ticket {

	private String code;
	
	private LocalDate dueDate;
	
	private BigDecimal value;
	
	private TicketType type;

	public Ticket() {}

	public Ticket(String code, LocalDate dueDate, BigDecimal value, TicketType type) {
		this.code = code;
		this.dueDate = dueDate;
		this.value = value;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public TicketType getType() {
		return type;
	}

	public void setType(TicketType type) {
		this.type = type;
	}
	
	public void validateTicketType() {
		if(this.type != TicketType.XPTO) {
			throw new ApplicationException(ExceptionType.INVALID_TICKET_TYPE);
			
		}
	}
	
	public void validateDueDate() {
		if(this.dueDate.isAfter(LocalDate.now())) {
			throw new ApplicationException(ExceptionType.NOT_EXPIRED_TICKET);
		}
	}	
}
