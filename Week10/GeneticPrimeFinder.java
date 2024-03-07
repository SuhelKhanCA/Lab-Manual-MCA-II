package Week10;
import java.util.*;

public class GeneticPrimeFinder { // Q2
    private static final int POPULATION_SIZE = 100;
    private static final int CHROMOSOME_LENGTH = 7; // To represent numbers up to 127
    private static final int MAX_GENERATIONS = 1000;
    private static final double MUTATION_RATE = 0.01;

    public static void main(String[] args) {
        List<String> population = initializePopulation();
        int generation = 0;

        while (generation < MAX_GENERATIONS) {
            Map<String, Integer> fitnessMap = calculateFitness(population);
            population = selectNewPopulation(fitnessMap);
            mutatePopulation(population);

            String bestIndividual = Collections.max(fitnessMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            if (isPrime(Integer.parseInt(bestIndividual, 2))) {
                System.out.println("Found prime number: " + Integer.parseInt(bestIndividual, 2));
                System.out.println("Generation: " + generation);
                break;
            }

            generation++;
        }
    }

    private static List<String> initializePopulation() {
        List<String> population = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            StringBuilder chromosome = new StringBuilder();
            for (int j = 0; j < CHROMOSOME_LENGTH; j++) {
                chromosome.append(Math.random() < 0.5 ? '0' : '1');
            }
            population.add(chromosome.toString());
        }
        return population;
    }

    private static Map<String, Integer> calculateFitness(List<String> population) {
        Map<String, Integer> fitnessMap = new HashMap<>();
        for (String individual : population) {
            int number = Integer.parseInt(individual, 2);
            int fitness = number < 2 ? 0 : (int) Math.floor(Math.sqrt(number));
            fitnessMap.put(individual, fitness);
        }
        return fitnessMap;
    }

    private static List<String> selectNewPopulation(Map<String, Integer> fitnessMap) {
        List<String> newPopulation = new ArrayList<>();
        List<Map.Entry<String, Integer>> sortedFitnessMap = new ArrayList<>(fitnessMap.entrySet());
        sortedFitnessMap.sort(Map.Entry.comparingByValue());

        for (int i = POPULATION_SIZE / 2; i < POPULATION_SIZE; i++) {
            newPopulation.add(sortedFitnessMap.get(i).getKey());
        }

        while (newPopulation.size() < POPULATION_SIZE) {
            int parent1Index = (int) (Math.random() * (POPULATION_SIZE / 2));
            int parent2Index = (int) (Math.random() * (POPULATION_SIZE / 2));
            String offspring = crossover(sortedFitnessMap.get(parent1Index).getKey(), sortedFitnessMap.get(parent2Index).getKey());
            newPopulation.add(offspring);
        }

        return newPopulation;
    }

    private static String crossover(String parent1, String parent2) {
        int crossoverPoint = (int) (Math.random() * CHROMOSOME_LENGTH);
        return parent1.substring(0, crossoverPoint) + parent2.substring(crossoverPoint);
    }

    private static void mutatePopulation(List<String> population) {
        for (int i = 0; i < population.size(); i++) {
            String individual = population.get(i);
            for (int j = 0; j < CHROMOSOME_LENGTH; j++) {
                if (Math.random() < MUTATION_RATE) {
                    char[] chars = individual.toCharArray();
                    chars[j] = chars[j] == '0' ? '1' : '0';
                    individual = String.valueOf(chars);
                }
            }
            population.set(i, individual);
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
