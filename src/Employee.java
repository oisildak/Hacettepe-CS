public class Employee extends personal {
    int totalHour;
    int perHourSalary;
    public Employee(){
    }
    @Override
    public void overTime_calculator(String week) {
        super.overTime_calculator(week);
    }
    public void employeeDayTransformation(String hour){//it helps us calculate total hour bc subclass worked for hourly
        totalHour+=Integer.parseInt(hour);
    }
    @Override
    public void calculator() {
        super.calculator();
    }
}
//it takes from personal's methods