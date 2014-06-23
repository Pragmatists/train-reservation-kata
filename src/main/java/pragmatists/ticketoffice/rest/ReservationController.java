package pragmatists.ticketoffice.rest;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pragmatists.ticketoffice.testfactories.BookingReferenceService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    BookingReferenceService bookingReferenceService;

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody ReservationResponse reservation(@RequestParam(value="trainId", required=true, defaultValue="") String trainId,
                                                      @RequestParam(value="seats", required=true, defaultValue="1") Integer seats) {
        return new ReservationResponse(trainId, bookingReferenceService.getNextBookingReference(), Collections.<String>emptyList());
    }

}