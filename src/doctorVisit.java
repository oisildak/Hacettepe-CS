public class doctorVisit extends  examinationDecarator {
    public doctorVisit(examClass examination) {
        super(examination);
    }

    @Override
    public String operationName() {
        System.out.println("Doctor Visit");
        return examination.operationName();
    }

    @Override
    public double getCost() {
        return  examination.getCost()+15;
    }
}
