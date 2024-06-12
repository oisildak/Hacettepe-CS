public class Chief extends FullTime {
    private String name;
    workingHour registerNumber;
    private String position;
    private String startYear;
    /*
    chief derived from fulltime and fulltime derived from personal
    chiefs have to work 40 and over also I override overtime method
    sent I use setOverWork and Daily salary method from Fulltime class

     */


    public Chief(String name, workingHour registerNumber, String position, String startYear) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.position = position;
        this.startYear = startYear;
    }

    @Override
    public void overTime_calculator(String week) {//they can max work for 8 hour
        if(Integer.parseInt(week)>48){
            overWork+=8;
        }else {
            overWork+=Integer.parseInt(week)-40;
        }
    }

    @Override
    public void calculator() {
        overTime_calculator(registerNumber.getWeek1());
        overTime_calculator(registerNumber.getWeek2());
        overTime_calculator(registerNumber.getWeek3());
        overTime_calculator(registerNumber.getWeek4());
        setOverWorkSalary(15);//from fulltime class
        setDailySalary(125);//from fulltime
        super.calculator();//and its superclass' method we can call with super keyword
    }
    //getters and setters
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
