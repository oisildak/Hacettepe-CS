#include "DeckBuilder.h"

int temp=0;
card myMatrix[20][7];
//card **myMatrix=new card*[20]; //Its just a experiment
ofstream outfile;

card Sarray[14];//They are Foundations
card Darray[14];
card Carray[14];
card Harray[14];

int Sn=0;//These are keeping index of Foundations when I add a card into Foundations They will update
int Dn=0;
int Cn=0;
int Hn=0;

card Waste[3];
card Stack[24];
card tempStack[24];//to re insert cards to Stack it works like a buffer memory.
bool isStackfull=true;
string wFilem;
void assignerV2(){//assign Cards to 2d matrix
    int z=0;
    for( int i = 0; i < 20; i++ ) {
        //myMatrix[i] = new card[7]; //experiment
        for( int j = 0; j < 7; j++ ) {
            myMatrix[i][j]=card();
        }
    }
    for (int j = 0; j < 7; j++)
    {
        for (int i = z; i < 7; i++)
        {
            myMatrix[j][i]=cardArray[temp];
            myMatrix[j][i].flag=false;
            cardArray[temp].number=-1;
            temp++;
        }
        z++;
    }
    for (int a = 0; a < 7; a++)
    {
        myMatrix[a][a].flag=true;
    }
}


void printer(string filename2){//  Printing Matrixes
   //outfile<<"@@@"<<" "<<"___"<<" "<<"___"<<" "<<"___"<<"         "<<"___"<<" "<<"___"<<" "<<"___"<<" "<<"___"<<endl<<endl;
   outfile.open(wFilem, std::ios_base::app);
   if (isStackfull==true)
   {
       outfile<<"@@@";
   }
   else if (isStackfull==false)
   {
       outfile<<"___";
   }
   
   
   for (int i = 0; i < 3; i++)
   {
       if(Waste[i].number==-1){
           outfile<<" "<<"___";
       }
       else{
           outfile<<" "<<Waste[i].fullNameOfCard;
       }
   }
   outfile<<"         ";
   if(Harray[0].number==-1){
       outfile<<" ___";
    }
   else{
    outfile<<" "<<Harray[Hn-1].fullNameOfCard;}

    if(Darray[0].number==-1){
       outfile<<" ___";
    }
    else{
        outfile<<" "<<Darray[Dn-1].fullNameOfCard;}
    
    if(Sarray[0].number==-1){
       outfile<<" ___";
    }
    else{
        outfile<<" "<<Sarray[0].fullNameOfCard;}

    if(Carray[0].number==-1){
       outfile<<" ___"<<endl<<endl;
    }
    else{
        outfile<<" "<<Carray[Cn-1].fullNameOfCard<<endl<<endl;}
   
    for (int i = 0; i <20; i++)
    {
        for (int j = 0;j <7; j++)
        {
            if (myMatrix[i][j].flag==false && myMatrix[i][j].number!=-1)
            {
                outfile<<"@@@"<<"   ";
            }
            else if (myMatrix[i][j].number!=-1)
            {
                outfile<<myMatrix[i][j].fullNameOfCard<<"   ";
            }
            else
            {
                outfile<<"      ";
            }
        }        
        outfile<<endl;
    }
    
    outfile.close();
}
void openPile(int a){//To open pile 
    int n=-1;
    for (int i = 0; i < 20; i++)
    {
        if (myMatrix[i][a].number!=-1)
        {
            n++;
        }
        else if(myMatrix[i][a].number==-1){
            break;
        }
        else
            outfile.open(wFilem, std::ios_base::app);
            outfile<<" ";
            outfile<<"Invalid Move!"<<endl;
            outfile.close();
        
    }
    if(myMatrix[n][a].flag==false){
        myMatrix[n][a].flag=true;
        printer(wFilem);
    }
    else
        outfile.open(wFilem, std::ios_base::app);
        outfile<<" ";
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
    
}


void stackStarter(){//its stareting stack
    int a=0;
    for (int i = 0; i < 52; i++)
    {
        if(cardArray[i].number!=-1){
            Stack[a]=cardArray[i];
            a++;
        }
    }
    
}



