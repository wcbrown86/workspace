#include <mpi.h>
#include <iostream>
#include <chrono>

#ifdef __cplusplus
extern "C" {
#endif

//instructor provided functions
float f1(float x, int intensity);
float f2(float x, int intensity);
float f3(float x, int intensity);
float f4(float x, int intensity);

#ifdef __cplusplus
}
#endif
//function call for the work each worker needs to preform. 
float numInt(int start, int end);

//variables that store the user input
int functionid, intensity;
float a, b, n;

//main function 
int main (int argc, char* argv[]) {

  if (argc < 6) {
    std::cerr<<"usage: mpirun "<<argv[0]<<" <functionid> <a> <b> <n> <intensity>"<<std::endl;
    return -1;
  }

  //starts the MPI program
  MPI_Init(&argc, &argv);
  //sets up variables to store the rank of the process, and the total number of processor.
  int size, rank;
  //sets the size and rank 
  MPI_Comm_size(MPI_COMM_WORLD, &size);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  //stores the user enter information.
  functionid = atoi(argv[1]);
  a = atoi(argv[2]);
  b = atoi(argv[3]);
  n = atoi(argv[4]);
  intensity = atoi(argv[5]);
  //Global sum used to store information sent by workers
  float calcSum = 0.0f;

  // ---------- Master -------------
  if(rank == 0){

    //records start time. 
    std::chrono::time_point<std::chrono::system_clock> start = std::chrono::system_clock::now();

    //sets granularity and other veriables used to track the progress of the program.
    int gran = n/10;
    int current = 0; 
    float sum = 0.0;
    float recSum = 0.0;
    int* data = new int[2];

      //sends the next amount of work to the worker process. the program sends more work than needed to allow the workers
      //to all end gracfully. 
      while(current < n + gran*size){
        //MPI types for the waitall function after the loop
        MPI_Request requ[size-1];
        MPI_Status stat[size-1];
        //loops to sends the next section of work to 
        for(int i = 1; i < size; i++){ 
          //array that sends the needed information to the workers.
          data[0] = current;
          data[1] = current + gran;

          //sends the information
          MPI_Isend(data, 2, MPI_INT, i, 0, MPI_COMM_WORLD, &requ[i-1]);
          //changes the current by the grandularity.
          current += gran;
        }
        //Wait all is used to make sure all the process get the next set of work. 
        MPI_Waitall(size-1, requ, stat);
    }

    //loop that recieves all the local sums from the worker processes
    for(int i = 1; i < size; i++){
      //recieves the information 
      MPI_Recv(&recSum, 1, MPI_FLOAT, i, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
      //sums information sent back. 
      sum += recSum;
    }  

    //prints the sum to the standered out.
    std::cout << sum << std::endl;
    //records ending time and prints to standered error
    std::chrono::time_point<std::chrono::system_clock> end = std::chrono::system_clock::now();
    std::chrono::duration<double> elapsed_seconds = end-start;
    std::cerr<<elapsed_seconds.count()<<std::endl;
  
  // ----------- Workers --------------
  } else {

    //array that stores the information sent
    int* recData = new int[2];
    
    //loop that looks for new work to be done
    while(recData[0] < n ){

      //recieves the information sent by the master program.       
      MPI_Recv(&recData[0], 3, MPI_INT, 0, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
      //sums the local calculations from the information returned from the function call.
      calcSum += numInt(recData[0], recData[1]);      
    }

    //sends the local sum to the master process to store and print when all the work in complete. 
    MPI_Send(&calcSum, 1, MPI_FLOAT, 0, 0, MPI_COMM_WORLD);

  }

  //ends the MPI program. 
  
  MPI_Finalize();
  return 0;
}

//Function that calculates the intergal. 
float numInt(int start, int end){
  float localSum = 0;
  
  
  for(float i = start; i < end || i < n; i++){
      float f = 0.0f;
      float x = (a + (i + 0.5) * ((b - a) / (float)n));
      
      switch (functionid){
        case 1:
          f = f1(x, intensity) * ((b - a) / (float)n);
          break;
        case 2:
          f = f2(x, intensity) * ((b - a) / (float)n);
          break;
        case 3:
          f = f3(x, intensity) * ((b - a) / (float)n);
          break;
        case 4:
          f = f4(x, intensity) * ((b - a) / (float)n);
          break;
        default:
          break;
      }

      localSum += f;
  }

  return localSum;

}
