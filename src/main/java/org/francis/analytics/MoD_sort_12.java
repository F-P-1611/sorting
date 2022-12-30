package org.francis.analytics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 23.02.2022
 * @author
 */

public class MoD_sort_12 extends JFrame {
    // Anfang Attribute
  // start attributes
    private JButton bGeneriere = new JButton();
    private JButton bSort = new JButton();
    private JNumberField laengeNF = new JNumberField();
    private JLabel unsortLabel = new JLabel();
    private JLabel sortLabel = new JLabel();

    private JNumberField anzahlVerschiebungen = new JNumberField();
    public int[] unsorted = new int[50];

    private JLabel lAnzahlVergleiche = new JLabel();
    private JLabel lAnzahlVerschiebungen = new JLabel();
    private JNumberField versucheNF = new JNumberField();
    // Ende Attribute

    public JLabel  lLaufzeit = new JLabel();
    public JToggleButton tbnoduplicates1 = new JToggleButton();
    // end attributes
    public MoD_sort_12() {

        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 1245;
        int frameHeight = 500;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Sortieren von Zufallszahlen");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
    // start components

        // Anfang Komponenten

        bGeneriere.setBounds(6, 10, 131, 25);
        bGeneriere.setText("Generiere Zahlen");
        bGeneriere.setMargin(new Insets(2, 2, 2, 2));
        bGeneriere.addActionListener(new ActionListener() {;
            public void actionPerformed(ActionEvent evt) {
                bGeneriere_ActionPerformed(evt);
            }
        });
        cp.add(bGeneriere);
        bSort.setBounds(6, 78, 131, 25);
        bSort.setText("Sortiere");
        bSort.setMargin(new Insets(2, 2, 2, 2));
        bSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bSort_ActionPerformed(evt);
            }
        });
        cp.add(bSort);
        laengeNF.setBounds(144, 10, 41, 25);
        laengeNF.setText("50");
        cp.add(laengeNF);
        unsortLabel.setBounds(14, 43, 1000, 25);
        unsortLabel.setText("");
        cp.add(unsortLabel);
        sortLabel.setBounds(14, 115, 1000, 25);
        sortLabel.setText("");
        cp.add(sortLabel);
        lAnzahlVergleiche.setBounds(310, 72, 117, 33);
        lAnzahlVergleiche.setText("Anzahl Vergleiche");
        cp.add(lAnzahlVergleiche);
        anzahlVerschiebungen.setBounds(800, 72, 117, 33);
        anzahlVerschiebungen.setText("");
        cp.add(anzahlVerschiebungen);
        lAnzahlVerschiebungen.setBounds(650, 72, 150, 33);
        lAnzahlVerschiebungen.setText("Anzahl Verschiebungen");
        cp.add(lAnzahlVerschiebungen);
        lLaufzeit.setBounds(14,150,200,25);
        //lLaufzeit.setText("Laufzeit:");
        //cp.add(lLaufzeit);

        versucheNF.setBounds(425, 72, 65, 33);
        versucheNF.setText("");
        versucheNF.setEditable(false);
        cp.add(versucheNF);
        // Ende Komponenten

        tbnoduplicates1.setBounds(8, 136, 112, 24);
        tbnoduplicates1.setText("no duplicates");
        tbnoduplicates1.setMargin(new Insets(2, 2, 2, 2));
        tbnoduplicates1.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent evt) { 
            //tbnoduplicates1_ActionPerformed(evt);
          }
        });
        cp.add(tbnoduplicates1);
        // end components
            setVisible(true);
        } // end of public MoD_sort

    // Anfang Methoden

  // start methods
    public static void main(String[] args) {
        new MoD_sort_12();
    } // end of main

    private class TempoClass2 {
  // start attributes1
  // end attributes1

  // start methods1
        public  void main(String[] args) {
            final long timeStart = System.nanoTime();
            for (int i = 0; i < 1000000; i++) {
                // nichts machen
            }
            final long timeEnd = System.nanoTime();
            System.out.println("Laufzeit: " + (timeEnd - timeStart) + " Nanosek.");
        }
    // start components1
    // end components1
  public void tbnoduplicates1_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    
  } // end of tbnoduplicates1_ActionPerformed

  // end methods1
    }
  
    private boolean contains(int[] array, int end, int value)  {
        for  (int i = 0;i < end ;i++ ) {
             if ( array[i] == value)
                return true;
        } // end of for   
        
        return false;
    } 
    public void bGeneriere_ActionPerformed(ActionEvent evt) {
        //Generierung und Ausgabe der unsortierten Zufallszahlen (voreingestellte Maximallänge: 80 Zahlen)
        int eingabe = laengeNF.getIntValue();
        int laenge = Math.min(eingabe, 50);
        boolean noDuplicates = this.tbnoduplicates1.isSelected();
    
        
        for (int i = 0;i<50 ;i++ ) {
            unsorted[i] = 0;
        } // end of for

        for (int k = 0;k < laenge ;k++ ) {  
            for (int l = 0;l<100 ; l++ ) {
                int candidate = (int)(Math.random()*100);  
                   
                if(!noDuplicates  || contains(unsorted, k, candidate) == false)      {
                    unsorted[k] = candidate;
                    break;
                }                                      
                System.out.println(String.format("duplicate trying again %s", l+1));
            } // end of for     
        } // end of for

        unsortLabel.setText("" + unsorted[0]);
        for (int j = 1;j < laenge ;j++ ) {
            unsortLabel.setText(unsortLabel.getText() + ";" + unsorted[j]);
        } // end of for

    } // end of bGeneriere_ActionPerformed

    private void printResult(){
        int laenge = laengeNF.getIntValue();
        sortLabel.setText("" + unsorted[0]);
        for (int j = 1;j < laenge ;j++ ) {
            sortLabel.setText(sortLabel.getText() + ";" + unsorted[j]);
        }
    }
    public void bSort_ActionPerformed(ActionEvent evt) {
        // TODO - hier sind Sie gefragt: Sortieren Sie die Zahlen im array unsorted aufsteigend!

        int tempVar = 0;
        int laenge = laengeNF.getIntValue();
        int zaehler = 0;
        int v = 0;
        for (int i = 0; i < laenge-1; i++)
        {
            for(int j = 0; j < laenge-i-1; j++)
            {
                zaehler++;
                if(unsorted[j] > unsorted[j + 1])
                {
                    v++;
                    tempVar = unsorted [j + 1];
                    unsorted [j + 1]= unsorted [j];
                    unsorted [j] = tempVar;

                }
            }
        }

        printResult();

        anzahlVerschiebungen.setText(Integer.toString(v));
        versucheNF.setText(Integer.toString(zaehler));
        System.out.println(unsorted);

    } // end of bSort_ActionPerformed

    // Ende Methoden
  // end methods
} // end of class MoD_sort
