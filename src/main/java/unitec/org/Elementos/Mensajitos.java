
package unitec.org.Elementos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // Especifica que la clase es una Entidad (se asocia a una tabla de una BD Relacional)
public class Mensajitos {
    @Id //Especifica la PK de una entidad
    @GeneratedValue // Genera un valor automático
    Integer id;
    String titulo, cuerpo;

    //CONSTRUCTORES
    public Mensajitos() {
    }

    public Mensajitos(Integer id) {
        this.id = id;
    }

    public Mensajitos(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Mensajitos(Integer id, String titulo, String cuerpo) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }
    
    //GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    
}
