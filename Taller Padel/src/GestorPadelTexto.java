import java.io.*;
import java.util.ArrayList;

public class GestorPadelTexto {
    private String nombreArchivo, rutaArchivo;    
    
    public GestorPadelTexto(String nombFile){
        nombreArchivo = nombFile;
        rutaArchivo = String.format("ArchivoTexto/%s", nombFile);
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
    
    public String datosOut(PartidoPadel padel){
        return String.format("%s;%s;%s", 
                padel.getNombre1(), padel.getNombre2(), padel.getMarcador());
    }
    
    public void escrituraArchivoTexto(ArrayList<PartidoPadel> partidos){
        if(partidos.isEmpty()){
            System.out.println("No hay partidos registrados...");
            return;
        }
        
        if(!verificarRuta()) return;
        
        try {
            FileWriter archivoOut = new FileWriter(rutaArchivo);
            BufferedWriter archivoWriter = new BufferedWriter(archivoOut);
            
            for (int i = 0; i < partidos.size(); i++) {
                String cadena = datosOut(partidos.get(i));
                archivoWriter.write(cadena);
                archivoWriter.newLine();
            }
            System.out.println("Archivo de texto creado correctamente...");
            archivoWriter.close();
            archivoOut.close();
        } catch (IOException e) {
            System.out.printf("Hubo un error en la escritura o creacion del archivo...\n%s\n", 
                              e.getMessage());
        }
    }
    
    public ArrayList<PartidoPadel> lecturaArchivoTexto(){
        ArrayList<PartidoPadel> partidos = new ArrayList<>();
        if(!verificarRuta()) return partidos;
        
        File file = new File(rutaArchivo);
        if(!file.exists()){
            System.out.println("El archivo no existe...");
            return partidos;
        }
        
        try {
            FileReader archivoIn = new FileReader(rutaArchivo);
            BufferedReader archivoReader = new BufferedReader(archivoIn);
            String linea;
            System.out.println("\nLectura desde Archivo de Texto");
            System.out.println("===========================================");
            while((linea = archivoReader.readLine()) != null){
                String[] datos = linea.split(";");
                if(datos.length == 3){
                    String oponente1 = datos[0], 
                           oponente2 = datos[1], 
                           marcador = datos[2];
                    System.out.printf("%s vs %s| Marcador: %s|\n", 
                                      oponente1, oponente2, marcador);
                    partidos.add(new PartidoPadel(oponente1, oponente2, marcador));
                }else{
                    System.out.println("Hay una linea vacia o con datos faltantes...");
                    break;
                }
            }
            archivoIn.close();
            archivoReader.close();
        } catch (IOException e) {
            System.out.printf("Hubo un error en la escritura o creacion del archivo...\n%s\n", 
                              e.getMessage());
        }
        return partidos;
    }    
}