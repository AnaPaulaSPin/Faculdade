
 


public class Pequeno extends Automovel {
    private String modelo;
    
    public Pequeno(String modelo, String Placa, int ano){
        super(Placa, ano);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
