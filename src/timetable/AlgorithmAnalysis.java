/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author acer
 */
public class AlgorithmAnalysis extends javax.swing.JDialog {

    /**
     * Creates new form AlgorithmAnalysis
     */
    ArrayList<Output> populationSizeop;
    ArrayList<Output> generationOp;
    ArrayList<Output> crossoverop;
    ArrayList<Output> mutationop;

    public AlgorithmAnalysis(ArrayList<Output> populationSizeop,ArrayList<Output> generationOp,ArrayList<Output> crossoverop,ArrayList<Output> mutationop) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.populationSizeop = null;
        
        this.populationSizeop = populationSizeop;
        this.generationOp = generationOp;
        this.crossoverop = crossoverop;
        this.mutationop = mutationop;

        pnlPopulationSize.removeAll();
        pnlPopulationSize.repaint();
        pnlPopulationSize.revalidate();
        pnlPopulationSize.setLayout(new GridLayout(5, 1));

        JPanel pnl = null;
        JLabel lbl = null;
        for (Output op : this.populationSizeop) {
            pnl = new JPanel(new BorderLayout(200, 10));
            pnl.removeAll();
            pnl.repaint();
            pnl.revalidate();
            lbl = new JLabel("Population size = " + op.populationSize + ", time taken = " + op.timeTaken + " Miliseconds");
            lbl.setFont(new Font("Arial Black", Font.PLAIN, 30));
            pnl.add(lbl, BorderLayout.NORTH);
            pnl.repaint();
            pnl.revalidate();
            JFreeChart lineChart = ChartFactory.createLineChart(
                    "Population size Analysis",
                    "Fitness", "Generation",
                    createDataset(op),
                    PlotOrientation.VERTICAL,
                    true, true, false);

            ChartPanel chartPanel = new ChartPanel(lineChart);
            chartPanel.setPreferredSize(new java.awt.Dimension(1300, 800));
            pnl.add(chartPanel, BorderLayout.CENTER);

            String[] columnNames = {"Generation", "Fitness"};
            ArrayList<String> generations = new ArrayList<>();
            ArrayList<String> fn = new ArrayList<>();
            int i = 0;
            double prevFitness = -1.0;
            int prevGeneration = -1;
            for (double fitness : op.getGenerationFitness()) {
                if (prevFitness == -1.0) {
                    prevFitness = fitness;
                    prevGeneration = i + 1;
                } else {
                    if (fitness != prevFitness) {
                        if (prevGeneration == i) {
                            generations.add(i + "");
                        } else {
                            generations.add(prevGeneration + "-" + (i));
                        }
                        fn.add(prevFitness + "");
                        prevGeneration = i + 1;
                        prevFitness = fitness;
                    }
                }
                i = i + 1;

            }
            
            if (prevGeneration!=i) {
                generations.add(prevGeneration + "-" + (i));
                fn.add(prevFitness + "");
            } else {
                generations.add(i + "");
                fn.add(prevFitness + "");
            }

            String[][] data = new String[fn.size()][2];

            for (i = 0; i < fn.size(); i++) {
                data[i][0] = generations.get(i);
                data[i][1] = fn.get(i);
                System.out.println(i);
            }
            JTable tbl = new JTable(data, new String[]{"Generation", "Fitness"});

            JScrollPane scrollPane = new JScrollPane(tbl);
            scrollPane.setSize(500, 500);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setBorder(BorderFactory.createTitledBorder("Fitness Growth"));
            pnl.add(scrollPane, BorderLayout.SOUTH);

            pnl.repaint();
            pnl.revalidate();

            pnlPopulationSize.add(pnl);

        }
        pnlPopulationSize.repaint();
        pnlPopulationSize.revalidate();
        
