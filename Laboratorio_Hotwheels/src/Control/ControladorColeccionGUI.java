package Control;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.ColeccionGUI;
import Modelo.Auto;
import Modelo.Coleccion;

public class ControladorColeccionGUI implements ActionListener {
    //atributos

    private ColeccionGUI unaColeccion;
    private Auto unAuto;
    private Coleccion coleccionAutos;

    //Constructor
    public ControladorColeccionGUI() {

        this.unaColeccion = new ColeccionGUI();
        this.unAuto = new Auto();
        this.coleccionAutos = new Coleccion();
        this.unaColeccion.setVisible(true);

        //Agregar escuchas o listener de botones
        //error con el this como parametro
        this.unaColeccion.jButtonAgregarAuto.addActionListener((ActionListener) this);
        this.unaColeccion.jButtonBorrarAuto.addActionListener(this);
        this.unaColeccion.jButtonBuscarAuto.addActionListener(this);
        this.unaColeccion.jButtonListarAuto.addActionListener(this);

    }

    //Métodos
    public void actionPerformed(ActionEvent e) {
        //eventos
        //evento Agregar auto
        //posiblemente en esté evento hay que llamar a la clase agregarAutoGUI
        if (e.getSource() == this.unaColeccion.jButtonAgregarAuto) {

            ControladorAgregarAutoGUI agregarAuto = new ControladorAgregarAutoGUI();
            agregarAuto.setCtrlColeccion(this);
            this.coleccionAutos.getAutos().add(this.unAuto);
            
        }

        //Evento Borrar Auto
        //No está borrando carros
        if (e.getSource() == this.unaColeccion.jButtonBorrarAuto) {

            if (this.coleccionAutos.getAutos().size() != 0) {

                for (int i = 0; i < this.coleccionAutos.getAutos().size(); i++) {

                    if (this.unaColeccion.jtf_anhoSerieC.getText().equals(this.coleccionAutos.getAutos().get(i).getAnhoSerie())) {
                        //javax.swing.JOptionPane.showMessageDialog(null, "El auto se borro con exito !!! ");
                        if (this.unaColeccion.jtf_numSerieC.getText().equals(this.coleccionAutos.getAutos().get(i).getNumeroSerie())) {
                            this.coleccionAutos.borrarAuto (Integer.parseInt(unaColeccion.jtf_anhoSerieC.getText()), Integer.parseInt(unaColeccion.jtf_numSerieC.getText()));
                            javax.swing.JOptionPane.showMessageDialog(null, "El auto se borro con exito !!! ");
                        }
                    }

                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "No hay autos en la coleccion para borrar");

            }
        }

        //Evento Listar Autos
        if(e.getSource()== this.unaColeccion.jButtonListarAuto){
            String listaAutos = coleccionAutos.listarColeccion();
            JOptionPane.showMessageDialog(null, listaAutos, "Lista de Autos", JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getSource()== this.unaColeccion.jButtonBuscarAuto){
            // Implementar la lógica para buscar un auto
            int anhoSerie = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de serie del auto a buscar:"));
            int numSerie = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de serie del auto a buscar:"));
            
            String resultadoBusqueda = coleccionAutos.buscarAuto(anhoSerie, numSerie);
            JOptionPane.showMessageDialog(null, resultadoBusqueda, "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // getters and setters
    public ColeccionGUI getUnaColeccion() {
        return unaColeccion;
    }

    public void setUnaColeccion(ColeccionGUI unaColeccion) {
        this.unaColeccion = unaColeccion;
    }

    public Auto getUnAuto() {
        return unAuto;
    }

    public void setUnAuto(Auto unAuto) {
        this.unAuto = unAuto;
    }

    public Coleccion getColeccionAutos() {
        return coleccionAutos;
    }

    public void setColeccionAutos(Coleccion coleccionAutos) {
        this.coleccionAutos = coleccionAutos;
    }

    
}