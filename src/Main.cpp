#include "FunctiosOfDeck.h"
#include <sstream>
//Note: I figure out its c++ 14 please compilte this version.
int main(int argc, char *argv[]){//main but huge mostly long if else because of commad list.
    builder(argv[1]);
    assignerV2();
    wFilem=argv[3];

    stackStarter();
    string commandString;
    ifstream commandFile;
    commandFile.open(argv[2]);
    while (getline(commandFile,commandString))
    {   
        string tempComArr[5];
        int i=0;
        stringstream stringin(commandString);
        while (stringin.good() && i<5)
        {
            stringin>>tempComArr[i];
            i++;
        }
        if(tempComArr[0]=="exit"){
            outfile.open(wFilem, std::ios_base::app);
            for (i = 0; i < 5; i++)
            {
                outfile<<tempComArr[i]<<" ";
            }
            outfile<<endl;
            earyExit();
            outfile<<"****************************************"<<endl;
            outfile.close();
        }
        else if (tempComArr[0]=="move" && tempComArr[1]=="to"&& tempComArr[2]=="foundation"&& tempComArr[3]=="pile")
        {
            int a=(int)tempComArr[4][0]-48;
            moveFoundation(a);
            outfile.open(wFilem, std::ios_base::app);
            for (i = 0; i < 5; i++)
            {
                outfile<<tempComArr[i]<<" ";
            }
            outfile<<endl;
            
            VictoryExit();
            outfile<<"****************************************"<<endl;
            outfile.close();
        }
        else if(tempComArr[0]=="open" && tempComArr[1]!="waste" && tempComArr[1]!="from"){
            int a=(int)tempComArr[1][0]-48;
            openPile(a);
            outfile.open(wFilem, std::ios_base::app);
            for (i = 0; i < 5; i++)
            {
                outfile<<tempComArr[i]<<" ";
            }
            outfile<<endl;
            outfile<<"****************************************"<<endl;
            outfile.close();
        }
        else if(tempComArr[0]=="move" && tempComArr[1]=="pile"){
            int a=(int)tempComArr[2][0]-48;
            int b=(int)tempComArr[3][0]-48;
            int c=(int)tempComArr[4][0]-48;
            movePile(a,b,c);
            outfile.open(wFilem, std::ios_base::app);
            for (i = 0; i < 5; i++)
            {
                outfile<<tempComArr[i]<<" ";
            }
            outfile<<endl;
            outfile<<"****************************************"<<endl;
            outfile.close();
            
        }
        else if(tempComArr[0]=="open" && tempComArr[1]=="from" && tempComArr[2]=="stock"){
            
            openStack();
            outfile.open(wFilem, std::ios_base::app);
            for (i = 0; i < 5; i++)
            {
                outfile<<tempComArr[i]<<" ";
            }
            outfile<<endl;
            outfile<<"****************************************"<<endl;
            outfile.close();
        }
        else if(tempComArr[0]=="move"&& tempComArr[1]=="waste"){
            int a=(int)tempComArr[2][0]-48;
            moveWasteToPile(a);
            outfile.open(wFilem, std::ios_base::app);
            for (i = 0; i < 5; i++)
            {
                outfile<<tempComArr[i]<<" ";
            }
            outfile<<endl;
            outfile<<"****************************************"<<endl;
            outfile.close();
        }
        else if(tempComArr[0]=="move"&& tempComArr[1]=="to" && tempComArr[2]=="foundation"&&tempComArr[3]=="waste"){
            moveWasteToFoundation();
            outfile.open(wFilem, std::ios_base::app);
            for (i = 0; i < 5; i++)
            {
                outfile<<tempComArr[i]<<" ";
            }
            outfile<<endl;
            VictoryExit();
            outfile<<"****************************************"<<endl;
            outfile.close();
            
        }
        else{
            outfile.open(wFilem, std::ios_base::app);
            for (i = 0; i < 5; i++)
            {
                outfile<<tempComArr[i]<<" ";
            }
            outfile<<endl;
            outfile<<"Big error"<<endl;
            outfile<<"****************************************"<<endl;
            outfile.close();
        }
    }
    
    


    
}