void openStack(){//That is change stack gives a kind of loop but it doesnt work properly
    int numberOfstack=0;
    for (int i = 0; i < 24; i++)
    {
        if(Stack[i].number!=-1){
            numberOfstack++;
        }
    }
    if(numberOfstack>2){
        for (int i = 0; i < 3; i++)
        {
            Waste[i].number=-1;
        }
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; i < 24; j++)
            {
                if(Stack[j].number!=-1){
                    Waste[i]=Stack[j];
                    tempStack[j]=Stack[j];
                    Stack[j].number=-1;
                    break;
                }
            }
            
        }
        printer(wFilem);
        
    }
    int a=0;
 
    if(numberOfstack<3 && numberOfstack>0){
        for (int i = 0; i < 3; i++)
        {
            Waste[i].number=-1;
        }
        for (int i = 0; i < numberOfstack; i++)
        {
            for (int j = 0; i < 24; j++)
            {
                if(Stack[j].number!=-1){
                    Waste[i]=Stack[j];
                    tempStack[j]=Stack[j];
                    Stack[j].number=-1;
                    break;
                }
            }
        }
        isStackfull=false; 
        printer(wFilem);
    }   
    else if(numberOfstack==0){
        for (int i = 0; i < 24; i++)
        {
            if(tempStack[i].number!=-1){
                Stack[a]=tempStack[i];
                a++;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            Waste[i].number=-1;
        }
        
        isStackfull=false;
        printer(wFilem);
        isStackfull=true;
        return;
    }
}
void moveWasteToPile(int Destination){//That moves waste to pile
    int indexim=-1;
    int Destinationindex=0;
    for (int i = 0; i < 3; i++)
    {
        if (Waste[i].number!=-1)
        {
            indexim++;
        }
        
    }
    if (indexim==-1)
    {   outfile.open(wFilem, std::ios_base::app);
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
        return;
    }
    for (int i = 0; i < 20; i++)
    {
        if (myMatrix[i][Destination].number!=-1)
        {
            Destinationindex++;
        }
        else{
            break;
        }
        
    }
    if (myMatrix[0][Destination].number==-1)
    {   myMatrix[0][Destination]=Waste[indexim];
        Waste[indexim].number=-1;
        for (int i = 0; i < 24; i++)
        {
            if (Waste[indexim].fullNameOfCard==tempStack[i].fullNameOfCard)
            {
                tempStack[i].number=-1;
            }
        }
        printer(wFilem);
        return;
    }
    else if(myMatrix[Destinationindex-1][Destination].number==-1 || myMatrix[Destinationindex-1][Destination].flag==false){
        outfile.open(wFilem, std::ios_base::app);
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
    }
    
    else if((Waste[indexim].number+1)==myMatrix[Destinationindex-1][Destination].number){
        if (Waste[indexim].typeOfCard=='H' && myMatrix[Destinationindex-1][Destination].typeOfCard!='H' && myMatrix[Destinationindex-1][Destination].typeOfCard!='D')
        {
            myMatrix[Destinationindex][Destination]=Waste[indexim];
            Waste[indexim].number=-1;
            for (int i = 0; i < 24; i++)
            {
                if (Waste[indexim].fullNameOfCard==tempStack[i].fullNameOfCard)
                {
                    tempStack[i].number=-1;
                }
            }
            printer(wFilem);
        }
        else if (Waste[indexim].typeOfCard=='D' && myMatrix[Destinationindex-1][Destination].typeOfCard!='H' && myMatrix[Destinationindex-1][Destination].typeOfCard!='D')
        {
            myMatrix[Destinationindex][Destination]=Waste[indexim];
            Waste[indexim].number=-1;
            for (int i = 0; i < 24; i++)
            {
                if (Waste[indexim].fullNameOfCard==tempStack[i].fullNameOfCard)
                {
                    tempStack[i].number=-1;
                }
            }
            printer(wFilem);
        }
        else if (Waste[indexim].typeOfCard=='C' && myMatrix[Destinationindex-1][Destination].typeOfCard!='S' && myMatrix[Destinationindex-1][Destination].typeOfCard!='C')
        {
            myMatrix[Destinationindex][Destination]=Waste[indexim];
            Waste[indexim].number=-1;
            for (int i = 0; i < 24; i++)
            {
                if (Waste[indexim].fullNameOfCard==tempStack[i].fullNameOfCard)
                {
                    tempStack[i].number=-1;
                }
                
            }
            printer(wFilem);
        }
        else if (Waste[indexim].typeOfCard=='S' && myMatrix[Destinationindex-1][Destination].typeOfCard!='C' && myMatrix[Destinationindex-1][Destination].typeOfCard!='S')
        {
            myMatrix[Destinationindex][Destination]=Waste[indexim];
            Waste[indexim].number=-1;
            for (int i = 0; i < 24; i++)
            {
                if (Waste[indexim].fullNameOfCard==tempStack[i].fullNameOfCard)
                {
                    tempStack[i].number=-1;
                }
                
            }
            printer(wFilem);
        }
        else
        {   outfile.open(wFilem, std::ios_base::app);
            outfile<<"Invalid Move!"<<endl;
            outfile.close();
            return;
        }
        
    }
    else{
        outfile.open(wFilem, std::ios_base::app);
        outfile<<" ";
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
        return;
    }
    


    
    
}

