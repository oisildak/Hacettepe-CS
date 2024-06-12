import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

/*
That class and its functions split file and doing operation on it.

 */
public class StackOperation {
    public static void StackOperation(String args) throws IOException {
        Random rand = new Random(); //instance of random class

        ArrayList<Integer> integerArrayList=new ArrayList<>();
        Stack stack = new Stack();
        String[] lines = ReadFromFile.readFile("stack.txt");//I am starting to reading in there
        for (String line : lines) {
            String[] split = line.split("\\s+");
            for (String item : split) {
                integerArrayList.add(Integer.parseInt(item));
            }
        }
        for (int i=0;i<integerArrayList.size();i++){
            stack.push(integerArrayList.get((integerArrayList.size()-1)-i));
        }


        FileWriter myfile=new FileWriter("stackOut.txt");//and in there I am starting to write file
        String[] commandLines = ReadFromFile.readFile(args);
        for (String line : commandLines) {
            String[] split = line.split("\\s+");
            if (split[0].equals("S")){//In there I split file to S which stands for stack
                if (split[1].equals("addOrRemove")){//it is like switch-case but I prefer use if also In there if its positive I add to stack else I am removing from stack
                    myfile.append("After addOrRemove "+split[2]+":\n");
                    int temp=Integer.parseInt(split[2]);
                    if (temp<0){

                        for (int i=0;i<Math.abs(temp);i++){//it works like range
                            stack.pop();
                        }
                    }else {
                        for (int i=0;i<(Integer.parseInt(split[2]));i++){
                            stack.push(rand.nextInt(51));//That helps me to limit bound between 0-50
                        }
                    }
                    for (int i = 0; i<stack.first+1; i++){
                        myfile.append(String.format("%d ",stack.ints[stack.first-i]));//to print true format I used it
                    }
                    myfile.append("\n");
                }
             if (split[1].equals("calculateDistance")){
                 myfile.append("After calculateDistance: \n");
                 int totalDistance=0;
                 for (int i=0;i<stack.first+1;i++){//These 2 loops helps me to calculate to distance and I have used Math.absolute
                     for (int j=i+1;j<stack.first+1;j++){
                         totalDistance+=Math.abs(stack.ints[i]-stack.ints[j]);
                     }
                 }
                 myfile.append("Total distance="+totalDistance+"\n");
             }
             if (split[1].equals("sortElements")){
                 myfile.append("After sortElements:\n");
                 ArrayList<Integer> temp=new ArrayList<>();
                 for (int i=0;i<stack.first+1;i++){
                     temp.add(stack.ints[i]);
                 }
                 Collections.sort(temp);//I sort according to Collections' sort
                 int range=stack.first+1;
                 for (int i = 0; i <range; i++) {//and There I cleared whole stack in order to push again
                     stack.pop();
                 }
                for (int i=0;i<temp.size();i++){
                     stack.push(temp.get(i));
                 }for (int i = 0; i < stack.first + 1; i++) {
                     myfile.append(String.format("%d ", stack.ints[stack.first - i]));
                 }
                 myfile.append("\n");

                temp.clear();
             }
             if (split[1].equals("removeGreater")){
                 myfile.append("After removeGreater "+split[2]+" :\n");
                 ArrayList<Integer> tempRemove=new ArrayList<>();//nearly same as sort elements part
                 for (int i=0;i<stack.first+1;i++){
                     tempRemove.add(stack.ints[i]);
                 }
                 int range=stack.first+1;
                 for (int i = 0; i <range; i++) {
                     stack.pop();
                 }
                 for (Integer integer : tempRemove) {
                     if (integer <= Integer.parseInt(split[2])) {//that part provides the  condition of command.txt
                         stack.push(integer);
                     }
                 }
                 for (int i = 0; i<stack.first+1; i++){
                     myfile.append(String.format("%d ",stack.ints[stack.first-i]));
                 }
                 myfile.append("\n");
                 tempRemove.clear();
             }
            if (split[1].equals("distinctElements")){
                myfile.append("After distinctElements:\n");//in that part it I added them into hashSet then I re push into stack
                HashSet<Integer> tempHashset=new HashSet<>();
                for (int i=0;i<stack.first+1;i++){
                    tempHashset.add(stack.ints[i]);
                }
                int range=stack.first+1;
                for (int i = 0; i <range; i++) {
                    stack.pop();
                }
                for (Integer integer : tempHashset) {
                    stack.push(integer);
                }
                myfile.append("Total distinct element="+(stack.first+1)+"\n");
                tempHashset.clear();

            }
            if (split[1].equals("reverse")) {

                myfile.append("After reverse " + split[2] + ":\n");//in this part I split stack to 2 arraylist one of them holds reserve part which was splitting acc. to command.txt other one is holding rest of stack
                int reserve = Integer.parseInt(split[2]) - 1;//After the split I re push in to stack but reserve array pushing array reverse version of it.
                ArrayList<Integer> reserveArray = new ArrayList<>();
                ArrayList<Integer> tempReserve = new ArrayList<>();
                try {
                    for (int i = 0; i < stack.first + 1; i++){
                        tempReserve.add(stack.ints[stack.first - i]);
                    }
                    for (int i=0;i<reserve+1;i++){
                        reserveArray.add(tempReserve.get(i));
                    }
                    int range=stack.first+1;
                    for (int i = 0; i <range; i++) {
                        stack.pop();
                    }

                    for (int i=0;i<tempReserve.size()-(reserve+1);i++){
                        stack.push(tempReserve.get((tempReserve.size()-1)-i));

                    }
                    for (int i=0;i<reserveArray.size();i++){
                        stack.push(reserveArray.get(i));
                    }
                }catch (Exception ignored){

                }

                for (int i = 0; i < stack.first + 1; i++) {
                    myfile.append(String.format("%d ", stack.ints[stack.first - i]));
                }
                myfile.append("\n");
            }

            }
        }
        myfile.close();
        FileWriter filem=new FileWriter("stack.txt");//in this part I override stack.txt
        for (int i = 0; i < stack.first + 1; i++) {
            filem.append(String.format("%d ", stack.ints[stack.first - i]));
        }filem.close();



    }

}
