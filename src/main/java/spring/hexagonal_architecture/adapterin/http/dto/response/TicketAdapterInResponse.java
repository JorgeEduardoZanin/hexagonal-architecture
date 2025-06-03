package spring.hexagonal_architecture.adapterin.http.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import spring.hexagonal_architecture.core.enums.TicketType;

public record TicketAdapterInResponse(String code, 
		@JsonProperty("dueDate") LocalDate dueDate, 
		BigDecimal value, 
		TicketType ticketType) {

}
