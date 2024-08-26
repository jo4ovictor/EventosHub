
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Evento;
import modelo.Inscricao;

public class InscricaoDao {
    private Connection c;
    
    public InscricaoDao(Connection c){
        this.c = c;
    }
    
    public String AddInscricao(int id_even, int id_user){
        String r = "";
        PreparedStatement sta = null;
         try{
           
           String sql = "INSERT INTO inscricao(eventos_even_id, usuario_usua_id)\n" +
                         "VALUES (?,?)";
           sta = this.c.prepareStatement(sql);
           sta.setInt(1, id_even);
           sta.setInt(2, id_user);
           sta.executeUpdate();
           sta.close();
            r = "Inscrito com sucesso";
            
      }catch(SQLException e){
          r = "Erro ao inscrever-se: " + e.getMessage();
      
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
    
      public List<Inscricao> CarregarInscricoes(int id) {
    List<Inscricao> InscricaoLista = new ArrayList<>();
    PreparedStatement sstt = null;
    ResultSet rss = null;

    try {
        String sql = "SELECT " +
                     "inscricao.insc_id, " +
                     "eventos.even_nome, " +
                     "DATE_FORMAT(eventos.even_dt_inicio, '%d/%m/%Y %H:%i:%s') AS dt_inicio_formatado " +
                     "FROM " +
                     "inscricao " +
                     "INNER JOIN eventos ON inscricao.eventos_even_id = eventos.even_id " +
                     "INNER JOIN usuario ON inscricao.usuario_usua_id = usuario.usua_id " +
                     "WHERE usuario.usua_id = ?;";

        sstt = this.c.prepareStatement(sql);
        sstt.setInt(1, id);  // Corrigido o método de configuração do parâmetro

        rss = sstt.executeQuery();

        while (rss.next()) {
            int ins_id = rss.getInt("insc_id");
            String nome = rss.getString("even_nome");
            String dtInicio = rss.getString("dt_inicio_formatado");  // Usar o alias correto

            Inscricao insc = new Inscricao(ins_id, nome, dtInicio);
            InscricaoLista.add(insc);
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

    return InscricaoLista;
}

      
      public boolean ExcluirInscricao(int id_inscricao){
          String sql = "DELETE FROM inscricao WHERE insc_id = ?";
          boolean excluir = false;
          try{
              PreparedStatement sta = c.prepareStatement(sql);
              sta.setInt(1, id_inscricao);
               int rowAffected = sta.executeUpdate();
               if(rowAffected > 0){
                   excluir = true;
               }
          }catch(SQLException e){
              System.out.println("Erro ao cancelar inscrição" +e.getMessage());
              e.printStackTrace();
          }
          return excluir;
      }

    
}

