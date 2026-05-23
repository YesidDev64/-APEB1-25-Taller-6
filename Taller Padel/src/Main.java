import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        ArrayList<PartidoPadel> listaPartidos = new ArrayList<>();
        GestorPadelTexto gestorTexto = new GestorPadelTexto("partidosPadel.txt");
        GestorPadelBinario gestorBinario = new GestorPadelBinario("partidoPadel.dat");
        int opcion;
        do {
            System.out.printf("\n--------PARTIDOS DE PADEL--------\n"
                            + "[1] Registrar nuevo partido\n"
                            + "[2] Guardar datos en Archivo.txt\n"
                            + "[3] Guardar datos en Archivo.dat\n"
                            + "[4] Leer y cargar datos de Archivo.txt\n"
                            + "[5] Leer y cargar datos de Archivo.dat\n"
                            + "[6] Mostrar partidos registrados\n"
                            + "[7] Eliminar partido\n"
                            + "[8] Salir\n"
                            + "Ingrese una opcion: ");
            opcion = tcl.nextInt();
            tcl.nextLine();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Digame el nombre del jugador 1: ");
                    String pareja1 = tcl.nextLine();
                    System.out.print("Digame el nombre del jugador 2: ");
                    String pareja2 = tcl.nextLine();
                    System.out.print("Digame el marcador final del partido: ");
                    String marcador = tcl.nextLine();
                    PartidoPadel partido = new PartidoPadel(pareja1, pareja2, marcador);
                    listaPartidos.add(partido);
                    System.out.println("Partido registrado");
                }
                case 2 -> gestorTexto.escrituraArchivoTexto(listaPartidos);  
                case 3 -> gestorBinario.escrituraArchivoBinario(listaPartidos);  
                case 4 -> listaPartidos = gestorTexto.lecturaArchivoTexto();
                case 5 -> listaPartidos = gestorBinario.lecturaArchivoBinario();
                case 6 -> {
                    if(listaPartidos.isEmpty())
                        System.out.println("No hay partidos registrados para mostrar...");
                    else{
                        System.out.printf("--------PARTIDOS REGISTRADOS--------\n");
                        for (int i = 0; i < listaPartidos.size(); i++) {
                            System.out.printf("[%d] %s vs %s| Marcador: %s|\n", 
                                  i, listaPartidos.get(i).getNombre1(), 
                                      listaPartidos.get(i).getNombre2(), 
                                      listaPartidos.get(i).getMarcador());
                        }   
                    }
                }
                case 7 -> {
                    if(listaPartidos.isEmpty())
                        System.out.println("No hay partidos registrados para eliminar...");
                    else{
                        System.out.print("Dime el indice del partido que deseas eliminar: ");
                        int indice = tcl.nextInt();
                        if(indice >= 0 && indice < listaPartidos.size()){
                            listaPartidos.remove(indice);
                            System.out.println("Partido eliminado...");
                        }else
                            System.out.println("Indice invalido");
                    }    
                }
                case 8 -> {System.out.println("Saliendo del programa..."); break;}
                default -> System.out.println("Opcion no disponible...");
            }
        } while (opcion != 8);
    }
}