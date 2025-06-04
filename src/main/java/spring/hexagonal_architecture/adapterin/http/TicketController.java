package spring.hexagonal_architecture.adapterin.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import spring.hexagonal_architecture.adapterin.http.dto.request.TicketAdapterInRequest;
import spring.hexagonal_architecture.adapterin.http.dto.response.TicketAdapterInResponse;
import spring.hexagonal_architecture.adapterin.http.mapper.TicketMapperAdapterIn;
import spring.hexagonal_architecture.core.port.in.TicketCalculation;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

	private TicketCalculation ticketCalculation;
	
	public TicketController(TicketCalculation ticketCalculation) {
		this.ticketCalculation = ticketCalculation;
	}
	
	@PostMapping("/calculation")
	@Operation(summary = "Calcular juros de um boleto")
	public ResponseEntity<TicketAdapterInResponse> calculateTicket(@Valid @RequestBody TicketAdapterInRequest ticketAdapterInRequest){
		var calculatedTicket = ticketCalculation.executeTicket(ticketAdapterInRequest.code(), ticketAdapterInRequest.paymentDate());
		return ResponseEntity.status(HttpStatus.CREATED).body(TicketMapperAdapterIn.toTicketAdapterInResponse(calculatedTicket));
	}
	
}
