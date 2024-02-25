import java.io.*;
import java.util.ArrayList;
import java.util.List;

class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

class DataProcessor {
    public List<Double> readValuesFromFile(String filePath) throws FileNotFoundException, IOException, InvalidDataException {
        List<Double> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    double value = Double.parseDouble(line);
                    values.add(value);
                } catch (NumberFormatException e) {
                    throw new InvalidDataException("Invalid data found in the file.");
                }
            }
        }
        return values;
    }
    public void validateData(List<Double> values) throws InvalidDataException {
        if (values.isEmpty()) {
            throw new InvalidDataException("No valid numeric data found.");
        }
    }

    public double calculateAverage(List<Double> validValues) {
        double sum = 0;
        for (double value : validValues) {
            sum += value;
        }
        return sum / validValues.size();
    }

    public void writeResultToFile(double average, String outputPath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            bw.write(String.valueOf(average));
        }
    }
}

public class q1 {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            DataProcessor processor = new DataProcessor();
            List<Double> values = processor.readValuesFromFile(inputFilePath);
            processor.validateData(values);
            double average = processor.calculateAverage(values);
            processor.writeResultToFile(average, outputFilePath);
            System.out.println("Average calculated and written to output file successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred during file processing: " + e.getMessage());
        } catch (InvalidDataException e) {
            System.err.println("Invalid data: " + e.getMessage());
        }
    }
}
