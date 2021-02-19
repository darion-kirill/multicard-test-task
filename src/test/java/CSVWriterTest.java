import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Provides testing methods of class CSVWriter.
 */
public class CSVWriterTest {
    /**
     * Path to output the test file.
     */
    private final Path CSV_TEST_FILE_PATH = Paths.get("./src/test/results.csv");

    /**
     * A collection for testing file writing methods.
     */
    private List<String> expectedList = Arrays.asList(",,   , T1002,,,   , T1005,",
            " T1005 ,  ,,, ,  ,T1002,  ,, , T1009, T23456,  , T108,  T101,");

    /**
     * Testing the correctness of writing to the input collection file.
     */
    @Test
    public void writeListTest() throws IOException {
        CSVWriter.writeList(expectedList, CSV_TEST_FILE_PATH);
        try(FileInputStream CSVFile = new FileInputStream(CSV_TEST_FILE_PATH.toFile());) {
            List<String> actualList = Arrays.asList(new String(CSVFile.readAllBytes()).split("\r\n"));
            Assert.assertEquals(expectedList, actualList);
        }
    }

    /**
     * Tests throwing an FileNotFoundException when there is no directory
     * specified in the method writeList signature.
     */
    @Test(expected = FileNotFoundException.class)
    public void incorrectPathShouldThrowException() throws FileNotFoundException {
        Path incorrectPath = Paths.get("./test/results.csv");
        CSVWriter.writeList(expectedList, incorrectPath);
        Assert.fail("Expected FileNotFoundException");
    }

    /**
     * The method deletes the temporary test file after all tests have passed
     */
    @After
    public void deleteTestFile(){
        File deleteFile = CSV_TEST_FILE_PATH.toFile();
        deleteFile.delete();
    }
}