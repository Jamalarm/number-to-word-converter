package converters;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Integration test - no mocking here
 */
public class CompositeNumberToTextConverterTest {

    @Rule
    final public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testZero() {
        CompositeNumberToTextConverter converter = new CompositeNumberToTextConverter();

        Assert.assertEquals("zero", converter.convertToString(0));
    }

    @Test
    public void testSmallNumbers() {
        CompositeNumberToTextConverter converter = new CompositeNumberToTextConverter();

        Assert.assertEquals("thirty one", converter.convertToString(31));
        Assert.assertEquals("seven", converter.convertToString(7));
        Assert.assertEquals("fifteen", converter.convertToString(15));
        Assert.assertEquals("forty", converter.convertToString(40));
    }

    @Test
    public void testLargeNumbers() {
        CompositeNumberToTextConverter converter = new CompositeNumberToTextConverter();

        Assert.assertEquals("forty eight million, seven hundred and ninety one thousand, one hundred and forty nine", converter.convertToString(48791149));
        Assert.assertEquals("one million, one hundred and twenty one", converter.convertToString(1000121));
        Assert.assertEquals("ninety nine million, nine hundred and ninety nine thousand, one hundred and ninety nine", converter.convertToString(99999199));
        Assert.assertEquals("one million, two hundred and thirteen thousand, two hundred and seventy eight", converter.convertToString(1213278));
        Assert.assertEquals("eighteen million, seven hundred and eighty seven thousand, nine hundred and eighty seven", converter.convertToString(18787987));
        Assert.assertEquals("six million, two hundred and twenty two thousand, two hundred and twenty two", converter.convertToString(6222222));
    }

    /**
     * this is a list of the cases I have found are not currently handled well by my implementation
     */
    @Test
    public void testCasesNotHandledWell() {
        CompositeNumberToTextConverter converter = new CompositeNumberToTextConverter();

        Assert.assertEquals("one hundred thousand, one", converter.convertToString(100001));
        Assert.assertEquals("four thousand, twenty", converter.convertToString(4020));
    }

    @Test
    public void testRepeatedNumbers() {
        CompositeNumberToTextConverter converter = new CompositeNumberToTextConverter();

        Assert.assertEquals("one hundred and eleven million, one hundred and eleven thousand, one hundred and eleven", converter.convertToString(111111111));
        Assert.assertEquals("two hundred and twenty two million, two hundred and twenty two thousand, two hundred and twenty two", converter.convertToString(222222222));
        Assert.assertEquals("three hundred and thirty three million, three hundred and thirty three thousand, three hundred and thirty three", converter.convertToString(333333333));
        Assert.assertEquals("four hundred and forty four million, four hundred and forty four thousand, four hundred and forty four", converter.convertToString(444444444));
        Assert.assertEquals("five hundred and fifty five million, five hundred and fifty five thousand, five hundred and fifty five", converter.convertToString(555555555));
        Assert.assertEquals("six hundred and sixty six million, six hundred and sixty six thousand, six hundred and sixty six", converter.convertToString(666666666));
        Assert.assertEquals("seven hundred and seventy seven million, seven hundred and seventy seven thousand, seven hundred and seventy seven", converter.convertToString(777777777));
        Assert.assertEquals("eight hundred and eighty eight million, eight hundred and eighty eight thousand, eight hundred and eighty eight", converter.convertToString(888888888));
        Assert.assertEquals("nine hundred and ninety nine million, nine hundred and ninety nine thousand, nine hundred and ninety nine", converter.convertToString(999999999));
    }

    @Test
    public void testOrders() {
        CompositeNumberToTextConverter converter = new CompositeNumberToTextConverter();

        Assert.assertEquals("two", converter.convertToString(2));
        Assert.assertEquals("twenty", converter.convertToString(20));
        Assert.assertEquals("two hundred", converter.convertToString(200));
        Assert.assertEquals("two thousand", converter.convertToString(2000));
        Assert.assertEquals("twenty thousand", converter.convertToString(20000));
        Assert.assertEquals("two hundred thousand", converter.convertToString(200000));
        Assert.assertEquals("two million", converter.convertToString(2000000));
        Assert.assertEquals("twenty million", converter.convertToString(20000000));
        Assert.assertEquals("two hundred million", converter.convertToString(200000000));
    }

    @Test
    public void testParseFailsWhenArgumentLessThanMinimum() {
        CompositeNumberToTextConverter converter = new CompositeNumberToTextConverter();

        expectedException.expect(UnsupportedOperationException.class);
        converter.convertToString(-1);

    }

    @Test
    public void testParseFailsWhenArgumentMoreThanMaximum() {
        CompositeNumberToTextConverter converter = new CompositeNumberToTextConverter();

        expectedException.expect(UnsupportedOperationException.class);
        converter.convertToString(converter.getMaxCanHandle() + 1);

    }

}