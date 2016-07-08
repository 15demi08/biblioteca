/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.GUI.livro;

import biblioteca.DAO.LivroDAODB;
import biblioteca.modelos.Livro;
import biblioteca.utilidades.MSG;

/**
 * 
 * @author demetrius
 */
public class CadastrarLivro extends javax.swing.JFrame {

    private LivroDAODB db = new LivroDAODB();
    private Livros parent;

    /**
     * Creates new form AlterarCliente
     *
     * @param parent
     */
    public CadastrarLivro(Livros parent) {
        this.parent = parent;
        initComponents();
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
        labelTitulo = new javax.swing.JLabel();
        labelAutores = new javax.swing.JLabel();
        labelEditora = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEditora = new javax.swing.JTextField();
        txtAutores = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        labelISBN = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        labelAno = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tituloJanela.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tituloJanela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tituloJanela.setText("Cadastrar Livro");

        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTitulo.setText("Título");

        labelAutores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAutores.setText("Autor(es)");

        labelEditora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelEditora.setText("Editora");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharJanela(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarLivro(evt);
            }
        });

        labelISBN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelISBN.setText("ISBN");

        labelAno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAno.setText("Ano de Publicação");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelISBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(labelAno, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNome)
                            .addComponent(txtEditora, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloJanela, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAutores)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloJanela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnOK))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Valida os dados do formulário e cadastra o livro na base
     * @param evt 
     */
    private void cadastrarLivro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarLivro

        int ano;

        try {

            // Campos vazios
            if (txtISBN.getText().isEmpty() || txtAutores.getText().isEmpty()
                    || txtEditora.getText().isEmpty() || txtISBN.getText().isEmpty() || txtAno.getText().isEmpty()) {

                MSG.show(this, "Nenhum campo pode ficar vazio!");

            // Validar ISBN
            } else if (db.verificarISBN(txtISBN.getText())) {

                MSG.show(this, "ISBN informado já existe!");

            // Tudo OK
            } else {
                
                // Se txtAno não contiver um valor válido, a excecução deste método
                // é cancelada (catch NumberFormatException)
                ano = Integer.parseInt(txtAno.getText());

                Livro livro = new Livro(
                        txtISBN.getText().trim(),
                        txtNome.getText().trim(),
                        txtAutores.getText().trim(),
                        txtEditora.getText().trim(),
                        ano
                    );

                if (db.inserir(livro) > 0) {

                    MSG.show(this, "Livro cadastrado com sucesso!");
                    parent.atualizarDados();
                    this.dispose();

                } else {

                    MSG.show(this, "Falha no cadstro do livro.");

                }

            }

        } catch (NumberFormatException ex) {
            MSG.show(this, "Ano deve ser um valor numérico!");
        }
    }//GEN-LAST:event_cadastrarLivro

    /**
     * Auto-explicativo
     * @param evt
     */
    private void fecharJanela(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharJanela
        this.dispose();
    }//GEN-LAST:event_fecharJanela

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel labelAno;
    private javax.swing.JLabel labelAutores;
    private javax.swing.JLabel labelEditora;
    private javax.swing.JLabel labelISBN;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel tituloJanela;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAutores;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}