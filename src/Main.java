import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int opcion=0;
//        char jugador = 'J';
//        boolean bonus = false;
//        boolean repitiendo=false;
//        do{
//            bonus = false;
//            System.out.println("Ingrese un tamaño de arena: 1. Chica, 2.Mediana, 3.Grande, -1.SALIR");
//            opcion = s.nextInt();
//            if(opcion==1||opcion==2||opcion==3){
//                Arena a = new Arena(opcion);
//                char movimiento = ' ';
//                while(a.ganador==' '){
//                    if(!repitiendo || jugador=='J')
//                        a.printArena();
//                    else
//                        repitiendo = false;
//                    if(jugador=='J'){
//                        System.out.println("Su turno, utilice WASD para moverse o F para disparar");
//                        movimiento = Character.toUpperCase(s.next().charAt(0));
//                    }
//                    else {
//                        // Generar un movimiento aleatorio, incluyendo 'F'
//                        double randomDouble = Math.random(); // Genera un número aleatorio entre 0 (inclusive) y 1 (exclusivo)
//                        int randomNumber = (int) (randomDouble * 5); // Escala el número aleatorio al rango 0-4
//                        System.out.println("La máquina ha hecho un movimiento");
//
//                        // Mapear el número aleatorio a las opciones de movimiento
//                        switch (randomNumber) {
//                            case 0:
//                                movimiento = 'W';
//                                break;
//                            case 1:
//                                movimiento = 'A';
//                                break;
//                            case 2:
//                                movimiento = 'S';
//                                break;
//                            case 3:
//                                movimiento = 'D';
//                                break;
//                            case 4:
//                                movimiento = 'F';
//                                break;
//                            default:
//                                movimiento = 'W'; // En caso de un valor fuera de rango, simplemente elegir 'W'
//                                break;
//
//                        }
//                    }
//
//                    if(movimiento=='F'){
//                        if(a.hacerDisparo(jugador)){
//                            System.out.println("El jugador "+jugador+" ha ganado la partida!");
//                            break;
//                        }
//                        else{
//                            if(jugador=='J')
//                                jugador='M';
//                            else
//                                jugador='J';
//                        }
//                    }
//                    else{
//                        String mov =a.hacerMovimiento(movimiento, jugador);
//                        if(mov=="movido"){
//
//                            if(jugador=='J')
//                                jugador='M';
//                            else
//                                jugador='J';
//                        }
//                        else if(mov=="bonus"){
//                            System.out.println("Ha caído sobre el bonus. Tiene un nuevo movimiento.");
//                            bonus =true;
//                        }
//                        else{
//                            if(jugador!='M'){
//                                System.out.println("No es posible realizar el movimiento. Inténtelo nuevamente.");
//                                repitiendo = true;
//                            }
//                        }
//                    }
//
//
//                }
//            }
//            else{
//                System.out.println("No se ingresó una opción correcta");
//            }
//
//        }
//        while(opcion!=-1);
//
//
        System.out.println("Seleccione el tamaño de la arena (1: Chica, 2: Mediana, 3: Grande):");
        int choice = 3;

        int width, height;
        switch (choice) {
            case 1: width = 10; height = 10; break;
            case 2: width = 15; height = 10; break;
            default: width = 30; height = 15; break;
        }

        Arena2 arena = new Arena2(width, height);
        arena.initializeGame();
        arena.displayArena();

    }
}