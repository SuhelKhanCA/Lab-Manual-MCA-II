package Week10;
import java.util.Random;

public class PSOImplementation { // Q3
    static class Particle {
        double position;
        double velocity;
        double bestPosition;

        Particle(double position, double velocity) {
            this.position = position;
            this.velocity = velocity;
            this.bestPosition = position;
        }
    }

    static double fitnessFunction(double x) {
        return x * x; // The function to optimize is f(x) = x^2
    }

    public static void main(String[] args) {
        int numParticles = 100;
        int numIterations = 1000;
        double omega = 0.5; // inertia weight
        double c1 = 1.0; // cognitive weight
        double c2 = 2.0; // social weight

        Particle[] particles = new Particle[numParticles];
        double globalBestPosition = Double.MAX_VALUE;
        Random rand = new Random();

        // Initialize particles
        for (int i = 0; i < numParticles; i++) {
            double position = rand.nextDouble() * 100 - 50; // Random position between -50 and 50
            double velocity = rand.nextDouble() * 20 - 10; // Random velocity between -10 and 10
            particles[i] = new Particle(position, velocity);
            if (fitnessFunction(particles[i].position) < fitnessFunction(globalBestPosition)) {
                globalBestPosition = particles[i].position;
            }
        }

        // Main loop
        for (int iter = 0; iter < numIterations; iter++) {
            for (Particle particle : particles) {
                // Update velocity
                particle.velocity = omega * particle.velocity + c1 * rand.nextDouble() * (particle.bestPosition - particle.position) + c2 * rand.nextDouble() * (globalBestPosition - particle.position);

                // Update position
                particle.position += particle.velocity;

                // Update personal best position
                if (fitnessFunction(particle.position) < fitnessFunction(particle.bestPosition)) {
                    particle.bestPosition = particle.position;
                }

                // Update global best position
                if (fitnessFunction(particle.position) < fitnessFunction(globalBestPosition)) {
                    globalBestPosition = particle.position;
                }
            }
        }

        System.out.println("Final optimized solution: " + globalBestPosition);
        System.out.println("Fitness value: " + fitnessFunction(globalBestPosition));
    }
}
