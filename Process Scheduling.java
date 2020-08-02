FCFS

import java.util.*;

class Process{
int pid;
int burst;
int temp_burst;
int arrival;
int temp_arrival;
int tat;
int wt;

public Process(int id, int at, int bt){
pid = id;
arrival = at;
temp_arrival = at;
burst = bt;
temp_burst = bt;
}
public void computeTAT(int elapsedTime){
tat = elapsedTime - arrival;
}
public void computeWT(){
wt =  tat - burst;
}
public void decrementBT(int quantum){
temp_burst -=quantum;
}
public void increment_TEMP_AT(int elapsedTime){
if(temp_arrival<=elapsedTime)
temp_arrival = elapsedTime;
}

public int PID(){
return pid;
}
public int AT(){
return arrival;
}
public int TEMP_AT(){
return temp_arrival;
}
public int BT(){
return temp_burst;
}
public int TAT(){
return tat;
}
public int WT(){
return wt;
}

@Override
public String toString() {
return ("\t\t\t"+this.PID()+"\t\t"+this.AT()+"\t\t"+this.BT());
}

public static Comparator<Process> sortingProcesses = new Comparator<Process>() {
public int compare(Process p1, Process p2) {
int at1 = p1.TEMP_AT();
int at2 = p2.TEMP_AT();

if(at1!=at2)
return at1 - at2;

else
return 0;
}
};

}


class Main {
public static void main(String[] args) {
Scanner sc= new Scanner(System.in);

int bt,at,id;
String ch;
int n,nn,i;

int elapsedTime = 0;
double totalWT=0.0;
double totalTAT=0.0;
double averageWT=0.0;
double averageTAT=0.0;


ArrayList<Process> queue = new ArrayList<Process>();
ArrayList<Process> process_list = new ArrayList<Process>();
System.out.println("*********************FCFS***************************");

System.out.println("Enter the number of processes :");
n = sc.nextInt();

System.out.println("Enter the process id, arrival time and burst time :");
for(i=0;i<n;i++){
id = sc.nextInt();
at = sc.nextInt();
bt = sc.nextInt();
Process obj = new Process(id,at,bt);
process_list.add(obj);
queue.add(obj);
}

System.out.println("\t\t Process ID \t Arrival time \t Burst time ");
for(i=0;i<n;i++){
System.out.println(process_list.get(i));
}
Collections.sort(queue, Process.sortingProcesses);

System.out.println();
System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
System.out.println(queue.get(i));
}

do{
if(queue.get(0).AT()>elapsedTime){
 System.out.println();
 System.out.println("No.of seconds the system was idle : "+(queue.get(0).AT()-elapsedTime));
 elapsedTime+=(queue.get(0).AT()-elapsedTime);
}
 System.out.println();
 System.out.println("No. of seconds process  " + queue.get(0).PID()+" was executed : "+queue.get(0).BT());
 System.out.println("Process " + queue.get(0).PID()+" completed");
  elapsedTime+=queue.get(0).BT();
 queue.get(0).computeTAT(elapsedTime);
 queue.get(0).computeWT();
   queue.remove(0);
System.out.println();
System.out.println("Current queue:");
 for(i=0;i<queue.size();i++){
   System.out.println(queue.get(i));
 }
System.out.println();
System.out.println("Do you wish to add another process? Y/N");
ch = sc.next();

if(ch.equalsIgnoreCase("N")){
for(i=0;i<queue.size();i++){
 queue.get(i).increment_TEMP_AT(elapsedTime);
}

  Collections.sort(queue,Process.sortingProcesses);
  System.out.println();
System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
     System.out.println(queue.get(i));
   }

}

else if(ch.equalsIgnoreCase("Y")){
 System.out.println("Enter the number of processes to be added : ");
 nn = sc.nextInt();

for(i=0;i<queue.size();i++){
   queue.get(i).increment_TEMP_AT(elapsedTime);
}
 System.out.println("Enter the process id, arrival time and burst time :");
  for(i=0;i<nn;i++){
   id = sc.nextInt();
   at = sc.nextInt();
   bt = sc.nextInt();
   if(at>=elapsedTime){
     Process obj = new Process(id,at,bt);
     process_list.add(obj);
     queue.add(obj);
   }
 }

 Collections.sort(queue, Process.sortingProcesses);
  System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
     System.out.println(queue.get(i));
   }
}

