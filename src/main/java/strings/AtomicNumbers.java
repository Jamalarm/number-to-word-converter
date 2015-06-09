package strings;

/*
This class defines the list of numbers that cannot have anything appended to them in a phrase. I.e. you can't have
"eleven and two"
 */
public enum AtomicNumbers {

    //Note - I know I'm duplicating slightly here by having a string constant in the enum, I could just convert the
    // enum to a string and get it's name - I personally don't like relying on non-string literals for logic like this.

    /*SINGLE DIGITS*/
    ZERO(0, "zero"),
    ONE(1, "one"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine"),

    /*-TEENS*/
    TEN(10, "ten"),
    ELEVEN(11, "eleven"),
    TWELVE(12, "twelve"),
    THIRTEEN(13, "thirteen"),
    FOURTEEN(14, "fourteen"),
    FIFTEEN(15, "fifteen"),
    SIXTEEN(16, "sixteen"),
    SEVENTEEN(17, "seventeen"),
    EIGHTEEN(18, "eighteen"),
    NINETEEN(19, "nineteen");

    private int numberValue;
    private String stringRepresentation;

    AtomicNumbers(int numberValue, String stringRepresentation) {
        this.numberValue = numberValue;
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public int getNumberValue() {
        return numberValue;
    }

    public static AtomicNumbers getFromNumberValue(int i) {
        for (AtomicNumbers atomicNumber : values()) {
            if (atomicNumber.numberValue == i) {
                return atomicNumber;
            }
        }
        return null;
    }
}
