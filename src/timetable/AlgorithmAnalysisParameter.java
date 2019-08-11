/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class AlgorithmAnalysisParameter {
    public static int populationSizeStandard = 50;
    public static double crossoverRateStandard = 0.9;
    public static double mutationRateStandard = 0.01;
    public static int tournamentSizeStandard = 5;
    public static int eliticsmCountStandard = 2;
    public static int maxGenerationStandard = 4000;
    
    public static ArrayList<Integer> populationSizes = new ArrayList<>();
    public static ArrayList<Integer> maxGenerations = new ArrayList<>();
    public static ArrayList<Double> crossoverRates = new ArrayList<>();
    public static ArrayList<Double> mutationRates = new ArrayList<>();
    
    
    public static void loadParameter(){
        populationSizes.add(25);
        populationSizes.add(50);
        populationSizes.add(100);
        populationSizes.add(150);
        populationSizes.add(200);
        
        
        maxGenerations.add(1000);
        maxGenerations.add(4000);
        maxGenerations.add(7000);
        maxGenerations.add(10000);
        maxGenerations.add(15000);
        
        crossoverRates.add(0.5);
        crossoverRates.add(0.6);
        crossoverRates.add(0.7);
        crossoverRates.add(0.8);
        crossoverRates.add(0.9);

        mutationRates.add(0.01);
        mutationRates.add(0.02);
        mutationRates.add(0.03);
        mutationRates.add(0.04);
        mutationRates.add(0.05);
        
        
    }
}
