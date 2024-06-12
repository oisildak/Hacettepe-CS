public class examinationDecarator extends  examClass {
    protected  examClass examination;

    public examinationDecarator(examClass examination) {
        this.examination = examination;
    }

    @Override
    public String operationName() {
        return null;
    }

    @Override
    public double getCost() {
        return 0;
    }
}
