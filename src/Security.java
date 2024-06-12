public class Security extends personal {
    private String name;
    workingHour registerNumber;
    private String position;
    private String startYear;
    private int transMoney;
    private int foodMoney;
    private int hourOfWork;
//food and transformation money is unique for this class
    public Security(String name, workingHour registerNumber, String position, String startYear) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.position = position;
        this.startYear = startYear;
    }

    @Override//as you stated in pdf security security different properties they have transformation and food  benefits Also if they does not work in certain hour they can not get pay
    public void overTime_calculator(String week) {
        if(Integer.parseInt(week)>54){
            hourOfWork+=54;
            foodMoney+=6*10;
            transMoney+=6*5;
        }else if(Integer.parseInt(week)>29 && Integer.parseInt(week)<55){
            hourOfWork+=Integer.parseInt(week);
            foodMoney+=6*10;
            transMoney+=6*5;
        }
    }

    @Override
    public void calculator() {//parsing week and calculate the salary
        overTime_calculator(registerNumber.getWeek1());
        overTime_calculator(registerNumber.getWeek2());
        overTime_calculator(registerNumber.getWeek3());
        overTime_calculator(registerNumber.getWeek4());
        totalSalary=(hourOfWork*10)+foodMoney+transMoney+(getCurrentYear()-Integer.parseInt(getStartYear()))*20*0.8;

    }
    //getters and setters
    @Override
    public String getName() {
        return name;
    }

    public int getHourOfWork() {
        return hourOfWork;
    }

    public void setHourOfWork(int hourOfWork) {
        this.hourOfWork = hourOfWork;
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

    public int getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(int transMoney) {
        this.transMoney = transMoney;
    }

    public int getFoodMoney() {
        return foodMoney;
    }

    public void setFoodMoney(int foodMoney) {
        this.foodMoney = foodMoney;
    }
}
