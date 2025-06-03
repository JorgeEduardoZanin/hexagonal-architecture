package spring.hexagonal_architecture.core.port.out;

import spring.hexagonal_architecture.core.domain.CalculatedTicket;

public interface TicketRepository {

	void saveTicket(CalculatedTicket calculatedTicket);
	
}
