package task2;
import java.util.*;
public class StudentGradeCalculator {
	public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of subjects: "); 
        int n=sc.nextInt();
        int marks[]=new int[10];
        int total_marks=0;
        float avg_marks=0;
        String grade;
        System.out.println("Enter the marks in "+ n +" subjects(out of 100):");
        for(int i=0;i<n;i++){
             marks[i]=sc.nextInt();
             total_marks+=marks[i];
        }
        avg_marks=(float)total_marks/n;
        
        // Assigning Grades
        if (avg_marks>=95.0){
            grade="A+";
        }
        else if (avg_marks>=90.0){
            grade="A";
        }
        else if (avg_marks>=75.0){
            grade="B";
        }
        else if (avg_marks>=55.0){ 
            grade="C";
        }
        else if (avg_marks>=30.0){
            grade="D";
        }
        else{
            grade="E";
        }

        System.out.println("Result");
        System.out.println("Total marks: "+total_marks);
        System.out.println("Average marks: "+avg_marks);
        System.out.println("Grade: "+grade);
    }
}
