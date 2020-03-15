package Second.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	          
	        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	        Session session=factory.openSession();  
	          
	         Transaction t=session.beginTransaction();   
	         
	            

	            Book b1=new Book();    
	            b1.setTitle("hibetnet config");  
	            b1.setAuthor("angshuman");
	            b1.setPrice(200);
	            b1.setId(1);
	                
	                            
	            session.save(b1); 
	                 
	            t.commit();    
	            session.close();    
	            System.out.println("success"); 
	            session=factory.openSession();  
	            
	            t=session.beginTransaction();    
	               
	               Book b2=session.get(Book.class, 1L);    
	               
	               
	              
	                               
	                
	                    
	               t.commit();    
	               session.close(); 
	               
	               session=factory.openSession();  
	               
	               t=session.beginTransaction();    
	                  
	                  Book b3=session.get(Book.class, 1L);    
	                  
	                 
	                 
	                                  
	                   
	                       
	                  t.commit();    
	                  session.close(); 
	               
	               session=factory.openSession();  
	               
	               t=session.beginTransaction();
	               b1.setTitle("hibetnet config");  
	               b1.setAuthor("angshuman Chatterjee");
	               b1.setPrice(200);
	               b1.setId(1);
	               session.update(b1);
	               
	               t.commit();    
	               session.close();
	               }  


	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
