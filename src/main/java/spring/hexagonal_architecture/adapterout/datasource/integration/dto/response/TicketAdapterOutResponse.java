package spring.hexagonal_architecture.adapterout.datasource.integration.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import spring.hexagonal_architecture.core.enums.TicketType;

public record TicketAdapterOutResponse(String code, @JsonProperty("dueDate") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy") LocalDate dueDate, BigDecimal value, TicketType type) {

}
