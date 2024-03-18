#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <time.h>

int main(int argc, char *argv[]){
    if (argc < 3) {
        printf("Debe ingresar dos argumentos\n");
        return 1;
    }

    pid_t h1, h2;
    int argumento_1, argumento_2;
    int t1[2], t2[2], c1[2], c2[2];

    argumento_1 = atoi(argv[1]);
    argumento_2 = atoi(argv[2]);

    srand(time(NULL));

    pipe(t1);
    pipe(t2);
    pipe(c1);
    pipe(c2);

    h1 = fork();
    if (h1 == 0){
        close(t1[0]); // Cierra lectura en t1
        close(c1[1]); // Cierra escritura en c1

        for (int i = 0; i < argumento_1; i++) {
            int n = rand() % 10;
            write(t1[1], &n, sizeof(n));
            char dummy;
            read(c1[0], &dummy, 1); // Espera a que el padre lea
        }

        close(t1[1]);
        close(c1[0]);
        exit(0);
    } else {
        h2 = fork();
        if (h2 == 0){
            close(t2[0]); // Cierra lectura en t2
            close(c2[1]); // Cierra escritura en c2

            for (int i = 0; i < argumento_2; i++) {
                int n = rand() % 10 + 10;
                write(t2[1], &n, sizeof(n));
                char dummy;
                read(c2[0], &dummy, 1); // Espera a que el padre lea
            }

            close(t2[1]);
            close(c2[0]);
            exit(0);
        } else {
            close(t1[1]);
            close(t2[1]);
            close(c1[0]);
            close(c2[0]);

            int num1, num2;
            char dummy = 'x';
            for (int i = 0; i < argumento_1 + argumento_2; i++) {
                if (i < argumento_1) {
                    read(t1[0], &num1, sizeof(num1));
                    printf("H1: %d\n", num1);
                    write(c2[1], &dummy, 1); // Indica a H2 que puede enviar
                }

                if (i < argumento_2) {
                    read(t2[0], &num2, sizeof(num2));
                    printf("H2: %d\n", num2);
                    write(c1[1], &dummy, 1); // Indica a H1 que puede enviar
                }
            }

            close(t1[0]);
            close(t2[0]);
            close(c1[1]);
            close(c2[1]);

            wait(NULL);
            wait(NULL);
        }
    }

    return 0;
}
