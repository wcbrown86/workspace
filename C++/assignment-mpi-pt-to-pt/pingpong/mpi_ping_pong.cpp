#include <mpi.h>
#include <iostream>
#include <chrono>

int main (int argc, char* argv[]) {

  if (argc < 2) {
    std::cerr<<"usage: mpirun "<<argv[0]<<" <value>"<<std::endl;
    return -1;
  }


  //setting up MPI and values needed for the program.
  MPI_Init(&argc, &argv);
  int size, rank, value;
  //sets rank based of the current process. 
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  //sets size with the total number of processors.
  MPI_Comm_size(MPI_COMM_WORLD, &size);

  
  //records the starting time.
  std::chrono::time_point<std::chrono::system_clock> start = std::chrono::system_clock::now();

  // ----- Master ------
  if(rank == 0){

    // the number entered by the user is assigned to value
    value = atoi(argv[1]);

    //Sends the number in value to process 2
    MPI_Send(&value, 1, MPI_INT, 1, 0, MPI_COMM_WORLD);

    //receive the updated value from process 2.
    MPI_Recv(&value, 1, MPI_INT, 1, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);

    //Prints the updated value out to the user.
    std::cout << value << std::endl;

  // ----- Slaves -----
  } else {

    //Creates the variable to store the sent number to change and send back
    int number = 0; 

    //Receives the number from the master process to update.
    MPI_Recv(&number, 1, MPI_INT, 0, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);

    //Changes the number by 2.
    number += 2; 

    //Sends the number back to the master program. 
    MPI_Send(&number, 1, MPI_INT, 0, 0, MPI_COMM_WORLD);
  }

  //Records the final time and prints it to the error logs. 
  std::chrono::time_point<std::chrono::system_clock> end = std::chrono::system_clock::now();
  std::chrono::duration<double> elapsed_seconds = end-start;
  std::cerr<<elapsed_seconds.count()<<std::endl;

  //Closes out MPI.
  MPI_Finalize();
  


  return 0;
}
