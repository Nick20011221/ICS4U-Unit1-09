import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * This program generates and prints marks for some students and finds the overall average.
 * 
 * @author Nick P-A
 * @since 2020/3/6
 * @version 1.0
 */
 
public class Studentmarks {
  
  private static int randomSkewedNumber() {
    Random random = new Random();
    int randomNumb = random.nextInt(101);
    int randomNumb2 = random.nextInt(101);
    if (randomNumb > randomNumb2) {
      return randomNumb;
    }   else {
      return randomNumb2;
    }
  }

  private static double average(double[][] array) {

    double[] studentAverages = new double[array.length];
    double studentMark = 0;
    double overallAverage = 0;

    for (int student = 0; student < array.length; student++) {
      studentMark = 0;
      for (double assignment: array[student]) {
        studentMark += assignment;
      }
      studentAverages[student] = studentMark / array[student].length;
    }

    for (double studentAverage: studentAverages) {
      overallAverage += studentAverage;
    }

    return (double) Math.round(overallAverage / studentAverages.length * 100) / 100;
  }


  /**
  * this class prints the marks of the students.
  */


  public static void main(String[] args) {

    double[][] classroom = new double[4][6];


    for (double[] student: classroom) {
      for (int assignment = 0; assignment < student.length; assignment++) {
        student[assignment] = randomSkewedNumber();
      }
    }

    for (int student = 0; student < classroom.length; student++) {
      System.out.print("Student" + (student + 1) + ":");
      for (double assignment: classroom[student]) {
        System.out.print(" " + (int)assignment);
      }
      System.out.println();
    }
    System.out.println("The class average is " + average(classroom));
  }
}