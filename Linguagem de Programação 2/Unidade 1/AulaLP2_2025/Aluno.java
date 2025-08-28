
/**
 * Escreva uma descrição da classe Aluno aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Aluno
{
   int matricula;
   String nome;
   int anoIngresso;
   String curso;
   int quantDisc;
   String situacao;
   
   public Aluno(int matricula, String nome, int anoIngresso, String curso){
       this.matricula = matricula;
       this.nome = nome;
       this.anoIngresso = anoIngresso;
       this.curso = curso;
   }
   
   int permanencia(int anoAtual){
       int tempo;
       tempo = anoAtual - this.anoIngresso;
       return tempo;
    }
   
   void informarDisc(int quantDisc){
       this.quantDisc = quantDisc;
       System.out.println("sua mensalidade será:"+this.calcularMensalidade());
   }
   
   float calcularMensalidade(){
       return this.quantDisc*150;
   }
   
}
