package com.java.pianomaster;
/* 
import org.springframework.beans.factory.annotation.Autowired;
*/
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* 
import com.java.pianomaster.entidades.Estudiante;
import com.java.pianomaster.repositorios.EstudianteRepositorio;
*/
@SpringBootApplication
public class PianomasterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PianomasterApplication.class, args);
	}
/* 
	@Autowired
	private EstudianteRepositorio repositorio;
   */ 
	@Override
	public void run(String... args) throws Exception{
/* 
		
		Estudiante estudiante1 = new Estudiante("Juan", "Parra", "juanjo@gmail.com");
		repositorio.save(estudiante1);

		Estudiante estudiante2 = new Estudiante("Sara", "Villalobos", "saraVilla@gmail.com");
		repositorio.save(estudiante2);
	*/	
		
	}

}
