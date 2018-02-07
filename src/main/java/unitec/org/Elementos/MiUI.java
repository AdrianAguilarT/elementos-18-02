
package unitec.org.Elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI   //Indica que usará la UI de Spring
@Theme("valo")  //Usará el tema Valo
public class MiUI extends UI{
    Grid<Mensajitos> grid = new Grid<>();
    public TextField t1;
    public TextField t2 ;
    public Integer miId;
    
    @Autowired RepositorioMensajitos repoMensa;    
    @Override
    protected void init(VaadinRequest request) {
        
        t1=new TextField();
        t2=new TextField();
        
        /*Agregaremos un Layout vertical y dentro de el, las componentes
        que quedarán en orden descendente*/
        VerticalLayout layout=new VerticalLayout();
        
        Label e1=new Label("¡Bienvenido!");
        e1.addStyleName(ValoTheme.LABEL_H1);
        
        Button b1=new Button("Guardar");
        b1.addStyleName(ValoTheme.BUTTON_DANGER);
                
        /*Vamos a programaer el evento del botón b1, usando Programación
        Funcional*/
        b1.addClickListener(algo->{
            //Aquí ponemos el evento
            e1.setValue("Mi primer programación funcional");
        });
        
        //Agregamos las componentes al Layout
        layout.addComponent(e1);
        layout.addComponent(b1);
        
        
        List<Mensajitos> mensajitos = (List<Mensajitos>) repoMensa.findAll();

            
            grid.setItems(mensajitos);
            grid.addColumn(Mensajitos::getId).setCaption("ID");
            grid.addColumn(Mensajitos::getTitulo).setCaption("Título del mensaje");
            grid.addColumn(Mensajitos::getCuerpo).setCaption("Cuerpo del mensaje");
            
            grid.setSelectionMode(SelectionMode.SINGLE);
            
           
            grid.addItemClickListener(evento -> {
              t1.setValue(evento.getItem().getTitulo());
              t2.setValue(evento.getItem().getCuerpo());
              miId=evento.getItem().getId();
                MiVentana sub = new MiVentana();
                UI.getCurrent().addWindow(sub);
                
            });

            layout.addComponent(grid);
            
            
        //Se agrega el Layout solo UNA VEZ al index.
        setContent(layout);
        
        
    }


class MiVentana extends Window {
    public MiVentana() {
        super("Actualizaciones"); // Título
        center(); //Localización
        //setClosable(false); // Disable the close button
        
        // Inserción de objetos:
        VerticalLayout vl1 = new VerticalLayout();
        Button boton = new Button("Actualizar");
        
        vl1.addComponent(t1);
        vl1.addComponent(t2);
        vl1.addComponent(boton);

        //Evento del boton:
        boton.addClickListener(evento -> {
            repoMensa.save(new Mensajitos(miId,  t1.getValue(), t2.getValue())); //Actualiza con nuevos datos
            close();
            
            //grid.getData().
            //grid.getDataProvider().refreshAll();
        });
        
        setContent(vl1); //Inserta los objetos
    }
}
}