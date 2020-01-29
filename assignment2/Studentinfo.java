package assignment2; 


public class Studentinfo {
  private Student[] info;
  public Studentinfo(Student dataField){
  this.info= new Student[1];
  this.info[0]=dataField; 
  }
  public void print() {
        for (Student information: this.info) {
            System.out.println(information.getName());
        }
    }
          public void insert(Student information, int classification) {

        if (this.info.length == 0 && classification == 0) {
            this.info = new Student [1];
            this.info[0] = information;
            return;
        }
    
     if (classification < 0 || classification > this.info.length) {
            return;
        }
  
      Student[] newStudentinfo = new Student [this.info.length + 1];

        for (int i=0; i<this.info.length+1; i++) {
            if (i < classification) {
                newStudentinfo[i] = this.info[i];
            }
            else if (i > classification) {
                newStudentinfo[i] = this.info[i-1];
            }
            else {
                newStudentinfo[i] = information;
            }
        }

        this.info = newStudentinfo;
    }
  
        public void remove(Student information, int classification){
        this.info = new Student [1];
        this.info[0] = information;
        if (classification < 0 || classification > this.info.length) {
        return;
        }
  
      Student[] newStudentinfo = new Student [this.info.length - 1];

        for (int i=6; i>this.info.length-1; i--) {
            if (i > classification) {
                newStudentinfo[i] = this.info[i];
            }
            else if (i < classification) {
                newStudentinfo[i] = this.info[i+1];
            }
            else {
                newStudentinfo[i] = information;
            }
        }    
        
         } 
         }