if(queue.size()==0)
 break;
}while(queue!=null);
System.out.println("********************************************************");
System.out.println("\t\tAll the processes have been executed.");
System.out.println("\t\tProcess ID \t Turnaround time \t Waiting time ");
for(i=0;i<process_list.size();i++){
totalWT+=process_list.get(i).WT();
totalTAT+=process_list.get(i).TAT();
System.out.println("\t\t\t"+process_list.get(i).PID() +"\t\t"+process_list.get(i).TAT() +"\t\t"+process_list.get(i).WT());
}

averageWT=(double)totalWT/(double)process_list.size();
averageTAT=(double)totalTAT/(double)process_list.size();

System.out.println();
System.out.println("Average waiting time in seconds : "+averageWT);
System.out.println("Average turnaround time in seconds : "+averageTAT);
System.out.println("********************************************************");
sc.close();
}
}





SJN

import java.util.*;

class Process{
int pid;
int burst;
int temp_burst;
int arrival;
int temp_arrival;
int tat;
int wt;

public Process(int id, int at, int bt){
pid = id;
arrival = at;
temp_arrival = at;
burst = bt;
temp_burst = bt;
}
public void computeTAT(int elapsedTime){
tat = elapsedTime - arrival;
}
public void computeWT(){
wt =  tat - burst;
}
public void decrementBT(int quantum){
temp_burst -=quantum;
}
public void increment_TEMP_AT(int elapsedTime){
if(temp_arrival<=elapsedTime)
temp_arrival = elapsedTime;
}

public int PID(){
return pid;
}
public int AT(){
return arrival;
}
public int TEMP_AT(){
return temp_arrival;
}
public int BT(){
return temp_burst;
}
public int TAT(){
return tat;
}
public int WT(){
return wt;
}

@Override
public String toString() {
return ("\t\t\t"+this.PID()+"\t\t"+this.AT()+"\t\t"+this.BT());
}

public static Comparator<Process> sortingProcesses = new Comparator<Process>() {
public int compare(Process p1, Process p2) {
int at1 = p1.TEMP_AT();
int at2 = p2.TEMP_AT();

if(at1!=at2)
return at1 - at2;
int bt1 = p1.BT();
int bt2 = p2.BT();
return bt1-bt2;

}
};

}


class Main {
public static void main(String[] args) {
Scanner sc= new Scanner(System.in);

int bt,at,id;
String ch;
int n,nn,i;

int elapsedTime = 0;
double totalWT=0.0;
double totalTAT=0.0;
double averageWT=0.0;
double averageTAT=0.0;


ArrayList<Process> queue = new ArrayList<Process>();
ArrayList<Process> process_list = new ArrayList<Process>();
System.out.println("*********************SJN***************************");

System.out.println("Enter the number of processes :");
n = sc.nextInt();

System.out.println("Enter the process id, arrival time and burst time :");
for(i=0;i<n;i++){
id = sc.nextInt();
at = sc.nextInt();
bt = sc.nextInt();
Process obj = new Process(id,at,bt);
process_list.add(obj);
queue.add(obj);
}

System.out.println("\t\t Process ID \t Arrival time \t Burst time ");
for(i=0;i<n;i++){
System.out.println(process_list.get(i));
}
Collections.sort(queue, Process.sortingProcesses);

System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
System.out.println(queue.get(i));
}

do{
if(queue.get(0).AT()>elapsedTime){
  System.out.println("No.of seconds the system was idle : "+(queue.get(0).AT()-elapsedTime));
 elapsedTime+=(queue.get(0).AT()-elapsedTime);
}
  System.out.println("No. of seconds process  " + queue.get(0).PID()+" was executed : "+queue.get(0).BT());
 System.out.println("Process " + queue.get(0).PID()+" completed");
  elapsedTime+=queue.get(0).BT();
 queue.get(0).computeTAT(elapsedTime);
 queue.get(0).computeWT();
   queue.remove(0);

System.out.println("Current queue : ");
 for(i=0;i<queue.size();i++){
   System.out.println(queue.get(i));
 }

System.out.println("Do you wish to add another process? Y/N");
ch = sc.next();

if(ch.equalsIgnoreCase("N")){
for(i=0;i<queue.size();i++){
 queue.get(i).increment_TEMP_AT(elapsedTime);
}

  Collections.sort(queue,Process.sortingProcesses);
System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
     System.out.println(queue.get(i));
   }

}

else if(ch.equalsIgnoreCase("Y")){
 System.out.println("Enter the number of processes to be added : ");
 nn = sc.nextInt();

for(i=0;i<queue.size();i++){
   queue.get(i).increment_TEMP_AT(elapsedTime);
}
  System.out.println("Enter the process id, arrival time and burst time :");
  for(i=0;i<nn;i++){
   id = sc.nextInt();
   at = sc.nextInt();
   bt = sc.nextInt();
   if(at>=elapsedTime){
     Process obj = new Process(id,at,bt);
     process_list.add(obj);
     queue.add(obj);
   }
 }

 Collections.sort(queue, Process.sortingProcesses);
  System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
     System.out.println(queue.get(i));
   }
}

