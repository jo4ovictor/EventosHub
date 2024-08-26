
package modelo;

public class Inscricao {
    private int id;
    private int user_id;
    private int even_id;
    private String even_nome;
    private String even_data;

    public Inscricao(int id, String even_nome, String even_data) {
        this.id = id;
        this.even_nome = even_nome;
        this.even_data = even_data;
    }
    
    
    
    public Inscricao(int user_id, int even_id) {
        this.user_id = user_id;
        this.even_id = even_id;
    }
    
    
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getEven_id() {
        return even_id;
    }

    public void setEven_id(int even_id) {
        this.even_id = even_id;
    }

    public String toString(int even_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEven_nome() {
        return even_nome;
    }

    public void setEven_nome(String even_nome) {
        this.even_nome = even_nome;
    }

    public String getEven_data() {
        return even_data;
    }

    public void setEven_data(String even_data) {
        this.even_data = even_data;
    }
    
    
}
