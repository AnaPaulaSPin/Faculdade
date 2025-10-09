

public class Aluno
{ String nome;
  int matricula;
  int anoIgress;
  String curso;
  int qtDisciplinas;
  String situacao;
  
  public Aluno(int matricula, String nome, int anoIgress, String curso){
      this.matricula = matricula;
      this.nome = nome;
      this.anoIgress = anoIgress;
      this.curso = curso;
      
  }
  
  int calculaTempo(int anoatual){
      anoatual = anoatual - this.anoIgress;
      
      System.out.println("Possui "+ anoatual +"Anos de curso");
      
      return anoatual;
      
  }
  
  void calcularMensalidade(int qtDisciplinas){
      this.qtDisciplinas = qtDisciplinas;
      double mensalidade;
      
      mensalidade = qtDisciplinas * 150.00;
      
      System.out.println("Valor que voce pagara esse semestre: "+ mensalidade);
    
    
    }
  
  
  void verificarSituacao(){
      if(this.qtDisciplinas == 0){
          this.situacao = "Nao Matriculado";
          
          System.out.print("Aluno nao se candidatou a nenhuma materia ");
          System.out.println("logo "+ this.situacao + "!");
      } else {
          this.situacao = "Matriculado";
          System.out.print("Aluno se candidatou a "+ this.qtDisciplinas );
          System.out.println("materias logo ele esta "+ this.situacao + "!");
      }
      
      
  }
    
}
