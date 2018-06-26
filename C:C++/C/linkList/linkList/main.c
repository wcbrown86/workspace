/* Operating and maintaining a list */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct listNode {  /* self-referential structure */
    char *data;
    struct listNode *nextPtr;
};

typedef struct listNode LISTNODE;
typedef LISTNODE *LISTNODEPTR;

void insert(LISTNODEPTR *, char *);
char delete(LISTNODEPTR *, char *);
int isEmpty(LISTNODEPTR);
void printList(LISTNODEPTR);
void instructions(void);

main()
{
    LISTNODEPTR startPtr = NULL;
    char *item = malloc(30*sizeof(char));
    char *str = malloc(30*sizeof(char));
    char *data = malloc(30*sizeof(char));
    char fileName[100];
    FILE *file;
    
    
    
    
    instructions();  /* display the menu */
    scanf("%s", fileName );
    file = fopen(fileName, "r");
    
    item = fgets(item, BUFSIZ,file);
    while(item != NULL){
        while(item != NULL && strncmp(item, "\r\n",2)){
            strcat(str, item);
            //printf("%s", str);
            item = fgets(item, BUFSIZ,file);
        }
        if(strncmp(str,"",1)){
            data = strtok(str," ");
            while(str != NULL && data != NULL){
                
                insert(&startPtr, data);
                data = strtok(NULL, " ");
                //printf("%s", data);
            
            }
            free(data);
            free(str);
            data = malloc(30*sizeof(char));
            str = malloc(30*sizeof(char));
            printList(startPtr);
            startPtr = NULL;

        }
        item = fgets(item, BUFSIZ,file);
    }
    


    return 0;
}

/* Print the instructions */
void instructions(void)
{
    printf("Please enter the file to be read.\n");
}

/* Insert a new value into the list in sorted order */
void insert(LISTNODEPTR *sPtr, char *value)
{
    LISTNODEPTR newPtr, previousPtr, currentPtr;
    
    newPtr = malloc(30*sizeof(LISTNODE));
    
    if (newPtr != NULL) {    /* is space available */
        newPtr->data = value;
        newPtr->nextPtr = NULL;
        
        previousPtr = NULL;
        currentPtr = *sPtr;
        
        while (currentPtr != NULL && value > currentPtr->data) {
            previousPtr = currentPtr;          /* walk to ...   */
            currentPtr = currentPtr->nextPtr;  /* ... next node */
        }
        
        if (previousPtr == NULL) {
            newPtr->nextPtr = *sPtr;
            *sPtr = newPtr;
        }
        else {
            previousPtr->nextPtr = newPtr;
            newPtr->nextPtr = currentPtr;
        }
    }
    else
        printf("%s not inserted. No memory available.\n", value);
}

/* Delete a list element */
char delete(LISTNODEPTR *sPtr, char *value)
{
    LISTNODEPTR previousPtr, currentPtr, tempPtr;
    
    if (value == (*sPtr)->data) {
        tempPtr = *sPtr;
        *sPtr = (*sPtr)->nextPtr;  /* de-thread the node */
        free(tempPtr);             /* free the de-threaded node */
        return *value;
    }
    else {
        previousPtr = *sPtr;
        currentPtr = (*sPtr)->nextPtr;
        
        while (currentPtr != NULL && currentPtr->data != value) {
            previousPtr = currentPtr;          /* walk to ...   */
            currentPtr = currentPtr->nextPtr;  /* ... next node */
        }
        
        if (currentPtr != NULL) {
            tempPtr = currentPtr;
            previousPtr->nextPtr = currentPtr->nextPtr;
            free(tempPtr);
            return *value;
        }
    }
    
    return '\0';
}

/* Return 1 if the list is empty, 0 otherwise */
int isEmpty(LISTNODEPTR sPtr)
{
    return sPtr == NULL;
}

/* Print the list */
void printList(LISTNODEPTR currentPtr)
{
    if (currentPtr == NULL)
        printf("List is empty.\n\n");
    else {
        printf("The list is:\n");
        
        while (currentPtr != NULL) {
            printf("%s ", currentPtr->data);
            currentPtr = currentPtr->nextPtr;
        }
        
        printf("NULL\n\n");
    }
}
