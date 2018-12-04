package es.estech;

import java.util.Scanner;

public class Main {

    static AlmAcEn almacen;
    static Scanner entrada = new Scanner(System.in);
    static double total = 0;


    public static void main(String[] args) {

        // Ahora se crean los productos y los añadimos al arraylist producto de la clase AlmAcEn
        almacen = new AlmAcEn();
        almacen.productos.add(new Producto("Leche", 0.8, 3));
        almacen.productos.add(new Producto("Jamón", 8, 1));
        almacen.productos.add(new Producto("Magdalenas", 2.3, 5));
        almacen.productos.add(new Producto("Huevos", 1.4, 1));

        // despues se llama a la clase mostrarProductosYPedirProducto() y seguira en ella hasta que no introdujamos el 9, en casode introducir el 9 con
        //if (elegido == 9) continue; pasa al metodo despedida()
        mostrarProductosYPedirProducto();
        despedida();

    }

    // Metodo para mostrar si el producto se ha vendido o si esta agotado, o lo que he comentado, si introducimos el numero 9 pasará al metodo despedida
    private static void mostrarProductosYPedirProducto() {

        int elegido = 0;
        while(elegido != 9) { // Salir si se selecciona el producto 9

            //Lo que hacemos es llamar al metodo mostrarProductos() para mostrar el listado de productos del arraylist productos
            mostrarProductos();

            // En caso de querer salir si escribimos 9 el metodo deja de actuar y pas aal siguiente metodo despedida()
            System.out.print("Elige un producto (9 para salir): ");
            elegido = entrada.nextInt();

            if (elegido == 9) continue; // Salir si se selecciona el producto 9

            // Si hay existencias deja vender y escribira Vendido, y a la vez restará a existencias con el metodo vender()

            if (almacen.productos.get(elegido - 1).getExistencias() > 0) { // Aqui he rectificado Get pot get en minuscula
                System.out.println("Vendido.");
                total = total + almacen.productos.get(elegido - 1).precio; // Aqui he rectificado la palabra PRECIO por precio en minuscula
                almacen.productos.get(elegido - 1).vender();
            } else {
                System.out.println("Producto agotado");
                almacen.productos.remove(elegido - 1);
            }
        }
    }

    // Este metodo se usa para imprimir el total de la compra y a la vez damos el mensaje de Gracias por su visita
    private static void despedida() {
        System.out.println("Total a pagar: " + total);
        System.out.println("Gracias por su visita");
    }

    // Este metodo muestra los productos que incluye el arraylist
    private static void mostrarProductos() {
        System.out.println("LISTA DE PRODUCTOS");
        int i = 1;
        for (Producto producto : almacen.productos) {
            System.out.println(i +  ". " + producto.nombre + " " + producto.precio);  // Aqui he rectificado la palabra PRECIO por precio en minuscula
            i++;
        }
    }

}
