import java.lang.*;
import java.util.*;
class Main
{
 public static void main(String args[])
 {
 Scanner sc=new Scanner(System.in);

// TOTAL RESOURCES
 System.out.println("Maximum number of each resource:");
 int i,j;
 int r[]={10,5,7};
 System.out.println("R1\tR2\tR3");
 for(i=0;i<3;i++)
 {
   System.out.print(r[i]+"\t");
 }

 System.out.println("\nEnter the number of processes");
 int n=sc.nextInt();

// CLAIM MATRIX
 int claim[][]=new int[n][3];
 System.out.println("Enter the claim matrix");
 for(i=0;i<n;i++)
 {
   for(j=0;j<3;j++)
   {
     int x=sc.nextInt();
     if(x<=r[j])
     {
       claim[i][j]=x;
     }
     else
     {
       System.out.println("Exceeds available system resources,please re-enter value\n");
       j--;
     }
   }
 }

 int flag ,tempsum;
// ALLOCATION MATRIX
 int alloc[][]=new int[n][3];
 do{ 
   System.out.println("Enter the allocation matrix");
   for(i=0;i<n;i++)
   {
     for(j=0;j<3;j++)
     {
       alloc[i][j]=sc.nextInt();
     }
   }

// CHECKING VALIDITY OF ALLOCATION MATRIX
   flag = 1;
   for(i=0;i<3;i++)
   {
     tempsum=0;
     for(j=0;j<n;j++)
     {
       tempsum += alloc[j][i];
       System.out.println("Sum="+tempsum);
     }
     if(tempsum > r[i]){
       System.out.println("Allocation exceeds maximum resources");
       flag=0;
       break;
     }
   }
 }while(flag==0);

//NEED MATRIX
 int need[][]=new int[n][3];
 System.out.println("The need matrix is as follows:");
 for(i=0;i<n;i++)
 {
   for(j=0;j<3;j++)
   {
     need[i][j]=claim[i][j]-alloc[i][j];
     System.out.print(need[i][j]+"\t");
   }
   System.out.println();
 }

// AVAILABLE VECTOR
 int a[]=new int[3];
 System.out.println("Available resources:\nR1\tR2\tR3");
 for(i=0;i<3;i++)
 {
   int sum=0;
   for(j=0;j<n;j++)
   {
     sum+=alloc[j][i];
   }
     a[i]=r[i]-sum;
   System.out.print(a[i]+"\t");
 }


 int exec[]=new int[n];
 int count=0;
 System.out.println("\nOrder of execution of processes:");
 while(count!=n)
 {
   for(i=0;i<n;i++)
   {
     flag=1;//to check if process can execute
     for(j=0;j<3;j++)
     {
       if((need[i][j]>a[j])||(exec[i]==1))
       {
       //checks if resources needed are greater or process
       // has already been executed
         flag=0;
         break;
       }
     }
     if(flag==0)
     {
       continue;
     }
     else
     {
       System.out.print("|--P"+(i+1)+"--|");
       count++;
       exec[i]=1;
       a[0]+=alloc[i][0];
       a[1]+=alloc[i][1];
       a[2]+=alloc[i][2];
       alloc[i][0]=alloc[i][1]=alloc[i][2]=0;//resources are
       // released
       i=-1;//will start checking from p1 again
     }
   }
   //The control will come out of this for loop only when the
   // system is in an unsafe state
    break;
 }
 if(count!=n)
 {
   System.out.println("\nUNSAFE STATE");
   System.out.println("The processes that did not execute are:");
   for(i=0;i<n;i++)
   {
     if(exec[i]==0)
     {
       System.out.print("P"+(i+1));
     }
   }
 }
 else
 {
   System.out.println("\nSAFE STATE: All processes executed");
 }
}
}

