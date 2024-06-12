public class tests extends  examinationDecarator {

    public tests(examClass examination) {
        super(examination);
    }

    @Override
    public String operationName() {
        System.out.println("tests");
        return examination.operationName();
    }

    @Override
    public double getCost() {
        return examination.getCost() + 7;
    }
}
