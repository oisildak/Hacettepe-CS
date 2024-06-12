import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Assigner {

    public static ArrayList<String[]> temp = new ArrayList<>();
    public static ArrayList<workingHour> workingArray = new ArrayList<>();
    public static ArrayList<personal> personalArray = new ArrayList<>();
    public static ArrayList<Officer> officerArrayList = new ArrayList<>();
    public static ArrayList<PartTime> partTimeArrayList = new ArrayList<>();
    public static ArrayList<Worker> workerArrayList = new ArrayList<>();
    public static ArrayList<Chief> chiefArrayList = new ArrayList<>();
    public static ArrayList<Security> securityArrayList = new ArrayList<>();
    public static ArrayList<FacultyMember> facultyMemberArrayList = new ArrayList<>();
    public static ArrayList<ResearchAssistant> researchAssistantArrayList = new ArrayList<>();

/*
my main calculation process is complete here
there are split and assign  by class also we can calculate total salary
 */

    public static void splitfile(String args) {//splitting
        String[] lines = ReadFromFile.readFile(args);
        for (String line : lines) {
            String[] split = line.split("\t");
            temp.add(split);
        }
    }

    public  void assembler(String[] args) throws IOException {//it works like a main method
        splitfile(args[1]);//monitoring.txt splitting and creating working array
        for (int i = 0; i < temp.size(); i++) {
            workingHour a = new workingHour(temp.get(i)[0], temp.get(i)[1], temp.get(i)[2], temp.get(i)[3], temp.get(i)[4]);
            workingArray.add(a);
        }
        temp.clear();
        splitfile(args[0]);//personal.txt splitting and creating personal method
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < workingArray.size(); j++) {
                if (temp.get(i)[1].equals(workingArray.get(j).getRegisterNumber())) {
                    personal b = new personal(temp.get(i)[0], workingArray.get(j), temp.get(i)[2], temp.get(i)[3]);
                    personalArray.add(b);
                }
            }
        }

        for (int i = 0; i < personalArray.size(); i++) {//split to words by words it helps us to figure out which one is which and we can assign these members to each others
            String definetype = personalArray.get(i).registerNumber.getRegisterNumber().split("")[0];
            if (definetype.equals("O")) {
                Office_assigner(personalArray.get(i));
            } else if (definetype.equals("P")) {
                Parttime_assigner(personalArray.get(i));
            } else if (definetype.equals("W")) {
                Worker_assigner(personalArray.get(i));
            } else if (definetype.equals("C")) {
                Chief_assigner(personalArray.get(i));
            } else if (definetype.equals("S")) {
                Security_assigner(personalArray.get(i));
            } else if (definetype.equals("F")) {
                FacultyMember_assigner(personalArray.get(i));
            }else if (definetype.equals("R")) {
                ResearchAssistant_assigner(personalArray.get(i));
            }
        }//they are writing  loops every personal has its unique loop  I could not figure out better way but it works  and it finished at 140.line
        for(int i=0;i<securityArrayList.size();i++){
            FileWriter myfile=new FileWriter(String.format("%s.txt",securityArrayList.get(i).registerNumber.getRegisterNumber()));
            myfile.append("Name"+" : "+securityArrayList.get(i).getName().split(" ")[0]+"\n");
            myfile.append("SurName"+" : "+securityArrayList.get(i).getName().split(" ")[1]+"\n");
            myfile.append("Registiration Number"+" : "+securityArrayList.get(i).registerNumber.getRegisterNumber()+"\n");
            myfile.append("Position"+" : "+securityArrayList.get(i).getPosition()+"\n");
            myfile.append("Year of Start"+" : "+securityArrayList.get(i).getStartYear()+"\n");
            myfile.append("Total Salary"+" : "+securityArrayList.get(i).totalSalary+"0 TL");
            myfile.close();
        }
        for(int i=0;i<officerArrayList.size();i++){
            FileWriter myfile=new FileWriter(String.format("%s.txt",officerArrayList.get(i).registerNumber.getRegisterNumber()));
            myfile.append("Name"+" : "+officerArrayList.get(i).getName().split(" ")[0]+"\n");
            myfile.append("SurName"+" : "+officerArrayList.get(i).getName().split(" ")[1]+"\n");
            myfile.append("Registiration Number"+" : "+officerArrayList.get(i).registerNumber.getRegisterNumber()+"\n");
            myfile.append("Position"+" : "+officerArrayList.get(i).getPosition()+"\n");
            myfile.append("Year of Start"+" : "+officerArrayList.get(i).getStartYear()+"\n");
            myfile.append("Total Salary"+" : "+officerArrayList.get(i).totalSalary+"0 TL");
            myfile.close();
        }
        for(int i=0;i<partTimeArrayList.size();i++){
            FileWriter myfile=new FileWriter(String.format("%s.txt",partTimeArrayList.get(i).registerNumber.getRegisterNumber()));
            myfile.append("Name"+" : "+partTimeArrayList.get(i).getName().split(" ")[0]+"\n");
            myfile.append("SurName"+" : "+partTimeArrayList.get(i).getName().split(" ")[1]+"\n");
            myfile.append("Registiration Number"+" : "+partTimeArrayList.get(i).registerNumber.getRegisterNumber()+"\n");
            myfile.append("Position"+" : "+partTimeArrayList.get(i).getPosition()+"\n");
            myfile.append("Year of Start"+" : "+partTimeArrayList.get(i).getStartYear()+"\n");
            myfile.append("Total Salary"+" : "+partTimeArrayList.get(i).totalSalary+"0 TL");
            myfile.close();
        }
        for(int i=0;i<workerArrayList.size();i++){
            FileWriter myfile=new FileWriter(String.format("%s.txt",workerArrayList.get(i).registerNumber.getRegisterNumber()));
            myfile.append("Name"+" : "+workerArrayList.get(i).getName().split(" ")[0]+"\n");
            myfile.append("SurName"+" : "+workerArrayList.get(i).getName().split(" ")[1]+"\n");
            myfile.append("Registiration Number"+" : "+workerArrayList.get(i).registerNumber.getRegisterNumber()+"\n");
            myfile.append("Position"+" : "+workerArrayList.get(i).getPosition()+"\n");
            myfile.append("Year of Start"+" : "+workerArrayList.get(i).getStartYear()+"\n");
            myfile.append("Total Salary"+" : "+workerArrayList.get(i).totalSalary+"0 TL");
            myfile.close();
        }
        for(int i=0;i<chiefArrayList.size();i++){
            FileWriter myfile=new FileWriter(String.format("%s.txt",chiefArrayList.get(i).registerNumber.getRegisterNumber()));
            myfile.append("Name"+" : "+chiefArrayList.get(i).getName().split(" ")[0]+"\n");
            myfile.append("SurName"+" : "+chiefArrayList.get(i).getName().split(" ")[1]+"\n");
            myfile.append("Registiration Number"+" : "+chiefArrayList.get(i).registerNumber.getRegisterNumber()+"\n");
            myfile.append("Position"+" : "+chiefArrayList.get(i).getPosition()+"\n");
            myfile.append("Year of Start"+" : "+chiefArrayList.get(i).getStartYear()+"\n");
            myfile.append("Total Salary"+" : "+chiefArrayList.get(i).totalSalary+"0 TL");
            myfile.close();
        }
        for(int i=0;i<facultyMemberArrayList.size();i++){
            FileWriter myfile=new FileWriter(String.format("%s.txt",facultyMemberArrayList.get(i).registerNumber.getRegisterNumber()));
            myfile.append("Name"+" : "+facultyMemberArrayList.get(i).getName().split(" ")[0]+"\n");
            myfile.append("SurName"+" : "+facultyMemberArrayList.get(i).getName().split(" ")[1]+"\n");
            myfile.append("Registiration Number"+" : "+facultyMemberArrayList.get(i).registerNumber.getRegisterNumber()+"\n");
            myfile.append("Position"+" : "+facultyMemberArrayList.get(i).getPosition()+"\n");
            myfile.append("Year of Start"+" : "+facultyMemberArrayList.get(i).getStartYear()+"\n");
            myfile.append("Total Salary"+" : "+facultyMemberArrayList.get(i).totalSalary+"0 TL");
            myfile.close();
        }
        for(int i=0;i<researchAssistantArrayList.size();i++){
            FileWriter myfile=new FileWriter(String.format("%s.txt",researchAssistantArrayList.get(i).registerNumber.getRegisterNumber()));
            myfile.append("Name"+" : "+researchAssistantArrayList.get(i).getName().split(" ")[0]+"\n");
            myfile.append("SurName"+" : "+researchAssistantArrayList.get(i).getName().split(" ")[1]+"\n");
            myfile.append("Registiration Number"+" : "+researchAssistantArrayList.get(i).registerNumber.getRegisterNumber()+"\n");
            myfile.append("Position"+" : "+researchAssistantArrayList.get(i).getPosition()+"\n");
            myfile.append("Year of Start"+" : "+researchAssistantArrayList.get(i).getStartYear()+"\n");
            myfile.append("Total Salary"+" : "+researchAssistantArrayList.get(i).totalSalary+"0 TL");
            myfile.close();
        }




    }

