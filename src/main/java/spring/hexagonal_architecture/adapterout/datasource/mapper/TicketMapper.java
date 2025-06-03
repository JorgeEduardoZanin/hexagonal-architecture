package spring.hexagonal_architecture.adapterout.datasource.mapper;

import spring.hexagonal_architecture.adapterout.datasource.database.entity.TicketEntity;
import spring.hexagonal_architecture.adapterout.datasource.integration.dto.response.TicketAdapterOutResponse;
import spring.hexagonal_architecture.core.domain.CalculatedTicket;
import spring.hexagonal_architecture.core.domain.Ticket;

public class TicketMapper {

	public static Ticket toTicketDomain(TicketAdapterOutResponse ticketResponse) {
		return new Ticket(ticketResponse.code(), 
				ticketResponse.dueDate(), 
				ticketResponse.value(), 
				ticketResponse.type());
	}
	
	public static TicketEntity toTicketEntity(CalculatedTicket calculatedTicket) {
		return new TicketEntity(calculatedTicket.getCode(), 
				calculatedTicket.getOriginalValue(),
				calculatedTicket.getInterestValue(),
				calculatedTicket.getValue(),
				calculatedTicket.getDueDate(),
				calculatedTicket.getPaymentDate(),
				calculatedTicket.getType());
	}
	
}
