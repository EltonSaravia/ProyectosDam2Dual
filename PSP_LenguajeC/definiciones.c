/*
    Directivas del procesador
    El defnie sirve para hacer macros que permiten calculos mas rapidos
    que las funciones.
*/
#include <stdio.h>

#define CUBO(a) a*a*a
#define PI 3.14159

int main(){
    int a ;
    printf("ingresa un numero:");

    scanf("%d",&a);
    
    printf("El cubo del numero insertado es : %i\n",CUBO(a));

    return 0;
}