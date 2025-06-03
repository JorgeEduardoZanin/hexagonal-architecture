package spring.hexagonal_architecture.adapterout.datasource.database;

import org.springframework.stereotype.Component;

import spring.hexagonal_architecture.adapterout.datasource.database.repository.TicketDatabaseRepository;
import spring.hexagonal_architecture.adapterout.datasource.mapper.TicketMapper;
import spring.hexagonal_architecture.core.domain.CalculatedTicket;
import spring.hexagonal_architecture.core.port.out.TicketRepository;

@Component
public class TicketAdapterRepository implements TicketRepository {

	private TicketDatabaseRepository ticketDatabaseRepository;
	
	public TicketAdapterRepository(TicketDatabaseRepository ticketDatabaseRepository) {
		this.ticketDatabaseRepository = ticketDatabaseRepository;
	}

	@Override
	public void saveTicket(CalculatedTicket calculatedTicker) {	
		ticketDatabaseRepository.save(TicketMapper.toTicketEntity(calculatedTicker));
	}

}
