package spring.hexagonal_architecture.adapterin.http.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public record TicketAdapterInRequest(@NotNull String code, 
		@NotNull @JsonProperty("paymentDate") @JsonFormat(pattern = "yyyy-MM-dd") LocalDate paymentDate){

}
