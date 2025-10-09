
/**
 * Escreva uma descrição da classe CarteiraMotorista aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class CarteiraMotorista
{
    private int numero,pontos;
    private String cpf,tipo,validade,expedicao,situacao;
    
    //construtor
    public CarteiraMotorista(int numero, String cpf, String tipo, String validade, String expedicao){
        this(numero, cpf,tipo,validade,expedicao,0);
    }
    public CarteiraMotorista(int numero, String cpf, String tipo){
         this(numero,cpf,tipo,null,null,0);
    }
    public CarteiraMotorista(int numero, String cpf, String tipo, String validade, String expedicao, int pontos){
        this.numero = numero;
        this.cpf = cpf;
        this.tipo = tipo;
        this.validade=validade;
        this.expedicao = expedicao;
        this.pontos=pontos;
        this.situacao="valida";
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public int getNumero(){
        return this.numero;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return this.cpf;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setValidade(String validade){
        this.validade = validade;
    }
    public String getValidade(){
        return this.validade;
    }
    public void setExpedicao(String expedicao){
        this.expedicao=expedicao;
    }
    public String getExpedicao(){
        return this.expedicao;
    }
    public void setPontos(int pontos){
        this.pontos = pontos;
    }
    public int getPontos(){
        return this.pontos;
    }
    public void setSituacao(String situacao){
        this.situacao = situacao;
    }
    public String getSituacao(){
        return this.situacao;
    }
    
    void addPontos(int quantidade){
        this.setPontos(this.getPontos()+quantidade);
        this.apreender();
    }
    void addPontos(String multa){
        int quantidade;
        if (multa.equals("sinalVermelho")){
           quantidade=200;
        }
        else if (multa.equals("estacionamento")){
           quantidade=130;
        }
        else{
            quantidade=100;
        }
        this.addPontos(quantidade);
    }
    int saldo(){
        return this.pontos;
    }
    void zerar(){
        this.pontos=0;
        this.apreender();
    }
    void apreender(){
        if (this.pontos>20)
           this.situacao="apreendida";
        else
           this.situacao="valida";
   }
   void verificarValidade(){
       if (this.situacao.equals("valida"))
          System.out.println("sua carteira esta valida");
       else
          System.out.println("atenção, voce nao pode dirigir, ja ultrapassou os pontos"); 
   }
}