        //generation
        pnlGeneration.removeAll();
        pnlGeneration.repaint();
        pnlGeneration.revalidate();
        pnlGeneration.setLayout(new GridLayout(5, 1));

        
        for (Output op : this.generationOp) {
            pnl = new JPanel(new BorderLayout(200, 10));
            pnl.removeAll();
            pnl.repaint();
            pnl.revalidate();
            lbl = new JLabel("Maximum Generation = " + op.maxGeneration + ", time taken = " + op.timeTaken + " Miliseconds");
            lbl.setFont(new Font("Arial Black", Font.PLAIN, 30));
            pnl.add(lbl, BorderLayout.NORTH);
            pnl.repaint();
            pnl.revalidate();
            JFreeChart lineChart = ChartFactory.createLineChart(
                    "Generation Analysis",
                    "Fitness", "Generation",
                    createDataset(op),
                    PlotOrientation.VERTICAL,
                    true, true, false);

            ChartPanel chartPanel = new ChartPanel(lineChart);
            chartPanel.setPreferredSize(new java.awt.Dimension(1300, 800));
            pnl.add(chartPanel, BorderLayout.CENTER);

            String[] columnNames = {"Generation", "Fitness"};
            ArrayList<String> generations = new ArrayList<>();
            ArrayList<String> fn = new ArrayList<>();
            int i = 0;
            double prevFitness = -1.0;
            int prevGeneration = -1;
            for (double fitness : op.getGenerationFitness()) {
                if (prevFitness == -1.0) {
                    prevFitness = fitness;
                    prevGeneration = i + 1;
                } else {
                    if (fitness != prevFitness) {
                        if (prevGeneration == i) {
                            generations.add(i + "");
                        } else {
                            generations.add(prevGeneration + "-" + (i));
                        }
                        fn.add(prevFitness + "");
                        prevGeneration = i + 1;
                        prevFitness = fitness;
                    }
                }
                i = i + 1;

            }
            
            if (prevGeneration!=i) {
                generations.add(prevGeneration + "-" + (i));
                fn.add(prevFitness + "");
            } else {
                generations.add(i + "");
                fn.add(prevFitness + "");
            }

            String[][] data = new String[fn.size()][2];

            for (i = 0; i < fn.size(); i++) {
                data[i][0] = generations.get(i);
                data[i][1] = fn.get(i);
                System.out.println(i);
            }
            JTable tbl = new JTable(data, new String[]{"Generation", "Fitness"});

            JScrollPane scrollPane = new JScrollPane(tbl);
            scrollPane.setSize(500, 500);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setBorder(BorderFactory.createTitledBorder("Fitness Growth"));
            pnl.add(scrollPane, BorderLayout.SOUTH);

            pnl.repaint();
            pnl.revalidate();

            pnlGeneration.add(pnl);

        }
        pnlGeneration.repaint();
        pnlGeneration.revalidate();
        
