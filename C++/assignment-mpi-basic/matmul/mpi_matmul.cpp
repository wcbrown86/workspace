#include <iostream>
#include <cmath>
#include <cstdlib>
#include <chrono>
#include <mpi.h>

//Generates the larger matrix based of the location in the grid
float genA (int row, int col) {
  if (row > col)
    return 1.;
  else
    return 0.;
}

//generates the vector.
float genx0 (int i) {
  return 1.;
}

//Checks the correctness of the matrix multplcation. 
void checkx (int iter, long i, float xval) {
  if (iter == 1) {
    float shouldbe = i;
    if (fabs(xval/shouldbe) > 1.01 || fabs(xval/shouldbe) < .99 )
      std::cout<<"incorrect : x["<<i<<"] at iteration "<<iter<<" should be "<<shouldbe<<" not "<<xval<<std::endl;
  }

  if (iter == 2) {
    float shouldbe =(i-1)*i/2;
    if (fabs(xval/shouldbe) > 1.01 || fabs(xval/shouldbe) < .99)
      std::cout<<"incorrect : x["<<i<<"] at iteration "<<iter<<" should be "<<shouldbe<<" not "<<xval<<std::endl;
  }
}

//perform dense y=Ax on an n \times n matrix/ stores the results in the location of the vector y. 
void matmul(float*A, float*x, float*y, long n, long startCol) {
  for (long row = 0; row<n; ++row) {
    float sum = 0;
    
    for (long col = 0; col<n; ++col) {
      //sum += x[col] *A[row][col]
      sum += x[col + (startCol * n)] * A[row*n+col];
    }

    y[row + (startCol * n)] = sum;
  }
}


int main (int argc, char*argv[]) {

  if (argc < 3) {
    std::cout<<"usage: "<<argv[0]<<" n iteration"<<std::endl;
  }

  MPI_Init(&argc, &argv);
  //Gets the number of the machines being used. This value is needed to split the work
  int size; 
  MPI_Comm_size(MPI_COMM_WORLD, &size);
  //Gets the current machine number. This is used to know what part of the work to do. 
  int rank;
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);

  //variables needed to run the program. 
  bool check = true;
  long n = atol(argv[1]);
  long iter = atol(argv[2]);
  //row col size deturmined by the square root of the number of processors
  long squareRoot = sqrt(size);
  //deturmines the matrix size of each 
  long matrixSize = n/squareRoot;
  //creates communicators for rom and col
  MPI_Comm rowComm, colComm;
  //sets the location of the grid based off the process number. 
  long gridRow = rank % squareRoot;
  long gridCol = rank / squareRoot;

  //Creates row and col communication
  MPI_Comm_split(MPI_COMM_WORLD, gridRow , gridCol , &rowComm); 
  MPI_Comm_split(MPI_COMM_WORLD, gridCol , gridRow , &colComm);
  
  //initialize data
  float* A = new float[matrixSize*matrixSize];
  for (long row = 0; row<matrixSize; row++) {
    for (long col=0; col<matrixSize; col++) {
      A[row*matrixSize+col] = genA(row +(gridRow * matrixSize), col + (gridCol * matrixSize));
    }
  }

  float* x = new float[n];
  for (long i=0; i<n; ++i)
    x[i] = genx0(i);

  float* y = new float[n];
  for (long i = 0; i < n; i++){
    y[i] = 0;
  }

  //starts time
  std::chrono::time_point<std::chrono::system_clock> start = std::chrono::system_clock::now();
   

  //Write the muliply reduce brodcast.

  for (long it = 0; it<iter; ++it) {

    //local multiplication 
    matmul(A, x, y, matrixSize, gridRow);
    
    //adds the information in the rows together
    MPI_Reduce( y , x , n , MPI_FLOAT , MPI_SUM , gridRow , rowComm);
    //sends the information to all the col. 
    MPI_Bcast(x, n, MPI_FLOAT, gridCol , colComm);
      
    //checks the vector for correctness. this program does not get the second half of interation 2 correct.
    if (check && (gridRow == gridCol))
      for (long i = 0; i<matrixSize; ++i)
        checkx (it+1, (i + (gridCol * matrixSize)), x[i + (gridRow * matrixSize)]); 
    
  }
  
  
  
  //each procees records the time it took to compete and prints to stderr
  std::chrono::time_point<std::chrono::system_clock> end = std::chrono::system_clock::now();
  std::chrono::duration<double> elapsed_seconds = end-start;
  std::cerr<<elapsed_seconds.count()<<std::endl;

  //frees the communicators
  MPI_Comm_free(&rowComm);
  MPI_Comm_free(&colComm);
  //ends the MPI rogram. 
  MPI_Finalize();
  
  
  delete[] A;
  delete[] x;
  delete[] y;
  
  return 0;
}
