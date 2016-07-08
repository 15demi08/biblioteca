/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.GUI.movimentacao.fluxoRetirada;

import biblioteca.DAO.LivroDAODB;
import biblioteca.modelos.Livro;
import biblioteca.modelos.LivroTableModel;
import biblioteca.utilidades.MSG;
import java.util.ArrayList;

/**
 *
 * @author demetrius
 */
public class MovSelecionaLivros extends javax.swing.JFrame {

    private LivroTableModel ltm = new LivroTableModel();
    private int maxSelecoes;
    private NovaRetirada parent;

    /**
     * Creates new form MovSelecionaCliente
     *
     * @param parent
     * @param maxSelecoes
     */
    public MovSelecionaLivros(NovaRetirada parent, int maxSelecoes) {
        this.parent = parent;
        this.maxSelecoes = maxSelecoes;
        mostraLivros();
        initComponents();
        redimensionaLarguraColunas();
        labelSelecoesDisp.setText(String.valueOf(maxSelecoes));
    }

    public final void mostraLivros() {
        ArrayList<Livro> livros = new LivroDAODB().consultaDisponiveis();
        ltm.setDados(livros);
    }

    public final void mostraLivros(String titulo) {

        ArrayList<Livro> livros = new LivroDAODB().pesquisarPorTitulo(titulo);

        if (livros == null) {
            MSG.show(this, "Nenhum livro encontrado!");
        } else {
            ltm.setDados(livros);
        }

    }

    private void redimensionaLarguraColunas() {
        tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(230);
        tabelaLivros.getColumnModel().getColumn(3).setPreferredWidth(100);
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
        painelDados = new javax.swing.JPanel();
        btnVerTodos = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        painelLista = new javax.swing.JPanel();
        tabelaContainer = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        painelControles = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        labelTxtSelecoesDisp = new javax.swing.JLabel();
        labelSelecoesDisp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarSelecao(evt);
            }
        });

        tituloJanela.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tituloJanela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tituloJanela.setText("Selecionar Livros");

        btnVerTodos.setText("Ver Todos");
        btnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodosLivros(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaLivros(evt);
            }
        });

        labelNome.setText("Título");

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerTodos))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnPesquisar)
                .addComponent(btnVerTodos)
                .addComponent(labelNome))
        );

        tabelaLivros.setModel(ltm);
        tabelaLivros.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tabelaLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selecionarItem(evt);
            }
        });
        tabelaContainer.setViewportView(tabelaLivros);

        javax.swing.GroupLayout painelListaLayout = new javax.swing.GroupLayout(painelLista);
        painelLista.setLayout(painelListaLayout);
        painelListaLayout.setHorizontalGroup(
            painelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelListaLayout.createSequentialGroup()
                .addComponent(tabelaContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelListaLayout.setVerticalGroup(
            painelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabelaContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharJanela(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.setEnabled(false);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarLivros(evt);
            }
        });

        labelTxtSelecoesDisp.setText("Número máximo permitido: ");

        labelSelecoesDisp.setText("0");

        javax.swing.GroupLayout painelControlesLayout = new javax.swing.GroupLayout(painelControles);
        painelControles.setLayout(painelControlesLayout);
        painelControlesLayout.setHorizontalGroup(
            painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelControlesLayout.createSequentialGroup()
                .addComponent(labelTxtSelecoesDisp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSelecoesDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar))
        );
        painelControlesLayout.setVerticalGroup(
            painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControlesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnOK)
                    .addComponent(labelTxtSelecoesDisp)
                    .addComponent(labelSelecoesDisp))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(tituloJanela)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(painelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloJanela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisaLivros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaLivros
        mostraLivros(txtNome.getText());
    }//GEN-LAST:event_pesquisaLivros

    private void verTodosLivros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodosLivros
        mostraLivros();
    }//GEN-LAST:event_verTodosLivros

    private void confirmarLivros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarLivros
        
        ArrayList<Livro> livros = new ArrayList<>();
        
        if( tabelaLivros.getSelectedRowCount() > maxSelecoes ){
            
            MSG.show(this, "Número de livros extrapola o máximo permitido para este cliente: " + maxSelecoes + ".");
            
        } else {
            
            for( int linha : tabelaLivros.getSelectedRows() ){
                livros.add(ltm.getLivro(linha));
            }
            
            parent.receberLivros(livros);
        
            this.dispose();
            
        }

    }//GEN-LAST:event_confirmarLivros

    private void fecharJanela(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharJanela
        this.dispose();
    }//GEN-LAST:event_fecharJanela

    private void selecionarItem(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selecionarItem
        btnOK.setEnabled(true);
    }//GEN-LAST:event_selecionarItem

    private void cancelarSelecao(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarSelecao
        btnOK.setEnabled(false);
        tabelaLivros.clearSelection();
    }//GEN-LAST:event_cancelarSelecao

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSelecoesDisp;
    private javax.swing.JLabel labelTxtSelecoesDisp;
    private javax.swing.JPanel painelControles;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelLista;
    private javax.swing.JScrollPane tabelaContainer;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JLabel tituloJanela;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
