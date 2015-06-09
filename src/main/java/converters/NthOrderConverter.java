package converters;

import strings.SeperatorStrings;

public class NthOrderConverter implements INumberToTextConverter {

    private final int maxValue;
    private final int order;
    private final String label;
    private final String finalSeperator;

    private final INumberToTextConverter delegate;

    public NthOrderConverter(int maxValue, int order, String label, String finalSeperator, INumberToTextConverter delegate) {
        this.maxValue = maxValue;
        this.order = order;
        this.label = label;
        this.finalSeperator = finalSeperator;
        this.delegate = delegate;
    }

    public String convertToString(int i) {

        if (i > maxValue || i < 0) {
            throw new UnsupportedOperationException(String.format("This converter only supports values to %s (supplied value: %s)", maxValue, i));
        }

        //First check if our delgate can handle this number
        if (i < delegate.getMaxCanHandle()) {
            return delegate.convertToString(i);
        }

        StringBuilder builder = new StringBuilder();
        //find the significant digits for this order
        int nthOrderVal = i / order;

        //use the delegate to convert
        if (nthOrderVal > 0) {
            builder.append(delegate.convertToString(nthOrderVal));
            builder.append(SeperatorStrings.WHITE_SPACE);
            builder.append(label);
        }

        //check if there is a remainder after the amount we just handled, and pass to the delegate if so
        int remainder = i - (nthOrderVal * order);
        if (remainder > 0) {
            if (nthOrderVal > 0) {
                builder.append(finalSeperator);
            }
            builder.append(delegate.convertToString(remainder));
        }

        return builder.toString();
    }

    public int getMaxCanHandle() {
        return maxValue;
    }
}
