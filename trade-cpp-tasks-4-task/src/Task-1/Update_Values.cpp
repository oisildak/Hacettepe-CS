#include <iostream>
#include  "update.h"

//
// Created by joi on 11.03.2024.
//
void update_function(int* a,int* b) {
    int sum=(*a)+(*b);
    int diff=std::abs((*a)-(*b));
    *a=sum;
    *b=diff;
}

void test_update() {
    std::cout << "Starting to Task-1 Tests\n";
    int a=5;
    int b=3;
    update_function(&a,&b);
    if (a==8 && b==2) {
        std::cout << "Passed Test-1\n";
    }else {
        std::cout << "Failed at Test-1\n";
    }
    a=-12;
    b=-5;
    update_function(&a,&b);
    if (a==-17 && b==7) {
        std::cout << "Passed Test-2\n";
    }else {
        std::cout << "Failed at Test-2\n";
    }
    std::cout << "Test for Tasks-1 Finished\n";
}