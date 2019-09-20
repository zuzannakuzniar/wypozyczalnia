package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.Event;
import com.sda.project.wypozyczalnia.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/events") // This means URL's start with /demo (after Application path)
public class EventController {

    @Autowired
    private EventService eventService;

    @PreAuthorize("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Event>> findAll() {
        return ResponseEntity.ok(eventService.getEvents());
    }
    @PreAuthorize("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> findOne(@PathVariable Long id) {

        Optional<Event> event = eventService.getEvent(id);

        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Event event) {
        //return ResponseEntity.ok(eventService.saveEvent(event));

         /**
         * H A T E O A S - styl pisania API typu REST
         *  Hypermedia As The Engine Of Application State
         */
        Event created = eventService.saveEvent(event);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity updateEvent(@PathVariable Long id, @Valid @RequestBody Event event) {

        eventService.update(id, event);

        return ResponseEntity.ok().build();
    }


}
