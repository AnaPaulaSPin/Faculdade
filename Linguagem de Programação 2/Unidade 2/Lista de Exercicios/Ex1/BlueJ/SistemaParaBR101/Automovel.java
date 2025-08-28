 

import java.util.ArrayList;

public class Automovel {
    protected String Placa;
    protected int ano;
    protected ArrayList<Passagem> passagens;
    
    public Automovel(String Placa, int ano){
        this.Placa = Placa;
        this.ano = ano;
        this.passagens = new ArrayList<>();
    }

    public float calcularPedagio(){  
        return 6;
    }
    
    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public ArrayList<Passagem> getPassagens() {
        return this.passagens;
    }

    public void addPassagens(Passagem passagem) {
        this.passagens.add(passagem);
    }
    
    
}
