/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import algorithm.GeneticAlgorithm;
import algorithm.Population;
import algorithm.Timetable;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class AlgorithmCallme {

    public Thread t;
    long timeTaken;
    int populationSize;
    int maxGeneration;
    double mutationRate;
    double crossoverRate;
    int eliticsmCount;
    int tournamentSize;
    Output o;
    String analysisParameter;

    public AlgorithmCallme(int populationSize, int maxGeneration, double mutationRate, double crossoverRate, int eliticsmCount, int tournamentSize, String analysisParameter) {
        this.populationSize = populationSize;
        this.maxGeneration = maxGeneration;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.eliticsmCount = eliticsmCount;
        this.tournamentSize = tournamentSize;
        this.analysisParameter = analysisParameter;
    }

    public void call() {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        Timetable timetable = Dashboard.initialTimetable;
        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize, mutationRate, crossoverRate, eliticsmCount, tournamentSize);
        Population population = ga.initPopulation(timetable);
        ga.evalPopulation(population, timetable);
        ArrayList<Double> fitness = new ArrayList<>();
        fitness.add(population.getFittest(0).getFitness());
        int generation = 1;
        while (generation <= maxGeneration && ga.isTerminationConditionMet(population) == false) {
            population = ga.crossoverPopulation(population);
            population = ga.mutatePopulation(population, timetable);
            ga.evalPopulation(population, timetable);
            fitness.add(population.getFittest(0).getFitness());
            System.out.println(generation);
            generation++;
        }
        endTime = System.currentTimeMillis();

        Output op = new Output(fitness, endTime - startTime, populationSize, generation, mutationRate,
                crossoverRate, eliticsmCount, tournamentSize);
        if (this.analysisParameter.equals("populationsize")) {
            Dashboard.populationSizeop.add(op);
        } else if (this.analysisParameter.equals("generation")) {
            Dashboard.generationop.add(op);
        }
    }
}
