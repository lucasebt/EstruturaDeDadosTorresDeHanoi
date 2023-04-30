
package com.mycompany.eddtorresdehanoi;

import java.util.Scanner;

public class EDDTorresDeHanoi {
    private static long movimentos = 0;
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o número de discos: ");
        int numDiscos = entrada.nextInt();
        entrada.close();

        long inicio = System.currentTimeMillis();
        moverDiscos(numDiscos, 'A', 'B', 'C');
        long fim = System.currentTimeMillis();

        int segundos = (int) ((fim - inicio) / 1000);
        int minutos = segundos / 60;
        segundos = segundos % 60;
        int milissegundos = (int) (fim - inicio) % 1000;

        System.out.printf("Tempo gasto: %02d:%02d:%02d.%03d\n", minutos, segundos, milissegundos, movimentos);
    }

    private static void moverDiscos(int numDiscos, char torreOrigem, char torreAuxiliar, char torreDestino) {
        if (numDiscos == 1) {
            // System.out.printf("Mover disco 1 da torre %c para a torre %c\n", torreOrigem, torreDestino);
            movimentos++;
        } else {
            moverDiscos(numDiscos - 1, torreOrigem, torreDestino, torreAuxiliar);
            // System.out.printf("Mover disco %d da torre %c para a torre %c\n", numDiscos, torreOrigem, torreDestino);
            movimentos++;
            moverDiscos(numDiscos - 1, torreAuxiliar, torreOrigem, torreDestino);
        }
    }
}
