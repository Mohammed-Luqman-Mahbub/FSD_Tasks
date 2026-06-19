package com.example.productDemo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Scanner;
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
                    product p1 = new product();
                    System.out.print("Enter ID, Name, Price: ");
                    p1.setId(sc.nextInt());
                    p1.setName(sc.next());
                    p1.setPrice(sc.nextDouble());
                    
                    session.persist(p1);
                    System.out.println("Product Inserted!");
                    break;

                case 2:
                    System.out.print("Enter ID to view: ");
                    product p2 = session.find(product.class, sc.nextInt());
                    if (p2 != null) {
                        System.out.println("ID: " + p2.getId() + " | Name: " + p2.getName() + " | Price: " + p2.getPrice());
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    product p3 = session.find(product.class, sc.nextInt());
                    if (p3 != null) {
                        System.out.print("Enter new Name and Price: ");
                        p3.setName(sc.next());
                        p3.setPrice(sc.nextDouble());
                        session.merge(p3);
                        System.out.println("Product Updated!");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 4: 
                    System.out.print("Enter ID to delete: ");
                    product p4 = session.find(product.class, sc.nextInt());
                    if (p4 != null) {
                        session.remove(p4);
                        System.out.println("Product Deleted!");
                    } else {
                        System.out.println("Product not found!");
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
