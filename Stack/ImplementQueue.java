package Stack;


class Queue
{
    int [] queue ;
    int rear = 0 ;
    int front = 0 ;
    int size = 0 ;
    public Queue( int n )
    {
        this.queue = new int[n];
    }

   public void add(int num)
   {
       if(size==queue.length)
       {
           System.out.println("Queue Overflow");
       }
       else
       {
           rear = rear% queue.length;
           queue[rear]=num ;
           rear++;
           size++;
       }
   }


   public int remove()
   {
       if(size==0) {
           System.out.println("Nothing to remove");
           return -1;
       }
       else {
           front = front% queue.length ;
           int val = queue[front];
           front++;
           size--;
           return val ;
       }
   }

   public int peek()
   {
       if(size==0)
       {
           System.out.println("Nothing to peek");
           return -1;
       }
       else
       {
           return queue[front%queue.length];
       }
   }

   public int getSize()
   {
        return  size ;
   }

   public void display()
   {
      for(int i = 0 ; i<size ; i++)
      {
          int index = (front+i)%queue.length ;
          System.out.println(queue[index]+" ");
      }
   }

}


public class ImplementQueue {

    public static void main(String[] args) {
        Queue que = new Queue(8);
        que.add(2);
        que.add(5);
        que.add(7);
        que.add(8);
        que.add(9);
        que.add(10);
        que.add(11);
        que.add(13);
        que.add(15);
        que.display();
        que.remove();
        que.remove();
        que.add(14);
        que.display();

    }


}
