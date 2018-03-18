import java.util.Random;
import java.util.Arrays;

public class Chromosome {
    private double fitness = 0;
    boolean isFitnessChanged = true;
    private int[] genes;
    private final int MAX = 10;
    double length = 0;
    Random rand = new Random();

    public Chromosome(int length,double len){
        genes = new int[length];
        this.length = len;
    }

    public Chromosome initializeChromosome() {

        for(int a=0; a<genes.length;a++){
           genes[a] = rand.nextInt(MAX - 0 + 1);
        }
        return this;
    }

    public double recalculateFitness(){
        return calculateSum()-length;
    }

    public int[] getGenes(){
        isFitnessChanged = true;
        return genes;
    }

    public double getFitness(){
        if(isFitnessChanged){
            fitness = recalculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    public String toString(){
        return Arrays.toString(this.genes);
    }

    public double calculateSum(){
        return (genes[0]*8) + (genes[1]*10) + (genes[2]*12) + (genes[3]*14) + (genes[4]*16);
    }
}
