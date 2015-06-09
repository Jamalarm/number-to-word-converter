package converters;

/**
 * Order agnostic interface defining a component number to text converter
 */
public interface INumberToTextConverter {

    /**
     * Performs text conversion of supplied number
     * @param i an integer that must be less than getMaxCanHandle()
     * @return a test representation of the supplied integer
     */
    public String convertToString(int i);

    /**
     *
     * @return the maximum integer this converter is able to handle
     */
    public int getMaxCanHandle();

}