if(queue.size()==0)
 break;
}while(queue!=null);
System.out.println("********************************************************");
System.out.println("\t\tAll the processes have been executed.");
System.out.println("\t\tProcess ID \t Turnaround time \t Waiting time ");
for(i=0;i<process_list.size();i++){
totalWT+=process_list.get(i).WT();
totalTAT+=process_list.get(i).TAT();
System.out.println("\t\t\t"+process_list.get(i).PID() +"\t\t"+process_list.get(i).TAT() +"\t\t"+process_list.get(i).WT());
}

averageWT=(double)totalWT/(double)process_list.size();
averageTAT=(double)totalTAT/(double)process_list.size();

System.out.println();
System.out.println("Average waiting time in seconds : "+averageWT);
System.out.println("Average turnaround time in seconds : "+averageTAT);
System.out.println("********************************************************");
sc.close();
}
}




Non Preemptive Priority
import java.util.*;

class Process{
int pid;
int burst;
int temp_burst;
int arrival;
int temp_arrival;
int priority;
int tat;
int wt;

public Process(int id, int at, int bt,int pr){
pid = id;
arrival = at;
temp_arrival = at;
burst = bt;
temp_burst = bt;
priority=pr;
}
public void computeTAT(int elapsedTime){
tat = elapsedTime - arrival;
}
public void computeWT(){
wt =  tat - burst;
}
public void decrementBT(int quantum){
temp_burst -=quantum;
}
public void increment_TEMP_AT(int elapsedTime){
if(temp_arrival<=elapsedTime)
temp_arrival = elapsedTime;
}

public int PID(){
return pid;
}
public int AT(){
return arrival;
}
public int TEMP_AT(){
return temp_arrival;
}
public int BT(){
return temp_burst;
}
public int PR(){
return priority;
}
public int TAT(){
return tat;
}
public int WT(){
return wt;
}

@Override
public String toString() {
return ("\t\t\t"+this.PID()+"\t\t"+this.AT()+"\t\t"+this.BT()+"\t\t"+this.PR());
}

public static Comparator<Process> sortingProcesses = new Comparator<Process>() {
public int compare(Process p1, Process p2) {
int at1 = p1.TEMP_AT();
int at2 = p2.TEMP_AT();

if(at1!=at2)
 return at1 - at2;

int priority1 = p1.PR();
int priority2 = p2.PR();
return priority1-priority2;

}
};

}


