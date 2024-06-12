import java.util.ArrayList;

public class Basketball extends  Sports {
    String team1;
    ArrayList<String> firstScores=new ArrayList<>();
    ArrayList<String> secondScores=new ArrayList<>();
    public int getForSet() {
        return forSet;
    }

    public void setForSet(int forSet) {
        this.forSet = forSet;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public Basketball(String team1) {
        this.team1 = team1;
    }

    @Override
    public int totalScore(int winNumber, int tieNumber, int lossNumber) {
        int tempwinNumber=winNumber*2;
        int tempLossNumber=lossNumber*1;
        int tempTieNumer=0;
        totalScore=tempwinNumber+tempTieNumer+tempLossNumber;
        return totalScore;
    }

    @Override
    public void winNumber(ArrayList<String> firstScores, ArrayList<String> secondScores) {
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

    @Override
    public int forSet(ArrayList<String> firstScores) {
        return super.forSet(firstScores);
    }

    @Override
    public int againstSet(ArrayList<String> secondScores) {
        return super.againstSet(secondScores);
    }
}
