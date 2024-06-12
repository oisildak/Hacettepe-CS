public class PartTime extends Employee {
    private String name;
    workingHour registerNumber;
    private String position;
    private String startYear;
/*
part time one of unique class they work hourly and They have to min 10 hours otherwise they can no get paid
also there is no over time  paid and max hours are limited by 20
 */
    public PartTime(String name, workingHour registerNumber, String position, String startYear) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.position = position;
        this.startYear = startYear;
    }

    @Override
    public void employeeDayTransformation(String hour) {//override from employee and limited acc.to  hours limit
        if(Integer.parseInt(hour)<21 && Integer.parseInt(hour)>9){
            totalHour+=Integer.parseInt(hour);
        }
    }

    @Override
    public void calculator() {//parsing by week and severence pay also added
        employeeDayTransformation(registerNumber.getWeek1());
        employeeDayTransformation(registerNumber.getWeek2());
        employeeDayTransformation(registerNumber.getWeek3());
        employeeDayTransformation(registerNumber.getWeek4());
        totalSalary=totalHour*18+(getCurrentYear()-Integer.parseInt(getStartYear()))*20*0.8;

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

