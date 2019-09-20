package com.sda.project.wypozyczalnia.services;

import com.sda.project.wypozyczalnia.dao.EventRepository;
import com.sda.project.wypozyczalnia.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event update(Long id, Event event) {

        Optional<Event> eventFromDatabase = eventRepository.findById(id);

        if (eventFromDatabase.isPresent()) {
            Event updatedEvent = eventFromDatabase.get();

            updatedEvent.setName(event.getName());
            updatedEvent.setAccessibility(event.getAccessibility());
            updatedEvent.setAddress(event.getAddress());
            updatedEvent.setOrganizer(event.getOrganizer());
            updatedEvent.setDate(event.getDate());

            return eventRepository.save(updatedEvent);
        } else {
            return eventRepository.save(event);
        }
    }

    public Optional<Event> getEvent(Long id) {
        return eventRepository.findById(id);
    }
}