void moveWasteToFoundation(){//waste to Foundation
    int indexim=-1;
    for (int i = 0; i < 3; i++)
    {
        if (Waste[i].number!=-1)
        {
            indexim++;
        }
        
    }
    if (indexim==-1)
    {   outfile.open(wFilem, std::ios_base::app);
        outfile<<" ";
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
        return;
    }
    if(Waste[indexim].typeOfCard=='H'){
        if((Hn+1)==Waste[indexim].number){
            Harray[Hn]=Waste[indexim];
            Hn++;
            Waste[indexim].number=-1;
            for (int i = 0; i < 24; i++)
            {
                if (Waste[indexim].fullNameOfCard==tempStack[i].fullNameOfCard)
                {
                    tempStack[i].number=-1;
                }
            }
            printer(wFilem);
        }
        
    }
    else if(Waste[indexim].typeOfCard=='D'){
        if((Dn+1)==Waste[indexim].number){
            Darray[Dn]=Waste[indexim];
            Dn++;
            Waste[indexim].number=-1;
            for (int i = 0; i < 24; i++)
            {
                if (Waste[indexim].fullNameOfCard==tempStack[i].fullNameOfCard)
                {
                    tempStack[i].number=-1;
                }
            }
            printer(wFilem);
        }
        
    }
    else if(Waste[indexim].typeOfCard=='C'){
        if((Cn+1)==Waste[indexim].number){
            Carray[Cn]=Waste[indexim];
            Cn++;
            Waste[indexim].number=-1;
            for (int i = 0; i < 24; i++)
            {
                if (Waste[indexim].fullNameOfCard==tempStack[i].fullNameOfCard)
                {
                    tempStack[i].number=-1;
                }
            }
            printer(wFilem);
        }
        
    }
    else if(Waste[indexim].typeOfCard=='S'){
        if((Sn+1)==Waste[indexim].number){
            Sarray[Sn]=Waste[indexim];
            Sn++;
            Waste[indexim].number=-1;
            for (int i = 0; i < 24; i++)
            {
                if (Waste[indexim].fullNameOfCard==tempStack[i].fullNameOfCard)
                {
                    tempStack[i].number=-1;
                }
            }
            printer(wFilem);
        }
        
    }
    else
    {   outfile.open(wFilem, std::ios_base::app);
        outfile<<" ";
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
        printer(wFilem);
     }
}

