//
//  main.cpp
//  test
//
//  Created by William Brown on 11/13/13.
//  Copyright (c) 2013 William Brown. All rights reserved.
//

#include <iostream>
using namespace std;

class book
{
private:
    string name;
    string author;
    
public:
    
    string getName()
    {
        return name;
    }
    
    void setName(string setName);
};
int main()
{
    
    cout << "What up!!" << endl;

    return 0;
}

