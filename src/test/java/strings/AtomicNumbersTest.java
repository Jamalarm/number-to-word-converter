package strings;

import org.junit.Assert;
import org.junit.Test;

import javax.smartcardio.ATR;

import static org.junit.Assert.*;

public class AtomicNumbersTest {

    @Test
    public void testGetFromNumberValue() throws Exception {
        Assert.assertEquals(AtomicNumbers.getFromNumberValue(0), AtomicNumbers.ZERO);
        Assert.assertEquals(AtomicNumbers.getFromNumberValue(14), AtomicNumbers.FOURTEEN);
        Assert.assertNull(AtomicNumbers.getFromNumberValue(20));
        Assert.assertNull(AtomicNumbers.getFromNumberValue(-1));
    }
}