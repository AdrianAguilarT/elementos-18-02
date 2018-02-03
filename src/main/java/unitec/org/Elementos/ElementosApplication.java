package unitec.org.Elementos;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElementosApplication implements CommandLineRunner{

        @Autowired RepositorioMensajitos repoMensa;
	public static void main(String[] args) {
		SpringApplication.run(ElementosApplication.class, args);
                
	}

    @Override
    public void run(String... strings) throws Exception {
        // INSERT
        //Mensajitos primerInsert=new Mensajitos("primero","Mi primer mensajito con Hibernate"); // Datos
        //repoMensa.save(primerInsert); // Insert
        
        // SELECT * FROM Mensajitos...
        //ArrayList<Mensajitos> mensajitos = (ArrayList<Mensajitos>)repoMensa.findAll();
        //for (Mensajitos mensa: mensajitos){
        //System.out.println(mensa.getTitulo());
        //}
        
        // SELECT * FROM Mensajitos WHERE ID = ...
        Mensajitos m1 = repoMensa.findOne(1);
        //System.out.println(m1.getTitulo());
        
        // UPDATE 
        //repoMensa.save(new Mensajitos(1,"otro","malo"));
        
        // DELETE
        //repoMensa.delete(1);
    }
    

}
