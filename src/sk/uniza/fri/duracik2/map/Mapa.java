/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.duracik2.map;

import java.awt.Color;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import sk.uniza.fri.duracik2.FileParser;
import sk.uniza.fri.duracik2.entity.Okres;
import sk.uniza.fri.duracik2.entity.Uzol;

/**
 *
 * @author Unlink
 */
public class Mapa extends javax.swing.JDialog {

	/**
	 * Creates new form Mapa
	 * @param fp
	 */
	public Mapa(JFrame parent, FileParser fp) {
		super(parent, "Mapa SR", true);
		initComponents();
		Set<Okres> okrs = new HashSet<>(fp.nahrajOkresy().values());
		/*Set<Okres> okrs = new HashSet<>(fp.najdiOkresy("Žilina, Bytča"));
		LinkedList<Zvyraznenie> zmesta = new LinkedList<>();
		zmesta.add(new Zvyraznenie(fp.najdiUzol("Žilina"), Color.RED));
		for (Uzol x : fp.najdiUzly(fp.najdiOkresy("Žilina"), false)) {
			zmesta.getLast().pridajUzol(x);
		}
		zmesta.add(new Zvyraznenie(fp.najdiUzol("Bytča"), Color.YELLOW));
		for (Uzol x : fp.najdiUzly(fp.najdiOkresy("Bytča"), false)) {
			zmesta.getLast().pridajUzol(x);
		}*/
		mapaCanvas21.vykresli(okrs, fp.najdiUzly(okrs), fp.najdiHrany(fp.najdiUzly(okrs)));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mapaCanvas21 = new sk.uniza.fri.duracik2.map.MapaCanvas2();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mapaCanvas21.setPreferredSize(new java.awt.Dimension(900, 600));
        jScrollPane1.setViewportView(mapaCanvas21);

        jButton2.setText("Uloz Obrazok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new FileNameExtensionFilter("Png Files", "png"));
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			mapaCanvas21.saveToImage(jfc.getSelectedFile());
		}
		
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private sk.uniza.fri.duracik2.map.MapaCanvas2 mapaCanvas21;
    // End of variables declaration//GEN-END:variables
}
