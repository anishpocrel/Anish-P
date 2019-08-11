/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;



/**
 *
 * @author acer
 */
public class AlgorithmThread implements Runnable {

    public Thread t;
    
    AlgorithmCallme target;

    public AlgorithmThread(int populationSize, int maxGeneration, double mutationRate, double crossoverRate, int eliticsmCount, int tournamentSize,String analysisParameter) {
        
        this.target = new AlgorithmCallme(populationSize, maxGeneration, mutationRate, crossoverRate, eliticsmCount, tournamentSize, analysisParameter);
        
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        target.call();
    }



}
