package unitec.org.Elementos;

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
        Mensajitos n=new Mensajitos("primero","Mi primer mensajito con Hibernate");
        repoMensa.save(n);
    }
}