class Main {
public static void main(String[] args) {
Scanner sc= new Scanner(System.in);

int bt,at,id,pr;
String ch;
int n,nn,i;

int elapsedTime = 0;
double totalWT=0.0;
double totalTAT=0.0;
double averageWT=0.0;
double averageTAT=0.0;


ArrayList<Process> queue = new ArrayList<Process>();
ArrayList<Process> process_list = new ArrayList<Process>();
System.out.println("*********************Non Preemptive Priority***************************");

System.out.println("Enter the number of processes :");
n = sc.nextInt();

System.out.println("Enter the process id, arrival time,burst time and priority :");
for(i=0;i<n;i++){
id = sc.nextInt();
at = sc.nextInt();
bt = sc.nextInt();
pr = sc.nextInt();
Process obj = new Process(id,at,bt,pr);
process_list.add(obj);
queue.add(obj);
}

System.out.println("\t\t Process ID \t Arrival time \t Burst time \t Priority ");
for(i=0;i<n;i++){
System.out.println(process_list.get(i));
}
Collections.sort(queue, Process.sortingProcesses);

System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
System.out.println(queue.get(i));
}

do{
   if(queue.get(0).AT()>elapsedTime){
 System.out.println("System idle for : "+(queue.get(0).AT()-elapsedTime)+ " sec");
 elapsedTime+=(queue.get(0).AT()-elapsedTime);
   }
  System.out.println("No. of seconds process  " + queue.get(0).PID()+" was executed : "+queue.get(0).BT());
System.out.println("Process " + queue.get(0).PID()+" completed");
  elapsedTime+=queue.get(0).BT();
 queue.get(0).computeTAT(elapsedTime);
 queue.get(0).computeWT();
 queue.remove(0);
 if(queue.size()==0)
    break;

System.out.println("Current queue:");
 for(i=0;i<queue.size();i++){
   System.out.println(queue.get(i));
 }

System.out.println("Do you wish to add another process? Y/N");
ch = sc.next();

if(ch.equalsIgnoreCase("N")){
for(i=0;i<queue.size();i++){
 queue.get(i).increment_TEMP_AT(elapsedTime);
}

  Collections.sort(queue,Process.sortingProcesses);
System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
     System.out.println(queue.get(i));
   }

}

else if(ch.equalsIgnoreCase("Y")){
 System.out.println("Enter the number of processes to be added : ");
 nn = sc.nextInt();

for(i=0;i<queue.size();i++){
   queue.get(i).increment_TEMP_AT(elapsedTime);
}
  System.out.println("Enter the process id, arrival time and burst time and priority :");
  for(i=0;i<nn;i++){
   id = sc.nextInt();
   at = sc.nextInt();
   bt = sc.nextInt();
   pr = sc.nextInt();
   if(at>=elapsedTime){
     Process obj = new Process(id,at,bt,pr);
     process_list.add(obj);
     queue.add(obj);
   }
 }

 Collections.sort(queue, Process.sortingProcesses);
  System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
     System.out.println(queue.get(i));
   }
}

}while(queue!=null);
System.out.println("********************************************************");
System.out.println("\t\tAll the processes have been executed.");
System.out.println("\t\tProcess ID \t Turnaround time \t Waiting time ");
for(i=0;i<process_list.size();i++){
totalWT+=process_list.get(i).WT();
totalTAT+=process_list.get(i).TAT();
System.out.println("\t\t\t"+process_list.get(i).PID() +"\t\t"+process_list.get(i).TAT() +"\t\t"+process_list.get(i).WT());
}

averageWT=(double)totalWT/(double)process_list.size();
averageTAT=(double)totalTAT/(double)process_list.size();

System.out.println();
System.out.println("Average waiting time in seconds : "+averageWT);
System.out.println("Average turnaround time in seconds : "+averageTAT);
System.out.println("********************************************************");
sc.close();
}
}




Preemptive Priority


SRTN

import java.util.*;

