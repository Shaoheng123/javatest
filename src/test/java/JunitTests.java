import org.example.*;
import org.example.EventListener;
import org.example.Record;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.timeout;

public class JunitTests {

    private User originalUser;
    @Before
    public void setup() {
        Address address = new Address("Singapore","Singapore");
        originalUser = new User("sh","te",address);
    }
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
//

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
    @Test
    public void testDeepCopy() {
        User pm = new User("sg","te",new Address("sg","sg"));
        User deepCopy = new User(pm);
        deepCopy.setAddress(new Address("st","st"));
        assertEquals(deepCopy.getAddress(),pm.getAddress());

    }
    @Test
    public void testShallowCopy() {
        Address address = new Address("Singapore","Singapore");
        User pm = new User("sh","te",address);
        address.setCountry("Malaysia");
        assertEquals(pm.getAddress().getCountry(),"Malaysia");
    }

    @Test
    public void shallowCopy() {

        User shallowUser= originalUser.clone();

    }
    @Test
    public void deepCopy() {
        User deepUser= originalUser.clone();
        deepUser.getAddress().setCountry("my");
        assertEquals(originalUser.getAddress().getCountry(),"my");

    }
    @Test
    public void arrayDefinition() {
        int[] array1 = new int[5];
        int[] array2;
        for(int i = 0; i < array1.length;i++) {
            array1[i] = i+1;
        }
        System.out.println(Arrays.toString(array1));
        array2 = new int[]{1,2,3,4,5};
        boolean isEqual = Arrays.equals(array1,array2);

        assertTrue(isEqual);
//Todo:

    }
    @Test
    public void arrayStream2D () {
        int[][] array2D = IntStream.range(0,3).mapToObj(i->IntStream.range(0,4).map(j->i*4+j).toArray()).toArray(int[][]:: new);
        int[][] arrayMulti = new int[][]{{0,1,2,3},{4,5,6,7},{8,9,10,11}};
        boolean isEqual = Arrays.deepEquals(array2D,arrayMulti);
        assertTrue(isEqual);
    }
    @Test
    public void collectionsStreamAdd() {
        ArrayList<Long> arrayList = new ArrayList<>();
        LongStream.range(4,10).boxed().collect(collectingAndThen(toCollection(ArrayList::new), ys ->arrayList.addAll(0,ys)));
        ArrayList<Long> arrayList2 = new ArrayList<>(List.of(4L,5L,6L,7L,8L,9L));
        assertEquals(arrayList,arrayList2);
    }
}
