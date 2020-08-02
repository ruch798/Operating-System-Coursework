import java.util.Scanner;

class Main
{
static class philosopher extends Thread
  {
   public int num; 
  public philosopher(int num){
     this.num=num;
   } 
   public int getnum(){
     return num;
   }
   public void run(){
     while(true){
       int x;
       x=getnum();
       System.out.println(Thread.currentThread().getName()+"Thinking");
      semwaitRoom(room);
      
      semwait(x%nop);
       System.out.println("  "+Thread.currentThread().getName()+"Chopstick "+x%nop+" acquired");

       semwait((x+1)%nop);
       System.out.println("   "+Thread.currentThread().getName()+"Chopstick "+(x+1)%nop+" acquired");

       System.out.println(Thread.currentThread().getName()+"Eating");

      System.out.println("  "+Thread.currentThread().getName()+"Chopstick "+(x+1)%nop+" released");
       semsignal((x+1)%nop);

       System.out.println("   "+Thread.currentThread().getName()+"Chopstick "+x%nop+" released");
       semsignal(x%nop);

       semsignalRoom(room);

      try{
        Thread.currentThread().sleep(3000);
       }catch (Exception e){}
     }
  }  
 }

 public static int chopstickstatus[];
 public static int nop,value=0;
 public static int room;
public static void semwaitRoom(int room){
   if(room<=0){
     System.out.println("Maximum number of philosophers in the room");
     while(room==0);
   }
   else{
     room-=room-1;
   }  
 }


 public static void semwait(int s){

   if(chopstickstatus[s]<=0){
     System.out.println(Thread.currentThread().getName()+"Chopstick "+s+" unavailable");
     while(chopstickstatus[s]==0);
   }
   else{
     chopstickstatus[s]=chopstickstatus[s]-1;
   }  
 }
public static void semsignalRoom(int room){
   room+=room;
 }
 public static void semsignal(int s){
   chopstickstatus[s]=chopstickstatus[s]+1;
 }

 public static void main(String[] args){
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the number of Philosphers");
   nop=sc.nextInt();
   room = nop-1;
   chopstickstatus=new int[nop];

   for(int i=0;i<nop;i++){
     chopstickstatus[i]=1;
   }
   philosopher p[]=new philosopher[nop];
   String name="";
   for(int i=0;i<nop;i++){
     p[i]=new philosopher(i);
     name="Philospher "+Integer.toString(i)+":";
     p[i].setName(name);
   }  

  for(int i=0;i<nop;i++){
     p[i].start();
   }
 }
}



