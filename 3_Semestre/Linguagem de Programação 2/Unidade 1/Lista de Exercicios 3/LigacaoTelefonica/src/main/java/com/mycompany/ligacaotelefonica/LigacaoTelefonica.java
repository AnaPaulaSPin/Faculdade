
package com.mycompany.ligacaotelefonica;


public class LigacaoTelefonica {
    private int numeroOrigem;
    private String localOrigem;
    private int numeroDestino;
    private String localDestino;
    private float valorTotal;
    private Tempo momentoInicio;
    private Tempo momentoFim;
    
    public LigacaoTelefonica(Tempo momentoInicio, int numOrigem, String localOrigem, int numDestino, String localDestino){
        this.momentoInicio = momentoInicio;
        this.numeroOrigem = numOrigem;
        this.localOrigem = localOrigem;
        this.numeroDestino = numDestino;
        this.localDestino = localDestino;
    }
    
    public void TerminarLigacao(Tempo momentoFim){
        this.setMomentoFim(momentoFim);
    }
    
    public void calcularValor(){
        int inicio = momentoInicio.conversao();
        int fim = momentoFim.conversao();
        
        int Diferenca = fim - inicio;
         int segundos = momentoFim.getSegundos() - momentoInicio.getSegundos();
         System.out.println("Segundos: " + segundos);
        
         //verificar uma logica sobre os segundos.
        if( segundos < 0 ){
            Diferenca = Diferenca + 1;   
        }
        
        this.setValorTotal(Diferenca * 1);
        System.out.println("Minutos da ligacao: " + Diferenca);
        
        System.out.println("O valor da sua ligacao foi: " + this.getValorTotal());
    }
    
    public void verificarNumero(int numero){
        if(numero == this.getNumeroOrigem()){
            System.out.println("O numero " + numero + "que voce digitou e o numero de origem!");
            
        } else if(numero == this.getNumeroDestino()){
            System.out.println("O numero " + numero + " que voce digitou e o numero de destino!");
        } else {
            System.out.println("O numero " + numero + " que voce digitou nao participou da chamada!");
        }
        
    }


    public int getNumeroOrigem() {
        return numeroOrigem;
    }
    public void setNumeroOrigem(int numeroOrigem) {
        this.numeroOrigem = numeroOrigem;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }
    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    public int getNumeroDestino() {
        return numeroDestino;
    }
    public void setNumeroDestino(int numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public String getLocalDestino() {
        return localDestino;
    }
    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Tempo getMomentoInicio() {
        return momentoInicio;
    }
    public void setMomentoInicio(Tempo momentoInicio) {
        this.momentoInicio = momentoInicio;
    }

    public Tempo getMomentoFim() {
        return momentoFim;
    }
    public void setMomentoFim(Tempo momentoFim) {
        this.momentoFim = momentoFim;
    }
}


