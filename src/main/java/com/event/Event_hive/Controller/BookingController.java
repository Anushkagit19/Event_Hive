package com.event.Event_hive.Controller;

import com.event.Event_hive.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingController {
   @Autowired
    private BookingService service;


}
