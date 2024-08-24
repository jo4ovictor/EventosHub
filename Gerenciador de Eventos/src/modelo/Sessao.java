
package modelo;

// criamos está classe para assim usar o padrao singleton
 public class Sessao {
    private static Sessao instancia;
    private Usuario usuarioLogado;
    
    
        private Sessao(){}
         public static Sessao getInstancia(){
             if (instancia == null){
                 instancia = new Sessao();
             }
             return instancia;
         }
         public Usuario getUsuarioLogado() {
               return usuarioLogado;
         }
         public void setUsuarioLogado(Usuario usuario){
               this.usuarioLogado = usuario;
         }
    }


// nesta classe tive que usar a classe sessao e aplicarla como padrao singleton (padrao criacional)
// ja que java nao possui variavel global recorri a esta classe para assim istanciar ela e que sirva como 
// como classe global para que possa ser acessada em qualquer lugar do codigoo.

// O Singleton é um padrão de projeto criacional que garante que uma classe tenha apenas uma única instância durante toda a execução do programa e fornece um ponto global de acesso a essa instância.


