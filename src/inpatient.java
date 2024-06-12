public class inpatient extends examinationDecarator {


    public inpatient(examClass examination) {
        super(examination);
    }

    @Override
    public String operationName() {
        System.out.println("inpatient");
        return examination.operationName();
    }

    @Override
    public double getCost() {
        return examination.getCost() + 10;
    }
}
