#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    int pid;
    int status;

    // Preparando los argumentos para execvp
    char **argumentos = malloc((argc) * sizeof(char *)); // Usando malloc
    if (argumentos == NULL) {
        perror("Error en la asignacion de memoria");
        exit(-1);
    }

    for (int i = 1; i < argc; ++i) {
        argumentos[i - 1] = argv[i];
    }
    argumentos[argc - 1] = NULL; // execvp espera un arreglo terminado en NULL
    printf("hola %s", *argumentos);
    pid = fork();

    switch(pid) {
        case -1:
            perror("ERROR EN EL FORK");
            exit(-1);

        case 0: // estamos en el proceso hijo
            execvp(argumentos[0], argumentos);
           
            perror("Error en execvp. Si todo ha ido bien esto no se ejecuta. ");
            exit(-1);

        default: // proceso padre
            while(wait(&status) != pid);
            if (status == 0)
                printf("Ejecucion normal del hijo \n");
            else
                printf("Error en el hijo \n");
    }

    free(argumentos); 
    exit(0);
}
