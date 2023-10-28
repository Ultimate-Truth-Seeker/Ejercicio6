import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        List<DispositivoElectronico> dispositivos = new ArrayList<>();
        // TODO: implementar csv
        dispositivos.add(new Telefono(false, "xd"));

        boolean menu = true;
        Scanner s = new Scanner(System.in);
        while (menu) {
            int op = s.nextInt();
            switch (op) {
                case 1:
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
                case 2:
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
                    break; 
                case 3:
                    menu = false;
                    break;
                default:
                    break;
            }
        }
        s.close();
    }
}