class Process{
int pid;
int burst;
int temp_burst;
int arrival;
int temp_arrival;
int tat;
int wt;

public Process(int id, int at, int bt){
pid = id;
arrival = at;
temp_arrival = at;
burst = bt;
temp_burst = bt;
}
public void computeTAT(int elapsedTime){
tat = elapsedTime - arrival;
}
public void computeWT(){
wt =  tat - burst;
}
public void decrementBT(int quantum){
temp_burst -=quantum;
}
public void increment_TEMP_AT(int elapsedTime){
if(temp_arrival<=elapsedTime)
temp_arrival = elapsedTime;
}

public int PID(){
return pid;
}
public int AT(){
return arrival;
}
public int TEMP_AT(){
return temp_arrival;
}
public int BT(){
return temp_burst;
}
public int TAT(){
return tat;
}
public int WT(){
return wt;
}

@Override
public String toString() {
return ("\t\t"+this.PID()+"\t\t"+this.AT()+"\t\t"+this.BT());
}

public static Comparator<Process> sortingProcesses = new Comparator<Process>() {
public int compare(Process p1, Process p2) {
int at1 = p1.TEMP_AT();
int at2 = p2.TEMP_AT();

if(at1-at2!=0)
return at1 - at2;
int bt1 = p1.BT();
int bt2 = p2.BT();
return bt1-bt2;
}
};

}


class Main {
public static void main(String[] args) {
Scanner sc= new Scanner(System.in);

int bt,at,id;
String ch;
int n,nn,i;
int quantum = 1;

int executedTime=0;
int elapsedTime = 0;
double averageWT=0.0;
double averageTAT=0.0;


ArrayList<Process> queue = new ArrayList<Process>();
ArrayList<Process> process_list = new ArrayList<Process>();
System.out.println("*********************SRTN***************************");

System.out.println("Enter the number of processes :");
n = sc.nextInt();

System.out.println("Enter the process id, arrival time and burst time :");
for(i=0;i<n;i++){
id = sc.nextInt();
at = sc.nextInt();
bt = sc.nextInt();
 Process obj = new Process(id,at,bt);
process_list.add(obj);
queue.add(obj);
}

System.out.println("\t\t Process ID \t Arrival time \t Burst time ");
for(i=0;i<n;i++){
System.out.println(process_list.get(i));
}
Collections.sort(queue, Process.sortingProcesses);

System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
 System.out.println(queue.get(i));
}

do{
if(queue.get(0).AT()>elapsedTime){
  System.out.println("System idle for : "+(queue.get(0).AT()-elapsedTime)+ " sec");
  elapsedTime+=(queue.get(0).AT()-elapsedTime);
}
 if(queue.get(0).BT()>quantum){
  executedTime = quantum;
  System.out.println("Executing process " + queue.get(0).PID()+" for "+executedTime+ " sec");
  elapsedTime +=executedTime;
  queue.get(0).decrementBT(quantum);
}

else if(queue.get(0).BT()<=quantum){
  executedTime=queue.get(0).BT();
  System.out.println("Executing process  " + queue.get(0).PID()+" for "+executedTime+ " sec");
  System.out.println("Process " + queue.get(0).PID()+" completed");
   elapsedTime+=executedTime;
  queue.get(0).computeTAT(elapsedTime);
  queue.get(0).computeWT();
  queue.get(0).decrementBT(quantum);
}

if(queue.get(0).BT()<=0)
   queue.remove(0);

 System.out.println("Current queue:");
  for(i=0;i<queue.size();i++){
    System.out.println(queue.get(i));
  }

System.out.println("Do you wish to add another process? Y/N");
ch = sc.next();

if(ch.equalsIgnoreCase("N")){
for(i=0;i<queue.size();i++){
  queue.get(i).increment_TEMP_AT(elapsedTime);
}

   Collections.sort(queue,Process.sortingProcesses);
 System.out.println("Current queue :");
 for(i=0;i<queue.size();i++){
      System.out.println(queue.get(i));
    }

}

else if(ch.equalsIgnoreCase("Y")){
  System.out.println("Enter the number of processes ");
  nn = sc.nextInt();

 for(i=0;i<queue.size();i++){
    queue.get(i).increment_TEMP_AT(elapsedTime);
 }
  System.out.println("Enter the process id, arrival time and burst time");
   for(i=0;i<nn;i++){
    id = sc.nextInt();
    at = sc.nextInt();
    bt = sc.nextInt();
 
    if(at>=elapsedTime){
      Process obj = new Process(id,at,bt);
      process_list.add(obj);
      queue.add(obj);
    }
 
  }

  Collections.sort(queue, Process.sortingProcesses);
   System.out.println("Current queue :");
 for(i=0;i<queue.size();i++){
      System.out.println(queue.get(i));
    }
}

if(queue.size()==0)
  break;
}while(queue!=null);
System.out.println("********************************************************");
System.out.println("All processes have been completed");
System.out.println("Process ID \t Turaround time \t Waiting time ");
for(i=0;i<process_list.size();i++){
averageWT+=process_list.get(i).WT();
averageTAT+=process_list.get(i).TAT();
System.out.println(process_list.get(i).PID() +"\t\t"+process_list.get(i).TAT() +"\t\t"+process_list.get(i).WT());
}


System.out.println("Average waiting time : "+(double)averageWT/(double)process_list.size() +" sec");
System.out.println("Average turnaround time : "+(double)averageTAT/(double)process_list.size()+" sec");
System.out.println("********************************************************");
sc.close();
}
}








