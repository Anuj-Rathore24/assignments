#include<stdio.h>
#include<stdlib.h>
#include<omp.h>
#define lenght 100000
int main(){
    int veca[lenght],vecb[lenght],vecc[lenght],i;
    for (int i = 0; i < lenght; i++)
    {
        veca[i]=i*2;
        vecb[i]=i;
        vecc[i]=0;
    }
    double start=omp_get_wtime();
    for (int i = 0; i < lenght; i++)
    {
        vecc[i]=veca[i]+vecb[i];
    }
    double end=omp_get_wtime();

    printf("With serialized method :%lf \n",end-start);

    start=omp_get_wtime();
    #pragma omp parallel for private(i)

    for (int i = 0; i < lenght; i++)
    {
        vecc[i]=veca[i]+vecb[i];
    }
    end=omp_get_wtime();

    printf("With Parallel method :%lf \n",end-start);
    
    return 0;
}