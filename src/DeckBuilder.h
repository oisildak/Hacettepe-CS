#include <iostream>
#include <fstream>
#include <string>
#include "card.h"
using namespace std;

card cardArray[52];
card TempcardArray[52];
void builder(string filename1){//we are doing CRUD 

    string mytext;
    ifstream myfile;
    myfile.open(filename1);
    int i=0;
    int numberOfCard = 0;
    while (getline(myfile,mytext))
    {
        numberOfCard=(int)mytext[1]-48;
        if (numberOfCard!=0)
        {
            numberOfCard=10+((int)mytext[2]-48);
        }
        else
        {
            numberOfCard=((int)mytext[2]-48);
        }
        cardArray[i]=card(mytext,mytext[0],numberOfCard);
        i++;
   }
    for(int i=0;i<52;i++){
        TempcardArray[i]=cardArray[i];
    }

    for(int i=0;i<52;i++){
        cardArray[51-i]=TempcardArray[i];
    }
    void close();
    // For now I flipped deck also create array of 
    //cout<<cardArray[0].fullNameOfCard<<" " <<cardArray[0].typeOfCard<<cardArray[0].number << endl;
}