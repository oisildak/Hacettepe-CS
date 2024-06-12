import java.util.ArrayList;

public class IceHokey extends  Sports {
    String team1;
    int totalScore=0;
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

    @Override
    public int totalScore(int winNumber, int tieNumber, int lossNumber) {//calculate totalscore
        int tempwinNumber=winNumber*3;
        int tempLossNumber=lossNumber*0;
        int tempTieNumer=tieNumber*1;
        totalScore=tempwinNumber+tempTieNumer+tempLossNumber;
        return totalScore;
    }

    @Override
    public void winNumber(ArrayList<String> firstScores, ArrayList<String> secondScores) {
        super.winNumber(firstScores, secondScores);
    }

    @Override
    public int forSet(ArrayList<String> firstScores) {
        super.forSet(this.firstScores);
        return forSet;
    }

    @Override
    public int againstSet(ArrayList<String> secondScores) {
        super.againstSet(secondScores);
        return againstSet;
    }

    public IceHokey(String team1) {
        this.team1 = team1;
    }

}
