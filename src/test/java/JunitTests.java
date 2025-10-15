import org.example.*;
import org.example.Record;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.timeout;

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

    @Test
    public void testEquals() {
//      Integer a = 1;
//      Integer b = a;
//      assertEquals(a,b);
      Address c = new Address("sg","2");
      Address d =  new Address("sg","2");
      Objects.equals(null,"1");
      Objects.equals(null,null);
      Address address = new Address("sg","sg");
//      assertTrue(Objects.equals(null,1));
        assertEquals(address.compareTo(new Address("sss","sss")),0);
        Comparator<Address> addressComparator = Comparator.comparing(Address::getCountry);
//        Collections.sort(list,addressComparator);
//      new personComparable().compareTo(new Address("a","b"));
//      assertEquals(c,d);
//      assertEquals(c,e);
//      assertEquals(Objects.equals(null,"1"));

    }
    @Test
    public void testCallBack() {
        EventListener eventListener = new SynchronousEventListenerImpl();
        SynchronousEventConsumer synchronousEventConsumer = new SynchronousEventConsumer(eventListener);
        String result = synchronousEventConsumer.doSynchronousOperation();
        assertEquals(result, "callBack sync");

    }
    @Test
    public void testAsyncCallBack() {
        EventListener listener = Mockito.mock(AsyncEventListenerImpl.class);
        AsyncEventConsumer synchronousEventListenerConsumer = new AsyncEventConsumer(listener);
        synchronousEventListenerConsumer.doAsynchronousOperation();

        Mockito.verify(listener, timeout(1000).times(1)).onTrigger();

    }

    @Test
    public void testConsumerCallback() {
        ConsumerCallBack consumerCallBack = new ConsumerCallBack();
        int ageDifference =10;
        AtomicInteger newAge1 = new AtomicInteger();
        int initialAge = 20;
        consumerCallBack.getAge(initialAge,(initialAge1) ->{
            consumerCallBack.increaseAge(initialAge1,ageDifference, newAge1::set);
    });
        assertEquals(initialAge + ageDifference, newAge1.get());
}


}
