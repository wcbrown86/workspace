//
//  main.c
//  path
//
//  Created by William Brown on 2/1/16.
//

#include <stdio.h>
#define  M 100
#define N 100
char array[M][N] = {{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                    {'1', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1'},
                    {'0', '0', '1', '0', '1', '0', '1', '1', '1', '1', '0', '1'},
                    {'1', '1', '1', '0', '1', '0', '0', '0', '0', '1', '0', '1'},
                    {'1', '0', '0', '0', '0', '1', '1', '1', '0', '1', '0', '0'},
                    {'1', '1', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
                    {'1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
                    {'1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
                    {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '1'},
                    {'1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1'},
                    {'1', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1'},
                    {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};
void readFile();
void findStartandEnd();
void mazeTraversal();
int m = 12;
int n = 12;
int start[2] = {0};
int end[2] = {0};

int main()
{
    readFile();
    findStartandEnd();
    mazeTraversal();

}

void printMaze(){
    for (int i = 0; i < M && i < m; i++)
        for (int j = 0; j < N && j < n; j++)  {
            if (j == 0) printf("\n");
            printf("%c  ",array[i][j]);
        }
    printf("\n");
}

void mazeTraversal(){
    int dir = 0;
    int dir2b = 0;
    int x = start[1];
    int y = start[0];
    int solution = 0, noSolution = 0;
    array[y][x] = 'S';
    int moveCount = 0;

    if(array[y][x+1]== '0') {
        dir=0;  //not dir=1!
    }else if(array[y+1][x]=='0') {
        dir=1;
    }else if(array[y][x-1]=='0') {
        dir=2;
    }else if(array[y-1][x]=='0') {
        dir=3;
    }

    while(solution == 0 && noSolution == 0){

        if(dir==0) { //North
            if(array[y][x+1] != '1' && array[y][x+1] != 'S') {
                dir2b=1;
                x++;
            }else if(array[y-1][x] != '1' && array[y-1][x] != 'S') {
                dir2b=0;
                y--;
            }else if(array[y][x-1] != '1' && array[y][x-1] != 'S') {
                dir2b=3;
                x--;
            }else if(array[y+1][x] != '1' && array[y+1][x] != 'S') {
                dir2b=2;
                y++;
            }
        }
        if(dir==1) { //East
            if(array[y+1][x] != '1' && array[y+1][x] != 'S') {
                dir2b=2;
                y++;
            }else if(array[y][x+1] != '1' && array[y][x+1] != 'S') {
                dir2b=1;
                x++;
            }else if(array[y-1][x] != '1' && array[y-1][x] != 'S') {
                dir2b=0;
                y--;
            }else if(array[y][x-1] != '1' && array[y][x-1] != 'S') {
                dir2b=3;
                x--;
            }
        }
        if(dir==2) { //South
            if(array[y][x-1] != '1' && array[y][x-1] != 'S') {
                dir2b=3;
                x--;
            }else if(array[y+1][x] != '1' && array[y+1][x] != 'S') {
                dir2b=2;
                y++;
            }else if(array[y][x+1] != '1' && array[y][x+1] != 'S') {
                dir2b=1;
                x++;
            }else if(array[y-1][x] != '1' && array[y-1][x] != 'S') {
                dir2b=0;
                y--;
            }
        }
        if(dir==3) { //West
            if(array[y-1][x] != '1' && array[y-1][x] != 'S') {
                dir2b=0;
                y--;
            }else if(array[y][x-1] != '1' && array[y][x-1] != 'S') {
                dir2b=3;
                x--;
            }else if(array[y+1][x] != '1' && array[y+1][x] != 'S') {
                dir2b=2;
                y++;
            }else if(array[y][x+1] != '1' && array[y][x+1] != 'S') {
                dir2b=1;
                x++;
            }
        }
        array[y][x]= 'X';
        dir = dir2b;
        moveCount++;

        if(y == end[0] && x == end[1]){
            solution = 1;
            printMaze();
            printf("Solution Found \n");
        }

        if(dir == 0 && moveCount > 1 && array[y][x+1] == 'S')
            noSolution = 1;
        else if(dir == 1 && moveCount > 1 && array[y+1][x] == 'S')
            noSolution = 1;
        else if(dir == 2 && moveCount > 1 && array[y][x - 1] == 'S')
            noSolution = 1;
        else if(dir == 3 && moveCount > 1 && array[y - 1][x] == 'S')
            noSolution = 1;
        if(noSolution == 1)
            printf("No Solution Found");
    }
}

void findStartandEnd(){

    int i,j, startFound, endFound = 0;

    while (startFound == 0 || endFound == 0) {

        if(j >= 0 && j < n && i == 0){
            if(array[i][j] == '0'){
                if(startFound == 0){
                    start[0] = i;
                    start[1] = j;
                    startFound = 1;
                }
                else if(endFound == 0){
                    end[0] = i;
                    end[1] = j;
                    endFound = 1;
                }
            }
           if(i < n) j++;
        }
        if(j == n - 1  && i >= 0 && i < m){
            if(array[i][j] == '0'){
                if(startFound == 0){
                    start[0] = i;
                    start[1] = j;
                    startFound = 1;
                }
                else if(endFound == 0){
                    end[0] = i;
                    end[1] = j;
                    endFound = 1;
                }
            }
            if(i < m) i++;
        }
        if(j >= 0 && j < n && i == n - 1){
            if(array[i][j] == '0'){
                if(startFound == 0){
                    start[0] = i;
                    start[1] = j;
                    startFound = 1;
                }
                else if(endFound == 0){
                    end[0] = i;
                    end[1] = j;
                    endFound = 1;
                }
            }
            if(j != 0) j--;
        }
        if(j == 0 && i >= 0 && i < n){
            if(array[i][j] == '0'){
                if(startFound == 0){
                    start[0] = i;
                    start[1] = j;
                    startFound = 1;
                }
                else if(endFound == 0){
                    end[0] = i;
                    end[1] = j;
                    endFound = 1;
                }
            }
           if(i != 0) i--;
        }


    }
}

void readFile(){

    FILE *fptr;
    char c;
    char file_name[20];
    int i,j;


    printf("Please enter the size of the MxN maze.\n");
    printf("Start with the M size then the N size follow each number by the return key.\n");
    scanf("%d",&m);
    scanf("%d",&n);
    printf("Type in the name of the file containing the Field\n");
    scanf("%s",file_name);
    fptr=fopen(file_name,"r");
    for (i = 0; i < M && i < m; i++)
        for (j = 0; j < N && j < n; j++){
            c = fgetc(fptr);
            while ( !((c == '1')||(c =='0')) ) c = fgetc(fptr);
            array[i][j]=c;
        }
    fclose(fptr);

    for (i = 0; i < M && i < m; i++)
        for (j = 0; j < N && j < n; j++)  {
            if (j == 0) printf("\n");
            printf("%c  ",array[i][j]);
        }
    printf("\n");


}
