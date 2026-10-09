/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 44 "../../model.ump"
// line 135 "../../model.ump"
public class Student extends BMOClient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Attributes
  private String school;
  private String studentId;
  private int graduationYear;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram, BMOBank aBank, String aSchool, String aStudentId, int aGraduationYear)
  {
    super(aMemberId, aName, aPoints, aProgram, aBank);
    school = aSchool;
    studentId = aStudentId;
    graduationYear = aGraduationYear;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSchool(String aSchool)
  {
    boolean wasSet = false;
    school = aSchool;
    wasSet = true;
    return wasSet;
  }

  public boolean setStudentId(String aStudentId)
  {
    boolean wasSet = false;
    studentId = aStudentId;
    wasSet = true;
    return wasSet;
  }

  public boolean setGraduationYear(int aGraduationYear)
  {
    boolean wasSet = false;
    graduationYear = aGraduationYear;
    wasSet = true;
    return wasSet;
  }

  public String getSchool()
  {
    return school;
  }

  public String getStudentId()
  {
    return studentId;
  }

  public int getGraduationYear()
  {
    return graduationYear;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "school" + ":" + getSchool()+ "," +
            "studentId" + ":" + getStudentId()+ "," +
            "graduationYear" + ":" + getGraduationYear()+ "]";
  }
}