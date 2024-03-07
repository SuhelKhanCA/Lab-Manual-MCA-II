// package Week11;
import java.util.*;

public class HybridPSOGATriangleTestCases { // Q1
    static class TestCase {
        double a, b, c; // Sides of the triangle
        String classification; // Classification of the triangle

        TestCase(double a, double b, double c, String classification) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.classification = classification;
        }

        @Override
        public String toString() {
            return "Triangle(a=" + a + ", b=" + b + ", c=" + c + ", classification=" + classification + ")";
        }
    }

    static String classifyTriangle(double a, double b, double c) {
        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || c == a) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    public static void main(String[] args) {
        int numTestCases = 100;
        int numIterations = 1000;
        double mutationRate = 0.01;

        List<TestCase> testCases = new ArrayList<>();

        // Initialize test cases
        Random rand = new Random();
        for (int i = 0; i < numTestCases; i++) {
            double a = rand.nextDouble() * 100;
            double b = rand.nextDouble() * 100;
            double c = rand.nextDouble() * 100;
            String classification = classifyTriangle(a, b, c);
            testCases.add(new TestCase(a, b, c, classification));
        }

        // Main loop
        for (int iter = 0; iter < numIterations; iter++) {
            // Mutation
            for (TestCase testCase : testCases) {
                if (rand.nextDouble() < mutationRate) {
                    testCase.a += rand.nextDouble() * 20 - 10;
                    testCase.b += rand.nextDouble() * 20 - 10;
                    testCase.c += rand.nextDouble() * 20 - 10;
                    testCase.classification = classifyTriangle(testCase.a, testCase.b, testCase.c);
                }
            }

            // Crossover
            for (int i = 0; i < numTestCases; i++) {
                if (rand.nextDouble() < mutationRate) {
                    int j = rand.nextInt(numTestCases);
                    double temp = testCases.get(i).a;
                    testCases.get(i).a = testCases.get(j).a;
                    testCases.get(j).a = temp;
                    testCases.get(i).classification = classifyTriangle(testCases.get(i).a, testCases.get(i).b, testCases.get(i).c);
                    testCases.get(j).classification = classifyTriangle(testCases.get(j).a, testCases.get(j).b, testCases.get(j).c);
                }
            }
        }

        // Print test cases
        for (TestCase testCase : testCases) {
            System.out.println(testCase);
        }
    }
}
