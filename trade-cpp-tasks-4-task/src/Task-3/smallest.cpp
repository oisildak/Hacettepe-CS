//
// Created by joi on 11.03.2024.
//
#include "smallest.h"

#include <iostream>
#include <string>

template<typename T>
int smallest(const T* array,int length) {
    if (length==0) {
        return -1;
    }
    int result=0;
    for (int i = 1; i < length; ++i) {
        if (array[i]<array[result]) {
            result=i;
        }
    }
    return  result;
}

void test_smallest() {
    std::cout << "Starting to Task-3 Tests\n";
    std::string words[]={"test","abc","tbc","cbaaaa"};
    int result=smallest(words,4);
    if(result==1) {
        std::cout << "Test-1 Passed\n";
    }else {
        std::cout << "Test-1 Failed\n";
    }
    /*
    std::cout << result<<std::endl;
    */
    int numbers[]={1,2,4,-12,2521,512};
    result=smallest(numbers,std::size(numbers));
    if(result==3) {
        std::cout << "Test-2 Passed\n";
    }else {
        std::cout << "Test-2 Failed\n";
    }
    std::cout << "Task-3 Tests are finished"<<std::endl;

}
