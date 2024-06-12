import java.util.ArrayList;

public class Handball extends  Sports {
    String team1;


    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getForSet() {
        return forSet;
    }

    public void setForSet(int forSet) {
        this.forSet = forSet;
    }

    ArrayList<String> firstScores=new ArrayList<>();
    ArrayList<String> secondScores=new ArrayList<>();

    public Handball(String team1) {
        this.team1 = team1;
    }

    @Override
    public int totalScore(int winNumber, int tieNumber, int lossNumber) {
        int tempwinNumber=winNumber*2;
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
        return super.forSet(firstScores);
    }

    @Override
    public int againstSet(ArrayList<String> secondScores) {
        return super.againstSet(secondScores);
    }
}
