import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class pointsummary {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\HP\\Downloads\\Iris.csv";

        // Create CSVReader object
     CSVReader reader = new CSVReader(new FileReader(filePath));

        // Initialize variables for summary statistics
        double sepalLengthMean = 0.0;
        double sepalWidthMean = 0.0;
        double petalLengthMean = 0.0;
        double petalWidthMean = 0.0;

        List<Double> sepalLengthValues = new ArrayList<>();
        List<Double> sepalWidthValues = new ArrayList<>();
        List<Double> petalLengthValues = new ArrayList<>();
        List<Double> petalWidthValues = new ArrayList<>();

        // Loop through CSV records
        String[] record;
        while ((record = reader.readNext()) != null) {
            // Get attribute values
            double sepalLength = Double.parseDouble(record[0]);
            double sepalWidth = Double.parseDouble(record[1]);
            double petalLength = Double.parseDouble(record[2]);
            double petalWidth = Double.parseDouble(record[3]);

            // Calculate means
            sepalLengthMean += sepalLength;
            sepalWidthMean += sepalWidth;
            petalLengthMean += petalLength;
            petalWidthMean += petalWidth;

            // Add attribute values to lists
            sepalLengthValues.add(sepalLength);
            sepalWidthValues.add(sepalWidth);
            petalLengthValues.add(petalLength);
            petalWidthValues.add(petalWidth);
        }

        // Calculate means
        int numRecords = sepalLengthValues.size();
        sepalLengthMean /= numRecords;
        sepalWidthMean /= numRecords;
        petalLengthMean /= numRecords;
        petalWidthMean /= numRecords;

        // Calculate medians
        double sepalLengthMedian = median(sepalLengthValues);
        double sepalWidthMedian = median(sepalWidthValues);
        double petalLengthMedian = median(petalLengthValues);
        double petalWidthMedian = median(petalWidthValues);

        // Calculate modes
        double sepalLengthMode = mode(sepalLengthValues);
        double sepalWidthMode = mode(sepalWidthValues);
        double petalLengthMode = mode(petalLengthValues);
        double petalWidthMode = mode(petalWidthValues);
        // TO calculate Min, Max
        double sepalLengthMin = Collections.min(sepalLengthValues);
        double sepalLengthMax = Collections.max(sepalLengthValues);
        double sepalWidthMin = Collections.min(sepalWidthValues);
        double sepalWidthMax = Collections.max(sepalWidthValues);
        double petalLengthMin = Collections.min(petalLengthValues);
        double petalLengthMax = Collections.max(petalLengthValues);
        double petalWidthMin = Collections.min(petalWidthValues);
        double petalWidthMax = Collections.max(petalWidthValues);

        
   
   
   
    }

    private static double median(List<Double> sepalLengthValues) {
        return 0;
    }

    private static double mode(List<Double> sepalWidthValues, String[] record) {
        return 0;

        // Calculate summary statistics for each species
        Map<String, List<Double>> speciesMap = new HashMap<>();
        String filePath;
        InputStreamReader reader = new InputStreamReader(new FileReader(filePath));
        reader.read(); // Skip header row
        while ((record = reader.read()) != null) {
            // Get species and attribute values
            String species = record[4];
            double sepalLength = Double.parseDouble(record[0]);
            double sepalWidth = Double.parseDouble(record[1]);
            double petalLength = Double.parseDouble(record[2]);
            double petalWidth = Double.parseDouble(record[3]);

            // Add attribute values to species map
            if (!speciesMap.containsKey(species)) {
                speciesMap.put(species, new ArrayList<>());
            }
            speciesMap.get(species).add(sepalLength);
            speciesMap.get(species).add(sepalWidth);
            speciesMap.get(species).add(petalLength);
            speciesMap.get(species).add(petalWidth);
        }

        // Print summary statistics for each species
        System.out.println("\nSummary Statistics by Species:");
        for (String species : speciesMap.keySet()) {
            List<Double> values = speciesMap.get(species);
            double mean = values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            double median = median(values);
            double mode = mode(values, record);
            double min = Collections.min(values);
            double max = Collections.max(values);
            System.out.println(species + ": Mean = " + mean + ", Median = " + median +
                    ", Mode = " + mode + ", Min = " + min + ", Max = " + max);
        }

        reader.close();

    }}
