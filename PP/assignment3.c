#include <stdlib.h>
#include <stdio.h>
#define max 4000
#include <omp.h>
int partition(int arr[], int low, int high)
{
	int pivot;
	pivot = arr[high];
	int i = low - 1;
	int j;
	for (j = low; j < high; j++)
	{
		if (arr[j] < pivot)
		{
			i++;
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	i++;
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
	return i;
}
void quicksort(int arr[], int low, int high)
{
	if (low < high)
	{
		int p = partition(arr, low, high);
		quicksort(arr, low, p - 1);
		quicksort(arr, p + 1, high);
	}
}
void quicksortparallel(int arr[], int low, int high)
{
	if (low < high)
	{
		int p = partition(arr, low, high);
#pragma omp parallel sections private(low, high)
		{
#pragma omp section
			{
				quicksort(arr, low, p - 1);
			}
#pragma omp section
			{
				quicksort(arr, p + 1, high);
			}
		}
	}
}
int main()
{
	int i, arrS[max], arrP[max];
	for (i = 0; i < max; i++)
	{
		arrS[i] = arrP[i] = rand() % max;
	}
	printf("\nSerial:");
	double start = omp_get_wtime();
	quicksort(arrS, 0, max - 1);
	double stop = omp_get_wtime();
	printf("Serial Execution time:%f ", stop - start);
	

	printf("\n");
	printf("\nParallel:");
	double start1 = omp_get_wtime();
	quicksort(arrP, 0, max - 1);
	double stop1 = omp_get_wtime();
	printf("Parallel Execution time:%f ", stop1 - start1);
	
	return 0;
}