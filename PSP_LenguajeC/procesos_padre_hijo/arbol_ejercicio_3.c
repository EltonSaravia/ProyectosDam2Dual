#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int nivel;
    printf("Introduce el nivel de procesos a crear: ");
    scanf("%d", &nivel);
    printf("Soy el proceso RAIZ con PID %d \n", getpid());
    pid_t pid;
    int hijos_creados = 0;

    for (int i = 0; i < nivel; i++) {
        pid = fork();

        if (pid == -1) {
            // Error al crear el proceso hijo
            perror("fork falló");
            exit(EXIT_FAILURE);
        } else if (pid == 0) {
            // Código del proceso hijo
            printf("Soy el proceso hijo con PID %d y mi padre es %d\n", getpid(), getppid());
            // El hijo no necesita crear más hijos si está en el último nivel
            if (nivel - i - 1 == 0) {
                exit(0);
            }
        } else {
            // Código del proceso padre
            hijos_creados++;
            wait(NULL); // Espera a que el hijo termine antes de crear otro
            // Rompe el bucle si ya no necesitamos más hijos en este nivel
            if (nivel - i - 1 == 0) {
                break;
            }
        }
    }

    if (pid > 0) {
        // Código del proceso padre después de crear todos los hijos
        printf("Total de hijos creados por el proceso padre: %d\n", hijos_creados);
    }

    return 0;
}
