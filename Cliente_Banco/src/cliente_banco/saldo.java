package cliente_banco;


/**
 *
 * @author Ivan Luis Jimenez
 */
public class saldo extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    String cliente = "";
    int user = 0;
    public saldo(String saldo,String cliente,int user) {
        initComponents();
        setSize(555, 435);
        this.cliente = cliente;
        this.user = user;
        mensaje.setText("USUARIO:"+this.cliente);
        this.saldo.setText("$"+saldo);
        setLocationRelativeTo(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        saldo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 0, 200, 112);

        saldo.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        saldo.setForeground(new java.awt.Color(255, 0, 0));
        saldo.setText("2588");
        getContentPane().add(saldo);
        saldo.setBounds(180, 220, 220, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/saldo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 190, 250, 90);

        jLabel4.setFont(new java.awt.Font("Euphemia", 1, 18)); // NOI18N
        jLabel4.setText("S U  S A L D O  E S:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 160, 250, 24);

        error.setBackground(new java.awt.Color(255, 255, 255));
        error.setFont(new java.awt.Font("Euphemia", 1, 18)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(error);
        error.setBounds(20, 350, 520, 0);

        aceptar.setBackground(new java.awt.Color(102, 255, 102));
        aceptar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        aceptar.setText("ACEPTAR");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar);
        aceptar.setBounds(200, 290, 170, 50);

        mensaje.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        getContentPane().add(mensaje);
        mensaje.setBounds(20, 350, 270, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
       
        this.setVisible(false);
        Principal2 on = new Principal2(cliente,user);
        on.setVisible(true);
    }//GEN-LAST:event_aceptarActionPerformed

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
            java.util.logging.Logger.getLogger(saldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(saldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(saldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(saldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel mensaje;
    private javax.swing.JLabel saldo;
    // End of variables declaration//GEN-END:variables
}
