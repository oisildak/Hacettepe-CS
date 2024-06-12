public class ResearchAssistant extends Academician {
    private String name;
    workingHour registerNumber;
    private String position;
    private String startYear;
    /*
    its second derive of personal I could extends directly from personal but this way more proper
    there are  bunch  of getters and setter also I override getssBenefit and calculutate
    */
    public ResearchAssistant(String name, workingHour registerNumber, String position, String startYear) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.position = position;
        this.startYear = startYear;
    }

    @Override
    public void getSsBenefits() {//benefit calculation
        ssBenefits=((baseSalary*105)/100);
    }

    @Override
    public void calculator() {//they haven't got overtime salary so I did not add it
        getSsBenefits();
        totalSalary=baseSalary+ssBenefits+(getCurrentYear()-Integer.parseInt(getStartYear()))*20*0.8;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getStartYear() {
        return startYear;
    }

    @Override
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }
}
