package lab4_jesusr;

import java.util.Scanner;

public class Lab4_JesusR {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int Opcion;
        do {
            System.out.println("Ingrese su opcion: ");
            System.out.println("1: Sumador Binario");
            System.out.println("2:Contains");
            System.out.println("3:Alpha");
            System.out.println("Ingrese su opcion");
            Opcion = leer.nextInt();
            switch (Opcion) {
                case 1:
                    String PN,
                     SN;
                    System.out.println("Ingrese un numero binario: ");
                    PN = leer.next();
                    System.out.println("Ingrese otro numero binario: ");
                    SN = leer.next();
                    while (PN.length() != SN.length()) {
                        System.out.println("No tiene el numero de bits adecuado. Ingrese una cadena adecuada para la primera"
                                + " cadena");
                        PN = leer.next();
                    }
                    System.out.println(PN);
                    for (int i = 0; i < PN.length(); i++) {
                        char Val = PN.charAt(i);
                        if (Val != '0' && Val != '1') {
                            System.out.println("Ingrese un numero valido en la primera");
                            PN = leer.next();
                        }
                    }
                    for (int i = 0; i < SN.length(); i++) {
                        char Val = SN.charAt(i);
                        if (Val != '0' && Val != '1') {
                            System.out.println("Ingrese un numero valido en la segunda");
                            SN = leer.next();
                        }
                    }
                    Sumador(PN, SN);
                    break;

                case 2:
                    String P1,
                     P2;
                    System.out.println("Ingrese una palabra: ");
                    P1 = leer.next();
                    System.out.println("Ingrese otra palabra: ");
                    P2 = leer.next();
                    if (P2.length() > P1.length()) {
                        System.out.println("Esto no es correcto, la segunda palabra no puede ser mayor que la primera");
                        P2 = leer.next();
                    } else {
                        Extraer(P1, P2); 
                    }

                    break;

                case 3:
                    String Palab;
                    System.out.println("Ingrese una palabra: ");
                    leer.nextLine();
                    Palab = leer.nextLine();
                    Alpha(Palab);

            }
        } while (Opcion != 0);//fin do

    }//fin main

    public static void Sumador(String PN, String SN) {
        String suma = "";
        char lleva = '0';
        for (int i = PN.length() - 1; i >= 0; i--) {

            char P11 = PN.charAt(i);
            char P12 = SN.charAt(i);
            if (lleva == '0') {
                if (P11 == '0' && P12 == '0') {
                    suma = '0' + suma;
                    lleva = '0';

                }//
                else if (P11 == '0' && P12 == '1' || P11 == '1' && P12 == '0') {
                    suma = '1' + suma;
                    lleva = '0';

                }//FIN ELSE
                else if (P11 == '1' && P12 == '1') {
                    suma = '0' + suma;
                    lleva = '1';

                }//fin if

            }//fin if
            else if (P11 == '1' && P12 == '1') {
                suma = '1' + suma;
                lleva = '1';

            }//fin else
            else if (P11 == '0' && P12 == '1' || P11 == '1' && P12 == '0') {
                suma = '0' + suma;
                lleva = '1';
            }//
            else if (P11 == '0' && P12 == '0') {
                suma = '1' + suma;
                lleva = '0';
            }//fin else

        }//fin for
        if (lleva == '1') {
            suma = '1' + suma;
        }
        System.out.println("La suma es de:" + suma);
    }//fin sumador

     public static void Extraer (String P1, String P2){
        int cont=0; 
        for (int i = 0; i < P1.length(); i++) {
           if(P1.charAt(i)==P2.charAt(0)){
               for (int j = 0; j < P2.length(); j++) {
                 if(P1.charAt(i+j)==P2.charAt(j)){
                     cont++;
                 }  //fin if
                 else
                 {
                     cont=0;
                 }//fin else
               }//fin for
               if(cont==P2.length()){
                System.out.println("La cadena "+P1+" contiene la palabra "+P2);
            }
            else{
                System.out.println("La cadena no contiene la palabra por dentro");
            }
               System.out.println(cont);
           }//fin if 
                
                
            }//fin for
            
            
        }
    
    public static void Alpha(String Palab) {
        boolean alpha = true;
        String cadenaLower = Palab.toLowerCase();
        String Acumorden = "";
        int num = 0;
        int acum=0;

        for (int j = 0; j < cadenaLower.length(); j++) {
            char It = cadenaLower.charAt(j);
            //sout
            if ((int)It>=97 && (int)It<=122) {
                acum+=1;
            }//fin if
            else {
                acum=0;
                break;
            }
            

        }//fin for
        System.out.println(acum + " vs " + cadenaLower.length() + " vs " + Palab.length());
        if (acum==cadenaLower.length()) {
            System.out.println("Solo consiste letras");
        }
        else{
            System.out.println("NO solo hay letras");
        }

    }//fom Alpha
}//fin
