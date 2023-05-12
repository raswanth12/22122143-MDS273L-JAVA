import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class pointsummary {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\HP\\Downloads\\Iris.csv";
        printOverallSummaryStatistics(filePath);
        printSummaryStatisticsBySpecies(filePath);
    }

    private static void printOverallSummaryStatistics(String filePath) throws IOException {
        CSVReader reader = new CSVReader();
        String[] nextLine;
        reader.readNext(); // skip the header

        // Initialize variables for summary statistics
        double sepalLengthSum = 0.0;
        double sepalWidthSum = 0.0;
        double petalLengthSum = 0.0;
        double petalWidthSum = 0.0;

        List<Double> sepalLengthValues = new ArrayList<>();
        List<Double> sepalWidthValues = new ArrayList<>();
        List<Double> petalLengthValues = new ArrayList<>();
        List<Double> petalWidthValues = new ArrayList<>();

        // Loop through CSV records
        while ((nextLine = reader.readNext()) != null) {
            // Get attribute values
            double sepalLength = Double.parseDouble(nextLine[0]);
            double sepalWidth = Double.parseDouble(nextLine[1]);
            double petalLength = Double.parseDouble(nextLine[2]);
            double petalWidth = Double.parseDouble(nextLine[3]);

            // Calculate sums
            sepalLengthSum += sepalLength;
            sepalWidthSum += sepalWidth;
            petalLengthSum += petalLength;
            petalWidthSum += petalWidth;

            // Add attribute values to lists
            sepalLengthValues.add(sepalLength);
            sepalWidthValues.add(sepalWidth);
            petalLengthValues.add(petalLength);
            petalWidthValues.add(petalWidth);
        }
        reader.clone();

        // Other statistical calculations go here...
    }

    /**
     * @param filePath
     * @throws IOException
     */
    private static void printSummaryStatisticsBySpecies(String filePath) throws IOException {
        CSVReader reader = new CSVReader();
        String[] nextLine;
        reader.readNext(); // skip the header

        // Calculate summary statistics for each species
        Map<String, List<Double>> speciesMap = new HashMap<>();
        while ((nextLine = reader.readNext()) != null) {
            // Get species and attribute values
            String species = nextLine[4];
            double sepalLength = Double.parseDouble(nextLine[0]);
            double sepalWidth = Double.parseDouble(nextLine[1]);
            double petalLength = Double.parseDouble(nextLine[2]);
            double petalWidth = Double.parseDouble(nextLine[3]);

            // Add attribute values to species map
            if (!speciesMap.containsKey(species)) {
                speciesMap.put(species, new ArrayList<>());
            }
            speciesMap.get(species).add(sepalLength);
            speciesMap.get(species).add(sepalWidth);
            speciesMap.get(species).add(petalLength);
            speciesMap.get(species).add(petalWidth);
        }
        reader.clone();

        // Print summary statistics for each species
        System.out.println("\nSummary Statistics by Species:");
        for (String species : speciesMap.keySet()) {
            List<Double> values = speciesMap.get(species);

            // Calculate mean
            double mean = values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            // Calculate median
            Collections.sort(values);
            double median;
            int size = values.size();
            if (size % 2 == 0)
                median = (values.get(size / 2) + values.get(size / 2 - 1)) / 2;
            else
                median = values.get(size / 2);

            // Calculate mode
            Map<Double, Long> freqMap = values.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            double mode = Collections.max(freqMap.entrySet(), Comparator.comparingLong(Map.Entry::getValue)).getKey();

            // Calculate min, max
            double min = Collections.min(values);
            double max = Collections.max(values);

            System.out.println(species + ": Mean = " + mean + ", Median = " + median +
                    ", Mode = " + mode + ", Min = " + min + ", Max = " + max);
        }
    }
}
