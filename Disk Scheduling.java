CSCAN
import java.util.*;
import java.lang.*;
public class Main
{
   public static void main(String args[])
   {
      Scanner scan=new Scanner(System.in);
      System.out.println("Enter number of disk access points");
      int n=scan.nextInt();
      System.out.println("Enter the start point");
      int start=scan.nextInt();
      int low=0;
      int high=199;
      System.out.println("Now enter the "+n+" disk access points");
      int less[]=new int[n]; int lc=0;
      int more[]=new int[n]; int mc=0;
      for(int i=0;i<n;i++)
      {
          int x=scan.nextInt();
          if(x<start)
          {
             less[lc]=x;
             lc++;
          }
          else if(x>start)
          {
             more[mc]=x;
             mc++;
          }
      }
      int d=0;
      System.out.println("The order of execution is");
      System.out.println(start);
      int count=lc;int prev=0;
      while(count>0)
      {
         int large=less[0]; int pos=0;
         for(int i=0;i<lc;i++) //find largest out of lesser part
         {
           if(less[i]>large)
           {
             large=less[i];
             pos=i;
           }
         }
         System.out.println(large); //print the largest
         if(count==lc) //if its the first one
         {
      	 d+=(start-large);
      	 prev=large; //prev is the one done now
         }
         else
         {
      	 d+=(prev-large);
      	 prev=large;
         }
         less[pos]=-1; //this one has been considered and wont interfere in finiding new large
         count--;
     }
     System.out.println("0");
     System.out.println("199");
     d+=prev;
     prev=199;
     count=mc;
      while(count>0)
      {
         int large=more[0]; int pos=0;
         for(int i=0;i<mc;i++)
         {
           if(more[i]>large)
           {
             large=more[i];
             pos=i;
           }
         }
         System.out.println(large);
      	d+=(prev-large); //prev already considered to be 199. in CLOOK it would be the largest of them all, not directly 199
         prev=large;
         more[pos]=-1;
         count--;
     }
     System.out.println("This distance covered is "+d);
   }
}





LOOK

import java.util.*;
import java.lang.*;
public class Main
{
   public static void main(String args[])
   {
      Scanner scan=new Scanner(System.in);
      System.out.println("Enter number of disk access points");
      int n=scan.nextInt();
      System.out.println("Enter the start point");
      int start=scan.nextInt();
      int low=0;
      int high=199;
      System.out.println("Now enter the "+n+" disk access points");
      int less[]=new int[n]; int lc=0;
      int more[]=new int[n]; int mc=0;
      for(int i=0;i<n;i++)
      {
          int x=scan.nextInt();
          if(x<start)
          {
             less[lc]=x;
             lc++;
          }
          else if(x>start)
          {
             more[mc]=x;
             mc++;
          }
      }
      int d=0;
      System.out.println("The order of execution is");
      System.out.println(start);
      int count=lc;int prev=0;
      while(count>0)
      {
         int large=less[0]; int pos=0;
         for(int i=0;i<lc;i++) //find largest out of lesser part
         {
           if(less[i]>large)
           {
             large=less[i];
             pos=i;
           }
         }
         System.out.println(large); //print the largest
         if(count==lc) //if its the first one
         {
      	 d+=(start-large);
      	 prev=large; //prev is the one done now
         }
         else
         {
      	 d+=(prev-large);
      	 prev=large;
         }
         less[pos]=-1; //this one has been considered and wont interfere in finiding new large
         count--;
         
     }
             
     int prev1=prev;
     count=mc;
      while(count>0)
      {
         int large=more[0]; int pos=0;
         for(int i=0;i<mc;i++)
         {
           if(more[i]<large)
           {
             large=more[i];
             pos=i;
           }
         }
         System.out.println(large);

          if(count==lc) //if its the first one
         {
           
      	   d+=(large-prev1);
             prev=large; //prev is the one done now
           
         }
         else
         {
      	 d+=(large-prev);
      	 prev=large;
         }
       
         more[pos]=9999;
         count--;
       
     }
     System.out.println("This distance covered is "+ d);
   }
}



SCAN
import java.util.*;
import java.lang.*;
public class Main
{
   public static void main(String args[])
   {
      Scanner scan=new Scanner(System.in);
      System.out.println("Enter number of disk access points");
      int n=scan.nextInt();
      System.out.println("Enter the start point");
      int start=scan.nextInt();
      int low=0;
      int high=199;
      System.out.println("Now enter the "+n+" disk access points");
      int less[]=new int[n]; int lc=0;
      int more[]=new int[n]; int mc=0;
      for(int i=0;i<n;i++)
      {
          int x=scan.nextInt();
          if(x<start)
          {
             less[lc]=x;
             lc++;
          }
          else if(x>start)
          {
             more[mc]=x;
             mc++;
          }
      }
      int d=0;
      System.out.println("The order of execution is");
      System.out.println(start);
      int count=lc;int prev=0;
      while(count>0)
      {
         int large=less[0]; int pos=0;
         for(int i=0;i<lc;i++) //find largest out of lesser part
         {
           if(less[i]>large)
           {
             large=less[i];
             pos=i;
           }
         }
         System.out.println(large); //print the largest
         if(count==lc) //if its the first one
         {
      	 d+=(start-large);
      	 prev=large; //prev is the one done now
         }
         else
         {
      	 d+=(prev-large);
      	 prev=large;
         }
         less[pos]=-1; //this one has been considered and wont interfere in finiding new large
         count--;
         
     }
     System.out.println("0");
     d+=prev;
     prev=0;
     count=mc;
      while(count>0)
      {
         int large=more[0]; int pos=0;
         for(int i=0;i<mc;i++)
         {
           if(more[i]<large)
           {
             large=more[i];
             pos=i;
           }
         }
         System.out.println(large);

          if(count==lc) //if its the first one
         {
           
      	   d+=(large-prev);
             prev=large; //prev is the one done now
           
         }
         else
         {
      	 d+=(large-prev);
      	 prev=large;
         }
       
         more[pos]=9999;
         count--;
       
     }
     System.out.println("199");
     d+=(199-prev)
     System.out.println("This distance covered is "+ d);
   }
}

