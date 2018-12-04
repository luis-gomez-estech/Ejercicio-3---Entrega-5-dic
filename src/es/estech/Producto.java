
package es.estech;

public class Producto {


    // se crean los atributos de los productos
    public String nombre;
    public double precio; // Aqui he rectiicado la variable precio que estaba en mayuscula
    public int existencias;

    // Ahora he rectificado tambien en el constructor la palabra precio

    public Producto(String nombre, double precio, int existencias) {
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }

    // Ahora se han creado los getter y setter, y he eliminado el get que habia

    /*

    public int GetExistencias() {
        return existencias;
    }

    */


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    // Ahora se ha creado el toString
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", existencias=" + existencias +
                '}';
    }


    // Este metodo se usa para una vez que e haga una compra se ejecuta este metodo restando a existencias el mismo valor d elos articulos comprados
    public void vender() {
        this.existencias--;
    }
}
