package com.becoder;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello ! Satyam Welcome in Hibernates" );
        
        Configuration cfg =new Configuration();
        cfg.configure();
        
       SessionFactory factory=cfg.buildSessionFactory();
       System.out.println(factory);
    }
}
