package converters;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import strings.SeperatorStrings;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NthOrderConverterTest {

    @Rule
    final public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testOutputIsCorrectWhenInputValid() {
        NthOrderConverter hundredsConverter = getHundredsConverter();

        Assert.assertEquals("four hundred and thirty one", hundredsConverter.convertToString(431));
    }

    @Test
    public void testParseFailsWhenArgumentLessThanMinimum() {
        NthOrderConverter hundredsConverter = getHundredsConverter();

        expectedException.expect(UnsupportedOperationException.class);
        hundredsConverter.convertToString(-1);

    }

    @Test
    public void testParseFailsWhenArgumentMoreThanMaximum() {
        NthOrderConverter hundredsConverter = getHundredsConverter();

        expectedException.expect(UnsupportedOperationException.class);
        hundredsConverter.convertToString(1000);

    }

    @Test
    public void testPassthroughWhenNumberIsSmallEnough() {
        NthOrderConverter hundredsConverter = getHundredsConverter();

        Assert.assertEquals("four", hundredsConverter.convertToString(4));
    }

    private NthOrderConverter getHundredsConverter() {
        INumberToTextConverter mockedTens = mock(INumberToTextConverter.class);
        when(mockedTens.getMaxCanHandle()).thenReturn(99);
        when(mockedTens.convertToString(4)).thenReturn("four");
        when(mockedTens.convertToString(31)).thenReturn("thirty one");

        return new NthOrderConverter(999, 100, "hundred", SeperatorStrings.AND, mockedTens);
    }

}