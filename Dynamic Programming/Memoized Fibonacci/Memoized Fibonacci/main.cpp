//
//  main.cpp
//  Memoized Fibonacci
//
//  Created by Shawon Ashraf on 6/24/16.
//  Copyright © 2016 Shawon Ashraf. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int fib(int n, vector<int> fibVec);

int main()
{
    int n = 100;
    vector<int> fibVec(n, -1);
    
    fibVec.at(0) = 0;
    fibVec.at(1) = 1;
    
    /*int r = fib(n - 1, fibVec);
    cout << r << endl;*/
    
    for(int i = 0; i < n; i++)
    {
        int r = fib(i, fibVec);
        cout << "fib # " << i << " : " << r << endl;
    }
    
    return 0;
}

int fib(int n, vector<int> fibVec)
{
    if(fibVec.at(n) != -1) { return fibVec.at(n); }
    else { return fib(n - 1, fibVec) + fib(n - 2, fibVec); }
    
    return fibVec.at(n);
}