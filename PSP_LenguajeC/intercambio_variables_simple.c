
#include <stdio.h>
#include <stdlib.h> //esta libreria sirve para traer n cantidad de funciones como rand() "random"

/* en esta funcion y en todas debo solicitar la direccion de memoria no un numero poniendo el asteriso delante*/
void intercambio(int *valor1, int *valor2) {
    int aux; // creo una variable que no tiene valor pero si direccion de memoria 
    aux = *valor1; // copio el valor de valor1 poniendo el * delante y le doy ese valor a aux
    *valor1 = *valor2;
    *valor2 = aux;
}

int main() {
    int a;
    int b;

    a = 5;  // al crear una variable se crea la direccion de memoria que se obtiene con un & delante
    b = 20; // si igualas una variable a otra ambas iran a la misma direccion de memoria?¿???

    printf("Antes de que cambie a = %d y b = %d", a, b);

    intercambio(&a, &b); // le tengo que pasar siempre las direcciones de memoria, no el numero 

    printf("\nDespues de intercambiar a = %d y b = %d", a, b);

    return 0;
}