Linked

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
public static void main(String args[])
{
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter number of blocks in disk");
    int n=scan.nextInt();
    int disk[]=new int [n];
     Random r=new Random();
    Vector <File> FAT=new Vector<File>();
    int remaining=n;
    int choice=0;
    do
    {
        System.out.println("1. New file");
        System.out.println("2. Delete file");
        System.out.println("3. Search for file");
        System.out.println("4. Display FAT");
        System.out.println("5. Exit");
        choice=scan.nextInt();
        if(choice==1)
        {
            System.out.println("Enter the name of the file");
            String s=scan.next();
            System.out.println("Enter the size");
            int size=scan.nextInt();
            if(size>remaining)
            {
                System.out.println("Can't be inserted");
                continue;
            }
            remaining-=size;
            int i=0;
            int flag=0; int index2=0;
            while(i<size)
            {
                int index=r.nextInt(n);                    if(disk[index]==0)        //no allocation
                {
                    i++;
                    if(flag==0) //start element in link
                    {
                        System.out.println("Initial index is "+index);
                        FAT.add(new File(s,index,size));    //add to FAT
                        flag=1;
                        disk[index]=-1;
                    }
                    else if(flag==1)    
                    {
                    
                        disk[index2]=index; //was initially -1, now points to new index
                        disk[index]=-1; //latest so will have -1
                   
                    }
                    index2=index; //index2 has the index of previous block now
                }
            }
            System.out.println("File added successfully");
            System.out.println("Remaining size is "+remaining);
        }

        if(choice==2)
        {
          int i, flag=0;
          System.out.println("Enter name of file you want to delete");
          String s=scan.next();
          for(i=0;i<FAT.size();i++)
          {
                if(FAT.elementAt(i).name.equalsIgnoreCase(s))
                {
                    flag=1;
                    System.out.println("File exists");
                    break;
                }
          }
          if(flag==0)
          {
              System.out.println("File does not exist");
          }
          else{
              int val=FAT.elementAt(i).start;
              while(disk[val]!=-1)          //check in start for next link
              {
                    int temp=val;
                    val=disk[val];            //update to next link
                    disk[temp]=0;
              }
              System.out.println("File deleted");
              System.out.println("Remaining size is "+(remaining+FAT.elementAt(i).size));
              FAT.removeElementAt(i);
          }
        }

       

        if(choice==3)
        {
            System.out.println("Enter a file name to search for");
            String search=scan.next();
            int flag=0;
            for(int i=0;i<FAT.size();i++)
            {
                if(FAT.elementAt(i).name.equalsIgnoreCase(search))
                {
                    flag=1;
                    System.out.println("File exists");
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("File does not exist");
            }
        }

        if(choice==4)
        {
            for(int i=0;i<FAT.size();i++)
            {
                System.out.println("File name is "+FAT.elementAt(i).name);
                System.out.println("Size is  "+FAT.elementAt(i).size);
                System.out.print("Stored in storage locations ");
                int val=FAT.elementAt(i).start;
                System.out.print(val+" ");     //start printed
                while(disk[val]!=-1)          //check in start for next link
                {
                    System.out.print(disk[val]+" ");
                    val=disk[val];            //update next link
                }
                System.out.println();
                System.out.println("---------------------");
            }
        }
     
        if(choice==5)
        {
            break;
        }
    }while(choice<=4);
}
}
class File
{
String name;
int start;
int size;
public File(String name, int start, int size)
{
    this.name=name;
    this.start=start;
    this.size=size;
}
}



Sequential
import java.util.*;

//initial: total memory=10 MB;  1 block=256 KB;
class file
{
 String fn;
 int fs,sb,b;

file(String fn, int fs, int sb, int b)
{
  this.fn=fn;
  this.fs=fs;
  this.sb=sb;
  this.b=b;
}
}
class Main
{
 static ArrayList<file> al=new ArrayList<file>();
 public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  int i,j,choice=0,fs,fs1,sb,b,sb1,sum=0,b1;
  String fn,fn1;
  int a[]=new int[40];

   while(choice!=4)

