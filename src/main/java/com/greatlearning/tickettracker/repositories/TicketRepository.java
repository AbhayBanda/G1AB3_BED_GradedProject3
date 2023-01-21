package com.greatlearning.tickettracker.repositories;

import com.greatlearning.tickettracker.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(value = "select * from ticket t where t.title like %:keyword% or t.description like %:keyword%", nativeQuery = true)
    public List<Ticket> getTicketsByKeyWord(@Param("keyword") String keyword);



}
