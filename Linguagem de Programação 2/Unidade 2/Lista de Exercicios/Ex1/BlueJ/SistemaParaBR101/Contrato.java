
 

import java.util.ArrayList;


public class Contrato {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private ArrayList<Automovel> automoveis;
  
    
    public Contrato(String nome, String cpf, String endereco, String email, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.automoveis = new ArrayList<>();
        
    }
    
    public float CalcularFatura(){
        float valor = 0;
        for(Automovel auto: automoveis){
            int cont= auto.passagens.size();
            valor += auto.calcularPedagio() * cont;
        }
  
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void addAutomoveis(Automovel automovel) {
        this.automoveis.add(automovel);
    }
    
   
    
    
    
}