Round Robin

import java.util.*;

class Process{
int pid;
int burst;
int temp_burst;
int arrival;
int tat;
int wt;

public Process(int id, int at, int bt){
pid = id;
arrival = at;
burst = bt;
temp_burst = bt;
}

public void computeTAT(int elapsedTime){
tat = elapsedTime - arrival;
}
public void computeWT(){
wt =  tat - burst;
}
public void decrementBT(int quantum){
temp_burst -=quantum;
}

public int PID(){
return pid;
}
public int AT(){
return arrival;
}
public int BT(){
return temp_burst;
}
public int TAT(){
return tat;
}
public int WT(){
return wt;
}

@Override
public String toString() {
return ("\t\t\t"+this.PID()+"\t\t"+this.AT()+"\t\t"+this.BT());
}

}


class Main {
public static void main(String[] args) {
Scanner sc= new Scanner(System.in);

int bt,at,id;
String ch;
int n,nn,i;

int quantum = 3;
int executedTime=0;
int elapsedTime = 0;
double totalWT=0.0;
double totalTAT=0.0;
double averageWT=0.0;
double averageTAT=0.0;

Process executed=null;

ArrayList<Process> queue = new ArrayList<Process>();
ArrayList<Process> process_list = new ArrayList<Process>();
System.out.println("*********************Round Robin***************************");

System.out.println("Enter the number of processes :");
n = sc.nextInt();

System.out.println("Enter the process id, arrival time and burst time :");
for(i=0;i<n;i++){
id = sc.nextInt();
at = sc.nextInt();
bt = sc.nextInt();
Process obj = new Process(id,at,bt);
process_list.add(obj);
queue.add(obj);
}

System.out.println("\t\t Process ID \t Arrival time \t Burst time");
for(i=0;i<n;i++){
System.out.println(process_list.get(i));
}

do{
 if(queue.get(0).AT()>elapsedTime){
  System.out.println("No. of seconds the system was idle for : "+(queue.get(0).AT()-elapsedTime));
  elapsedTime+=(queue.get(0).AT()-elapsedTime);
 }
 if(queue.get(0).BT()>quantum){
  executedTime = quantum;
  System.out.println("No. of seconds process " + queue.get(0).PID()+" was executed : "+executedTime);
  elapsedTime +=executedTime;
  queue.get(0).decrementBT(quantum);
  executed= queue.get(0);
 }
else if(queue.get(0).BT()<=quantum){
    executedTime=queue.get(0).BT();
    System.out.println("No. of seconds process " + queue.get(0).PID()+" was executed : "+executedTime);
    System.out.println("Process " + queue.get(0).PID()+" completed");
    elapsedTime+=executedTime;
    queue.get(0).computeTAT(elapsedTime);
    queue.get(0).computeWT();
    queue.get(0).decrementBT(quantum);
    if(queue.get(0).BT()<=0){
      executed=null;
    }
  }

   queue.remove(0);

System.out.println("Current queue :");
  for(i=0;i<queue.size();i++){
    System.out.println(queue.get(i));
  }

System.out.println("Do you wish to add another process? Y/N");
ch = sc.next();

if(ch.equalsIgnoreCase("N")){
  if(executed!=null)
      queue.add(executed);
 System.out.println("Current queue :");
 for(i=0;i<queue.size();i++){
      System.out.println(queue.get(i));
    }
}
else if(ch.equalsIgnoreCase("Y")){
  System.out.println("Enter the number of processes to be added : ");
  nn = sc.nextInt();

  System.out.println("Enter the process id, arrival time and burst time : ");
   for(i=0;i<nn;i++){
    id = sc.nextInt();
    at = sc.nextInt();
    bt = sc.nextInt();
 
       if(at==elapsedTime){
        Process obj = new Process(id,at,bt);
        process_list.add(obj);
        queue.add(obj);
        if(queue.contains(executed)==false){
          if(executed!=null)
            queue.add(executed); 
        }
      }
 
           else if(at>elapsedTime){
             if(queue.contains(executed) == false){
               if(executed!=null)
                 queue.add(executed);
        }
        Process obj = new Process(id,at,bt);
        process_list.add(obj);
        queue.add(obj);
        }
  }

  System.out.println("Current queue :");
  for(i=0;i<queue.size();i++){
    System.out.println(queue.get(i));
  }
}

if(queue.size()==0)
  break;
}while(queue!=null);
System.out.println("********************************************************");
System.out.println("\t\tAll the processes have been executed.");
System.out.println("\t\tProcess ID \t Turnaround time \t Waiting time ");
for(i=0;i<process_list.size();i++){
totalWT+=process_list.get(i).WT();
totalTAT+=process_list.get(i).TAT();
System.out.println("\t\t\t"+process_list.get(i).PID() +"\t\t"+process_list.get(i).TAT() +"\t\t"+process_list.get(i).WT());
}

averageWT=(double)totalWT/(double)process_list.size();
averageTAT=(double)totalTAT/(double)process_list.size();

System.out.println();
System.out.println("Average waiting time in seconds : "+averageWT);
System.out.println("Average turnaround time in seconds : "+averageTAT);
System.out.println("********************************************************");
sc.close();
}
}






