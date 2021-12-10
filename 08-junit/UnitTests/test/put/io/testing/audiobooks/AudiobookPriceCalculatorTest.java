package put.io.testing.audiobooks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator calculator;
    private Audiobook audiobook;

    @BeforeEach
    void setup() {
        audiobook = new Audiobook("Book", 10.0);
        calculator = new AudiobookPriceCalculator();
    }


    @Test
    void testCalculateForSubscriber(){
        Customer customer = new Customer ("Customer", Customer.LoyaltyLevel.STANDARD, true);
        assertEquals(calculator.calculate(customer, audiobook),0.0);
    }
    @Test
    void testCalculateForSilver(){
        Customer customer = new Customer ("Customer", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(calculator.calculate(customer, audiobook),0.9 * audiobook.getStartingPrice());
    }
    @Test
    void testCalculateForGold(){
        Customer customer = new Customer ("Customer", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(calculator.calculate(customer, audiobook),0.8 * audiobook.getStartingPrice());
    }
    @Test
    void testCalculateForStandard(){
        Customer customer = new Customer ("Customer", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(calculator.calculate(customer, audiobook), audiobook.getStartingPrice());
    }
}