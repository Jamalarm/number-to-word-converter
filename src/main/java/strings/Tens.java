package strings;

/*
This enum represents numbers that can have another number appended in a single phrase.
e.g. "Twenty two"
 */
public enum Tens {

    TWENTY(20, "twenty"),
    THIRTY(30, "thirty"),
    FORTY(40, "forty"),
    FIFTY(50, "fifty"),
    SIXTY(60, "sixty"),
    SEVENTY(70, "seventy"),
    EIGHTY(80, "eighty"),
    NINETY(90, "ninety");

    private int numberValue;
    private String stringRepresentation;

    Tens(int numberValue, String stringRepresentation) {
        this.numberValue = numberValue;
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public int getNumberValue() {
        return numberValue;
    }
}
