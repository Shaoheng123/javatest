import org.example.Address;
import org.example.FinalKeyword;
import org.example.PassbyValuevsReference;
import org.example.Record;
import org.example.User;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class JunitTests {
    @Test
    public void testPassByValuevsReference() {
        PassbyValuevsReference passbyValuevsReference = new PassbyValuevsReference();
        int[] result = passbyValuevsReference.testA();
        assertEquals(1,result[0]);
        assertEquals(2,result[1]);

    }
    @Test
    public void testValue() {
        FinalKeyword keyword = new FinalKeyword("SGD", LocalDateTime.now());
        assertEquals(keyword.test(),"Hello");
        assertEquals(keyword.getAmount(),5);
        assertEquals(keyword.getCurrency(),"SGD");
    }
    @Test
    public void testShallowCopy() {
        Address address = new Address("Singapore","Singapore");
        User pm = new User("sh","te",address);
        address.setCountry("Malaysia");
        assertEquals(pm.getAddress().getCountry(),"Malaysia");
    }
    @Test
    public void testRecord() {
        Record record = new Record("sh",11);
        assertEquals("sh",record.name());
    }

}
