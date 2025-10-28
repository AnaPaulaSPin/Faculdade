public class Calculadora {
    private int op1;
    private int op2;
    private String sinal;
    String[] sinais = {"+","-","*","/","%"};

    public boolean verificarSinal(String sinal){
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

    public void setOp1(int op){
        this.op1 = op;
    }

    public int getOp1(){
        return this.op1;
    }

    public void setOp2(int op){
        this.op1 = op;
    }

    public int getOp2(){
        return this.op2;
    }

    public void setSinal(String sinal){
        this.sinal = sinal;
    }

    public String getSinal(){
        return this.sinal;
    }
}