void cardAssign(int Source,int index,int lastindexofSource,int Destination,int Destindex){//auxilarry function
    int m=lastindexofSource-index;
    for (int i = 0; i < m+1; i++)
    {
        myMatrix[Destindex+i][Destination]=myMatrix[index+i][Source];
        myMatrix[index+i][Source].number=-1;
    }
    
}
void movePile(int Source,int indexi,int Destination)//That is huge function that moves cards to pile
{
    int lastindexofSource=-1;
    int Destindex=0;
    int startSource=0;
    int temp=0;
    for (int i = 0; i < 20; i++)
    {
        if (myMatrix[i][Source].flag==false)
        {
            startSource++;
        }
        else
            break;
        
    }
    indexi=indexi+startSource;
    lastindexofSource=indexi;

    if(myMatrix[indexi][Source].number==-1 || myMatrix[indexi][Source].flag==false || Source==Destination){
        outfile.open(wFilem, std::ios_base::app);outfile.open(wFilem, std::ios_base::app);
        outfile<<" ";
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
        return;
    }

    for (int i = 0; i < 20; i++)
    {
        if(myMatrix[i][Source].number!=-1){
            lastindexofSource++;
        }
        else
            continue;
    }
    for (int i = 0; i < 20; i++)
    {
        if(myMatrix[i][Destination].number!=-1){
            Destindex++;
        }
        else
            continue;
    }
    
    
    if(myMatrix[indexi][Source].number==-1){
        outfile.open(wFilem, std::ios_base::app);
        outfile<<" ";
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
        return;
    }
    else if(myMatrix[0][Destination].number==-1){
        Destindex=0;
        cardAssign(Source,startSource,lastindexofSource,Destination,Destindex);
        printer(wFilem);
    }
    else if((myMatrix[startSource][Source].number+1)==myMatrix[Destindex-1][Destination].number){
        
        if(myMatrix[startSource][Source].typeOfCard=='D' && myMatrix[Destindex-1][Destination].typeOfCard!='H' && myMatrix[Destindex-1][Destination].typeOfCard!='D')
        {
            cardAssign(Source,startSource,lastindexofSource,Destination,Destindex);
            printer(wFilem);
        }
        else if(myMatrix[startSource][Source].typeOfCard=='H' && myMatrix[Destindex-1][Destination].typeOfCard!='D' && myMatrix[Destindex-1][Destination].typeOfCard!='H')
        {
            cardAssign(Source,startSource,lastindexofSource,Destination,Destindex);
            printer(wFilem);
        }
        else if(myMatrix[startSource][Source].typeOfCard=='C' && myMatrix[Destindex-1][Destination].typeOfCard!='S' && myMatrix[Destindex-1][Destination].typeOfCard!='C')
        {
            cardAssign(Source,startSource,lastindexofSource,Destination,Destindex);
            printer(wFilem);
        }
        else if(myMatrix[startSource][Source].typeOfCard=='S' && myMatrix[Destindex-1][Destination].typeOfCard!='C' && myMatrix[Destindex-1][Destination].typeOfCard!='S')
        {
            cardAssign(Source,startSource,lastindexofSource,Destination,Destindex);
            printer(wFilem);
        }
        else{
            outfile.open(wFilem, std::ios_base::app);
            outfile<<" ";
            outfile<<"Invalid Move!"<<endl;
            outfile.close();
            printer(wFilem);
            return;
        }  
    }
    else{
        outfile.open(wFilem, std::ios_base::app);
        outfile<<" ";
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
        return;
    }
    
}
void moveFoundation(int Destination){//pile to Foundation
    int start=0;
    int end=-1;
    char types;
    for (int i = 0; i < 20; i++)
    {
        if(myMatrix[i][Destination].flag==false){
            start++;
        }
    }
    for (int i = 0; i < 20; i++)
    {
        if(myMatrix[i][Destination].number!=-1){
            end++;
        }
        else
            break;
    }
    types=myMatrix[start][Destination].typeOfCard;
    for (int i = 0; i < (end-start)+1; i++)
    {
       if(types!=myMatrix[start+i][Destination].typeOfCard){
           outfile.open(wFilem, std::ios_base::app);
           outfile<<"\n";
           outfile<<"Invalid Move!"<<endl;
           return;
       }
    }
    if(myMatrix[start][Destination].typeOfCard=='H'){
        for (int i = 0; i < (end-start)+1; i++){
            if((Hn+1)==myMatrix[start+i][Destination].number){
                Harray[Hn]=myMatrix[start+i][Destination];
                Hn++;
            }
        }
    }
    else if(myMatrix[start][Destination].typeOfCard=='C'){
        for (int i = 0; i < (end-start)+1; i++){
            if((Cn+1)==myMatrix[start+i][Destination].number){
                Carray[Cn]=myMatrix[start+i][Destination];
                Cn++;
            }
        }
    }
    else if(myMatrix[start][Destination].typeOfCard=='D'){
        for (int i = 0; i < (end-start)+1; i++){
            if((Dn+1)==myMatrix[start+i][Destination].number){
                Darray[Dn]=myMatrix[start+i][Destination];
                Dn++;
            }
        }
    }
    else if(myMatrix[start][Destination].typeOfCard=='S'){
        for (int i = 0; i < (end-start)+1; i++){
            if((Sn+1)==myMatrix[start+i][Destination].number){
                Sarray[Sn]=myMatrix[start+i][Destination];
                Sn++;
            }
        }
    }
    else
        outfile.open(wFilem, std::ios_base::app);
        outfile<<"Invalid Move!"<<endl;
        outfile.close();
    for (int i = 0; i < (end-start)+1; i++)
    {
        myMatrix[start+i][Destination].number=-1;
    }
    printer(wFilem);
}

void earyExit(){//exit function.
    outfile.open(wFilem, std::ios_base::app);
    outfile<<" ";
    outfile<<"Invalid Move!"<<endl;
    outfile.close();
    exit(0);
}
void VictoryExit(){//if you won that will calling but  in my program broken so no one could call it :(
    if (Harray[Hn-1].number==13 && Carray[Cn-1].number==13 && Darray[Dn-1].number==13 && Sarray[Sn-1].number==13)
    {   
        outfile<<"You Win!"<<endl<<endl;
        earyExit();
    }
    
    
}
