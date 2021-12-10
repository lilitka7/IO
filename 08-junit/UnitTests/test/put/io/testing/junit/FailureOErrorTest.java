package put.io.testing.junit;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTest {

    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    void test1(){ assertEquals(1,0);}

    @Test
    void test2() { throw new IllegalArgumentException();}

    @Test
    void test3(){
        try{ assertEquals(1,0);}
        catch(Throwable e) { e.printStackTrace();}
    }
}