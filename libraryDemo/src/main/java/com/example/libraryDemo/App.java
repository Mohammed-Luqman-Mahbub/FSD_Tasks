package com.example.libraryDemo;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true) {
        	System.out.println("1. Create 2.Read 3.Update 4.Delete 5.Exit");
        	System.out.println("Enter choice :");
        	int choice=sc.nextInt();
        	if(choice==5) {
        		System.out.println("Exiting ..!");
        		break;
        	}
        	Session session=utility.getSessionFactory().openSession();
        	Transaction tx=session.beginTransaction();
        	switch (choice) {
        	case 1:
        		System.out.println("Enter Book id,title,author,category,price,available copies :");
        		book b1=new book();
        		b1.setId(sc.nextInt());
        		b1.setTitle(sc.next());
        		b1.setAuthor(sc.next());
        		b1.setCategory(sc.next());
        		b1.setPrice(sc.nextDouble());
        		b1.setNumberofcopies(sc.nextInt());
        		session.persist(b1);
        		break;
        		
        	case 2:
        		System.out.println("Enter ID :");
        		book b2=session.find(book.class, sc.nextInt());
        		if(b2!=null) {
        			System.out.println("Id :"+b2.getId()+"| Title:"+b2.getTitle()+"| Author:"+b2.getAuthor()+"| Category:"+b2.getCategory()+"| Price:"+b2.getPrice()+"| Number of copies availabel:"+b2.getNumberofcopies());
        		}else {
        			System.out.println("Book Not Found !");
        		}
        		break;
        	case 3:
        		System.out.println("Enter Id :");
        		book b3=session.find(book.class,sc.nextInt());
        		if(b3!=null) {
        			System.out.println("Enter new Book title,author,category,price,available copies :");
        			b3.setTitle(sc.next());
            		b3.setAuthor(sc.next());
            		b3.setCategory(sc.next());
            		b3.setPrice(sc.nextDouble());
            		b3.setNumberofcopies(sc.nextInt());
            		session.persist(b3);
            		System.out.println("Book Updated");
        		}
        		else {
        			System.out.println("Book Not Found !");
        		}
        		break;
        	case 4:
        		System.out.println("Enter Id to Delete");
        		book b4=session.find(book.class, sc.nextInt());
        		if(b4!=null) {
        			System.out.println("Book Deleted  !");
        			session.remove(b4);
        		}
        		else {
        			System.out.println("Book Not Found !");
        		}
        		break;
        	default:
        		System.out.println("Invalid Choice");
        		break;
        		
        	}
        	tx.commit();
        	session.close();
        }
        sc.close();
    }
}
