
public class PriorityQueue 
{
	
	PriorityCustomer[] arr;
	PriorityCustomer compar;
    private int currentSize;   // Number of elements in heap

    
    public PriorityQueue( )
    {
        currentSize = 0;
        compar = null;
        arr = new PriorityCustomer[2] ; 
    }
    

    private int compare( PriorityCustomer x, PriorityCustomer y )
    {
          if(x.getPriority() > y.getPriority())
        	  return 1;
          else 
        	  return 0;
    }
    

    public boolean add( PriorityCustomer x )
    {
        if( currentSize + 1 == arr.length )
            doubleArray( );

            // Percolate up
        int hole = ++currentSize;
        arr[ 0 ] = x;
        
        for( ; compare( x, arr[ hole / 2 ] ) < 0; hole /= 2 )
            arr[ hole ] = arr[ hole / 2 ];
        arr[ hole ] = x;
        
        return true;
    }
    

    public int size( )
    {
        return currentSize;
    }
    

    

    public PriorityCustomer remove( )
    {
    	PriorityCustomer current = current();
        arr[ 1 ] = arr[ currentSize-- ];
        percolateDown( 1 );

        return current;
    }

 
    private void percolateDown( int hole )
    {
        int child;
        PriorityCustomer tmp = arr[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    compare( arr[ child + 1 ], arr[ child ] ) < 0 )
                child++;
            if( compare( arr[ child ], tmp ) < 0 )
                arr[ hole ] = arr[ child ];
            else
                break;
        }
        arr[ hole ] = tmp;
    }

    private void doubleArray( )
    {
        PriorityCustomer [ ] newArray;

        newArray =  new PriorityCustomer[ arr.length * 2 ];
        for( int i = 0; i < arr.length; i++ )
            newArray[ i ] = arr[ i ];
        arr = newArray;
    }


	public PriorityCustomer current() {

		return arr[1];
	}

}