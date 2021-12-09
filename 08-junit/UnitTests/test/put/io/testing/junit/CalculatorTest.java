package put.io.testing.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class CalculatorTest {

    private Calculator calculator;
    @BeforeEach //BeforeAll nie powiedzie się , chodzi o statyczność tego new ? ?
    void setup(){
        calculator = new Calculator();
    }

    @Test
    void testAdd(){
        int x=0,y=1,x1=2,y1=3;

        assertEquals(calculator.add(x,y),x+y);
        assertEquals(calculator.add(x1,y1),x1+y1);
    }
    @Test
    void testMultiply(){
        int x=0,y=1,x1=2,y1=3;

        assertEquals(calculator.multiply(x,y),x*y);
        assertEquals(calculator.multiply(x1,y1),x1*y1);
    }
    @Test
    void testAddPositiveNumbers(){
        int x=-1,y=1,x1=-2,y1=3;

        assertThrows(IllegalArgumentException.class, ()->{calculator.addPositiveNumbers(x,y);});
        assertThrows(IllegalArgumentException.class, ()->{calculator.addPositiveNumbers(x1,y1);});
    }
}