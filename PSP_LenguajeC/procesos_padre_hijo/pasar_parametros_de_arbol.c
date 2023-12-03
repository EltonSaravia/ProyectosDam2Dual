#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int alto, ancho;
    
    if (argc != 3) {
        printf("Por favor, proporcione altura y ancho como argumentos.\n");
        exit(0);
    }

    alto = atoi(argv[1]);
    ancho = atoi(argv[2]);

    // Bucle externo para la altura
    for (int i = 0; i < alto; i++) {
        // Bucle interno para la anchura
        for (int j = 0; j < ancho; j++) {
            // Crear un nuevo proceso en cada iteración del bucle interno
            pid_t pid = fork();

            if (pid == 0) {
                // Código para el proceso hijo
                printf("Soy el proceso %d y mi padre es %d\n", getpid(), getppid());
                sleep(2);// esperar 2 segundos para evitar erores ddd
                
                // Salir del bucle interno y del proceso hijo
                exit(0);
            }
        }
    }

    return 0;
}
