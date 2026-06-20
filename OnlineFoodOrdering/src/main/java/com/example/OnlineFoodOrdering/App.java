package com.example.OnlineFoodOrdering;
import java.time.LocalDate;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        while(true) {
        	System.out.println("1.Create 2.Read 3.Update 4.Delete 5.Exit");
        	System.out.println("Enter Choice :");
        	Session session=utility.getSessionFactory().openSession();
        	Transaction tx=session.beginTransaction();
        	int choice =sc.nextInt();
        	if(choice==5) {
        		System.out.println("Exiting !");
        		break;
        	}
        	switch(choice) {
        	case 1:
        		System.out.println("Enter order Details order id , customer id,food item,quantity,total amount,order date(yyyy mm dd),order status");
        		order o1=new order();
        		o1.setId(sc.nextInt());
        		o1.setCid(sc.nextInt());
        		o1.setItem(sc.next());
        		o1.setQuantity(sc.nextInt());
        		o1.setTotal(sc.nextInt());
        		int y=sc.nextInt();
        		int m=sc.nextInt();
        		int d=sc.nextInt();
        		o1.setDate(LocalDate.of(y, m, d));
        		o1.setStatus(sc.next());
        		session.persist(o1);
        		break;
        	case 2:
        		System.out.println("Enter order id:");
        		order o2=session.find(order.class, sc.nextInt());
        		if(o2!=null)
        			System.out.println(o2);
        		else {
					System.out.println("Order Not Found");
				}
        		break;
        	case 3:
        		System.out.println("Enter order to update:");
        		order o3=session.find(order.class,sc.nextInt());
        		if(o3!=null) {
        		o3.setCid(sc.nextInt());
        		o3.setItem(sc.next());
        		o3.setQuantity(sc.nextInt());
        		o3.setTotal(sc.nextInt());
        		int Y=sc.nextInt();
        		int M=sc.nextInt();
        		int D=sc.nextInt();
        		o3.setDate(LocalDate.of(Y, M, D));
        		o3.setStatus(sc.next());
        		session.merge(o3);
        		System.out.println("Order Updated  !");
        		}
        		else {
        			System.out.println("Order Not found  ");
        		}
        		break;
        	case 4:
        		System.out.println("Enter order id to delete !");
        		order o4=session.find(order.class, sc.nextInt());
        		if(o4!=null) {
        			session.remove(o4);
        			System.out.println("order Removed ");
        		}
        		else {
        			System.out.println("order Not found !");
        		}
        		break;
        	default:
        		System.out.println("Invalid choice --!");
        		break;
        	}
        	tx.commit();
        	session.close();
        }
        sc.close();
    }
}
