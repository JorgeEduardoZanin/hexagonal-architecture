package spring.hexagonal_architecture.adapterout.datasource.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.hexagonal_architecture.adapterout.datasource.database.entity.TicketEntity;

@Repository
public interface TicketDatabaseRepository extends JpaRepository<TicketEntity, Long>{}
