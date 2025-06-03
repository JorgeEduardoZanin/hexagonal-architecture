package spring.hexagonal_architecture.adapterout.datasource.integration;

import org.springframework.stereotype.Component;

import spring.hexagonal_architecture.adapterout.datasource.integration.client.TicketProviderClient;
import spring.hexagonal_architecture.adapterout.datasource.mapper.TicketMapper;
import spring.hexagonal_architecture.core.domain.Ticket;
import spring.hexagonal_architecture.core.port.out.TicketProvider;

@Component
public class TicketProviderIntegration implements TicketProvider{

	private final TicketProviderClient ticketProviderClient;
	
	public TicketProviderIntegration(TicketProviderClient ticketProviderClient) {
		this.ticketProviderClient = ticketProviderClient;
	}

	@Override
	public Ticket returnTicket(String code) {
		return TicketMapper.toTicketDomain(ticketProviderClient.getTicket(code));
	}

}