//assigner methods every personal type has its unique method to assign it we create a function and we add its object to array list which is unique by personal
    public static void Office_assigner(personal a) {
        Officer b = new Officer(a.getName(), a.registerNumber, a.getPosition(), a.getStartYear());
        b.calculator();
        officerArrayList.add(b);
    }

    public static void Parttime_assigner(personal a) {
        PartTime c = new PartTime(a.getName(), a.registerNumber, a.getPosition(), a.getStartYear());
        c.calculator();
        partTimeArrayList.add(c);
    }

    public static void Worker_assigner(personal a) {
        Worker d = new Worker(a.getName(), a.registerNumber, a.getPosition(), a.getStartYear());
        d.calculator();
        workerArrayList.add(d);
    }

    public static void Chief_assigner(personal a) {
        Chief e = new Chief(a.getName(), a.registerNumber, a.getPosition(), a.getStartYear());
        e.calculator();
        chiefArrayList.add(e);
    }

    public static void Security_assigner(personal a) {
        Security f = new Security(a.getName(), a.registerNumber, a.getPosition(), a.getStartYear());
        f.calculator();
        securityArrayList.add(f);
    }

    public static void FacultyMember_assigner(personal a) {
        FacultyMember g = new FacultyMember(a.getName(), a.registerNumber, a.getPosition(), a.getStartYear());
        g.calculator();
        facultyMemberArrayList.add(g);
    }public static void ResearchAssistant_assigner(personal a) {
        ResearchAssistant k = new ResearchAssistant(a.getName(), a.registerNumber, a.getPosition(), a.getStartYear());
        k.calculator();
        researchAssistantArrayList.add(k);
    }
}
