public class Calculadora {
    private int op1;
    private int op2;
    private String sinal;
    private String[] sinais = {"+","-","*","/","%"};

    public boolean verificarSinal(){
        for(String sin: sinais){
            if(sin.equals(sinal)){
                return true;
            }
        }
        return false;
    }

    public float operacao(){
        if(sinal.equals("+")){
            return op1 + op2;

        } else if(sinal.equals("-")){
            return op1 - op2;
        } else if(sinal.equals("/")){
            return op1 / op2;
        } else if(sinal.equals("*")){
            return op1 * op2;
        } else {
            return op1 % op2;
        }
    }
}