SSTF
import java.util.*;

class Main
{
 static int abs(int x, int y)
{
  if(x>=y)
  {
    return x-y;
  }
  else
  {
    return y-x;
  }
}
public static void main(String args[])
{
  Scanner scan=new Scanner(System.in);
  int i,j,n,start,start1,min,rec=0,d=0,count,absolute;
    
  System.out.println("Enter number of disk access points");
  n=scan.nextInt();

  int a[]=new int[n];
  int result[]=new int[n];

  System.out.println("Enter the start point");
  start=scan.nextInt();
  start1=start;
  System.out.println("Now enter the "+n+" disk access points");
  for(i=0; i<n; i++)
  {
    a[i]=scan.nextInt();
  }
   count=0;
  for(i=0;i<n; i++)
  {
    min=10000000;
    for(j=0; j<n; j++)
    {
      if(a[j]!=-1)
      {
        absolute=abs(start,a[j]);
        if(absolute<min)
        {
          min=absolute;
          rec=j;
        }
      }
    }
    result[count]=a[rec];
    start=a[rec];
    a[rec]=-1;
    count++;
  }
 System.out.println("The order of execution is");
 d=abs(start1,result[0]);
  for(i=0; i<n; i++)
  {
    System.out.println(result[i]);

    if(i<(n-1))
    {
      d+=abs(result[i],result[i+1]);
     }  
  }      
  System.out.println("This distance covered is "+ d);
 

}
}





FCFS

import java.util.*;

class Main
{

 static int abs(int x, int y)
 {
   if(x>=y)
   {
     return x-y;
   }
   else
   {
     return y-x;
   }
 }


public static void main(String args[])
{
  Scanner scan=new Scanner(System.in);
  int i,j,n,start,min,rec=0,d=0,count,absolute;
    
  System.out.println("Enter number of disk access points");
  n=scan.nextInt();

  int a[]=new int[n];
 
  System.out.println("Enter the start point");
  start=scan.nextInt();
  System.out.println("Now enter the "+n+" disk access points");
  for(i=0; i<n; i++)
  {
    a[i]=scan.nextInt();
  }
  System.out.println("The order of execution is");
 d=abs(start,a[0]);
 for(i=0; i<n; i++)
  {
    System.out.println(a[i]);

    if(i<(n-1))
    {
      d+=abs(a[i],a[i+1]);
     }  
  }      
  System.out.println("This distance covered is "+ d);
 

}
}















































































CLOOK
import java.util.*;
import java.lang.*;
public class Main
{
   public static void main(String args[])
   {
      Scanner scan=new Scanner(System.in);
      System.out.println("Enter number of disk access points");
      int n=scan.nextInt();
      System.out.println("Enter the start point");
      int start=scan.nextInt();
      int low=0;
      int high=199;
      System.out.println("Now enter the "+n+" disk access points");
      int less[]=new int[n]; int lc=0;
      int more[]=new int[n]; int mc=0;
      for(int i=0;i<n;i++)
      {
          int x=scan.nextInt();
          if(x<start)
          {
             less[lc]=x;
             lc++;
          }
          else if(x>start)
          {
             more[mc]=x;
             mc++;
          }
      }
      int d=0;
      System.out.println("The order of execution is");
      System.out.println(start);
      int count=lc;int prev=0;
      while(count>0)
      {
         int large=less[0]; int pos=0;
         for(int i=0;i<lc;i++) //find largest out of lesser part
         {
           if(less[i]>large)
           {
             large=less[i];
             pos=i;
           }
         }
         System.out.println(large); //print the largest
         if(count==lc) //if its the first one
         {
      	 d+=(start-large);
      	 prev=large; //prev is the one done now
         }
         else
         {
      	 d+=(prev-large);
      	 prev=large;
         }
         less[pos]=-1; //this one has been considered and wont interfere in finiding new large
         count--;
     }
     d+=prev;
     int prev1=prev;
     prev=more[0];
     count=mc;
      while(count>0)
      {
         int large=more[0]; int pos=0;
         for(int i=0;i<mc;i++)
         {
           if(more[i]>large)
           {
             large=more[i];
             pos=i;
           }
         }
         System.out.println(large);

          if(count==lc) //if its the first one
         {
      	 d+=(large-prev);
      	 prev=large; //prev is the one done now
         }
         else
         {
      	 d+=(prev-large);
      	 prev=large;
         }
       
         more[pos]=-1;
         count--;
     }
     System.out.println("This distance covered is "+ d);
   }
}

