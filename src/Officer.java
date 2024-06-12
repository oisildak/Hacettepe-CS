import java.util.ArrayList;

public class Officer extends personal {
    private String name;
    workingHour registerNumber;
    private String position;
    private String startYear;
    private int overTime;
/*
Officer derived from personal also  officer has unique methods I override the overtime method and calculation method because
they are unique
*/
    public Officer(String name, workingHour registerNumber, String position, String startYear) {//const. of officer
        this.name = name;
        this.registerNumber = registerNumber;
        this.position = position;
        this.startYear = startYear;
    }

    @Override
    public void overTime_calculator(String week) {//I override this method to calculate properly
        if(Integer.parseInt(week)>50){
            overTime+=10;
        }
        else if(Integer.parseInt(week)>39 &&Integer.parseInt(week)<50 ){
            overTime+=Integer.parseInt(week)-40;
        }

    }

    @Override
    public void calculator() {//I parsed weeks by weeks using overtime method and I add ssBenefit and severancePay
        overTime_calculator(registerNumber.getWeek1());
        overTime_calculator(registerNumber.getWeek2());
        overTime_calculator(registerNumber.getWeek3());
        overTime_calculator(registerNumber.getWeek4());
        totalSalary+=overTime*20;
        totalSalary+=super.baseSalary+(getCurrentYear()-Integer.parseInt(getStartYear()))*20*0.8;
        totalSalary+=super.baseSalary*65/100;
    }
    //and getters and setters
    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
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
