/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import banco.BibliotecarioBanco;
import banco.Conexao;
import interfaces.Dependente;
import interfaces.Parente;
import javax.swing.JOptionPane;
import model.Bibliotecaria;

/**
 *
 * @author Marcelo Moreira
 */
public class Bibliotecario extends javax.swing.JFrame {
    private Parente parent;
    private BibliotecarioBanco cb;
    private String modo;
    private Bibliotecaria bibliotecaria;
    
    public void setBibliotecaria(Bibliotecaria b){
        bibliotecaria = b;
        txtID.setText(String.valueOf(b.getId()));
        txtNome.setText(b.getNome());
        txtCpf.setText(b.getCpf());
        txtEmail.setText(b.getEmail());
        modo = "buscado";
        camposBuscado();
        if(b.getTipo().equals("normal")){
            rbNormal.setSelected(true);
        }else if(b.getTipo().equals("admin")){
            rbAdmin.setSelected(true);
        }
    }
    /**
     * Creates new form CadBibliotecario
     */
    public Bibliotecario() {
        initComponents();
        cb = new BibliotecarioBanco(Conexao.getConexao());
        
    }
    
    public Bibliotecario(Parente parent) {
        this();
        this.parent = parent;
        this.setIconImage(this.parent.getIcone());
        restaurarTela();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupTipo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtSenhaConfirm = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rbAdmin = new javax.swing.JRadioButton();
        rbNormal = new javax.swing.JRadioButton();
        btnNovo = new java.awt.Button();
        btnCancelar = new java.awt.Button();
        btnBuscar = new java.awt.Button();
        btnAtualizar = new java.awt.Button();
        btnConfirmar = new java.awt.Button();
        btnExcluir = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bibliotecário");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome:");

        jLabel2.setText("E-mail:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Senha:");

        jLabel5.setText("Confirme a Senha:");

        txtSenhaConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaConfirmKeyPressed(evt);
            }
        });

        jLabel6.setText("ID:");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 0, 0));
        txtID.setEnabled(false);

        jLabel7.setText("Tipo:");

        groupTipo.add(rbAdmin);
        rbAdmin.setText("Administrador");
        rbAdmin.setEnabled(false);

        groupTipo.add(rbNormal);
        rbNormal.setText("Normal");
        rbNormal.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSenha)
                    .addComponent(txtSenhaConfirm)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(73, 73, 73)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbNormal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbAdmin)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbAdmin)
                    .addComponent(rbNormal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenhaConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.setLabel("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setLabel("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBuscar.setLabel("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAtualizar.setLabel("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnConfirmar.setLabel("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnExcluir.setLabel("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAtualizar, btnBuscar, btnCancelar, btnConfirmar, btnExcluir, btnNovo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAtualizar, btnBuscar, btnCancelar, btnNovo});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        camposNovoCadastro();
        modo = "novo";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setEstadoAtivacao(true);
        restaurarTela();
    }//GEN-LAST:event_formWindowClosing

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Realmente deseja cancelar?", "Cancelar Operação", JOptionPane.YES_NO_OPTION);
        if(a == 0){
            restaurarTela();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtSenhaConfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaConfirmKeyPressed
        if(evt.getKeyCode() == 10){
            realizarAcao();
        }
    }//GEN-LAST:event_txtSenhaConfirmKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        BuscaBibliotecario bb = new BuscaBibliotecario(this);
        setEnabled(false);
        bb.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        realizarAcao();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o bibliotecário?", "Excluir Bibliotecário", JOptionPane.YES_NO_OPTION);
        if(a == 0){
            excluir();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        camposAtualizar();
        modo = "atualizar";
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void excluir(){
        if(Integer.parseInt(txtID.getText()) != ((Bibliotecaria) ((Dependente) parent).getInformacaoDependente()).getId()){
            int id = Integer.parseInt(txtID.getText());
            boolean resul = cb.excluirBibliotecario(id);
            if(resul){
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Exclusão efetuada", JOptionPane.INFORMATION_MESSAGE);
                restaurarTela();
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o bibliotecário!", "Erro na exclusão", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Você não pode se excluir!", "Erro na exclusão", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void atualizar(){
        if(!txtCpf.getText().equals("") && !txtEmail.getText().equals("") && !txtNome.getText().equals("") && (rbNormal.isSelected() || rbAdmin.isSelected())){
            if((!txtSenha.getText().equals("") && !txtSenhaConfirm.getText().equals("")) || (txtSenha.getText().equals("") && txtSenhaConfirm.getText().equals(""))){
                if(txtSenha.getText().equals(txtSenhaConfirm.getText())){
                    boolean resu = cb.atualizarBibliotecario(Integer.parseInt(txtID.getText()), txtNome.getText(), txtCpf.getText(), tipo(), txtEmail.getText(), txtSenha.getText());
                    if(resu){
                        JOptionPane.showMessageDialog(null, "Atualização de dados realizada com sucesso!", "Atualização efetuada", JOptionPane.INFORMATION_MESSAGE);
                        restaurarTela();
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro ao tentar realizar a atualização dos dados!\nO email requisitado pode ja ter sido cadastrado no sistema.", "Atualização não efetuada", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    txtSenha.setText("");
                    txtSenhaConfirm.setText("");
                    JOptionPane.showMessageDialog(null, "As senhas são incompatíveis!", "Senhas incompatíveis", JOptionPane.ERROR_MESSAGE);
                    txtSenha.requestFocus();
                }
            }else if((txtSenha.getText().equals("") && !txtSenhaConfirm.getText().equals("")) || (!txtSenha.getText().equals("") && txtSenhaConfirm.getText().equals(""))){
                
                JOptionPane.showMessageDialog(null, "Os dois campos de senha devem ser preenchidos!", "Campos vazios", JOptionPane.ERROR_MESSAGE);
                txtSenha.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para realizar a atualização, exceto os campos de senha!", "Campos vazios", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void realizarAcao(){
        if(modo.equals("novo")){
            cadastrar();            
        }else if(modo.equals("atualizar")){
            atualizar();
        }
    }
    
    private String tipo(){
        String tipo;
        if(rbAdmin.isSelected()){
            tipo = "admin";
        }else if(rbNormal.isSelected()){
            tipo = "normal";
        }else{
            tipo = null;
        }
        return tipo;
    }
    
    private void cadastrar(){
        if(txtSenha.getPassword().equals(txtSenhaConfirm.getPassword())){
            if(!txtCpf.getText().equals("") && !txtEmail.getText().equals("") && !txtNome.getText().equals("") && (rbNormal.isSelected() || rbAdmin.isSelected())){
                boolean res = cb.cadastrarBibliotecario(txtNome.getText(), txtCpf.getText(), tipo(),txtEmail.getText(), String.valueOf(txtSenha.getPassword()));
                if(res){                    
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Cadastro efetuado", JOptionPane.INFORMATION_MESSAGE);
                    restaurarTela();
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar o cadastro!\nO email requisitado pode ja ter sido cadastrado no sistema.", "Cadastro não efetuado", JOptionPane.ERROR_MESSAGE);
                }
                limparCampos();
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para realizar o cadastro!", "Campos vazios", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            txtSenha.setText("");
            txtSenhaConfirm.setText("");
            txtSenha.requestFocus();
            JOptionPane.showMessageDialog(null, "As senhas são incompatíveis!", "Senhas incompatíveis", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparCampos(){
        txtCpf.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtSenhaConfirm.setText("");
        txtID.setText("");
        groupTipo.clearSelection();
    }
    
    private void camposAtualizar(){
        txtCpf.setEditable(true);
        txtEmail.setEditable(true);
        txtNome.setEditable(true);
        txtSenha.setEditable(true);
        txtSenhaConfirm.setEditable(true);
        rbAdmin.setEnabled(true);
        rbNormal.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnConfirmar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnNovo.setEnabled(false);
        rbNormal.requestFocus();
    }
    
    private void camposBuscado(){
        txtCpf.setEditable(false);
        txtEmail.setEditable(false);
        txtNome.setEditable(false);
        txtSenha.setEditable(false);
        txtSenhaConfirm.setEditable(false);
        rbAdmin.setEnabled(false);
        rbNormal.setEnabled(false);
        btnConfirmar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnBuscar.setEnabled(true);
        
        if(((Bibliotecaria) ((Dependente) parent).getInformacaoDependente()).getTipo().equals("admin")){
            btnNovo.setEnabled(true);
            btnAtualizar.setEnabled(true);
            btnExcluir.setEnabled(true);
        }else{
            btnNovo.setEnabled(false);
            btnAtualizar.setEnabled(false);
            btnExcluir.setEnabled(false);
        }
    }
    
    private void camposNovoCadastro(){
        limparCampos();
        txtCpf.setEditable(true);
        txtEmail.setEditable(true);
        txtNome.setEditable(true);
        txtSenha.setEditable(true);
        txtSenhaConfirm.setEditable(true);
        btnConfirmar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnNovo.setEnabled(false);
        txtNome.requestFocus();
        rbAdmin.setEnabled(true);
        rbNormal.setEnabled(true);
        rbNormal.requestFocus();
                
    }
    
    private void restaurarTela(){
        limparCampos();
        if(((Bibliotecaria) ((Dependente) parent).getInformacaoDependente()).getTipo().equals("admin")){
            btnNovo.setEnabled(true);
        }else{
            btnNovo.setEnabled(false);
        }
        rbNormal.setEnabled(false);
        rbAdmin.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnConfirmar.setEnabled(false);
        btnAtualizar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnExcluir.setEnabled(false);
        txtCpf.setEditable(false);
        txtEmail.setEditable(false);
        txtNome.setEditable(false);
        txtSenha.setEditable(false);
        txtSenhaConfirm.setEditable(false);
        modo = null;
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
            java.util.logging.Logger.getLogger(Bibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bibliotecario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnAtualizar;
    private java.awt.Button btnBuscar;
    private java.awt.Button btnCancelar;
    private java.awt.Button btnConfirmar;
    private java.awt.Button btnExcluir;
    private java.awt.Button btnNovo;
    private javax.swing.ButtonGroup groupTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JRadioButton rbNormal;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaConfirm;
    // End of variables declaration//GEN-END:variables
}
