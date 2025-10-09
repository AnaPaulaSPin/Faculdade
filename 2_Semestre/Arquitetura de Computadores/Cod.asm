.MODEL SMALL
.STACK 200h

.DATA
Quadrados dw 1, 4, 9, 16, 25  ; Array com 5 valores

.CODE
START:
    mov ax, @data
    mov ds, ax

   ; Acessando Quadrados[2] e colocando o valor em AX
    mov bx, 2  
    mul bx,2 ; assim vai acessar a posição certa              
    

    ; Modificando Quadrados[2] para 100
    mov [Quadrados + bx], 40 

    mov ax, [Quadrados + bx*2] 

    ; Fim do programa
    mov ah, 4ch              ; Interrupção para terminar o programa
    int 21h

END START
