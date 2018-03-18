import java.util.Arrays;

public class Driver {
    public static void main(String[] args){
        double value = 42;
        Population population = new Population(GeneticAlgorithm.SIZE).initializePopulation(value);
        GeneticAlgorithm genalg = new GeneticAlgorithm(value);
        int generationNumber = 0;
        while ((population.getChromosomes()[0].getFitness() > 1 || population.getChromosomes()[0].getFitness() < 0) && generationNumber < 10000000){
            population = genalg.evolve(population);
            population.sortChromosomesByFitness();
            System.out.println("Generation #"+generationNumber+" | Fitness: "+population.getChromosomes()[0].getFitness());
            printPopulation(population);
            System.out.println();
            generationNumber++;
        }

    }

    public static void printPopulation(Population population){
        System.out.println("---------------------------------------------------------------------------------");
        for(int i=0;i < population.getChromosomes().length; i++){
            System.out.println("Chromosome " + i + " : " + Arrays.toString(population.getChromosomes()[i].getGenes()) + " | Fitness: " + population.getChromosomes()[i].getFitness());
        }
    }
}
