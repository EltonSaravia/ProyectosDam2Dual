#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h>

#define NUM_INTS 100

int main() {
    int pipe1[2], pipe2[2];
    pid_t h1, h2;

    // Crear tuberías
    if (pipe(pipe1) == -1 || pipe(pipe2) == -1) {
        perror("pipe");
        return 1;
    }

    h1 = fork();
    if (h1 == 0) {
        // Proceso hijo H1
        close(pipe1[1]); // Cierra extremo de escritura
        int val, sum = 0, count = 0;
        while (read(pipe1[0], &val, sizeof(val)) > 0) {
            sum += val;
            count++;
        }
        close(pipe1[0]);
        printf("H1: Suma = %d, Cantidad = %d\n", sum, count);
        exit(0);
    }

    h2 = fork();
    if (h2 == 0) {
        // Proceso hijo H2
        close(pipe2[1]); // Cierra extremo de escritura
        int val, sum = 0, count = 0;
        while (read(pipe2[0], &val, sizeof(val)) > 0) {
            sum += val;
            count++;
        }
        close(pipe2[0]);
        printf("H2: Suma = %d, Cantidad = %d\n", sum, count);
        exit(0);
    }

    // Proceso padre
    close(pipe1[0]); // Cierra extremo de lectura en H1
    close(pipe2[0]); // Cierra extremo de lectura en H2

    srand(time(NULL));
    for (int i = 0; i < NUM_INTS; i++) {
        int num = rand() % 100; // Generar un número aleatorio entre 0 y 99
        if (num % 5 == 0) {
            // Enviar a H1
            write(pipe1[1], &num, sizeof(num));
        } else {
            // Enviar a H2
            write(pipe2[1], &num, sizeof(num));
        }
    }

    // Cerrar los extremos de escritura después de enviar todos los números
    close(pipe1[1]);
    close(pipe2[1]);

    // Esperar a que los procesos hijos terminen
    waitpid(h1, NULL, 0);
    waitpid(h2, NULL, 0);

    return 0;
}
