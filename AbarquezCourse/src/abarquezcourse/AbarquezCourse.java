
package abarquezcourse;

import java.util.Scanner;


public class AbarquezCourse {
    
    static Scanner sc = new Scanner(System.in);
    config conf = new config();
    

    
    public void addCourse() {
        
            config conf = new config();
            System.out.println("Course ID");
            String c_id = sc.next();
            System.out.print("Course Name: ");
            String c_name = sc.next();
            System.out.print("Course Code: ");
            String c_code = sc.next();
            System.out.print("Course Cred: ");
            String c_credits = sc.next();
            System.out.print("Course Sem: ");
            String c_semester = sc.next();
            System.out.println("Course Years: ");
            String c_year = sc.next();

            String sql = "INSERT INTO tbl_Course ( c_id, c_name, c_code, c_credits, c_semester, c_year) VALUES (?, ?, ?, ?, ?, ?)";
            conf.addRecord(sql, c_id, c_name, c_code, c_credits, c_semester, c_year);
    }
    public static void main(String[] args) {
        
        String resp;
        
        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter action: ");
            int action = sc.nextInt();
            AbarquezCourse test = new AbarquezCourse(); 

            switch (action) {
                case 1:
                    test.addCourse();
                    break;
                case 2:
                    test.viewCourse(); 
                    break;
                case 3:
                    test.viewCourse();
                    test.updateCourse();
                    break;
                case 4:
                    test.viewCourse(); 
                    test.deleteCourse(); 
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
            }

            System.out.print("Continue? (yes/no): ");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("yes"));

        System.out.println("Thank You!");
    }

   
    public void viewCourse() {
        String Query = "SELECT * FROM tbl_Course";
        String[] Hdr = {"Course ID", "Course name", "Course Code", "Course Credits", "Course semester", "Course Year"};
        String[] Clmn = {"c_id", "c_name", "c_code", "c_credits", "c_semester", "c_year"};
        
        conf.viewRecords(Query, Hdr, Clmn);
    }

    public void updateCourse() {
        System.out.print("Select ID: ");
        int updateID = sc.nextInt();
        
        String sqlUpdate;
        
        System.out.print("Choose what to update: "
                + "\n1. Course ID"
                + "\n2. Course name"
                + "\n3. Course Code"
                + "\n4. Course Credits"
                + "\n5. Course semester"
                + "\n6. Course Year"
                + "Enter selection: ");
        int updateSelection = sc.nextInt();
        
        switch(updateSelection){
            case 1:
                System.out.print("Enter new Course ID : ");
                sc.nextLine();
                String newSport = sc.nextLine();
                
                sqlUpdate = "UPDATE tbl_Course set c_id = ? WHERE tbl_Course = ?";
                conf.updateRecord(sqlUpdate, newSport, updateID);
                break;
            case 2:
                System.out.print("Enter new Course name: ");
                String newFname = sc.next();
                
                sqlUpdate = "UPDATE tbl_Course set c_name = ? WHERE tbl_Course = ?";
                conf.updateRecord(sqlUpdate, newFname, updateID);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid action. Please try again.");
        }
    }

    public void deleteCourse() {
       System.out.print("Select ID: ");
        int deleteID = sc.nextInt();
        
        String sqlDelete = "DELETE FROM tbl_Course WHERE tbl_Course = ?";
        conf.deleteRecord(sqlDelete, deleteID);
    }
}
    

        
        
        
    