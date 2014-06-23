package pragmatists.ticketoffice;

import com.jayway.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pragmatists.ticketoffice.testfactories.BookingReferenceService;

public class EndToEndTest {

    @Test
    public void endToEndReservation() throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        BookingReferenceService bean = context.getBean(BookingReferenceService.class);
        Mockito.when(bean.getNextBookingReference()).thenReturn("1234bookref");
        Assertions.assertThat(bean).isNotNull();
        String trainId = "5543";
        RestAssured.given().param("trainId", trainId).when().post("http://localhost:8080/reservation")
                .then().body("trainId", Matchers.is("5543"))
                .body("bookingReference", Matchers.is("1234bookref"));

        SpringApplication.exit(context);
    }

}