import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Provides analysis of incoming data for Id matching.
 */
public class IdAnalyzer {
    /**
     * Delimiter for Id in incoming data.
     */
    private static final String ROW_ID_DELIMITER = ",";

    /**
     * The method finds all records in the input Array
     * that contain all Ids from the input String.
     * @param string String with Ids delimited ','.
     * @param array Array of strings with Ids delimited ','.
     * @return collection with all elements of an array containing all id from a string
     * @throws IllegalArgumentException if input parameters was wrong.
     */
    public static List<String> findIdFromStringInArray(String string, String[] array){
        if (string == null || array == null) {
            throw new IllegalArgumentException("Input string or array cannot be null");
        }

        List<String> idFromString = parseIds(string);

        return  Arrays.stream(array)
                .filter((arrayElement) -> Objects.nonNull(arrayElement) &&
                                parseIds(arrayElement).containsAll(idFromString))
                .collect(Collectors.toList());
    }

    /**
     * The method parses the input string, extracting only Ids from it, which are written to the output collection.
     * @param rowIds String with Ids delimited ','.
     * @return collection with all ids from the input string
     */
    private static List<String> parseIds(String rowIds){
        return Arrays.stream(rowIds.replaceAll("\\s+", "")
                .split(ROW_ID_DELIMITER))
                .filter(id -> !id.isEmpty())
                .collect(Collectors.toList());
    }
}
