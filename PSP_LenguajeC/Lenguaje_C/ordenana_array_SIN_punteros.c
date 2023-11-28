#include <stdio.h>
#include <stdlib.h> //esta libreria sirve para traer n cantidad de funciones como rand() "random"

void imprime_vector (int vector[ ], int *size){ 

    for (int contador = 0; contador < *size; contador++){ // el tamano debe llama al valor si no se va de madre

        printf("\nPosiscion %d almacenada = %d", contador + 1 , vector[contador]);
    }
 }


void ordena_vector(int vector[], int *size) {
    /* utilizola ordenacion en burbuja que es la que me salia mas facil */
    for (int i = 0; i < *size - 1; i++) { // con este for se controla que no salgamos del rango maximo del array
         for (int j = 0; j < *size - i - 1; j++) { //  con este  for nos aseguramos que se haga el intercambio si un numero es menor al siguiente
            if (vector[j] > vector[j + 1]) {
                // Intercambiar elementos si están en el orden incorrecto
                int temp = vector[j];
                vector[j] = vector[j + 1];
                vector[j + 1] = temp;
            }
        }
    }
}
 

int main(){

    int numeros[] = {9 ,7, 8, 3, 1, 4, 2, 5, 0, 6} ;
    int sizeArrayEnbytes = sizeof numeros; 
    int sizeArrayEntero = sizeArrayEnbytes / (sizeof numeros[0]);
    
    printf("\nAntes de ordenar los numeros.... %d", sizeArrayEntero);

    imprime_vector (numeros, &sizeArrayEntero);

    ordena_vector(numeros, &sizeArrayEntero);

    printf("\nDepues de ordenar los numeros....");

    imprime_vector (numeros, &sizeArrayEntero);


    
}