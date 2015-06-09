package converters;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TensConverterTest {

    @Rule
    final public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testOutputIsCorrectWhenInputValid() {

        TensConverter tensConverter = getTensConverter();

        Assert.assertEquals(tensConverter.convertToString(21), "twenty one");
        Assert.assertEquals(tensConverter.convertToString(31), "thirty one");
        Assert.assertEquals(tensConverter.convertToString(41), "forty one");
        Assert.assertEquals(tensConverter.convertToString(51), "fifty one");
        Assert.assertEquals(tensConverter.convertToString(61), "sixty one");
        Assert.assertEquals(tensConverter.convertToString(71), "seventy one");
        Assert.assertEquals(tensConverter.convertToString(81), "eighty one");
        Assert.assertEquals(tensConverter.convertToString(91), "ninety one");

    }

    @Test
    public void testPassthroughWhenInputIsSmallEnough() {
        TensConverter tensConverter = getTensConverter();

        Assert.assertEquals(tensConverter.convertToString(15), "fifteen");
    }

    @Test
    public void testParseFailsWhenArgumentLessThanMinimum() {
        TensConverter tensConverter = getTensConverter();

        expectedException.expect(UnsupportedOperationException.class);
        tensConverter.convertToString(-1);
    }

    @Test
    public void testParseFailsWhenArgumentMoreThanMaximum() {
        TensConverter tensConverter = getTensConverter();

        expectedException.expect(UnsupportedOperationException.class);
        tensConverter.convertToString(100);
    }


    private TensConverter getTensConverter() {
        INumberToTextConverter mockDelegate = mock(INumberToTextConverter.class);
        when(mockDelegate.convertToString(1)).thenReturn("one");
        when(mockDelegate.convertToString(15)).thenReturn("fifteen");
        when(mockDelegate.getMaxCanHandle()).thenReturn(19);

        return new TensConverter(mockDelegate);
    }

}