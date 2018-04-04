package gui;

import domain.Student;
import file.StudentFile;
import file.StudentFile;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Heller
 */
public class InsertStudent extends javax.swing.JFrame {

    Color c = new Color(150, 150, 255);
    private StudentFile studentFile;
    File file = new File("Student.dat");
    int penalty=0;

    //constructores
    public InsertStudent() {
        try {
            initComponents();
            studentFile = new StudentFile(file);
            this.jTextField1.setVisible(false);
            this.jLabel4.setVisible(false);
            setLocationRelativeTo(null);
            setResizable(false);
            ((JPanel) getContentPane()).setOpaque(false);
            ImageIcon uno = new ImageIcon(this.getClass().getResource("/Assets/fondoDos.jpg"));
            JLabel fondo = new JLabel();
            fondo.setIcon(uno);
            getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
            fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

            this.getContentPane().setBackground(c);
            this.setBackground(Color.BLACK);
        } catch (IOException ex) {
            Logger.getLogger(InsertStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("           Career");
        jLabel2.setOpaque(true);

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informatica", "Agronomia", "Educacion" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("       Year of income");
        jLabel3.setOpaque(true);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("            Name");
        jLabel1.setOpaque(true);

        jtfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNameActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("    Your identification is");
        jLabel4.setOpaque(true);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox, 0, 175, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jComboBox2))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //inserta el estudiante generando a la vez un carnet con la informacion ingresada
    public void insertStudent() {
        try {
            List<Student> listStudent = studentFile.getAllStudent();
            if (this.jComboBox.getSelectedItem() == "Informatica") {
                String year = this.jComboBox2.getSelectedItem().toString();//Este String coge el año que se escoje del combo
                String endYear = year.substring(3, 4);//el String anterior sólo coge el último número, por jemplo 2018-> '8'
                ArrayList<Student> listInfo = new ArrayList<>();//Se crea una lista para sólo los informaticos
                for (int i = 0; i < listStudent.size(); i++) {//Ciclo para recorrer si existes informaticos en el archivo
                    if (listStudent.get(i).getId().contains("I")) {//condición de existencia
                        listInfo.add(listStudent.get(i));//se agrega a la lista de informaticos
                    }
                }
                if (listInfo.isEmpty()) {//Si es la primera vez, entonces esa lista va estar vacia, por los tanto será en el primer carnet que está por defecto
                    String fCarnet = "I" + endYear + "100";//carnet creado por defecto, ya que es el primero.
                    Student st = new Student(this.jtfName.getText(), (String) this.jComboBox.getSelectedItem(), this.jComboBox2.getSelectedItem().toString(), fCarnet);
                    //Se inserta de manera normal en el archivo
                    if (this.studentFile.addEndRecord(st)) {
                        JOptionPane.showMessageDialog(null, "The student has been saved successfully");
                        this.jLabel4.setVisible(true);
                        this.jTextField1.setVisible(true);
                        this.jTextField1.setText(fCarnet);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not inserted");
                    }
                } else {
                    //Esta parte es si ya hay al menos un estudiante de informatica
                    ArrayList<String> carnets = new ArrayList<>();//se crea un Array de carnet, porque es lo unico que se ocupa

                    for (int i = 0; i < listStudent.size(); i++) {//recorrecos el ciclo para ingresar todos los carnets existentes
                        if (listStudent.get(i).getId().contains("I")) {
                            carnets.add(listStudent.get(i).getId());// se agregan a lista de carnets
                        }//if
                    }//for
                    String lastID = carnets.get(carnets.size() - 1);// con este String capturamos el último carnet ya que estpy obteniendo la ultima posición de la lista
                    String s2 = lastID.substring(2);//Con este último carnet se va obtener el consecutivo, por ejemplo si el carnet es I8100-> '100'
                    int conts = Integer.parseInt(s2) + 1;//se parsea ese número para poder sumarle uno en ese consecutivo
                    String fCarnet2 = "I" + endYear + conts;//se forma el nuevo carnet

                    Student st = new Student(this.jtfName.getText(), (String) this.jComboBox.getSelectedItem(), this.jComboBox2.getSelectedItem().toString(), fCarnet2);
                    //Se inserta de manera normal
                    if (this.studentFile.addEndRecord(st)) {
                        JOptionPane.showMessageDialog(null, "The student has been saved successfully");
                        this.jLabel4.setVisible(true);
                        this.jTextField1.setVisible(true);
                        this.jTextField1.setText(fCarnet2);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not inserted");
                    }//if (this.studentFile.agregarRegistroAlFinal(st)) 

                }// if (listStudent.isEmpty()) 

            } else if (this.jComboBox.getSelectedItem() == "Agronomia") {
                //Se realixa el mismo procedimiento que se explic´anteriormente
                String year = this.jComboBox2.getSelectedItem().toString();
                String endYear = year.substring(3, 4);
                ArrayList<Student> listAgro = new ArrayList<>();
                for (int i = 0; i < listStudent.size(); i++) {
                    if (listStudent.get(i).getId().contains("A")) {
                        System.err.println("entró");
                        listAgro.add(listStudent.get(i));
                    }
                }
                if (listAgro.isEmpty()) {
                    String fCarnet = "A" + endYear + "100";
                    Student st = new Student(this.jtfName.getText(), (String) this.jComboBox.getSelectedItem(), this.jComboBox2.getSelectedItem().toString(), fCarnet);

                    if (this.studentFile.addEndRecord(st)) {
                        JOptionPane.showMessageDialog(null, "The student has been saved successfully");
                        this.jLabel4.setVisible(true);
                        this.jTextField1.setVisible(true);
                        this.jTextField1.setText(fCarnet);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not inserted");
                    }

                } else {
                    //Se realiza el mismo procedimiento que se explic´anteriormente
                    ArrayList<String> carnets = new ArrayList<>();

                    for (int i = 0; i < listStudent.size(); i++) {

                        if (listStudent.get(i).getId().contains("A")) {
                            carnets.add(listStudent.get(i).getId());
                        }
                    }//for

                    String s = carnets.get(carnets.size() - 1);
                    String s2 = s.substring(2);
                    int conts = Integer.parseInt(s2) + 1;
                    String fCarnet2 = "A" + endYear + conts;
                    Student st = new Student(this.jtfName.getText(), (String) this.jComboBox.getSelectedItem(), this.jComboBox2.getSelectedItem().toString(), fCarnet2);
                    if (this.studentFile.addEndRecord(st)) {
                        JOptionPane.showMessageDialog(null, "The student has been saved successfully");
                        this.jLabel4.setVisible(true);
                        this.jTextField1.setVisible(true);
                        this.jTextField1.setText(fCarnet2);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not inserted");
                    }//if (this.studentFile.agregarRegistroAlFinal(st)) 

                }// if (listStudent.isEmpty()) 
            } else {
                //Se realixa el mismo procedimiento que se explic´anteriormente
                String year = this.jComboBox2.getSelectedItem().toString();
                String endYear = year.substring(3, 4);
                ArrayList<Student> listEdu = new ArrayList<>();
                for (int i = 0; i < listStudent.size(); i++) {
                    if (listStudent.get(i).getId().contains("E")) {
                        listEdu.add(listStudent.get(i));
                    }
                }
                if (listEdu.isEmpty()) {
                    String fCarnet = "E" + endYear + "100";
                    Student st = new Student(this.jtfName.getText(), (String) this.jComboBox.getSelectedItem(), this.jComboBox2.getSelectedItem().toString(), fCarnet);
                    if (this.studentFile.addEndRecord(st)) {
                        JOptionPane.showMessageDialog(null, "The student has been saved successfully");
                        this.jLabel4.setVisible(true);
                        this.jTextField1.setVisible(true);
                        this.jTextField1.setText(fCarnet);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not inserted");
                    }

                } else {
                    //Se realixa el mismo procedimiento que se explic´anteriormente
                    ArrayList<String> carnets = new ArrayList<>();

                    for (int i = 0; i < listStudent.size(); i++) {
                        if (listStudent.get(i).getId().contains("E")) {
                            carnets.add(listStudent.get(i).getId());
                        }
                    }//for

                    String s = carnets.get(carnets.size() - 1);
                    String s2 = s.substring(2);
                    int conts = Integer.parseInt(s2) + 1;
                    String fCarnet2 = "E" + endYear + conts;
                    Student st = new Student(this.jtfName.getText(), (String) this.jComboBox.getSelectedItem(), this.jComboBox2.getSelectedItem().toString(), fCarnet2);
                    if (this.studentFile.addEndRecord(st)) {
                        JOptionPane.showMessageDialog(null, "The student has been saved successfully" );
                        this.jLabel4.setVisible(true);
                        this.jTextField1.setVisible(true);
                        this.jTextField1.setText(fCarnet2);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not inserted");
                    }//if (this.studentFile.agregarRegistroAlFinal(st)) 

                }// if (listStudent.isEmpty()) 

            }
        } catch (IOException ex) {
            Logger.getLogger(InsertStudent.class.getName()).log(Level.SEVERE, null, ex);
        }//catch
    }//insertSudent

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed

    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertStudent();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNameActionPerformed

    }//GEN-LAST:event_jtfNameActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        StudentsF studentF = new StudentsF();
        studentF.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(InsertStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables
}
