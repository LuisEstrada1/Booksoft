// Sustentacion Practica 1 Ude@
package booksoft;


import java.util.Scanner;

public class Booksoft {
    
    public static void menu (){
            System.out.println("\nMENU PRINCIPAL\n");
            System.out.println("1. Gestión de Libros");
            System.out.println("2. Gestión de Préstamos");
            System.out.println("3. Salir");
            System.out.println("\nSeleccione una opción: ");
    
    }
    
    public static void submenu (){
            System.out.println("\nGESTOR DE LIBROS\n");
            System.out.println("1. Ingresar Libro");
            System.out.println("2. Actualizar Libro");
            System.out.println("3. Eliminar Libro");
            System.out.println("4. Buscar Libro");
            System.out.println("5. Volver al Menú Principal");
            System.out.println("\nSeleccione una opción: ");
    }
    
    public static void submenu2 (){
            System.out.println("\nGESTOR DE PRESTAMOS\n");
            System.out.println("1. Prestar Libro");
            System.out.println("2. Devolver Libro");
            System.out.println("3. Libros Prestados");
            System.out.println("4. Volver al Menú Principal");
            System.out.println("\nSeleccione una opción: ");
    }
    
    
    public static void main(String[] args) {
        bookdata Datos[] = new bookdata [100]; //Almacena 100 Libros
        Prestamo Libros[] = new Prestamo[10];// Almacena 10 Prestamos
        Scanner lector = new Scanner (System.in);
        int opc = 0, subopc = 0, subopc2 = 0, contUs=0, band=0, cantidad=0, contPre = 0, libpre=0, ncantidad=0, libdev=0;//ContUs me permite saber cuantos usuarios hay en el sistema
        String name; //variable para eliminar buscar y actualizar
    
        do{
            menu();
            opc = lector.nextInt();
            
            
            switch (opc) {
                
                case 1:
                        do{
                            submenu();
                            subopc = lector.nextInt();
                        
                            switch (subopc){
                            case 1:
                                if (contUs<99){      
                                    Datos[contUs] =new bookdata();//Genera la posicion de Usuario a llenar
                                    System.out.print("Digite el nombre del Libro: ");
                                    Datos[contUs].setNombre(lector.next());
                                    System.out.print("Digite el Autor del Libro: ");
                                    Datos[contUs].setAutor(lector.next());
                                    System.out.print("Digite el Año de Publicación del Libro: ");
                                    Datos[contUs].setFecha(lector.next());
                                    System.out.print("Digite el Codigo del Libro: ");
                                    Datos[contUs].setCodigo(lector.next());
                                    System.out.print("Digite la Cantidad: ");
                                    Datos[contUs].setCantidad(lector.nextInt());
                                    System.out.print("Digite el Nombre de las Areas: \n1.Quimica"+
                                    "\n2.Fisica \n3.Tecnologia \n4.Calculo \n5.Programacion\n");
                                    Datos[contUs].setAreas(lector.next());
                        
                                    contUs++; 
                                    }
                                else
                                 System.out.println("NO HAY MAS MEMORIA");
                                break;
                            
                            case 2:
                                System.out.println("Actualizar Datos:\n");
                                System.out.println("Digite el nombre del Libro que desea Buscar");
                                name = lector.next();
                    
                                for(int i=0; i<contUs;i++){
                                    if (name.equals(Datos[i].getNombre())){
                                    //posAux=i;
                                    band = 1;
                                    System.out.print("Digite el Nuevo Autor del Libro: ");
                                    Datos[i].setAutor(lector.next());
                                    System.out.print("Digite el Nuevo Año de Publicación del Libro: ");
                                    Datos[i].setFecha(lector.next());
                                    System.out.print("Digite el Nuevo Código del Libro: ");
                                    Datos[i].setCodigo(lector.next());
                                    System.out.print("Digite la Nueva Cantidad: ");
                                    Datos[i].setCantidad(lector.nextInt());
                                    System.out.print("Digite el nombre de las areas: \n1.Quimica"+
                                    "\n2.Fisica \n3.Tecnologia \n4.Calculo \n5.Programacion\n");
                                    Datos[i].setAreas(lector.next());
                                    }
                                }
                                    //Sino encuentra usuario muestra mensaje    
                                    if (band==0){
                                    System.out.println("Libro No Encontrado\n");
                                    }   
                                    else
                                    band=0;// si no hago esto funcionaria solo la primera vez
                    
                                break;
                            case 3:
                                System.out.println("Eliminar Libro:\n");
                                System.out.println("Digite el nombre del Libro que desea Eliminar");
                                name = lector.next();
                                for(int i=0; i<contUs;i++){
                                    if (name.equals(Datos[i].getNombre())){
                                    //posAux=i;
                                    band = 1;
                                        if (i!=contUs){
                                            for (int j=i; j<contUs-1;j++){
                                                Datos[j].setNombre(Datos[j+1].getNombre());
                                                Datos[j].setAutor(Datos[j+1].getAutor());
                                                Datos[j].setFecha(Datos[j+1].getFecha());
                                                Datos[j].setCodigo(Datos[j+1].getCodigo());
                                                Datos[j].setCantidad(Datos[j+1].getCantidad());
                                                Datos[j].setAreas(Datos[j+1].getAreas());
                                            }
                                        }
                                        else
                                        Datos[contUs-1].setNombre("");
                                    }
                                }
                                //Sino encuentra usuario muestra mensaje    
                                if (band==0){
                                    System.out.println("Libro No Encontrado\n");
                                }
                                else
                                band=0;// si no hago esto funcionaria solo la primera vez
                                    contUs--;        
                            break;
                            
                            case 4:
                                System.out.println("Buscar Libro:\n");
                                System.out.println("Digite el nombre del Libro que desea Buscar");
                                name = lector.next();
                                for(int i=0; i<contUs;i++){
                                    if (name.equals(Datos[i].getNombre())){
                                        //posAux=i;
                                        band = 1;
                                        System.out.println("El Nombre del Libro es: "+Datos[i].getNombre());
                                        System.out.println("El Autor del Libro es: "+Datos[i].getAutor());
                                        System.out.println("El Código del Libro es: "+Datos[i].getCodigo());
                                        System.out.println("La Cantidad disponible del libro es: "+Datos[i].getCantidad());
                                        System.out.println("El Area del Libro es: "+Datos[i].getAreas());
                                    }
                                }
                                //Sino encuentra usuario muestra mensaje    
                                if (band==0){
                                    System.out.println("Libro No Encontrado\n");
                                }
                                else
                                    band=0;// si no hago esto funcionaria solo la primera vez
                            break;
                            
                            case 5:
                                //System.out.println("\nGRACIAS POR USAR EL PROGRAMA, BYE\n");
                            break;
                            
                            default:
                                System.out.println("\nOPCION INCORRECTA\n");
                            break;
                            }    
                    } while(subopc!=5);
                                   
                break;
                
                case 2:
                     do{
                            submenu2();
                            subopc2 = lector.nextInt();
                            
                            switch (subopc2){
                            case 1:
                                System.out.println("Digite el nombre del Libro que desea Prestar");
                                name = lector.next();
                               
                                for(int i=0; i<contUs;i++){
                                    
                                    if (name.equals(Datos[i].getNombre())){
                                        cantidad = Datos[i].getCantidad();
                                        System.out.println("Cantidad disponible: "+cantidad);
                                        band = 1;
                                        if (cantidad>0){
                                            Libros[contPre] =new Prestamo();//Genera la Posicion del usuario que prestó el libro
                                            System.out.println("Digite la Cédula del Usuario que desea prestar el libro: ");
                                            Libros[contPre].setCedula(lector.nextInt());
                                            Libros[contPre].setNombr(Datos[i].getNombre());
                                            Libros[contPre].setAuto(Datos[i].getAutor());
                                            Libros[contPre].setFech(Datos[i].getFecha());
                                            Libros[contPre].setCodig(Datos[i].getCodigo());
                                            Libros[contPre].setArea(Datos[i].getAreas());
                                            libpre=cantidad-1;
                                            Datos[i].setCantidad(libpre);
                                            contPre++;
                                            
                                        }
                                    else
                                            System.out.println("No hay libros disponibles");
                                        }
                                }
                                if (band==0){
                                    System.out.println("Libro No Encontrado\n");
                                }
                                else
                                    band=0;// si no hago esto funcionaria solo la primera vez
                                    //cantidad=0;
                                    //libpre=0;
                                
                            break;
                
                            case 2:
                                System.out.println("\nDEVOLUCIÓN DE LIBROS\n");
                                System.out.println("Digite el Nombre del Libro que desea Devolver: \n");
                                name = lector.next();
                                
                                for (int i=0; i<contUs;i++){
                                    if (name.equals(Datos[i].getNombre())){
                                    ncantidad=Datos[i].getCantidad();
                                    libdev=ncantidad+1;
                                    Datos[i].setCantidad(libdev);
                                    }
                                }
                                
                                for(int i=0; i<contPre;i++){
                                    if (name.equals(Libros[i].getNombr())){
                                    //posAux=i;
                                    band = 1;
                                        if (i!=contPre){
                                            for (int j=i; j<contUs-1;j++){
                                                Libros[j].setNombr(Libros[j+1].getNombr());
                                                Libros[j].setAuto(Libros[j+1].getAuto());
                                                Libros[j].setFech(Libros[j+1].getFech());
                                                Libros[j].setCodig(Libros[j+1].getCodig());
                                                Libros[j].setArea(Libros[j+1].getArea());
                                            }
                                        }
                                        else
                                        Libros[contPre-1].setNombr("");
                                    }
                                }
                                //Sino encuentra usuario muestra mensaje    
                                if (band==0){
                                    System.out.println("El Libro no Pertenece a Esta Biblioteca\n");
                                }
                                else
                                band=0;// si no hago esto funcionaria solo la primera vez
                                    contPre--;
                            break;
                            
                            case 3:
                                if (contPre!=0){
                                    for(int i=0; i<contPre;i++){
                                        band = 1;
                                        System.out.println("El Nombre del Libro prestado es: "+Libros[i].getNombr());
                                        System.out.println("El Autor del Libro es: "+Libros[i].getAuto());
                                        System.out.println("El Código del Libro es: "+Libros[i].getCodig());
                                        //System.out.println("La Cantidad disponible del libro es: "+Datos[i].getCantidad());
                                        System.out.println("El Area del Libro es: "+Libros[i].getArea());
                                        System.out.println("La Cedula del Usuario es: "+Libros[i].getCedula());
                                    }
                                }
                                else
                                
                                System.out.println("\nNO HAY LIBROS PRESTADOS, BYE\n");
                            
                            break;
                            
                            case 4:
                                //System.out.println("\nLIBROS PRESTADOS, BYE\n");
                            break;
                    
                            default:
                                System.out.println("\nOPCION INCORRECTA\n");
                            break; 
                            } 
                        } while(subopc2!=4);
                    
                    break;
                
                case 3:
                    System.out.println("\nGRACIAS POR USAR EL PROGRAMA, BYE\n");
                    break;
                    
                default:
                    System.out.println("\nOPCION INCORRECTA\n");
                    break; 
            } 
        } while(opc!=3);
    }
}    


