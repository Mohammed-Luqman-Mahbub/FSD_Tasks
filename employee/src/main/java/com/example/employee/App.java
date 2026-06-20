package com.example.employee;
import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        while(true) {
        	System.out.println("1.Create 2.read 3.update 4.Delete 5.Exit");
        	Session session=utility.getSessionFactory().openSession();
        	Transaction transaction=session.beginTransaction();
        	System.out.println("Enter Choice");
        	int choice= sc.nextInt();
        	if(choice==5) {
        		System.out.println("Exiting --!");
        		break;
        	}
        	switch(choice) {
        	case 1:
        		emp e1=new emp();
        		System.out.println("Enter Employee id,name,department,joining date(yyyy mm dd)");
        		e1.setId(sc.nextInt());
        		e1.setName(sc.next());
        		e1.setDepartment(sc.next());
        		int y=sc.nextInt();
        		int m=sc.nextInt();
        		int d=sc.nextInt();
        		e1.setJoiningDate(LocalDate.of(y, m, d));
        		session.persist(e1);
        		System.out.println("Employee Added");
        		break;
        	case 2:
        		System.out.println("Enter Emplyee Id");
        		emp e2=session.find(emp.class, sc.nextInt());
        		if(e2==null) {
        			System.out.println("Employee Not Found");
        		}else {
        			System.out.println("Id :"+e2.getId()+"| Name :"+e2.getName()+"| Department: "+e2.getDepartment()+" |Joining Date:"+e2.getjoiningDate());
        		}
        		break;
        	case 3:
        		System.out.println("Enter Emplyee Id");
        		emp e3=session.find(emp.class, sc.nextInt());
        		if(e3!=null) {
        		System.out.println("Enter new Employee,name,department,joining date(yyyy mm dd)");
        		e3.setName(sc.next());
        		e3.setDepartment(sc.next());
        		int Y=sc.nextInt();
        		int M=sc.nextInt();
        		int D=sc.nextInt();
        		e3.setJoiningDate(LocalDate.of(Y, M, D));
        		session.persist(e3);
        		System.out.println("Employee is updated");
        		}else {
        			System.out.println("Employee Not Found !");
        		}
        		break;
        	case 4:
        		System.out.println("Enter Employee Id");
        		emp e4=session.find(emp.class, sc.nextInt());
        		if(e4!=null) {
        			session.remove(e4);
        			System.out.println("Employee Deleted !");
        		}else {
        			System.out.println("Employee Not Found");
        		}
        		break;
        	default:
        		System.out.println("Invalid Choice --!");
        		break;
        	}
        
        	transaction.commit();
        	session.close();
        }
        sc.close();
    }
}
