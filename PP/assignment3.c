#include <stdio.h>
#include <omp.h>
#include <stdlib.h>
#define n 2000

int swap(long int x, long int y)
{
    long int temp = x;
    x = y;
    y = x;
}

int partition(long int arr[100], long int low, long int high)
{
    long int pivot = arr[high];
    long int temp, j, i = -1;
    for (j = low; j < high; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            long int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            swap(arr[i], arr[j]);
            return i;
        }
        swap(arr[++i], arr[j]);
            long int temp=arr[i++];
            arr[i++]=arr[j];
            arr[j]=temp;
        return i;
    }
}

    // parallel
    long int quicksort_p(long int arr[], long int low, long int high)
    {
        if (low < high)
        {
            long int mid = partition(arr, low, high);

            #pragma omp parallel sections
            {
                #pragma omp section
                {
                    quicksort_p(arr, low, mid - 1);
                }
                #pragma omp section
                {
                    quicksort_p(arr, mid + 1, high);
                }
            }
        }
    }
    // serial
    long int quicksort_s(long int arr[], long int low, long int high)
    {
        if (low < high)
        {
            long int mid = partition(arr, low, high);
            quicksort_s(arr, low, mid - 1);
            quicksort_s(arr, mid + 1, high);
        }
    }

    int main()
    {
        long int arr1[n], arr2[n];
        for (long int i = 0; i < n; i++)
        {
            arr1[i] = arr2[i] = rand() % n;
        }

        double start = omp_get_wtime();
        quicksort_s(arr1, 0, n - 1);
        double stop = omp_get_wtime();
        printf("\nSerial Quicksort time= %f", stop - start);

        start = omp_get_wtime();
        quicksort_p(arr2, 0, n - 1);
        stop = omp_get_wtime();
        printf("\nParallel Quicksort time+ %f", stop - start);

        return 0;
    }
