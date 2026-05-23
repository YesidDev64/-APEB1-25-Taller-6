import java.io.*;
import java.util.ArrayList;

public class GestorPadelBinario {
    private String nombreArchivo, rutaArchivo;    
    
    public GestorPadelBinario(String nombFile){
        nombreArchivo = nombFile;
        rutaArchivo = String.format("ArchivoBinario/%s", nombFile);
    }
    
    public boolean verificarRuta(){
        File archivo = new File(rutaArchivo);
        File carpeta = archivo.getParentFile();
        if(carpeta != null){
           if(!carpeta.exists()){
               System.out.printf("La carpeta %s no existe, compruebe la ruta o cree la carpeta...", 
                                 carpeta.getName());
               return false;
           } 
        }
        return true;
    }
    
    public void escrituraArchivoBinario(ArrayList<PartidoPadel> partidos){
        if(!verificarRuta()) return;        
        
        try {
            FileOutputStream archivoOut = new FileOutputStream(rutaArchivo);
            ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut);
            objetoOut.writeObject(partidos);
            System.out.println("Objetos serializados correctamente...");
            objetoOut.close();
            archivoOut.close();
        } catch (IOException e) {
            System.out.printf("Hubo un error en la escritura o creacion del archivo binario...\n%s\n", 
                              e.getMessage());
        }
    }
    
    public ArrayList<PartidoPadel> lecturaArchivoBinario(){
        ArrayList<PartidoPadel> partidos = new ArrayList<>();
        if(!verificarRuta()) return partidos;
        
        File file = new File(rutaArchivo);
        if(!file.exists()){
            System.out.println("El archivo no existe...");
            return partidos;
        }
        try {
            FileInputStream archivoIn = new FileInputStream(rutaArchivo);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);
            Object objeto = objetoIn.readObject();
            partidos = (ArrayList<PartidoPadel>) objeto;
            System.out.println("Archivo binario leido correctamente...");
            for (int i = 0; i < partidos.size(); i++) {
                if(i==0){
                    System.out.println("\nLectura desde Archivo Binario");
                    System.out.println("===========================================");
                }
                System.out.printf("%s vs %s| Marcador: %s|\n", 
                                  partidos.get(i).getNombre1(), 
                                  partidos.get(i).getNombre2(), 
                                  partidos.get(i).getMarcador());
            }
            archivoIn.close();
            objetoIn.close();
        } catch (IOException e) {
            System.out.printf("Hubo un error en la lectura del archivo binario...\n%s\n", 
                              e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.printf("No se reconocio el tipo de objeto guardado...\n%s\n", 
                              e.getMessage());
        }
        return partidos;
    }
}