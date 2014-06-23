package pragmatists.ticketoffice.testfactories;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestServicesFactory {
    @Bean
    public BookingReferenceService bookingReferenceService() {
        return Mockito.mock(BookingReferenceService.class);
    }
}
