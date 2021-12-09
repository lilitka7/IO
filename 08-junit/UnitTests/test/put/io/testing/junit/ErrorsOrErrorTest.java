package put.io.testing.junit;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.fail;

class FailureOrErrorTest {

    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }
    @Test
    void test1(){   //failure - krzyzyk na zoltym
        assertEquals(1,0);
    }

    @Test
    void test2() { //error wykrzyknik na czerwonym
        throw new IllegalArgumentException();
    }
    @Test
    void test3(){
        try{
            assertEquals(1,0);}
        catch(Throwable e) {
            e.printStackTrace();
        }
    }
}