package spring.hexagonal_architecture.core.usecase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import spring.hexagonal_architecture.core.domain.CalculatedTicket;
import spring.hexagonal_architecture.core.domain.Ticket;
import spring.hexagonal_architecture.core.enums.ExceptionType;
import spring.hexagonal_architecture.core.exception.ApplicationException;
import spring.hexagonal_architecture.core.port.in.TicketCalculation;
import spring.hexagonal_architecture.core.port.out.TicketProvider;
import spring.hexagonal_architecture.core.port.out.TicketRepository;

@Service
public class CalculateTicket implements TicketCalculation{

	private final TicketProvider ticketProvider;
	private final TicketRepository ticketRepository;
	
	private static final BigDecimal DAILY_INTEREST = BigDecimal.valueOf(0.033);

	public CalculateTicket(TicketProvider ticketProvider, TicketRepository ticketRepository) {
		this.ticketProvider = ticketProvider;
		this.ticketRepository = ticketRepository;
	}

	@Override
	public CalculatedTicket executeTicket(String code, LocalDate paymentDate) {
		
		Ticket ticket = ticketProvider.returnTicket(code);
		validateTicket(ticket);
			
		long daysGoneBy = getDaysGoneBy(ticket.getDueDate(), paymentDate);
		
		var dailyInterestValue = DAILY_INTEREST.multiply(ticket.getValue()).divide(BigDecimal.valueOf(100));
		var interestValue = dailyInterestValue.multiply(BigDecimal.valueOf(daysGoneBy)).setScale(2, RoundingMode.HALF_EVEN);
		
		CalculatedTicket calculatedTicket = new CalculatedTicket(
				code,
				ticket.getValue(),
				interestValue,
				ticket.getValue().add(interestValue), 
				ticket.getDueDate(),
				paymentDate,
				ticket.getType()
		);
		
		ticketRepository.saveTicket(calculatedTicket);
		
		return calculatedTicket;
	}

	private void validateTicket(Ticket ticket) {
		 if (ticket == null) {
		        throw new ApplicationException(ExceptionType.INVALID_TICKET);
		    }
		ticket.validateTicketType();
		ticket.validateDueDate();
	}
	
	private long getDaysGoneBy(LocalDate dueDate, LocalDate paymentDate) {
		return ChronoUnit.DAYS.between(dueDate, paymentDate);
	}

}
