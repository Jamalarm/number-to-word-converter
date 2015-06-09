package converters;

import static strings.SeperatorStrings.AND;
import static strings.SeperatorStrings.COMMA;

public class CompositeNumberToTextConverter implements INumberToTextConverter {

    public static final String HUNDRED = "hundred";
    public static final String THOUSAND = "thousand";
    public static final String MILLION = "million";

    private final INumberToTextConverter delegate;

    public CompositeNumberToTextConverter() {

        //Build converter from ground up - This could easily be done in Spring if deemed necessary

        //0 - 19
        AtomicDigitConverter atomicDigitConverter = new AtomicDigitConverter();

        //20 - 99
        TensConverter tensConverter = new TensConverter(atomicDigitConverter);

        //100 - 999
        NthOrderConverter hundredsConverter = new NthOrderConverter(999, 100, HUNDRED, AND, tensConverter);

        //1000 - 999999
        NthOrderConverter thousandsConverter = new NthOrderConverter(999999, 1000, THOUSAND, COMMA, hundredsConverter);

        //1000000 - 999999999
        this.delegate = new NthOrderConverter(999999999, 1000000, MILLION, COMMA, thousandsConverter);
    }

    public String convertToString(int i) {
        return delegate.convertToString(i);
    }

    public int getMaxCanHandle() {
        return delegate.getMaxCanHandle();
    }
}
