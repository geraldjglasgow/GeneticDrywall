import java.util.Random;

public class GeneticAlgorithm {
    public static final int SIZE = 8;
    private static final double MUT_RATE = .5;
    private static final int MAX = 10;
    public static final int ELITE = 1;
    public static final int TOURNAMENT = 4;
    public final double LEN;

    public GeneticAlgorithm(double length){
        this.LEN = length;
    }

    private Population crossOverPopulation(Population population){
        Population crossOverPopulation = new Population(population.getChromosomes().length);
        for(int i=0;i<ELITE;i++){
            crossOverPopulation.getChromosomes()[i] = population.getChromosomes()[i];
        }
        for(int i=ELITE;i<population.getChromosomes().length;i++){
            Chromosome ch1 = selectTournament(population).getChromosomes()[0];
            Chromosome ch2 = selectTournament(population).getChromosomes()[0];
            crossOverPopulation.getChromosomes()[i] = crossover(ch1, ch2);
        }
        return crossOverPopulation;
    }

    private Population mutatePopulation(Population population){
        Population mutate = new Population(population.getChromosomes().length);
        for(int i=0;i<ELITE;i++){
            mutate.getChromosomes()[i] = population.getChromosomes()[i];
        }
        for(int i=ELITE;i<population.getChromosomes().length;i++){
            mutate.getChromosomes()[i] = mutateChromosome(population.getChromosomes()[i]);
        }
        return mutate;
    }

    public Population evolve(Population population){
        return mutatePopulation(crossOverPopulation(population));
    }

    private Chromosome crossover(Chromosome chromosome1, Chromosome chromosome2){
        Chromosome crossoverchromosome = new Chromosome(5, LEN);
        for(int i=0;i<chromosome1.getGenes().length;i++){
            if(Math.random() < 0.5){
                crossoverchromosome.getGenes()[i] = chromosome1.getGenes()[i];
            } else {
                crossoverchromosome.getGenes()[i] = chromosome2.getGenes()[i];
            }
        }
        return crossoverchromosome;
    }

    private Population selectTournament(Population population){
        Population tournamentPop = new Population(TOURNAMENT);
        for(int i=0;i<TOURNAMENT;i++){
            tournamentPop.getChromosomes()[i] = population.getChromosomes()[(int)(Math.random()*population.getChromosomes().length)];
        }
        tournamentPop.sortChromosomesByFitness();
        return tournamentPop;
    }

    private Chromosome mutateChromosome(Chromosome chromosome){
        Random rand = new Random();
        Chromosome mutate = new Chromosome(5, LEN);
        for(int i=0;i<chromosome.getGenes().length;i++){
            if(Math.random() < MUT_RATE){
                //mutate.getGenes()[i] = rand.nextInt(MAX - 0 + 1);
                if(Math.random() > .5){
                    mutate.getGenes()[i] = chromosome.getGenes()[i]+1;
                    System.out.println();
                } else {
                    if(mutate.getGenes()[i] == 0){

                    } else {
                        mutate.getGenes()[i] = chromosome.getGenes()[i] - 1;
                    }
                }
            } else {
                mutate.getGenes()[i] = chromosome.getGenes()[i];
            }
        }
        return mutate;
    }
}
