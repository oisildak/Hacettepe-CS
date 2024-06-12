public class outpatient extends examinationDecarator {


    public outpatient(examClass examination) {
        super(examination);
    }

    @Override
    public String operationName() {
        System.out.println("outpatient");
        return examination.operationName();
    }

    @Override
    public double getCost() {
        return examination.getCost() + 15;
    }
}
