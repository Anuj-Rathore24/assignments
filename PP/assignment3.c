#include <stdio.h>
#include <omp.h>
#include <stdlib.h>
#define n 1000

long long int Partition(long long int arr[],long long int start,long long int end)
{
	long long int p_index=start;
	long long int shift_index=start;
	
	for(long long int i=start+1;i<=end;i++)
	{
		if(arr[i] < arr[p_index])
		{
			long long int temp = arr[i];
			long long int set = p_index;
			while(shift_index!=i)
			{	
				for(long long int j=shift_index;j>=p_index;j--)
				{
					arr[j+1] = arr[j];	
				}
				p_index++;
				shift_index++;
			}
			arr[set] = temp;
		}
		
		else
		{
			shift_index++;
		}
	}
	
	
	return p_index;
}

void Quick_sort_p(long long int arr[],long long int start,long long int end)
{
	if(start<end)
	{
		long long int p_index = Partition(arr,start,end);
		#pragma omp parallel sections
		{
			#pragma omp section
			{Quick_sort_p(arr,start,p_index-1);}
			
			#pragma omp section
			{Quick_sort_p(arr,p_index+1,end);}
		}
	}
}


void Quick_sort_s(long long int arr[],long long int start,long long int end)
{
	if(start<end)
	{
		long long int p_index = Partition(arr,start,end);
		
		Quick_sort_s(arr,start,p_index-1);
		Quick_sort_s(arr,p_index+1,end);
	}
}



int main()
{
	omp_set_nested(1);
	long long int arr1[n];
	long long int arr2[n];
	
	for(long long int i=0;i<n;i++)
	{
		arr2[i] = arr1[i] = rand()%n;
	}
	
	double start_s = omp_get_wtime();
	Quick_sort_s(arr1,0,n-1);
	double stop_s = omp_get_wtime();
	
	printf("\nSerial Time: %lf",stop_s-start_s);
	
	printf("\n");
	
	
	double start_p = omp_get_wtime();
	Quick_sort_p(arr2,0,n-1);
	double stop_p = omp_get_wtime();
	
	printf("\n\nParallel Time: %lf",stop_p-start_p);
	
	return 0;
}