Preemptive Priority
import java.util.*;

class Process{
int pid;
int burst;
int temp_burst;
int arrival;
int temp_arrival;
int tat;
int wt;
int priority;

public Process(int id, int at, int bt,int pr){
pid = id;
arrival = at;
temp_arrival = at;
burst = bt;
temp_burst = bt;
priority=pr;
}
public void computeTAT(int elapsedTime){
tat = elapsedTime - arrival;
}
public void computeWT(){
wt =  tat - burst;
}
public void decrementBT(int quantum){
temp_burst -=quantum;
}
public void increment_TEMP_AT(int elapsedTime){
if(temp_arrival<=elapsedTime)
temp_arrival = elapsedTime;
}

public int PID(){
return pid;
}
public int AT(){
return arrival;
}
public int TEMP_AT(){
return temp_arrival;
}
public int BT(){
return temp_burst;
}
public int TAT(){
return tat;
}
public int WT(){
return wt;
}
public int PR()
{
return priority;
}

@Override
public String toString() {
return ("\t\t"+this.PID()+"\t\t"+this.AT()+"\t\t"+this.BT()+"\t\t"+this.PR());
}

public static Comparator<Process> sortingProcesses = new Comparator<Process>() {
public int compare(Process p1, Process p2) {
int at1 = p1.TEMP_AT();
int at2 = p2.TEMP_AT();

if(at1-at2!=0)
return at1 - at2;
int pr1 = p1.PR();
int pr2 = p2.PR();
return pr1-pr2;
}
};

}


