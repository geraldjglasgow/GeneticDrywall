import java.util.Random;
import java.util.Arrays;

public class Chromosome {
    private int fitness = 0;
    private int[] genes;
    private final int MAX = 10;
    Random rand = new Random();

    public Chromosome(int length){
        genes = new int[length];
    }

    public Chromosome initializeChromosome() {
        for(int a=0; a<genes.length;a++){
           genes[a] = rand.nextInt(MAX - 0 + 1);
        }
        return this;
    }

    public int recalculateFitness(){

    }

    public int[] getGenes(){
        return genes;
    }

    public int getFitness(){
        return fitness;
    }

    public String toString(){
        return Arrays.toString(this.genes);
    }
}
