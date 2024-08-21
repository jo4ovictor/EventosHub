package telas;

public class TelaPrincipal extends javax.swing.JFrame {

    
    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Arquivo icone.png"))); // NOI18N
        jMenu1.setText("Arquivo");
        jMenu1.setBorderPainted(false);
        jMenu1.setIconTextGap(-12);
        jMenu1.setPreferredSize(new java.awt.Dimension(90, 30));

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Usuario icone.png"))); // NOI18N
        jMenu2.setText("Usuarios");
        jMenu2.setIconTextGap(-12);
        jMenu2.setPreferredSize(new java.awt.Dimension(90, 30));

        jMenuItem2.setText("Cadastrar");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Alterar");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Excluir");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Pesquisar");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Trabalho Icone.png"))); // NOI18N
        jMenu3.setText("Clientes");
        jMenu3.setIconTextGap(-12);

        jMenuItem6.setText("Cadastrar");
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Alterar");
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Excluir");
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Pesquisar");
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Informação icone.png"))); // NOI18N
        jMenu4.setText("Sobre");
        jMenu4.setToolTipText("<html>\n<head>\n<title>Page Title</title>\n</head>\n<body>\n\n<h1>V 1.6</h1>\n<p>Sistema criado em:  01/08/2024</p>\n<p>Atualido em: 17/08/2024</p>\n</body>\n</html>");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu4.setIconTextGap(-12);
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
