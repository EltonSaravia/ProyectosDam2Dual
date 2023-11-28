#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

/*
  Se desea realizar un programa que pida al usuario cuántos procesos quiere crear. 
  El programa generará una estructura de procesos de un padre con varios hijos.
*/
int main() {
    int num1;
    printf("Ingrese el número de hijos a crear: \n");
    scanf("%d", &num1);

    pid_t padreOriginal_pid = getpid(); // Guardar el PID del padre original
    pid_t padreOriginal_pid
    int pid;

    for (int i = 0; i < num1; i++) {
        pid = fork();

        if (pid == 0) {
            printf("Soy el proceso hijo %d y mi padre es %d\n", getpid(), padre_pid);
            break;
        } else if (pid > 0) {
            // En el proceso padre, actualiza el PID del padre para el siguiente hijo.
            padre_pid = pid;
        } else {
            perror("Error al crear el proceso");
            exit(EXIT_FAILURE);
        }
    }

    return 0;
}