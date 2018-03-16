public class Population {

    private Chromosome[] chromosomes;
    private final int SIZE = 5;

    public Population(int length){
        chromosomes = new Chromosome[length];
    }

    public void sortChromosomesByFitness(){

    }

    public Population initializePopulation(){
        for(int a=0;a<chromosomes.length;a++){
            chromosomes[a] = new Chromosome(SIZE).initializeChromosome();
        }
        sortChromosomesByFitness();
        return this;
    }
}
