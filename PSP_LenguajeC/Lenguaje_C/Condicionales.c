/*
== x es igual a y
!= x es diferebte a y
> x es mayor a y
< x es menor a y
>= mayor o igual
<= menor o igual
*/

#include <stdio.h>
int main(){
    int edad;
    printf("ingresa tu edad\n");
    scanf("%d",&edad);

    if (edad >= 18){
        printf("eres mayor de edad\n");
    }else if(edad == 17){
        printf("eres menor de edad por poco tiempo");
    }else{
        printf("eres menor de edad\n");
    }

    return 0;
}