
package telas;

import dao.ConexaoBanco;
import dao.EventoDao;
import dao.InscricaoDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Evento;
import modelo.Inscricao;
import modelo.Sessao;
import modelo.Usuario;

public class TelaInscricoes extends javax.swing.JInternalFrame {

    public TelaInscricoes() {
        initComponents();
        CarregarInscricoes();
    }
    
    private void CarregarInscricoes(){
          try{
            // Instancia o dao e chama o método para obter os dados do cardápio
            ConexaoBanco conexx = new ConexaoBanco();// chama a conexao do banco de dados
           InscricaoDao inscricoes = new InscricaoDao (conexx.c);
           Usuario usuario = Sessao.getInstancia().getUsuarioLogado();// conexao com a classe que interage com o banco
           List<Inscricao> InscricaoLista = inscricoes.CarregarInscricoes(usuario.getId()); // chama a o metodo de carregar os dados das bebidas

            // obtem o modelo da tabela e limpa as linhas que estao existentes
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel(); // O jTable pega os dados cadastrados(nesse caso o cardapio)
            modelo.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

            // Adiciona os dados recuperados na tabela
            for (Inscricao be : InscricaoLista) {
                Object[] row = {
                    be.getId(),
                    be.getEven_nome(),
                    be.getEven_data()
                };
                modelo.addRow(row);
            }

          } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar Inscricões: " + e.getMessage());
            e.printStackTrace();
         }
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Data e hora"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Cancelar Inscrição");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
           
        int selectedrow = jTable1.getSelectedRow();
        
        if(selectedrow != -1){
            int id_insc = (int)jTable1.getValueAt(selectedrow, 0);
            ConexaoBanco conexao = new ConexaoBanco(); 
            
            InscricaoDao dao = new InscricaoDao (conexao.c);
            
            boolean excluir = dao.ExcluirInscricao(id_insc);
            
            if(excluir){
               ((DefaultTableModel) jTable1.getModel()).removeRow(selectedrow); //  principalmente ele remove a linha correspondente na tabela
               JOptionPane.showMessageDialog(null, "Inscrição cancelada"); 
            }else{
               JOptionPane.showMessageDialog(null, "Erro ao cancelar Inscrição");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma Inscrição");
        }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cancelar a inscrição " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
