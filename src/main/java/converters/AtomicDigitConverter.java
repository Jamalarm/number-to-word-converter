package converters;

import strings.AtomicNumbers;

public class AtomicDigitConverter implements INumberToTextConverter {

    private static final int MAX_VALUE = 19;

    public String convertToString(int i) {

        if (i > MAX_VALUE || i < 0) {
            throw new UnsupportedOperationException(String.format("This converter only supports values from to 19 (supplied value: %s)", i));
        }

        AtomicNumbers atomicNumber = AtomicNumbers.getFromNumberValue(i);

        if (atomicNumber != null) {
            return atomicNumber.getStringRepresentation();
        } else {
            //This should never be reached
            throw new IllegalArgumentException(String.format("Illegal number passed as argument: %s", i));
        }
    }

    public int getMaxCanHandle() {
        return MAX_VALUE;
    }
}
