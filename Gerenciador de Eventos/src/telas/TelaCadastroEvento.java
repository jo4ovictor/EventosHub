package telas;

import dao.ConexaoBanco;
import dao.EventoDao;
import dao.UsuarioDao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Evento;
import modelo.Sessao;
import modelo.Usuario;
import org.json.JSONObject;

public class TelaCadastroEvento extends javax.swing.JInternalFrame {

    private JTextField nomeField;
    private JTextArea descricaoArea;
    private JSpinner dtInicioSpinner;
    private JSpinner dtFimSpinner;
    private JTextField cepField;
    private JTextField bairroField;
    private JTextField ruaField;
    private JTextField numeroField;

    public TelaCadastroEvento() {
        initComponents();
    }

    private void initComponents() {
        // Definindo o título da janela
        setTitle("Cadastro de Eventos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Campo Nome
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nomeLabel, gbc);
        gbc.gridx = 1;
        add(nomeField, gbc);

        // Campo Descrição
        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoArea = new JTextArea(5, 30);
        JScrollPane descricaoScrollPane = new JScrollPane(descricaoArea);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(descricaoLabel, gbc);
        gbc.gridx = 1;
        add(descricaoScrollPane, gbc);
        gbc.anchor = GridBagConstraints.WEST;

        // Campo Data de Início
        JLabel dtInicioLabel = new JLabel("Data Início:");
        dtInicioSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dtInicioEditor = new JSpinner.DateEditor(dtInicioSpinner, "dd/MM/yyyy HH:mm:ss");
        dtInicioSpinner.setEditor(dtInicioEditor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(dtInicioLabel, gbc);
        gbc.gridx = 1;
        add(dtInicioSpinner, gbc);

        // Campo Data de Fim
        JLabel dtFimLabel = new JLabel("Data Fim:");
        dtFimSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dtFimEditor = new JSpinner.DateEditor(dtFimSpinner, "dd/MM/yyyy HH:mm:ss");
        dtFimSpinner.setEditor(dtFimEditor);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(dtFimLabel, gbc);
        gbc.gridx = 1;
        add(dtFimSpinner, gbc);

        // Campo CEP
        JLabel cepLabel = new JLabel("CEP:");
        cepField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(cepLabel, gbc);
        gbc.gridx = 1;
        add(cepField, gbc);
        // Adicionando o evento KeyReleased ao campo CEP
        cepField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                TxtCepKeyReleased(e);
            }
        });

        // Campo Bairro
        JLabel bairroLabel = new JLabel("Bairro:");
        bairroField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(bairroLabel, gbc);
        gbc.gridx = 1;
        add(bairroField, gbc);

        // Campo Rua
        JLabel ruaLabel = new JLabel("Rua:");
        ruaField = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(ruaLabel, gbc);
        gbc.gridx = 1;
        add(ruaField, gbc);

        // Campo Número
        JLabel numeroLabel = new JLabel("Número:");
        numeroField = new JTextField(5);
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(numeroLabel, gbc);
        gbc.gridx = 1;
        add(numeroField, gbc);
       

        // Painel para botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton cancelarButton = new JButton("Cancelar");
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(cancelarButton);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);

        // Adiciona ação ao botão Cancelar
        cancelarButton.addActionListener(e -> dispose());
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar a lógica para salvar os dados do evento
                // Por exemplo, capturar os valores dos campos e salvar no banco de dados
                if(nomeField.getText().equals("") || descricaoArea.getText().equals("") || cepField.getText().equals("") || numeroField.getText().equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Preecha todos os campos.");
                }else{
                    Date dataFim = (Date) dtFimSpinner.getValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String Datafim = dateFormat.format(dataFim);
                    Date dataInicio = (Date) dtInicioSpinner.getValue();
                    SimpleDateFormat dateFormata = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String Datainicio = dateFormata.format(dataInicio);
                    
                    Usuario usuario = Sessao.getInstancia().getUsuarioLogado();
                    
                    Evento novoevento = new Evento(
                            nomeField.getText(),
                            descricaoArea.getText(),
                            Datainicio,
                            Datafim,
                            cepField.getText(),
                            bairroField.getText(),
                            ruaField.getText(),
                            Integer.parseInt(numeroField.getText()),
                            usuario.getId()
                            
                    );
                    ConexaoBanco conexao = new ConexaoBanco();
                    EventoDao novoEvento = new EventoDao(conexao.c);
                    TelaCadastroEvento cadastro = new TelaCadastroEvento();
                    
                        try{ 
                            String resposta = novoEvento.AddEvento(novoevento);
                            if (resposta.equals("Evento cadastrado com sucesso")){
                                JOptionPane.showMessageDialog(rootPane, "Evento cadastrado com sucesso.");
                            }else{
                                JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar Evento: " + resposta);
                            }
                        }catch(Exception ex){

                            JOptionPane.showMessageDialog(rootPane , "Ocorreu um erro inesperado!" + ex);
                            ex.printStackTrace();
                        }         
                    }
            }
        });
        
    }
private void TxtCepKeyReleased(KeyEvent e) {
        String cep = cepField.getText().replaceAll("[^0-9]","");
        // Se o comprimento do CEP for maior que 5, insere um hífen na posição correta
        Date dataFim = (Date) dtFimSpinner.getValue();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(dataFim);
        
        if (cep.length() > 8) {
            cep = cep.substring(0, 8);
        }
        if(cep.length()>5){
            cep = cep.substring(0,5) + "-" + cep.substring(5);
        }
        // Atualiza o campo TxtCep com o CEP formatado
        cepField.setText(cep);
        
       // Se o comprimento do CEP  for igual a 9, faz a consulta na API
         if (cep.length() == 9){
            try {
                 // Chama o método ApiEndereco passando o CEP sem o hífen
                ApiEndereco(cep.replace("-", ""));
            } catch (IOException ex) {// Registra uma exceção no log se ocorrer um erro de I/O
                Logger.getLogger(TelaCadastroEvento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
private void ApiEndereco(String cep) throws MalformedURLException, IOException{
         try{
            String aUrl = "https://viacep.com.br/ws/" + cep + "/json/"; // Monta a URL para a requisição à API do ViaCEP
            URL url = new URL(aUrl);
             
           // Abre a conexão com a URL
            URLConnection rq = url.openConnection();
            rq.connect();
            
            InputStream is = rq.getInputStream();   // Lê o conteúdo da resposta da API
            
             BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
             StringBuilder builder = new StringBuilder();  // Constrói uma string com o conteúdo lido da resposta da API
             String jso;
             
             while ((jso = rd.readLine())!= null){
                 builder.append(jso);
                 
             }
             rd.close();
             
             JSONObject jsonOb = new JSONObject(builder.toString());   // Converte a string de resposta para um objeto JSON

            ruaField.setText(jsonOb.optString("logradouro"));    // Preenche os campos TxtRua e TxtBairro com os valores obtidos do JSON
            bairroField.setText(jsonOb.optString("bairro"));

        } catch (MalformedURLException ex) {   // Trata exceção de URL malformada
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaCadastroEvento::new);
    }
}
