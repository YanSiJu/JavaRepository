#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>


void Read_n(int *n_p);
void Allocate_vectors(double **x_pp,double **y_pp,double **z_pp,int n);
void Read_vector(double a[],int n,char vec_name[]);
void Vector_Sum(double x[],double y[],double z[],int n);
void Print_Vector(double b[],int n,char title[]);


int main()
{
	int n;
	double *x,*y,*z;
	Read_n(&n);
	Allocate_vectors(&x,&y,&z,n);


	printf("Please input the vector x:");
	Read_vector(x,n,"x");

	printf("Please input the vector x:");
	Read_vector(y,n,"y");


	Vector_Sum(x,y,z,n);

	Print_Vector(z,n,"The sum is"); 

	free(x);
	free(y);
	free(z);

	return 0;

}

void Vector_Sum(double x[],double y[],double z[],int n){

		int i;
		for(i=0; i<n; i++){
		z[i] = x[i]+ y[i];
		}
}

void Print_Vector(double b[],int n,char title[]){
		
	int i;
	printf("%s\n",title);
	for(i=0; i<n; i++){
		printf("%lf",b[i]);
		}

	printf("\n");
}

void Read_vector(double a[],int n,char vec_name[]){
		int i;
		for(i=0; i<n; i++){
		scanf("%lf",&a[i]);
		}
}



void Read_n(int *n_p){

		printf("What's the order of the Vectors?\n ");
		scanf("%d",n_p);

		if(*n_p <= 0){
		fprintf(stderr,"Order should be positive.");
		exit(-1);
		}
}

void Allocate_vectors(double **x_pp,double **y_pp,double **z_pp,int n){

		*x_pp = (double*)malloc(sizeof(double)*n);
		*z_pp = (double*)malloc(sizeof(double)*n);
		*y_pp = (double*)malloc(sizeof(double)*n);

		if(*x_pp == NULL || *y_pp == NULL || *z_pp == NULL ){
				fprintf(stderr,"Allocate  memory   failed.\n");
				exit(-1);
		}

}