class Main {
public static void main(String[] args) {
Scanner sc= new Scanner(System.in);

int bt,at,id,pr;
String ch;
int n,nn,i;
int quantum = 1;

int executedTime=0;
int elapsedTime = 0;
double averageWT=0.0;
double averageTAT=0.0;


ArrayList<Process> queue = new ArrayList<Process>();
ArrayList<Process> process_list = new ArrayList<Process>();
System.out.println("*********************Priority Preemptive***************************");

System.out.println("Enter the number of processes :");
n = sc.nextInt();

System.out.println("Enter the process id, arrival time,burst time and priority:");
for(i=0;i<n;i++){
id = sc.nextInt();
at = sc.nextInt();
bt = sc.nextInt();
pr = sc.nextInt();
Process obj = new Process(id,at,bt,pr);
process_list.add(obj);
queue.add(obj);
}

System.out.println("\t\t Process ID \t Arrival time \t Burst time \t Priority");
for(i=0;i<n;i++){
System.out.println(process_list.get(i));
}
Collections.sort(queue, Process.sortingProcesses);

System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
System.out.println(queue.get(i));
}

do{
if(queue.get(0).AT()>elapsedTime){
 System.out.println("System idle for : "+(queue.get(0).AT()-elapsedTime)+ " sec");
 elapsedTime+=(queue.get(0).AT()-elapsedTime);
}
if(queue.get(0).BT()>quantum){
 executedTime = quantum;
 System.out.println("Executing process " + queue.get(0).PID()+" for "+executedTime+ " sec");
 elapsedTime +=executedTime;
 queue.get(0).decrementBT(quantum);
}

else if(queue.get(0).BT()<=quantum){
 executedTime=queue.get(0).BT();
 System.out.println("Executing process  " + queue.get(0).PID()+" for "+executedTime+ " sec");
 System.out.println("Process " + queue.get(0).PID()+" completed");
  elapsedTime+=executedTime;
 queue.get(0).computeTAT(elapsedTime);
 queue.get(0).computeWT();
 queue.get(0).decrementBT(quantum);
}

if(queue.get(0).BT()<=0)
  queue.remove(0);

System.out.println("Current queue:");
 for(i=0;i<queue.size();i++){
   System.out.println(queue.get(i));
 }

System.out.println("Do you wish to add another process? Y/N");
ch = sc.next();

if(ch.equalsIgnoreCase("N")){
for(i=0;i<queue.size();i++){
 queue.get(i).increment_TEMP_AT(elapsedTime);
}

  Collections.sort(queue,Process.sortingProcesses);
System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
     System.out.println(queue.get(i));
   }

}

else if(ch.equalsIgnoreCase("Y")){
 System.out.println("Enter the number of processes ");
 nn = sc.nextInt();

for(i=0;i<queue.size();i++){
   queue.get(i).increment_TEMP_AT(elapsedTime);
}
 System.out.println("Enter the process id, arrival time,burst time and priority");
  for(i=0;i<nn;i++){
   id = sc.nextInt();
   at = sc.nextInt();
   bt = sc.nextInt();
   pr = sc.nextInt();
      if(at>=elapsedTime){
       Process obj = new Process(id,at,bt,pr);
       process_list.add(obj);
       queue.add(obj);
       }
 }

 Collections.sort(queue, Process.sortingProcesses);
  System.out.println("Current queue :");
for(i=0;i<queue.size();i++){
     System.out.println(queue.get(i));
   }
}

if(queue.size()==0)
 break;
}while(queue!=null);
System.out.println("********************************************************");
System.out.println("All processes have been completed");
System.out.println("Process ID \t Turaround time \t Waiting time ");
for(i=0;i<process_list.size();i++){
averageWT+=process_list.get(i).WT();
averageTAT+=process_list.get(i).TAT();
System.out.println(process_list.get(i).PID() +"\t\t"+process_list.get(i).TAT() +"\t\t"+process_list.get(i).WT());
}


System.out.println("Average waiting time : "+(double)averageWT/(double)process_list.size() +" sec");
System.out.println("Average turnaround time : "+(double)averageTAT/(double)process_list.size()+" sec");
System.out.println("********************************************************");
sc.close();
}
}

