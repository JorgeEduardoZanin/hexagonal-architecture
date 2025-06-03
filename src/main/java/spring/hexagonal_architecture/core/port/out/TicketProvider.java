package spring.hexagonal_architecture.core.port.out;

import spring.hexagonal_architecture.core.domain.Ticket;

public interface TicketProvider {

	Ticket returnTicket(String code);
	
}
