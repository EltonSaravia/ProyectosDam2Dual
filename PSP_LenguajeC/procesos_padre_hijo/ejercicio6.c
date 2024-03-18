#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

void manejador_hijo(int sig);
void manejador_padre(int sig);

pid_t pid_hijo;
int numero = 1;

int main() {
    struct sigaction sa_padre, sa_hijo;

    // Configurar el manejador de señales para el padre
    sa_padre.sa_handler = manejador_padre;
    sigemptyset(&sa_padre.sa_mask);
    sa_padre.sa_flags = 0;
    sigaction(SIGUSR1, &sa_padre, NULL);

    // Configurar el manejador de señales para el hijo
    sa_hijo.sa_handler = manejador_hijo;
    sigemptyset(&sa_hijo.sa_mask);
    sa_hijo.sa_flags = 0;
    sigaction(SIGUSR2, &sa_hijo, NULL);

    pid_hijo = fork();

    if (pid_hijo == -1) {
        perror("Error en fork");
        return 1;
    }

    if (pid_hijo == 0) {
        // Proceso hijo
        while (numero <= 10) {
            pause(); // Espera la señal del padre
        }
    } else {
        // Proceso padre
        printf("%d (padre)\n", numero++);
        kill(pid_hijo, SIGUSR2); // Envía la primera señal al hijo
        while (numero <= 10) {
            pause(); // Espera la señal del hijo
        }
        wait(NULL); // Espera que el hijo termine
    }

    return 0;
}

void manejador_padre(int sig) {
    if (numero <= 10) {
        printf("%d (padre)\n", numero++);
        kill(pid_hijo, SIGUSR2); // Envía señal al hijo
    }
}

void manejador_hijo(int sig) {
    if (numero <= 10) {
        printf("%d (hijo)\n", numero++);
        kill(getppid(), SIGUSR1); // Envía señal al padre
    }
}
