class Queue {
     int[] queue=new int[100];
     int front;
     int rear;
     int capacity;
     int count =0;
     /*
     "front"  is start point of queue
     capacity is capacity of queue and I fixed to 100
     count is helps us to count
     Also there is a important point taking mode of front and rear That helps us to get back to starting
     and its like a circle array not linear
      */

    Queue() {
        capacity=100;
    }

    public void dequeue() {//remove item from queue
        front=(front+1)%capacity;
        count--;
    }

    public void enqueue(int item) {//add item in to queue
        queue[rear]=item;
        rear=(rear+1)%capacity;
        count++;
    }




}