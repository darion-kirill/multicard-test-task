import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

/**
 * Provides ability to write data to .csv file.
 */
public class CSVWriter {
    /**
     * Provides logger for this class.
    */
    private static final Logger logger = LogManager.getLogger(CSVWriter.class);

    /**
     * Writes list of data to different lines of .csv file.
     * @param recordList Data to write to file.
     * @param csvPath Path to the .csv file to write.
     * @throws FileNotFoundException when an invalid file path is specified
     */
    public static void writeList(List<String> recordList, Path csvPath) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(csvPath.toFile())) {

            logger.info("Writing data to CSV file with path  '" + csvPath + "'....");

            String lineSeparator = System.lineSeparator();
            StringBuilder resultBuilder = new StringBuilder();

            recordList.forEach((listElement) -> resultBuilder.append(listElement).append(lineSeparator));
            writer.write(resultBuilder.toString());

            logger.info("CSV file " + csvPath + " was created");
        }
    }
}