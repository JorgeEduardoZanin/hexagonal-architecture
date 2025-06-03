package spring.hexagonal_architecture.core.port.in;

import java.time.LocalDate;

import spring.hexagonal_architecture.core.domain.CalculatedTicket;

public interface TicketCalculation {

	CalculatedTicket executeTicket(String code, LocalDate dueDate);
	
}
