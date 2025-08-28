 

import java.util.ArrayList;

public class Facul {
   private String nome;
   private int ano;
   private ArrayList<Curso> cursos;

   
   public Facul(String nome, int ano){
       this.nome = nome;
       this.ano = ano;
       this.cursos = new ArrayList<>();
   }
   
   public void AdicionarCurso(Curso curso1){
       boolean reptNome = false;
       
       for(Curso curs: cursos){
           if(curs.getNome().equals(curso1.getNome())){
              reptNome = true;
              break;
           }
       }
       
       if(!reptNome){
           this.addCursos(curso1);
       } else{
           System.out.println("Nao e possivel adicionar o mesmo curso na nossa faculdade! Tente novamente!");
       }
       
   }
   
   public void retirarCurso(String curso){
       boolean cursoEncontrado = false;
       
       for(Curso curs: cursos){
           if(curs.getNome().equals(nome)){
               cursoEncontrado = true;
               break;
           }
       }
       if(cursoEncontrado){
           cursos.remove(curso); 
       } else{
           System.out.println("Curso nao encontrado!");
       }
   }
   
     public Facul novaFaculdade(){
       Facul faculdade = new Facul("Unifacs", 2005);
       
       for(Curso curs: cursos){
           if (curs.getAnoCriacao() <= faculdade.getAno() + 5){
               faculdade.addCursos(curs);
           }
       } 
       return faculdade;
   }
   
   

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

   // retornar a lista
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    
    //adicionar um elemento a lista
    public void addCursos(Curso curso1) {
        this.cursos.add(curso1);
    }
   
   
}
