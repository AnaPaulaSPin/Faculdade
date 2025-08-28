
/**
 * Escreva uma descrição da classe ComandaRestaurante aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ComandaRestaurante
{
    
    int nrIdentificacao, bebidas, sobremesas;
    float quilos;
    String tipoPagamento;
    
    
    void criarComanda(int ident, String pag){
        nrIdentificacao = ident;
        tipoPagamento = pag;
    }
  float consumirComida(float kg){
        quilos = quilos+kg;
        return quilos;
    }
    void imprimir(){
        System.out.println(quilos);
    }
}
