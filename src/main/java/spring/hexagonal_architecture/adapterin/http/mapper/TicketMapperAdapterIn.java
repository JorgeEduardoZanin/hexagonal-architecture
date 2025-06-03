package spring.hexagonal_architecture.adapterin.http.mapper;

import spring.hexagonal_architecture.adapterin.http.dto.response.TicketAdapterInResponse;
import spring.hexagonal_architecture.core.domain.CalculatedTicket;

public class TicketMapperAdapterIn {

	public static TicketAdapterInResponse toTicketAdapterInResponse(CalculatedTicket calculatedTicket) {
		return new TicketAdapterInResponse(calculatedTicket.getCode(),
				calculatedTicket.getDueDate(),
				calculatedTicket.getValue(),
				calculatedTicket.getType());
	}
}
