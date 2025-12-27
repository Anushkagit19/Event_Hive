package com.event.Event_hive.Controller;

import com.event.Event_hive.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingController {


   @Autowired
    private BookingService service;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

   @PostMapping
   public ResponseEntity<?> createBooking(@RequestBody BookingRequest request) {
       try {
           Booking booking = bookingService.bookSeat(request.getEventId(), request.getUserId());
           return ResponseEntity.ok(booking);

       } catch (IllegalArgumentException e) {
           return ResponseEntity.badRequest().body(e.getMessage());

       } catch (IllegalStateException e) {
           return ResponseEntity.status(409).body(e.getMessage());

       } catch (Exception e) {
           return ResponseEntity.status(500).body("Internal server error");
       }
   }


}
