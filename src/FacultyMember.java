public class FacultyMember extends Academician {
    private String name;
    workingHour registerNumber;
    private String position;
    private String startYear;
    private int hoursWork;
    public FacultyMember(String name, workingHour registerNumber, String position, String startYear) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.position = position;
        this.startYear = startYear;
    }

    @Override
    public void overTime_calculator(String week) {//faculty members can get overtime and this method works for
        if(Integer.parseInt(week)>48){
            hoursWork+=8;
        }
        else {
            hoursWork+=Integer.parseInt(week)-40;
        }
    }

    @Override
    public void getSsBenefits() {//benefit calculation acc. to pdf
        ssBenefits=baseSalary*135/100;
    }

    @Override
    public void calculator() {//parsing by week ad calculate total salary
    overTime_calculator(registerNumber.getWeek1());
    overTime_calculator(registerNumber.getWeek2());
    overTime_calculator(registerNumber.getWeek3());
    overTime_calculator(registerNumber.getWeek4());
    getSsBenefits();

    totalSalary=(hoursWork*20)+baseSalary+ssBenefits+(getCurrentYear()-Integer.parseInt(getStartYear()))*20*0.8;
    }
    //getter and setters
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

    public int getHoursWork() {
        return hoursWork;
    }

    public void setHoursWork(int hoursWork) {
        this.hoursWork = hoursWork;
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
