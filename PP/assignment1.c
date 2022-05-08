#include<stdio.h>
#include<omp.h>


int main(){
    int n;
    printf("Enter the Size of each matrix :");
    scanf("%d",&n);
    int mat1[n][n];
    int mat2[n][n];
    int mat3[n][n];

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            mat1[i][j]=i+j;
            mat2[i][j]=i*j;
            mat3[i][j]=0;
        }
    }
    
    //Parallel Multiplication

    int i,j,k;
    double start=omp_get_wtime();
    #pragma omp parallel for private(i,j,k)

    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            for(k=0;k<n;k++){
                mat3[i][j]+=mat1[i][k]*mat2[k][j];
            }
        }

    }

    double stop=omp_get_wtime();
    printf("\nTime taken in Parallel :%lf",stop-start);
    
    
    //Series Multiplication
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            mat3[i][j]=0;
        }
    }
    start=omp_get_wtime();
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                mat3[i][j]+=mat1[i][k]*mat2[k][j];
            }
        }

    }
    stop=omp_get_wtime();
    printf("\nTime taken in Series :%lf",stop-start);

        
    return 0;
 }