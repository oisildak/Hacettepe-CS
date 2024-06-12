public class measurements extends  examinationDecarator {

    public measurements(examClass examination) {
        super(examination);
    }

    @Override
    public String operationName() {
        System.out.println("measurements");
        return examination.operationName();
    }

    @Override
    public double getCost() {
        return examination.getCost() + 5;
    }
}
