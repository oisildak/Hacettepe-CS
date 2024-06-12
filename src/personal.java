public class personal {
    private String name;
    workingHour registerNumber;
    private String position;
    private String  startYear;
    protected int baseSalary=2600;
    public double totalSalary;
    private int currentYear=2020;
/*personal is a superclass all classes are derived from personal class also derived classes are derived so it means there are second derived classes
Ex. what are  derived classes these are Academician-->FacultyMember and ResearchAssistant and so on...
there are certain values which are current year and base salary  also  you can change it.
also there are bunch of getters and setters method
  */
    public personal(){//empty constructor to avoid compile errors
    }
    public personal(String name, workingHour registerNumber, String position, String startYear) {//our second constructor that assign value to persona and it helps later
        this.name = name;
        this.registerNumber = registerNumber;
        this.position = position;
        this.startYear = startYear;
    }

    public void overTime_calculator(String week){//it name is overTime calculator but I used it calculate overtime and parse weeks
        totalSalary+=Integer.parseInt(week);
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }


    public void calculator(){//calculates the salary I could add  severancePay but when I printed it there is too much decimal and I figure out it that way does not work so I did not add them in to this method
        totalSalary+=baseSalary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }
}
