package assignment2;


public class Studentlist {

   public static void main(String[] args){
   System.out.println("student information");
   
   Studentinfo info1= new Studentinfo(new Student("Tarik"));
   info1.insert(new Student("gpa = 3.9"), 1);  
   info1.insert(new Student("Calculus:A"), 2); 
   info1.insert(new Student("Physics:A"), 3);
   info1.insert(new Student("Student ID:s01140641"), 4);
  info1.print();
   System.out.println("removed:");
   info1.remove(new Student("Student ID:s01140641"), 4);
   info1.print();
   }
   
 
   

}