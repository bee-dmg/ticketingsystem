package com.TSystem.TicketSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TSystem.TicketSystem.model.Ticket;
import com.TSystem.TicketSystem.repository.TicketRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/tickets")

    public ResponseEntity<List<Ticket>> getAllTickets(@RequestParam(required = false) String title){
            try{
                List<Ticket> tickets = new ArrayList<Ticket>();
                if(title == null){
                    ticketRepository.findAll().forEach(tickets::add);
                }else{
                    ticketRepository.findByTitleContaining(title).forEach(tickets::add);
                }
              if(tickets.isEmpty()){
                return new ResponseEntity(HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<>(tickets,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    
    };

    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") long id){
        Optional<Ticket> ticketData = ticketRepository.findById(id);

        if(ticketData.isPresent()){
            return new ResponseEntity<>(ticketData.get(), HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // @PostMapping("/tickets")
 
}