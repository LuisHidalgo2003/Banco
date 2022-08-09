package cliente_banco;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.apache.xmlrpc.XmlRpcClient;

/**
 *
 * @author Ivan Luis Jimenez
 */
public class retirar extends javax.swing.JFrame {

    static String CAJERO = "4GJB";
    static String ruta_RPC = "http://localhost:81/";
    String cliente = "";
    int user = 0;
    String time = "";
    int year, mes,dia,hora, min, seg;
    Calendar calendario = new GregorianCalendar();
    Vector<String> datos = new Vector<String>();
    Vector<String> datoss = new Vector<String>();
    int sal = 0;
    Principal2 ob = new Principal2(cliente, user);

    public retirar(String cliente, int user) {
        initComponents();
        setSize(555, 435);
        this.cliente = cliente;
        this.user = user;
        mensaje.setText("CLIENTE:" + this.cliente);
        setLocationRelativeTo(this);
    }

    public String obtener_hora() {
        year = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        min = calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND);
        return year+"-"+mes+"-"+dia+"-"+hora + ":" + min + ":" + seg;
    }

    public void retirar(int monto) {
        wr("uno");
        int s = ob.saldo();
        wr(""+monto+"-"+s);
        datos.addElement("" + s);
        datos.addElement("" + monto);
        datos.addElement(obtener_hora());
        datos.addElement(CAJERO);
        datos.addElement("" + user);
        wr("dos");
        if (monto <= s) {
            sal = s - monto;
            datoss.addElement(String.valueOf(sal));
            datoss.addElement("" + obtener_hora());
            datoss.addElement("" + user);
            try {
                wr("tres");
                XmlRpcClient clientee = new XmlRpcClient(ruta_RPC);
                Object result = clientee.execute("ServerRPC.insertar_estado", datos);
                Object resultt = clientee.execute("ServerRPC.insertar_nSaldo", datoss);
                int rr = (int) result;
                int r = (int) resultt;
                wr("cuatro");
                if (r == 1 && rr == 1) {
                    JOptionPane.showMessageDialog(null, "RETIRE SU EFECTIVO");
                    this.setVisible(false);
                    Principal on = new Principal();
                    on.setVisible(true);
                }
            } catch (Exception e) {
            }
        } else {
            error.setText("NO CUENTA CON EL SALDO SUFICIENTE");
        }

        datos.clear();
        datoss.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        mensaje = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 0, 200, 112);

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton4.setText("$ 5,000");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(280, 190, 210, 60);

        jButton6.setBackground(new java.awt.Color(0, 204, 204));
        jButton6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton6.setText("$ 100");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(20, 190, 210, 60);

        cancelar.setBackground(new java.awt.Color(255, 0, 0));
        cancelar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setText("C A N C E L A R");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(280, 260, 210, 60);

        jButton8.setBackground(new java.awt.Color(0, 204, 204));
        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton8.setText("$ 500");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(20, 260, 210, 60);

        mensaje.setText("U S U A R I O: ");
        getContentPane().add(mensaje);
        mensaje.setBounds(30, 340, 180, 14);

        jButton7.setBackground(new java.awt.Color(0, 204, 204));
        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton7.setText("$ 50");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(20, 120, 210, 60);

        jButton5.setBackground(new java.awt.Color(0, 204, 204));
        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton5.setText("$ 1,000");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(280, 120, 210, 60);
        getContentPane().add(error);
        error.setBounds(30, 360, 450, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        retirar(100);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.setVisible(false);
        Principal2 on = new Principal2(cliente, user);
        on.setVisible(true);
    }//GEN-LAST:event_cancelarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        retirar(5000);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        retirar(50);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        retirar(1000);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        retirar(500);
    }//GEN-LAST:event_jButton8ActionPerformed
    
    public void wr(String ms){
        System.out.println(ms);
    }
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
            java.util.logging.Logger.getLogger(retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel error;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mensaje;
    // End of variables declaration//GEN-END:variables
}
