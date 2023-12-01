#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
/*
Se desea realizar un programa que pida al usuario, cuantos procesos quiere crear. 
El programa generará una estructura de procesos de un padre con varios hijos 
*/
int main ()
{
int num1;
printf("ingrese el numero de hijos a crear \n");
scanf("%d",&num1);
int  pid;
for (int i = 0; i < num1; i++ )
   {
        pid = fork (5);

    /*a partir de fork()  se ejecutan 2 programas replicados por eso hay que 
    hacer una comprobacion */
    if (pid == 0) { //compruebo que sea un numero mayor a 0 (el padre)
        printf("Soy el proceso hijo %d y mi padre es %d \n" , getpid() ,getppid());

    }

   }
  return 0;
}
