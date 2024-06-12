public class FullTime extends Employee {
    protected int overWork;
    protected int dailySalary;
    protected int overWorkSalary;
//class has not got a object but it will derived to workers and chief
    public FullTime(){//empty const.
    }
    @Override
    public void overTime_calculator(String week) {
        if(Integer.parseInt(week)>50){
            overWork+=10;
        }else {
            overWork+=Integer.parseInt(week)-40;
        }
    }

    @Override
    public void calculator() {
        totalSalary+=(dailySalary*5*4)+(overWorkSalary*overWork)+(getCurrentYear()-Integer.parseInt(getStartYear()))*20*0.8;
    }
//getter and setters
    public int getOverWork() {
        return overWork;
    }

    public void setOverWork(int overWork) {
        this.overWork = overWork;
    }

    public int getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(int dailySalary) {
        this.dailySalary = dailySalary;
    }

    public int getOverWorkSalary() {
        return overWorkSalary;
    }

    public void setOverWorkSalary(int overWorkSalary) {
        this.overWorkSalary = overWorkSalary;
    }
}

