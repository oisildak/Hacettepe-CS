import java.util.ArrayList;

public class Volleyball extends  Sports {
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

    public Volleyball(String team1) {
        this.team1 = team1;
    }

    @Override
    public int totalScore(int winNumber, int tieNumber, int lossNumber) {
        for(int i=0;i<firstScores.size();i++){
            int a1=Integer.parseInt(firstScores.get(i));
            int a2=Integer.parseInt(secondScores.get(i));
            int dif=a1-a2;
            if(dif>=2){
                totalScore+=3;
            }
            else if (dif==1){
                totalScore+=2;
            }
            else if (dif==-1){
                totalScore+=1;
            }
        }
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
