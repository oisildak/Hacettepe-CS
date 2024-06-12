import java.util.ArrayList;

public class Sports {//first class our superclass and whole class derivate from this except team and readfromfile
    Team team1;//there just inital point and they help us to derivate
    int winNumber=0;
    int tieNumber=0;
    int lossNumber=0;
    int forSet=0;
    int againstSet=0;
    int totalScore=0;
    ArrayList<String> firstScores;
    ArrayList<String> secondScores;
    public int totalScore(int winNumber,int tieNumber,int lossNumber){//calculate total number
        int tempwinNumber=winNumber*3;
        int tempLossNumber=lossNumber*0;
        int tempTieNumer=tieNumber*1;
        totalScore=tempwinNumber+tempTieNumer+tempLossNumber;
        return totalScore;
    }
    public void winNumber(ArrayList<String> firstScores,ArrayList<String> secondScores){//to decide who is winner
        for(int i=0;i<firstScores.size();i++){
            int a1=Integer.parseInt(firstScores.get(i));
            int a2=Integer.parseInt(secondScores.get(i));
            if(a1>a2){
                winNumber+=1;
            }
        else if (a1<a2){
            lossNumber+=1;
            }
        else if (a1==a2){
            tieNumber+=1;
            }
        }

        }

    public int forSet(ArrayList<String> firstScores){
        for(int i=0;i<firstScores.size();i++){
            forSet+=Integer.parseInt(firstScores.get(i));
        }
        return forSet;
    }
    public int againstSet(ArrayList<String> secondScores) {
        for (int i = 0; i < secondScores.size(); i++) {
            againstSet += Integer.parseInt(secondScores.get(i));
        }
        return againstSet;
    }






}
