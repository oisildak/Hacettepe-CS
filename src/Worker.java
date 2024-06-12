public class Worker extends FullTime {
    private String name;
    workingHour registerNumber;
    private String position;
    private String startYear;
/*
    They similar to chief class because their superclass same who is Full time
    Workers have to work min 40 hour and they can gain overtime benefits



 */

    public Worker(String name, workingHour registerNumber, String position, String startYear) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.position = position;
        this.startYear = startYear;
    }

    @Override
    public void overTime_calculator(String week) {//Full time's method I call it with super key word
        super.overTime_calculator(week);
    }

    @Override
    public void setOverWorkSalary(int overWorkSalary) {//Full time's method I call it with super key word
        super.setOverWorkSalary(overWorkSalary);
    }

    @Override
    public void setDailySalary(int dailySalary) {//Full time's method I call it with super key word
        super.setDailySalary(dailySalary);
    }
//and parsing by week and calculation
    @Override
    public void calculator() {
        overTime_calculator(registerNumber.getWeek1());
        overTime_calculator(registerNumber.getWeek2());
        overTime_calculator(registerNumber.getWeek3());
        overTime_calculator(registerNumber.getWeek4());
        setOverWorkSalary(11);
        setDailySalary(105);
        super.calculator();
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
