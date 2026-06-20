package com.example.studentDemo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Create  2.Read  3.Update  4.Delete  5.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }
            Session session = utility.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            switch (choice) {
                case 1:
                    student s1 = new student();
                    System.out.print("Enter Student ID, Name, email,course,age : ");
                    s1.setId(sc.nextInt());
                    s1.setName(sc.next());
                    s1.setEmail(sc.next());
                    s1.setCourse(sc.next());
                    s1.setAge(sc.nextInt());
                    
                    session.persist(s1);
                    System.out.println("Student Added!");
                    break;

                case 2:
                    System.out.print("Enter ID to view: ");
                    student s2 = session.find(student.class, sc.nextInt());
                    if (s2 != null) {
                        System.out.println("ID: " + s2.getId() + " | Name: " + s2.getName() + " | Email: " + s2.getEmail() +" |Course : "+s2.getCourse()+" | Age: "+s2.getAge());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    student s3 = session.find(student.class, sc.nextInt());
                    if (s3 != null) {
                        System.out.print("Enter new Name , email ,Course and Age : ");
                        s3.setName(sc.next());
                        s3.setEmail(sc.next());
                        s3.setCourse(sc.next());
                        s3.setAge(sc.nextInt());
                        session.merge(s3);
                        System.out.println("Student Updated!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4: 
                    System.out.print("Enter ID to delete: ");
                    student s4 = session.find(student.class, sc.nextInt());
                    if (s4 != null) {
                        session.remove(s4);
                        System.out.println("Student Deleted!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            tx.commit();
            session.close();
        }
        sc.close();
    }
}
