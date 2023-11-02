import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Programa para manejo de dsipositivos
 * NOTA: los csv que lee y escribe llevan un entero en la primera columan que representa el tipo de dispositivo. Este dato solo es de referencia, no se añade a la memoria del programa
 * @author Ultimate.Truth-Seeker
 * @version 1 nov 2023
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        List<DispositivoElectronico> dispositivos = new ArrayList<>();// Listado de dispositivos
        boolean menu = true;
        Scanner s = new Scanner(System.in);
        while (menu) {// menú de opciones
            System.out.println("Bienvenido, ingrese una opción:\n1.Añadir dispositivo\n2.Ver información de cada dispositivo\n3.Validar elementos encendidos y apagados\n4.Cargar archivo csv con datos\n5.Guardar datos en archivo csv\n6.Encender/Apagar por modelo/marca\n7.Salir");
            int op = s.nextInt();
            switch (op) {
                case 1:// añadir un nuevo dispositivo
                    System.out.println("Ingrese 1 si el dispositivo está encendido y 0 si está apagado");
                    int choice = s.nextInt();
                    while (choice < 0 && choice > 1){
                        choice = s.nextInt();
                    }
                    boolean status = false;
                    if (choice == 1) {
                        status = true;
                    }
                    System.out.println("Ingrese 1 si el dispositivo es un teléfono y 0 si es una computadora");
                    choice = s.nextInt();
                    while (choice < 0 && choice > 1){
                        choice = s.nextInt();
                    }
                    s.nextLine();
                    if (choice == 1) {
                        System.out.println("Ingrese el modelo del teléfono: ");
                        String modelo = s.nextLine();
                        dispositivos.add(new Telefono(status, modelo));
                    } else if (choice == 0) {
                        System.out.println("Ingrese la marca de la computadora: ");
                        String marca = s.nextLine();
                        dispositivos.add(new Computadora(status, marca));
                    }
                    break;
                case 2:// ver lista de dispositivos
                    System.out.println("Listado de dispositivos:");
                    for (DispositivoElectronico d : dispositivos) {
                        if (d.getClass() == Telefono.class) {
                            Telefono t = (Telefono) d;
                            System.out.println("Tipo: Teléfono, Encendido: " + t.isTurnedOn() + ", Modelo: " + t.getModelo());
                        } else if (d.getClass() == Computadora.class) {
                            Computadora c = (Computadora) d;
                            System.out.println("Tipo: Computadora, Encendido: " + c.isTurnedOn() + ", Marca: " + c.getMarca());
                        }
                    }
                    break;
                case 3:// verificar dispositivos encendidos y apagados
                    System.out.println("Elementos encendidos: ");
                    for (DispositivoElectronico d: dispositivos) {
                        if (d.isTurnedOn() == true) {
                            if (d.getClass() == Telefono.class) {
                                Telefono t = (Telefono) d;
                                System.out.println("Tipo: Teléfono, Encendido: " + t.isTurnedOn() + ", Modelo: " + t.getModelo());
                            } else if (d.getClass() == Computadora.class) {
                                Computadora c = (Computadora) d;
                                System.out.println("Tipo: Computadora, Encendido: " + c.isTurnedOn() + ", Marca: " + c.getMarca());
                            }
                        }
                    }
                    System.out.println("Elementos apagados: ");
                    for (DispositivoElectronico d: dispositivos) {
                        if (d.isTurnedOn() == false) {
                            if (d.getClass() == Telefono.class) {
                                Telefono t = (Telefono) d;
                                System.out.println("Tipo: Teléfono, Encendido: " + t.isTurnedOn() + ", Modelo: " + t.getModelo());
                            } else if (d.getClass() == Computadora.class) {
                                Computadora c = (Computadora) d;
                                System.out.println("Tipo: Computadora, Encendido: " + c.isTurnedOn() + ", Marca: " + c.getMarca());
                            }
                        }
                    }
                    break; 
                case 4:// Cargar de archivo .csv
                    System.out.println("Escriba el nombre del archivo csv a cargar. La extensión .csv se añade automáticamente");
                    s.nextLine();
                    String path = s.nextLine();
                    try (Scanner rd = new Scanner(new File(path+".csv"))) {
                        while (rd.hasNextLine()) {
                            Scanner ln = new Scanner(rd.nextLine());
                            ln.useDelimiter(",");
                            int type = Integer.parseInt(ln.next());
                            boolean on = Boolean.parseBoolean(ln.next());
                            String m = ln.next();
                            if (type == 1) {
                                dispositivos.add(new Telefono(on, m));
                            } else if (type == 0) {
                                dispositivos.add(new Computadora(on, m));
                            }
                        }
                        System.out.println("Lectura exitosa");
                    } catch (Exception e) {
                        System.out.println("Error en la lectura. Revise el nombre y la integridad del archivo.");
                    }
                    break;
                case 5:// Guardar en archivo .csv
                    System.out.println("Ingrese el nombre del archivo a escribir. La extensión .csv se añade automáticamente.");
                    s.nextLine();
                    path = s.nextLine();
                    try (FileWriter wr = new FileWriter(new File(path + ".csv"))) {
                        for (DispositivoElectronico d : dispositivos) {
                            if (d.getClass() == Telefono.class) {
                                Telefono t = (Telefono) d;
                                wr.write("1,"+d.isTurnedOn()+","+t.getModelo()+"\n");
                            } else if (d.getClass() == Computadora.class) {
                                Computadora c = (Computadora) d;
                                wr.write("0,"+d.isTurnedOn()+","+c.getMarca()+"\n");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error en la escritura");
                    }
                    break;
                case 6://Encender o apagar los dispositivos de cierto tipo
                    System.out.println("Ingrese el modelo/marca de dispositivo a cambiar de estado:");
                    s.nextLine();
                    String mm = s.nextLine();
                    for (DispositivoElectronico d : dispositivos) {
                        if (d.getClass() == Telefono.class) {
                            Telefono t = (Telefono) d;
                            if (t.getModelo().equals(mm)) {
                                if (t.isTurnedOn()) {
                                    dispositivos.get(dispositivos.indexOf(d)).Off();
                                } else {
                                    dispositivos.get(dispositivos.indexOf(d)).On();
                                }
                            }
                        } else if (d.getClass() == Computadora.class) {
                            Computadora c = (Computadora) d;
                            if (c.getMarca().equals(mm)) {
                                if (c.isTurnedOn()) {
                                    dispositivos.get(dispositivos.indexOf(d)).Off();
                                } else {
                                    dispositivos.get(dispositivos.indexOf(d)).On();
                                }
                            }
                        }
                    }
                    break;
                case 7:// Salir
                    menu = false;
                    break;
                default:
                    break;
            }
        }
        s.close();
    }
}