TOKEN tokenAtual;
TOKEN listaTokens[MAX_TOKENS];

int main() {
    while (1){
        proximoToken(); // analixe lexical
        partdeclVariavel(); // analize sintática
        if(tokenAtual.tipo == TOKEN_FIM){
            break;
        }
    }

    return 0;
}


void proximoToken() {
    // Implementação da análise lexical para obter o próximo token
    // Atualiza a variável global tokenAtual com o próximo token
}

void partdeclVariavel() {
    if(tokenAtual.categoria == VAR){
        declaVar();

        While(tokenAtual == PONTO_VIRGULA){
            proximoToken();
            declaVar();
        }
    } else{
        erro("Esperado declaração de variável");
    }
}

void declaVar() {
    listIdentificador();
    if(tokenAtual.categoria =! PONTO_VIRGULA){
        erro("Esperado ponto e vírgula");
    } else{
        proximoToken();
        tipo();
        for (int i = 0; i < MAX_TOKENS; i++){
            insereTabelaSimbolos(listaTokens[i]);
        }
        
        proximoToken();
    }
}

void listIdentificador() {
    if(tokenAtual.categoria == IDENTIFICADOR){
        // Adiciona o identificador à lista de tokens
        listaTokens[contadorTokens++] = tokenAtual;
        proximoToken();
    } else{
        erro("Esperado identificador");
    }
}

void tipo() {
    if(tokenAtual.categoria == INTEIRO || tokenAtual.categoria == REAL || tokenAtual.categoria == BooLEAN ){
        // Tipo válido, prosseguir
        proximoToken();
    } else{
        erro("Esperado tipo de dado (inteiro, real ou caractere)");
    }
}

