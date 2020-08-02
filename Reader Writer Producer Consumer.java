Reader Writer
import java.util.Scanner;
class Main
{
 static class reader extends Thread
 {
   public int num;   
   public reader(int num){
     this.num=num;
   }
   public int getnum(){
     return num;
   }
   public void run(){
     while(true){
       int x;
       x=getnum();
       semwaitReader();
      
       readcount++;
       if(readcount==1){
         semwaitWriter();
       }
       semsignalReader();       
       System.out.println(Thread.currentThread().getName()+"Reading file");

       semwaitReader();

       readcount--;
       if(readcount==0){
         semsignalWriter();
       }

       semsignalReader();
      
       try{
         Thread.sleep(3000);
       }catch(Exception e){}
     }
   }  
 }

 static class writer extends Thread
 {
   public int num; 
   public writer(int num){
     this.num=num;
   } 
   public int getnum(){
     return num;
   }
   public void run(){
     while(true){
       semwaitWriter();
       System.out.println(Thread.currentThread().getName()+"Writing to file");
       semsignalWriter();
       try{
         Thread.sleep(2000);
       }catch(Exception e){}
     }
   }
 }
  public static int semw,semr, readcount;
 public static int numr,numw;

 public static void semwaitWriter(){
   if(semw<=0){
     System.out.println(Thread.currentThread().getName()+"Cannot access file.");
     try{
       Thread.sleep(1000);
     }catch(Exception e){}
     while(semw==0);
   }
   else{
     semw= semw-1;
   }  
 }

 public static void semwaitReader(){
   if(semr<=0){
     System.out.println(Thread.currentThread().getName()+"Cannot access memory");
     try{
       Thread.sleep(1000);
     }catch(Exception e){}
     while(semr==0);
   }
   else{
     semr = semr -1;
   }  
 }

 public static void semsignalWriter(){
   semw = semw + 1;
 }

 public static void semsignalReader(){
   semr = semr + 1;;
 }

 public static void main(String args[]){
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the number of readers and writers");
   numr=sc.nextInt();
   numw=sc.nextInt();
   reader r[]=new reader[numr];
   writer w[]=new writer[numw];

   String name="";
   for(int i=0;i<numr;i++){
     r[i]=new reader(i);
     name="Reader "+Integer.toString(i)+":";
     r[i].setName(name);
   }

   name="";
   for(int i=0;i<numw;i++){
     w[i]=new writer(i);
     name="Writer "+Integer.toString(i)+":";
     w[i].setName(name);
   }

   semw=1; semr=1;readcount=0;

   for(int i=0;i<numr||i<numw;i++){
     if(i<numr)
       r[i].start();
     if(i<numw)
       w[i].start();
   }
 }
}




Producer Consumer

import java.util.*;
public class Main
{
  public static void semwait(int s)
  { 
    if(s<=0)
      {
   	System.out.println("Critical section occupied.");
   	while(s<=0);
      }
    else
    { 
      s=s-1;
    }
  }

  public static void semsignal(int s)
  {
    s=s+1;
  }

  public static int s,n;
  public static int in,out;
  public static int val=0;
  public static int queue[];

  public static void produce()
  {
    Random rn=new Random();
    int x;
    while(true)
    {
      if((in+1)%n==out)
      {
        System.out.println("Queue full. Producer waits");
   	   try
          {
            Thread.sleep(1000);
          }catch(Exception e){}
      }
      else
      {
        semwait(s);
        val++;
        queue[in]=val;
        System.out.println("Producer produced :"+queue[in]);
        in=(in+1)%n;
        semsignal(s);
        x=rn.nextInt();
        if(x>5)
        {
          try
          {
            Thread.sleep(1000);
          }catch(Exception e){}
        }
      }
    }
   }

  public static void consume()
  {
    Random rn=new Random();
    int y;
    int value=0;
    while(true)
    {
      if(in==out)
      {
        System.out.println("Queue Empty. Consumer waits");
        try
          {
            Thread.sleep(1000);
          }catch(Exception e){}
      }
      else
      {
        semwait(s);
        value=queue[out];
        System.out.println("Consumer consumed :"+queue[out]);
        queue[out]=-1;
        out=(out+1)%n;
        semsignal(s);
        y=rn.nextInt();
        if(y>5)
        {
          try
          {
            Thread.sleep(1000);
          }catch(Exception e){}
        }
      }
     }
  }

  public static void main(String args[]) throws Exception
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Queue Length=");
    n=sc.nextInt();
    n++;
    queue=new int[n];
    s=1;
    in=0;
    out=0;
    Thread t1 = new Thread(new Runnable()
         {
      public void run()
               {
                   produce();  
               }
         });
         Thread t2 = new Thread(new Runnable()
         {
             public void run()
               {
 	                consume();
         }});
         t1.start();
         t2.start();  
  }
}

