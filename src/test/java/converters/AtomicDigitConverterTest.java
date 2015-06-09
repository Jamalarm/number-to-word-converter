package converters;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static strings.AtomicNumbers.*;

public class AtomicDigitConverterTest {

    @Rule
    final public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSuccessfulParsing() {
        final INumberToTextConverter converter = new AtomicDigitConverter();

        Assert.assertEquals(converter.convertToString(1), ONE.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(2), TWO.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(3), THREE.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(4), FOUR.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(5), FIVE.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(6), SIX.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(7), SEVEN.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(8), EIGHT.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(9), NINE.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(10), TEN.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(11), ELEVEN.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(12), TWELVE.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(13), THIRTEEN.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(14), FOURTEEN.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(15), FIFTEEN.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(16), SIXTEEN.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(17), SEVENTEEN.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(18), EIGHTEEN.getStringRepresentation());
        Assert.assertEquals(converter.convertToString(19), NINETEEN.getStringRepresentation());

    }

    @Test
    public void testParseFailsWhenArgumentLessThanMinimum() {
        final AtomicDigitConverter converter = new AtomicDigitConverter();

        expectedException.expect(UnsupportedOperationException.class);
        converter.convertToString(-1);
    }

    @Test
    public void testParseFailsWhenArgumentMoreThanMaximum() {
        final AtomicDigitConverter converter = new AtomicDigitConverter();

        expectedException.expect(UnsupportedOperationException.class);
        converter.convertToString(20);
    }

}