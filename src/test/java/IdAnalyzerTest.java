import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Provides testing methods of class IdAnalyzer.
 */
public class IdAnalyzerTest {
    /**
     * Input array for testing.
     */
    private String[] array = {"T1001,,   , T1002,,,   , T1003",
            ",,   , T1002,,,   , T1005,",
            ",T1006,",
            "T1001 ,  ,,, ,  ,",
            "T1002,  ,, , T1009, T23456,  , T108,  T1001,",
            null,
            " T1005 ,  ,,, ,  ,T1002,  ,, , T1009, T23456,  , T108,  T101,"};

    /**
     * Input string for testing.
     */
    private String string = ",T1002,,  ,T1005,,,   , ";

    /**
     * Tests the correctness of the search for records in the input array
     * that contain all Ids from the input String.
     */
    @Test
    public void findIdFromStringInArrayTest(){
        List<String> actualList = IdAnalyzer.findIdFromStringInArray(string, array);
        List<String> expectedList = Arrays.asList(",,   , T1002,,,   , T1005,",
                " T1005 ,  ,,, ,  ,T1002,  ,, , T1009, T23456,  , T108,  T101,");
        Assert.assertEquals(actualList, expectedList);
    }

    /**
     * Tests throwing an IllegalArgumentException when the input string is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullInputStringShouldThrowException(){
        IdAnalyzer.findIdFromStringInArray(null, array);
    }

    /**
     * Tests throwing an IllegalArgumentException when the input array is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullInputArrayShouldThrowException(){
        IdAnalyzer.findIdFromStringInArray(null, array);
    }
}