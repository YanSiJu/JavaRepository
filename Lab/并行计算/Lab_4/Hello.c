#include<stdio.h>
#include<String.h>
#include "mpi.h"

int main(int argc,char *argv[]){
	
	int myid,numprocs,source;
	MPI_Status status;
	char message[100];
	MPI_Init(&argc,&argv);
	MPI_Comm_rank(MPI_COMM_WORLD,&myid);
	MPI_Comm_size(MPI_COMM_WORLD,&numprocs);
	if(myid!=0){
		strcpy(message,"hahahahahaha");	
		MPI_Send(message,strlen(message)+1,MPI_CHAR,0,99,MPI_COMM_WORLD);

	}else{
		strcpy(message,"hahahahahaha_else_MYID=0");	
		printf("%s\n",message);
		for(source=1;source<numprocs;source++){
			MPI_Recv(message,100,MPI_CHAR,source,99,MPI_COMM_WORLD,&status);
			printf("%s\n",message);
		}
	}	

	MPI_Finalize();
}
