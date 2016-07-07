/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.GUI.movimentacao.fluxoRetirada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author demetrius
 */
public class NovaRetirada extends javax.swing.JFrame {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    LocalDate dataPrevistaDevolucao = LocalDate.now().plusDays(7);
    
    /**
     * Creates new form NovaRetirada
     */
    public NovaRetirada() {
        initComponents();
        labelDataRetirada.setText(LocalDate.now().format(dtf));
        labelDevPrev.setText(dataPrevistaDevolucao.format(dtf));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloJanela = new javax.swing.JLabel();
        painelCliente = new javax.swing.JPanel();
        btnSelecionarCliente = new javax.swing.JButton();
        labelClienteContainer = new javax.swing.JPanel();
        labelCliente = new javax.swing.JLabel();
        painelLivros = new javax.swing.JPanel();
        tabelaLivrosContainer = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        painelLivrosControles = new javax.swing.JPanel();
        btnSelecionarLivros = new javax.swing.JButton();
        labelTxtDataRetirada = new javax.swing.JLabel();
        labelDataRetirada = new javax.swing.JLabel();
        labelTxtDevPrev = new javax.swing.JLabel();
        labelDevPrev = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloJanela.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tituloJanela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tituloJanela.setText("Nova Retirada");

        painelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));

        btnSelecionarCliente.setText("Selecionar");

        labelClienteContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        labelCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout labelClienteContainerLayout = new javax.swing.GroupLayout(labelClienteContainer);
        labelClienteContainer.setLayout(labelClienteContainerLayout);
        labelClienteContainerLayout.setHorizontalGroup(
            labelClienteContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelClienteContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
        );
        labelClienteContainerLayout.setVerticalGroup(
            labelClienteContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelClienteLayout = new javax.swing.GroupLayout(painelCliente);
        painelCliente.setLayout(painelClienteLayout);
        painelClienteLayout.setHorizontalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(labelClienteContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelecionarCliente)
                .addGap(14, 14, 14))
        );
        painelClienteLayout.setVerticalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSelecionarCliente)
                    .addComponent(labelClienteContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        painelLivros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Livros", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));

        tabelaLivrosContainer.setBorder(null);

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaLivrosContainer.setViewportView(tabelaLivros);

        btnSelecionarLivros.setText("jButton1");

        javax.swing.GroupLayout painelLivrosControlesLayout = new javax.swing.GroupLayout(painelLivrosControles);
        painelLivrosControles.setLayout(painelLivrosControlesLayout);
        painelLivrosControlesLayout.setHorizontalGroup(
            painelLivrosControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLivrosControlesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSelecionarLivros))
        );
        painelLivrosControlesLayout.setVerticalGroup(
            painelLivrosControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSelecionarLivros)
        );

        javax.swing.GroupLayout painelLivrosLayout = new javax.swing.GroupLayout(painelLivros);
        painelLivros.setLayout(painelLivrosLayout);
        painelLivrosLayout.setHorizontalGroup(
            painelLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelaLivrosContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(painelLivrosControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelLivrosLayout.setVerticalGroup(
            painelLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelaLivrosContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelLivrosControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelTxtDataRetirada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelTxtDataRetirada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTxtDataRetirada.setText("Data de Retirada:");

        labelDataRetirada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDataRetirada.setText(" ");

        labelTxtDevPrev.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelTxtDevPrev.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTxtDevPrev.setText("Devolução Prevista: ");

        labelDevPrev.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDevPrev.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelLivros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTxtDataRetirada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDataRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTxtDevPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDevPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloJanela)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloJanela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataRetirada)
                    .addComponent(labelTxtDataRetirada)
                    .addComponent(labelTxtDevPrev)
                    .addComponent(labelDevPrev))
                .addGap(18, 18, 18)
                .addComponent(painelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NovaRetirada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaRetirada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaRetirada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaRetirada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovaRetirada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionarCliente;
    private javax.swing.JButton btnSelecionarLivros;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JPanel labelClienteContainer;
    private javax.swing.JLabel labelDataRetirada;
    private javax.swing.JLabel labelDevPrev;
    private javax.swing.JLabel labelTxtDataRetirada;
    private javax.swing.JLabel labelTxtDevPrev;
    private javax.swing.JPanel painelCliente;
    private javax.swing.JPanel painelLivros;
    private javax.swing.JPanel painelLivrosControles;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JScrollPane tabelaLivrosContainer;
    private javax.swing.JLabel tituloJanela;
    // End of variables declaration//GEN-END:variables
}