  {

    System.out.println("");
    System.out.println("1: Create a new file");     System.out.println("2: Delete an existing file");
    System.out.println("3: Edit size of file");
    System.out.println("4: Exit");
    choice=sc.nextInt();
    if(choice==1)
    {
      System.out.println("Enter the filename");
      fn=sc.next();
      System.out.println("Enter the file size");
      fs=sc.nextInt();
      if(fs%256==0)
      {
        b=fs/256;
      }
      else
      {
        b=(fs/256)+1;
      }
      int flag=-1;   

      for(i=0; i<40-b; i++) //for checking if b consecutive blocks are free
       {

        sum=0;
        for(j=i; j<i+b; j++)
        {

         if(a[j]!=0)
          {
            sum++;
          }
        }
        if(sum==0)
        {
          flag=0;
          break;
        }
      }
      if(flag==0)
      {
        sb=i;
        for(i=sb; i<sb+b; i++)
        {
          a[i]=1;
        }
        file f1=new file(fn,fs,sb,b);
        al.add(f1);
      }
       else
      {
        System.out.println("No consecutive empty blocks found");
      }
    }

    else if(choice==2)
    {
      System.out.println("Enter the filename which has to be deleted");
      fn1=sc.next();
      for(file temp: al)
      {
        if(temp.fn.equals(fn1))
        {
          sb1=temp.sb;
          b1=temp.b;
          for(i=sb1; i<sb1+b1; i++)
          {
            a[i]=0;
          }
          al.remove(temp);
        }
      }
      System.out.println("Filename "+fn1+" is deleted");
    }

    else if(choice==3)
    {

     System.out.println("Enter the filename which has to be edited");
     fn1=sc.next();
     for(file temp: al)
      {
        if(temp.fn.equals(fn1))
        {
          System.out.println("Enter the new size of the file");
          fs1=sc.nextInt();
          sb1=temp.sb;
          if(fs1>temp.fs)
          {
            if(fs1%256==0)
            {
              b1=fs1/256;
            }

            else
            {
              b1=(fs1/256)+1;
            }
            for(i=sb1; i<sb1+b1; i++)
            {
              a[i]=1;
            }
          }

          else if(fs1<temp.fs)
          {
            if(fs1%256==0)
            {
              b1=fs1/256;
            }

            else
            {
              b1=(fs1/256)+1;
            }

            for(i=sb1+b1; i<temp.b; i++)
            {
              a[i]=0;
            }
          }
        }
      }
      System.out.println("Filename "+fn1+" is edited");
    }

    else if(choice==4)
    {
      System.out.println("Exiting...");
      break;
    }
    else
    {
      System.out.println("Enter a valid option");
    }

    System.out.println("File table:");
    System.out.println("Filename      Filesize       Starting block       No. of blocks");
    for(file temp1: al)
    {
      System.out.println(temp1.fn+"                "+temp1.fs+"                 "+temp1.sb+"                   "+temp1.b);
    }
 
 }
 }
}

Indexed
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
public static void main(String args[])
{
  Scanner scan=new Scanner(System.in);
  System.out.println("Enter number of blocks in disk");
  int n=scan.nextInt();
  int disk[]=new int [n];

  Random r=new Random();
  Vector <File> FAT=new Vector<File>();
  int remaining=n;
  int choice=0;
  do
  {
    System.out.println("1. New file");
    System.out.println("2. Delete file");
    System.out.println("3. Search for file");
    System.out.println("4. Display FAT");
    System.out.println("5. Exit");
    choice=scan.nextInt();
  
    if(choice==1)
    {
      System.out.println("Enter name");
      String s=scan.next();
      System.out.println("Enter size");
      int size=scan.nextInt();
      if(size>remaining)
      {
        System.out.println("Greater than remaining size. Can't be put");
        continue;
      }
      FAT.add(new File(s,size));
      int i=0;
      while(i<size)
      {
        int index=r.nextInt(n);
        // System.out.println("Random number generated = "+index);
        if(disk[index]==0)
        {
          i++;
          FAT.lastElement().add(index); //added address of block to that file's arraylist
          disk[index]=1; //now that space is occupied
        }
      }
      System.out.println("File added successfully");
      remaining-=size;
      System.out.println("Remaining space is "+remaining);
    }

    else if(choice==2)
    {
        int i,flag=0;
        System.out.println("Enter some file name to delete");
        String s=scan.next();
        for(i=0;i<FAT.size();i++)
        {
            if(FAT.elementAt(i).name.equalsIgnoreCase(s))
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("The file does not exist");
        }
        for(int j=0;j<FAT.elementAt(i).addr.size();j++)
        {
              int temp = FAT.elementAt(i).addr.get(j);
              disk[temp] = 0;     //deallocate
        }
        remaining += FAT.elementAt(i).size;
        FAT.removeElementAt(i);
        System.out.println("File is deleted");
        System.out.println("Remaining space is "+remaining);
    }

   
    else if(choice==3)
    {
      System.out.println("Enter some file name to search");
      String search=scan.next();
      int flag=0;
      for(int i=0;i<FAT.size();i++)
      {
        if(FAT.elementAt(i).name.equalsIgnoreCase(search))
        {
          flag=1;
          System.out.println("File exists");
          break;
        }
      }
      if(flag==0)
      {
        System.out.println("The file does not exist");
      }
    }


    else if(choice==4)
    {
      for(int i=0;i<FAT.size();i++)
      {
        System.out.println("Name: "+FAT.elementAt(i).name);
        System.out.println("Size: "+FAT.elementAt(i).size);
        System.out.print("Stored at locations :");
        for(int j=0;j<FAT.elementAt(i).addr.size();j++)
        {
          System.out.print(FAT.elementAt(i).addr.get(j)+" ");
        }
      }
      System.out.println();
      System.out.println("----------------");
    }
  
    else if(choice==5)
    {
      break;
    }
  }while(choice<=4);
}
}
class File
{
String name;
int size;
ArrayList<Integer> addr=new ArrayList<Integer>(); //store all the locations
public File(String name, int size)
{
  this.name=name;
  this.size=size;
}
public void add(int i)
{
  addr.add(i);
}
}




