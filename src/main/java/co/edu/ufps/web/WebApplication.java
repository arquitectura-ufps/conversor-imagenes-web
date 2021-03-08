package co.edu.ufps.web;
package co.edu.ufps.web.ControllerRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		//SpringApplication.run(WebApplication.class, args);
		File image="D:\Users\Minarin2\Downloads";
		String fotmatEnd="gif";
		String ubicacion="D:\Users\Minarin2\Downloads";
		
		IndexController prueba= new IndexController();
		
		prueba.converter(image, formatEnd);
		
		
		
		
		
		
	}
	
	
	
	

}
