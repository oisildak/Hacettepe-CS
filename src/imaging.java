public class imaging extends examinationDecarator {

    public imaging(examClass examination) {
        super(examination);
    }

    @Override
    public String operationName() {
        System.out.println("imaging");
        return examination.operationName();
    }

    @Override
    public double getCost() {
        return examination.getCost() + 10 ;
    }
}
