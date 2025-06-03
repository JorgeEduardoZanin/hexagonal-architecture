package spring.hexagonal_architecture.adapterout.datasource.integration.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import spring.hexagonal_architecture.adapterout.datasource.integration.dto.response.TicketAdapterOutResponse;



@FeignClient(value = "provider", url = "${api.ticket}")
public interface TicketProviderClient {

	@GetMapping(value ="/{code}",  
	produces = MediaType.APPLICATION_JSON_VALUE)
	TicketAdapterOutResponse getTicket(@PathVariable String code);
		
	
	
	
	
}