        //pnl crossoverrate
        pnlCrossover.removeAll();
        pnlCrossover.repaint();
        pnlCrossover.revalidate();
        pnlCrossover.setLayout(new GridLayout(5, 1));

        
        for (Output op : this.crossoverop) {
            pnl = new JPanel(new BorderLayout(200, 10));
            pnl.removeAll();
            pnl.repaint();
            pnl.revalidate();
            lbl = new JLabel("Crossover rate = " + op.crossoverRate + ", time taken = " + op.timeTaken + " Miliseconds");
            lbl.setFont(new Font("Arial Black", Font.PLAIN, 30));
            pnl.add(lbl, BorderLayout.NORTH);
            pnl.repaint();
            pnl.revalidate();
            JFreeChart lineChart = ChartFactory.createLineChart(
                    "Crossover rate Analysis",
                    "Fitness", "Generation",
                    createDataset(op),
                    PlotOrientation.VERTICAL,
                    true, true, false);

            ChartPanel chartPanel = new ChartPanel(lineChart);
            chartPanel.setPreferredSize(new java.awt.Dimension(1300, 800));
            pnl.add(chartPanel, BorderLayout.CENTER);

            String[] columnNames = {"Generation", "Fitness"};
            ArrayList<String> generations = new ArrayList<>();
            ArrayList<String> fn = new ArrayList<>();
            int i = 0;
            double prevFitness = -1.0;
            int prevGeneration = -1;
            for (double fitness : op.getGenerationFitness()) {
                if (prevFitness == -1.0) {
                    prevFitness = fitness;
                    prevGeneration = i + 1;
                } else {
                    if (fitness != prevFitness) {
                        if (prevGeneration == i) {
                            generations.add(i + "");
                        } else {
                            generations.add(prevGeneration + "-" + (i));
                        }
                        fn.add(prevFitness + "");
                        prevGeneration = i + 1;
                        prevFitness = fitness;
                    }
                }
                i = i + 1;

            }
            
            if (prevGeneration!=i) {
                generations.add(prevGeneration + "-" + (i));
                fn.add(prevFitness + "");
            } else {
                generations.add(i + "");
                fn.add(prevFitness + "");
            }

            String[][] data = new String[fn.size()][2];

            for (i = 0; i < fn.size(); i++) {
                data[i][0] = generations.get(i);
                data[i][1] = fn.get(i);
                System.out.println(i);
            }
            JTable tbl = new JTable(data, new String[]{"Generation", "Fitness"});

            JScrollPane scrollPane = new JScrollPane(tbl);
            scrollPane.setSize(500, 500);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setBorder(BorderFactory.createTitledBorder("Fitness Growth"));
            pnl.add(scrollPane, BorderLayout.SOUTH);

            pnl.repaint();
            pnl.revalidate();

            pnlCrossover.add(pnl);

        }
        pnlCrossover.repaint();
        pnlCrossover.revalidate();
        
        
        //pnl crossoverrate
        pnlMutation.removeAll();
        pnlMutation.repaint();
        pnlMutation.revalidate();
        pnlMutation.setLayout(new GridLayout(5, 1));

        
        for (Output op : this.mutationop) {
            pnl = new JPanel(new BorderLayout(200, 10));
            pnl.removeAll();
            pnl.repaint();
            pnl.revalidate();
            lbl = new JLabel("Mutation rate = " + op.mutationRate + ", time taken = " + op.timeTaken + " Miliseconds");
            lbl.setFont(new Font("Arial Black", Font.PLAIN, 30));
            pnl.add(lbl, BorderLayout.NORTH);
            pnl.repaint();
            pnl.revalidate();
            JFreeChart lineChart = ChartFactory.createLineChart(
                    "Mutation rate Analysis",
                    "Fitness", "Generation",
                    createDataset(op),
                    PlotOrientation.VERTICAL,
                    true, true, false);

            ChartPanel chartPanel = new ChartPanel(lineChart);
            chartPanel.setPreferredSize(new java.awt.Dimension(1300, 800));
            pnl.add(chartPanel, BorderLayout.CENTER);

            String[] columnNames = {"Generation", "Fitness"};
            ArrayList<String> generations = new ArrayList<>();
            ArrayList<String> fn = new ArrayList<>();
            int i = 0;
            double prevFitness = -1.0;
            int prevGeneration = -1;
            for (double fitness : op.getGenerationFitness()) {
                if (prevFitness == -1.0) {
                    prevFitness = fitness;
                    prevGeneration = i + 1;
                } else {
                    if (fitness != prevFitness) {
                        if (prevGeneration == i) {
                            generations.add(i + "");
                        } else {
                            generations.add(prevGeneration + "-" + (i));
                        }
                        fn.add(prevFitness + "");
                        prevGeneration = i + 1;
                        prevFitness = fitness;
                    }
                }
                i = i + 1;

            }
            
            if (prevGeneration!=i) {
                generations.add(prevGeneration + "-" + (i));
                fn.add(prevFitness + "");
            } else {
                generations.add(i + "");
                fn.add(prevFitness + "");
            }

            String[][] data = new String[fn.size()][2];

            for (i = 0; i < fn.size(); i++) {
                data[i][0] = generations.get(i);
                data[i][1] = fn.get(i);
                System.out.println(i);
            }
            JTable tbl = new JTable(data, new String[]{"Generation", "Fitness"});

            JScrollPane scrollPane = new JScrollPane(tbl);
            scrollPane.setSize(500, 500);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setBorder(BorderFactory.createTitledBorder("Fitness Growth"));
            pnl.add(scrollPane, BorderLayout.SOUTH);

            pnl.repaint();
            pnl.revalidate();

            pnlMutation.add(pnl);

        }
        pnlMutation.repaint();
        pnlMutation.revalidate();
        
        
        

    }

    private DefaultCategoryDataset createDataset(Output op) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int i = 0;
        for (double fitness : op.getGenerationFitness()) {
            dataset.addValue(i, "Fitness A/C to Generation", String.format("%.2f", fitness));
            ++i;
        }

        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        SPPopulationSize = new javax.swing.JScrollPane();
        pnlPopulationSize = new javax.swing.JPanel();
        SPGeneration = new javax.swing.JScrollPane();
        pnlGeneration = new javax.swing.JPanel();
        SPCrossover = new javax.swing.JScrollPane();
        pnlCrossover = new javax.swing.JPanel();
        SPMuation = new javax.swing.JScrollPane();
        pnlMutation = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1600, 1000));
        setMinimumSize(new java.awt.Dimension(1600, 1000));
        setPreferredSize(new java.awt.Dimension(1600, 1000));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/logo.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Algorithm-Analysis");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPopulationSizeLayout = new javax.swing.GroupLayout(pnlPopulationSize);
        pnlPopulationSize.setLayout(pnlPopulationSizeLayout);
        pnlPopulationSizeLayout.setHorizontalGroup(
            pnlPopulationSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1593, Short.MAX_VALUE)
        );
        pnlPopulationSizeLayout.setVerticalGroup(
            pnlPopulationSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
        );

        SPPopulationSize.setViewportView(pnlPopulationSize);

        jTabbedPane1.addTab("Population Size", SPPopulationSize);

        javax.swing.GroupLayout pnlGenerationLayout = new javax.swing.GroupLayout(pnlGeneration);
        pnlGeneration.setLayout(pnlGenerationLayout);
        pnlGenerationLayout.setHorizontalGroup(
            pnlGenerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1593, Short.MAX_VALUE)
        );
        pnlGenerationLayout.setVerticalGroup(
            pnlGenerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
        );

        SPGeneration.setViewportView(pnlGeneration);

        jTabbedPane1.addTab("Generations", SPGeneration);

        javax.swing.GroupLayout pnlCrossoverLayout = new javax.swing.GroupLayout(pnlCrossover);
        pnlCrossover.setLayout(pnlCrossoverLayout);
        pnlCrossoverLayout.setHorizontalGroup(
            pnlCrossoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1593, Short.MAX_VALUE)
        );
        pnlCrossoverLayout.setVerticalGroup(
            pnlCrossoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
        );

        SPCrossover.setViewportView(pnlCrossover);

        jTabbedPane1.addTab("Crossover Rate", SPCrossover);

        javax.swing.GroupLayout pnlMutationLayout = new javax.swing.GroupLayout(pnlMutation);
        pnlMutation.setLayout(pnlMutationLayout);
        pnlMutationLayout.setHorizontalGroup(
            pnlMutationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1593, Short.MAX_VALUE)
        );
        pnlMutationLayout.setVerticalGroup(
            pnlMutationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
        );

        SPMuation.setViewportView(pnlMutation);

        jTabbedPane1.addTab("Mutation Rate", SPMuation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AlgorithmAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AlgorithmAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AlgorithmAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AlgorithmAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AlgorithmAnalysis().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SPCrossover;
    private javax.swing.JScrollPane SPGeneration;
    private javax.swing.JScrollPane SPMuation;
    private javax.swing.JScrollPane SPPopulationSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlCrossover;
    private javax.swing.JPanel pnlGeneration;
    private javax.swing.JPanel pnlMutation;
    private javax.swing.JPanel pnlPopulationSize;
    // End of variables declaration//GEN-END:variables
}
