
 


public class Passagem {
    private Data data;
    private String hora;
    
    public Passagem(Data data, String hora, float valor){
        this.data = data;
        this.hora = hora;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
