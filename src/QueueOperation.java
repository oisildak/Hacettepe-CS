import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
/*
Its like Stack Operation Class But There are small differences between them
 */
public class QueueOperation {
    public static void QueueOperation(String args) throws IOException {
        Random rand = new Random();
        Queue queue = new Queue();
        String[] lines = ReadFromFile.readFile("queue.txt");//I am starting reading queue.txt in there and split it
        for (String line : lines) {
            String[] split = line.split("\\s+");
            for (String item : split) {
                queue.enqueue(Integer.parseInt(item));
            }
        }

        FileWriter file = new FileWriter("queueOut.txt");//in there I start to write queue.txt
        String[] commandLines = ReadFromFile.readFile(args);
        for (String line : commandLines) {
            String[] split = line.split("\\s+");
            if (split[0].equals("Q")) {//Splitting command.txt acc. to Q which is stands for queue
                if (split[1].equals("addOrRemove")) {//In there if its positive I add to queue else I am removing from queue
                    file.append("After addOrRemove " + split[2] + ":\n");
                    int temp = Integer.parseInt(split[2]);
                    if (temp < 0) {
                        for (int i = 0; i < Math.abs(temp); i++) {
                            queue.dequeue();
                        }
                    } else {
                        for (int i = 0; i < (Integer.parseInt(split[2])); i++) {
                            queue.enqueue(rand.nextInt(51));
                        }
                    }
                    for (int i = 0; i<queue.count; i++) {
                        file.append(String.format("%d ",queue.queue[(queue.front+i)%100]));//I am taking mode of this because In this way I can create A circle and that helps me to create loop and I can reach the value
                    }
                    file.append("\n");
                }
                if (split[1].equals("calculateDistance")){
                    file.append("After calculateDistance: \n");
                    int totalDistance=0;
                    for (int i = 0; i<queue.count; i++){
                        for (int j = i+1; j<queue.count; j++){//two loops help me to calculate to distance between items
                            totalDistance+=Math.abs(queue.queue[queue.front+i]-queue.queue[queue.front+j]);
                        }
                    }
                    file.append("Total distance="+totalDistance+"\n");
                }if (split[1].equals("sortElements")){
                    file.append("After sortElements:\n");
                    ArrayList<Integer> temp=new ArrayList<>();//I created one temporary array list to store values and that helps me to do operations
                    for (int i = 0; i<queue.count; i++){
                        temp.add(queue.queue[queue.front+i]);
                    }
                    Collections.sort(temp);//sorting
                    int range=queue.count;
                    for (int i = 0; i <range; i++) {// between 70 and 75 I clear all value's of queue and re-set all values of queue I used that multiple times in this class
                        queue.dequeue();
                    }
                    queue.rear=0;
                    queue.front=0;
                    queue.count =0;
                    for (int i=0;i<temp.size();i++){
                        queue.enqueue(temp.get(i));
                    }for (int i = 0; i < queue.count; i++) {
                        file.append(String.format("%d ", queue.queue[(queue.front+i)%100]));
                    }
                    file.append("\n");

                    temp.clear();
                }if (split[1].equals("removeGreater")){
                    file.append("After removeGreater "+split[2]+" :\n");
                    ArrayList<Integer> tempRemove=new ArrayList<>();
                    for (int i = 0; i<queue.count; i++){
                        tempRemove.add(queue.queue[queue.front+i]);
                    }
                    int range=queue.count;
                    for (int i = 0; i <range; i++) {
                        queue.dequeue();
                    }
                    queue.rear=0;
                    queue.front=0;
                    queue.count =0;
                    for (Integer integer : tempRemove) {
                        if (integer <= Integer.parseInt(split[2])) {//that part provides the  condition of command.txt
                            queue.enqueue(integer);
                        }
                    }
                    for (int i = 0; i<queue.count; i++){
                        file.append(String.format("%d ", queue.queue[(queue.front+i)%100]));
                    }
                    file.append("\n");
                    tempRemove.clear();
                }
                if (split[1].equals("distinctElements")){
                    file.append("After distinctElements:\n");
                    HashSet<Integer> tempHashset=new HashSet<>();
                    for (int i = 0; i<queue.count; i++){
                        tempHashset.add(queue.queue[queue.front+i]);
                    }
                    int range=queue.count;
                    for (int i = 0; i <range; i++) {
                        queue.dequeue();
                    }
                    queue.rear=0;
                    queue.front=0;
                    queue.count =0;

                    for (Integer integer : tempHashset) {
                        queue.enqueue(integer);
                    }
                    file.append("Total distinct element="+(queue.count)+"\n");
                    tempHashset.clear();

                }if (split[1].equals("reverse")) {//in this part I split stack to 3 array list one of them holds reserve part which was splitting acc. to command.txt other one is holding rest of stack

                    file.append("After reverse " + split[2] + ":\n");//After the split I re push in to 3.array list  but reserve array pushing array reverse version of it.
                    int reserve = Integer.parseInt(split[2]) - 1;//Then I enqueue to queue
                    ArrayList<Integer> reserveArray = new ArrayList<>();
                    ArrayList<Integer> tempReserve = new ArrayList<>();
                    ArrayList<Integer> lastTemp = new ArrayList<>();

                    try{
                        for (int i = 0; i < queue.count; i++){
                            tempReserve.add(queue.queue[queue.front+i]);

                        }
                        for (int i=0;i<reserve+1;i++){
                            reserveArray.add(tempReserve.get(i));
                        }

                        int range=queue.count;
                        for (int i = 0; i <range; i++) {
                            queue.dequeue();
                        }
                        queue.rear=0;
                        queue.front=0;
                        queue.count =0;

                        for (int i=0;i<tempReserve.size()-(reserve+1);i++){
                            lastTemp.add(tempReserve.get((tempReserve.size()-1)-i));

                        }
                        for (int i=0;i<reserveArray.size();i++){
                            lastTemp.add(reserveArray.get(i));
                        }
                        for (int i=0;i<lastTemp.size();i++){
                            queue.enqueue(lastTemp.get((lastTemp.size()-1)-i));
                        }
                    }catch (Exception ignored){

                    }

                    for (int i = 0; i < queue.count; i++) {
                        file.append(String.format("%d ",queue.queue[(queue.front+i)%100]));
                    }
                    file.append("\n");
                }

                }

            }
        file.close();
        FileWriter fileWriter=new FileWriter("queue.txt");//in this part I am updating queue.txt
        for (int i = 0; i < queue.count; i++) {
            fileWriter.append(String.format("%d ",queue.queue[(queue.front+i)%100]));
        }
        fileWriter.close();


    }

}
