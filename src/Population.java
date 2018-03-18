import java.util.Arrays;

public class Population {

    private Chromosome[] chromosomes;
    private final int SIZE = 5;

    public Population(int length){
        chromosomes = new Chromosome[length];
    }

    public void sortChromosomesByFitness(){
        Arrays.sort(chromosomes, (chromosomes1, chromosomes2) -> {
            int flag = 0;
            if(chromosomes1.getFitness() > chromosomes2.getFitness()) flag = -1;
            else if(chromosomes1.getFitness() < chromosomes2.getFitness()) flag = 1;
            return flag;
        });
        boolean sorted = false;
        while(!sorted && chromosomes.length == 8) {
            sorted = true;
            for (int i = 0; i < 7; i++) {
                if (chromosomes[i].getFitness() > chromosomes[i + 1].getFitness() && chromosomes[i].getFitness() > 0 && chromosomes[i + 1].getFitness() > 0) {
                    Chromosome ch = chromosomes[i];
                    chromosomes[i] = chromosomes[i + 1];
                    chromosomes[i + 1] = ch;
                    sorted = false;
                }
            }
        }
        while(!sorted && chromosomes.length == 4) {
            sorted = true;
            for (int i = 0; i < 3; i++) {
                if (chromosomes[i].getFitness() > chromosomes[i + 1].getFitness() && chromosomes[i].getFitness() > 0 && chromosomes[i + 1].getFitness() > 0) {
                    Chromosome ch = chromosomes[i];
                    chromosomes[i] = chromosomes[i + 1];
                    chromosomes[i + 1] = ch;
                    sorted = false;
                }
            }
        }
    }

    public Population initializePopulation(double length){
        for(int a=0;a<chromosomes.length;a++){
            chromosomes[a] = new Chromosome(SIZE, length).initializeChromosome();
        }
        sortChromosomesByFitness();
        return this;
    }

    public Chromosome[] getChromosomes(){
        return chromosomes;
    }
}
