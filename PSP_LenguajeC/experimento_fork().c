#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main(){

int contador = 1;
while (contador <= 10000){
	fork();
	contador++;
}

return 0;

}