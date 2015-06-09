package converters;

import strings.AtomicNumbers;
import strings.SeperatorStrings;
import strings.Tens;

import java.util.LinkedList;
import java.util.List;

import static strings.Tens.*;
import static strings.SeperatorStrings.WHITE_SPACE;

public class TensConverter implements INumberToTextConverter {

    private static final int MAX_VALUE = 99;

    private static final List<Tens> orderedTens;

    static {
        orderedTens = new LinkedList<Tens>();
        orderedTens.add(NINETY);
        orderedTens.add(EIGHTY);
        orderedTens.add(SEVENTY);
        orderedTens.add(SIXTY);
        orderedTens.add(FIFTY);
        orderedTens.add(FORTY);
        orderedTens.add(THIRTY);
        orderedTens.add(TWENTY);
    }

    private final INumberToTextConverter delegate;

    public TensConverter(INumberToTextConverter delegate) {
        this.delegate = delegate;
    }

    public String convertToString(int i) {

        if (i > MAX_VALUE || i < 0) {
            throw new UnsupportedOperationException(String.format("This converter only supports values from 0 to 99 (supplied value: %s)", i));
        }

        if (i < delegate.getMaxCanHandle()) {
            return delegate.convertToString(i);
        }

        StringBuilder builder = new StringBuilder();

        for (Tens ten : orderedTens) {
            if (i >= ten.getNumberValue()) {
                builder.append(ten.getStringRepresentation());
                i -= ten.getNumberValue();
                break;
            }
        }

        if (i > 0) {
            builder.append(WHITE_SPACE);
            builder.append(delegate.convertToString(i));
        }

        return builder.toString();

    }

    public int getMaxCanHandle() {
        return MAX_VALUE;
    }
}
