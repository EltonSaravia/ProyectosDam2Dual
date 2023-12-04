#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
/*
 Con este comando podemos averiguar los procesos zombies (661) y sus padres (ppid 660).

ps -A -ostat,ppid,pid,cmd | grep  defunct
*/
int main ()
{
  int  pid;

  pid = fork ();

  /*a partir de aqui se ejecutan 2 programas replicados por eso hay que 
  hacer una comprobacion */
  if (pid > 0) { //compruebo que sea un numero mayor a 0
    sleep (60); /// si es el padre lo pongo a dormir  60 segundos
    exit (0);
  }
  else { // el else entra si es el hijo porque no ha dado un numero mayor a 0
    exit (0); // con esto paramos el proceso de inmediato
  }
  return 0;
}
