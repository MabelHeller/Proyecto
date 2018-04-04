package gui;

import domain.Media;
import domain.Loan;
import file.AudiovisualFile;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Heller
 */
public class AudiovisualCode extends javax.swing.JFrame {

    private String idStudent;
    private String idAudiovisual;
    private String nameAudiovisual;
    private String nameStudent;
    DateFormat df = DateFormat.getDateInstance();
    private Calendar unaFecha = Calendar.getInstance();

    /**
     * Creates new form AudiovisualCode
     */
    //constructores
    public AudiovisualCode(String student, String nameS) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Assets/fondoTres.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        nameStudent = nameS;
        idStudent = student;
        this.setBackground(Color.BLACK);

    }

    private AudiovisualCode() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Area", "Brand", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Request");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  Inserted Date");
        jLabel2.setOpaque(true);

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  Code or Name the Media");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//metodo que busca en el archivo audiovisual el equipo por medio de la primera letra o el codigo
    //si si esta el equipo guardado se mostrara en una tabla 
    public void check() throws IOException {
        File file = new File("Audiovisual.dat");
        Media audiovisual = new Media();
        AudiovisualFile audiovisualF = new AudiovisualFile(file);
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setNumRows(0);
        for (int i = 0; i < audiovisualF.getAllAudiovisual().size(); i++) {
            String firstLetter = this.jTextField1.getText().toLowerCase();
            String firstName = audiovisualF.getAllAudiovisual().get(i).getName().toLowerCase();
            char firstL = firstLetter.charAt(0);
            char firstN = firstName.charAt(0);
            if (audiovisualF.getAllAudiovisual().get(i).getCode().equalsIgnoreCase(this.jTextField1.getText()) || firstL == firstN) {
                audiovisual = audiovisualF.getAllAudiovisual().get(i);
                if (audiovisualF.getAllAudiovisual() != null) {
                    Object[] e = new Object[5];
                    e[0] = audiovisualF.getAllAudiovisual().get(i).getCode();
                    idAudiovisual = audiovisualF.getAllAudiovisual().get(i).getCode();
                    e[1] = audiovisualF.getAllAudiovisual().get(i).getName();
                    nameAudiovisual = audiovisualF.getAllAudiovisual().get(i).getName();
                    e[2] = audiovisualF.getAllAudiovisual().get(i).getArea();
                    e[3] = audiovisualF.getAllAudiovisual().get(i).getBrand();
                    e[4] = audiovisualF.getAllAudiovisual().get(i).getQuantity();
                    dtm.addRow(e);
                }//if
                
            }//for
            
        }
        jTable1.setModel(dtm);
    }//check()

    //metodo en el que guarda el prestamo, se guarda la fecha en la que se realizo el prestamo y con base a esta 
    //se genera otra fecha que corresponde al dia de devolución
    public boolean Request() {
        try {
            String date = df.format(jDateChooser1.getDate());
            File file = new File("Audiovisual.dat");
            Media audiovisualS = new Media();
            AudiovisualFile audiovisual = new AudiovisualFile(file);
            System.out.println(date);
            Random aleatorio = new Random();
            String[] parts = date.split("/");///divide la fecha para guardarla en un vector
            String part1 = parts[0];
            String part2 = parts[1];
            String part3 = parts[2];
            jDateChooser1.getDate();//fecha que seleccione
            unaFecha.add(Calendar.DAY_OF_MONTH, +3);// agrega una fecha con el calendario de java
            unaFecha.set(Integer.parseInt(part3), Integer.parseInt(part2), Integer.parseInt(part1));//se guarda en la fecha la fecha que se ingreso
            Date dateDevolution = unaFecha.getTime();// genera la fecha de devolucion con base a la anterior
            Loan loans = new Loan(idAudiovisual, idStudent, date, dateDevolution, nameStudent, nameAudiovisual);
            if (loans.saveLoansA(loans)) {
                for (int i = 0; i < audiovisual.getAllAudiovisual().size(); i++) {
                    if (audiovisual.getAllAudiovisual().get(i).getCode().equalsIgnoreCase(idAudiovisual) && audiovisual.getAllAudiovisual().get(i).getQuantity() > 0) {
                        String code = audiovisual.getAllAudiovisual().get(i).getCode();
                        int quantity = audiovisual.getAllAudiovisual().get(i).getQuantity() - 1;//disminuye en uno ya que se presto un equipo
                        String name = audiovisual.getAllAudiovisual().get(i).getName();
                        String area = audiovisual.getAllAudiovisual().get(i).getArea();
                        String brand = audiovisual.getAllAudiovisual().get(i).getBrand();
                        audiovisual.deletedAudiovisual(code);
                        audiovisualS.deletedAudiovisual(name);
                        audiovisualS = new Media(code, name, area, brand, quantity);
                        audiovisualS.saveAudiovisual(audiovisualS);
                        audiovisual.addEndRecord(audiovisualS);// lo anterior actualizo el archivo para que aparezca la modificacion de la cantidad
                        JOptionPane.showMessageDialog(null, "Your loan was successful, return:" + dateDevolution);
                        return true;
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(BookCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Unsuccessful loan");
        return false;
    }


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Request();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        LoansJFrame studentF = new LoansJFrame();
        studentF.setVisible(true);       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            check();
//        try {
//            if (check()) {
//                JOptionPane.showMessageDialog(null, "Found");
//            } else {
//                JOptionPane.showMessageDialog(null, "Not found");
//            }//if
//        } catch (IOException ex) {
//            Logger.getLogger(BookCode.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (IOException ex) {
            Logger.getLogger(AudiovisualCode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AudiovisualCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AudiovisualCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AudiovisualCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AudiovisualCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AudiovisualCode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
