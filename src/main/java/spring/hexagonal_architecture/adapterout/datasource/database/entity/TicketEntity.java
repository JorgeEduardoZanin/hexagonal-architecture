package spring.hexagonal_architecture.adapterout.datasource.database.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import spring.hexagonal_architecture.core.enums.TicketType;

@Entity
@Table(name = "tb_ticket")
public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	String code;
	BigDecimal originalValue; 
	BigDecimal interestValue;
	BigDecimal value;
	LocalDate dueDate;
	LocalDate paymentDate;
	TicketType type;
	
	public TicketEntity() {
	}

	public TicketEntity(String code, BigDecimal originalValue, BigDecimal interestValue, BigDecimal value,
			LocalDate dueDate, LocalDate paymentDate, TicketType type) {
		this.code = code;
		this.originalValue = originalValue;
		this.interestValue = interestValue;
		this.value = value;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getOriginalValue() {
		return originalValue;
	}

	public void setOriginalValue(BigDecimal originalValue) {
		this.originalValue = originalValue;
	}

	public BigDecimal getInterestValue() {
		return interestValue;
	}

	public void setInterestValue(BigDecimal interestValue) {
		this.interestValue = interestValue;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public TicketType getType() {
		return type;
	}

	public void setType(TicketType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, dueDate, id, interestValue, originalValue, paymentDate, type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketEntity other = (TicketEntity) obj;
		return Objects.equals(code, other.code) && Objects.equals(dueDate, other.dueDate)
				&& Objects.equals(id, other.id) && Objects.equals(interestValue, other.interestValue)
				&& Objects.equals(originalValue, other.originalValue) && Objects.equals(paymentDate, other.paymentDate)
				&& type == other.type && Objects.equals(value, other.value);
	}
	
	
}
