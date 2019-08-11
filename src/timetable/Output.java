/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.ArrayList;


public class Output {
   ArrayList<Double> generationFitness ;
   long timeTaken;
   int populationSize;
   int maxGeneration;
   double mutationRate;
   double crossoverRate;
   int eliticsmCount;
   int tournamentSize;
   

    public Output(ArrayList<Double> generationFitness,int maxGeneration,long timeTaken) {
        this.populationSize = 100;
        this.mutationRate = 0.01;
        this.crossoverRate = 0.9;
        this.eliticsmCount = 2;
        this.tournamentSize = 5;
        this.generationFitness = generationFitness;
        this.maxGeneration = maxGeneration;
        this.timeTaken = timeTaken;
    }

    public Output(ArrayList<Double> generationFitness, long timeTaken, int populationSize, int maxGeneration, double mutationRate, double crossoverRate, int eliticsmCount, int tournamentSize) {
        this.generationFitness = generationFitness;
        this.timeTaken = timeTaken;
        this.populationSize = populationSize;
        this.maxGeneration = maxGeneration;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.eliticsmCount = eliticsmCount;
        this.tournamentSize = tournamentSize;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public ArrayList<Double> getGenerationFitness() {
        return generationFitness;
    }

    public void setGenerationFitness(ArrayList<Double> generationFitness) {
        this.generationFitness = generationFitness;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getMaxGeneration() {
        return maxGeneration;
    }

    public void setMaxGeneration(int maxGeneration) {
        this.maxGeneration = maxGeneration;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    public int getEliticsmCount() {
        return eliticsmCount;
    }

    public void setEliticsmCount(int eliticsmCount) {
        this.eliticsmCount = eliticsmCount;
    }

    public int getTournamentSize() {
        return tournamentSize;
    }

    public void setTournamentSize(int tournamentSize) {
        this.tournamentSize = tournamentSize;
    }
    
   
   
}
