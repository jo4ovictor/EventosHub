
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Evento;

public class EventoDao {
    private Connection c;

    public EventoDao(Connection c) {
        this.c = c;
  
      }
    
    public String AddEvento(Evento evento){
        String r = "";
        PreparedStatement sta = null;
         try{
           
           String sql = "INSERT INTO eventos(even_nome, even_descricao, even_dt_inicio, even_dt_fim, even_cep, even_bairro, even_rua, even_numero, usuario_usua_id)\n" +
                         "VALUES (?,?,?,?,?,?,?,?,?)";
           sta = this.c.prepareStatement(sql);
           sta.setString(1, evento.getNome());
           sta.setString(2, evento.getDescricao());
           sta.setString(3, evento.getDt_inicio());
           sta.setString(4, evento.getDt_fim());
           sta.setString(5, evento.getCep());
           sta.setString(6, evento.getBairro());
           sta.setString(7, evento.getRua());
           sta.setInt(8, evento.getNumero());
           sta.setInt(9, evento.getUsua_id());
           sta.executeUpdate();
           sta.close();
            r = "Evento cadastrado com sucesso";
            
      }catch(SQLException e){
          r = "Erro ao cadastrar Evento: " + e.getMessage();
      
    }finally{
     if(sta != null){
         try{
             sta.close();
          }catch(SQLException e){
             
            }
        }
    
        }
        return r;
    }
    
      public List<Evento>CarregarEventos(){
         List<Evento> EventoLista = new ArrayList<>();
           PreparedStatement sstt = null;
           ResultSet rss = null;
          try{
              String sql = "SELECT even_id, even_nome, even_descricao, DATE_FORMAT(even_dt_inicio, '%d/%m/%Y %H:%i:%s') AS even_dt_inicio, DATE_FORMAT(even_dt_fim, '%d/%m/%Y %H:%i:%s') AS even_dt_fim,even_cep, even_bairro, even_rua, even_numero, CONCAT(even_bairro, ', ', even_rua, ', ', even_numero) AS endereco_completo, usuario_usua_id FROM eventos;";
              sstt = this.c.prepareStatement(sql);
              rss = sstt.executeQuery();
              
                while (rss.next()) {
                int id = rss.getInt("even_id");
                String nome = rss.getString("even_nome");
                String descricao = rss.getString("even_descricao");
                String dtInicio = rss.getString("even_dt_inicio");
                String dtFim = rss.getString("even_dt_fim");
                String cep = rss.getString("even_cep");
                String bairro = rss.getString("even_bairro");
                String rua = rss.getString("even_rua");
                int numero = rss.getInt("even_numero");
                String endereco = rss.getString("endereco_completo");
                int usuarioId = rss.getInt("usuario_usua_id");

                Evento even = new Evento(id, nome, descricao, dtInicio, dtFim, cep, bairro, rua, numero,endereco, usuarioId);
                EventoLista.add(even);
              
            }
                
           } catch (SQLException e) {
            e.printStackTrace();
            // Aqui você pode adicionar um tratamento de erro, como logging ou lançando uma exceção personalizada
        } finally {
            try {
                if (rss != null) rss.close();
                if (sstt != null) sstt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return EventoLista;
      }
      
      public boolean ExcluirEvento(int id_evento){
          String sql = "DELETE FROM eventos WHERE even_id = ?";
          boolean excluir = false;
          try{
              PreparedStatement sta = c.prepareStatement(sql);
              sta.setInt(1, id_evento);
               int rowAffected = sta.executeUpdate();
               if(rowAffected > 0){
                   excluir = true;
               }
          }catch(SQLException e){
              System.out.println("Erro ao exluir o evento" +e.getMessage());
              e.printStackTrace();
          }
          return excluir;
      }
}
