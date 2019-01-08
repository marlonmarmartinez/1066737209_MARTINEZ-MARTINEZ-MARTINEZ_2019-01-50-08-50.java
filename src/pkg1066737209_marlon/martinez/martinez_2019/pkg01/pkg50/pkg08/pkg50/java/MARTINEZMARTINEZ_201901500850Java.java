package pkg1066737209_marlon.martinez.martinez_2019.pkg01.pkg50.pkg08.pkg50.java;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class MARTINEZMARTINEZ_201901500850Java {

    public static void main(String[] args) {
        MARTINEZMARTINEZ_201901500850Java matriz = new MARTINEZMARTINEZ_201901500850Java();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el numero de filas : ");
        int n = entrada.nextInt();

        System.out.println("Ingrese el numero de columnas : ");
        int m = entrada.nextInt();

        if (n > 2 && m > 2) {

            System.out.println(matriz.numerosAleatorios(n, m));

        } else {

            System.out.println("El numero de filas y columnas debe ser mayor que dos");

        }
    }

    public int numerosAleatorios(int n, int m) {
        int k = n * m;
        int res;
        Random rnd = new Random();
        Stack< Integer> aleatorioSinRepetir = new Stack<>();
        int[][] matriz = new int[n][m];
        int horizontal[] = new int[m];
        int columnasPares[] = new int[m / 2];
        double sumaImpares = 0;
        double promedioimpares;
        int columnasmayor = 0;
        int contador = 0;
        int con = 0;
        int mayor = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                res = rnd.nextInt(k) + 1;

                while (aleatorioSinRepetir.contains(res)) {

                    res = rnd.nextInt(k) + 1;

                }

                aleatorioSinRepetir.push(res);
                matriz[i][j] = res;
            }
        }
        for (int i = 0; i < n; i++) {

            System.out.println("");

            for (int j = 0; j < m; j++) {

                System.out.print(matriz[i][j] + "\t");

            }
        }
        System.out.println("");
        System.out.println("=============================");

        for (int columna = 0; columna < m; columna++) {
            int suma = 0;
            for (int fila = 0; fila < n; fila++) {
                suma += matriz[fila][columna];
            }
            horizontal[columna] = suma;
        }

        for (int i = 0; i < m; i++) {

            System.out.print(horizontal[i] + "\t");

            if (i % 2 == 0) {

                sumaImpares = sumaImpares + horizontal[i];
                contador++;
            } else {

                columnasPares[con] = horizontal[i];
                con++;
            }
        }

        promedioimpares = (sumaImpares / contador);
        System.out.println("");
        System.out.println("Promedio columanas impares : " + promedioimpares);
        System.out.print("Cantidad de columnas cuyo total es mayor que : ");
        for (int i = 0; i < m / 2; i++) {

            System.out.print(columnasPares[i] + ": ");

            if (columnasPares[i] > mayor) {
                mayor = columnasPares[i];
            }
        }
        for (int i = 0; i < m; i++) {

            if (horizontal[i] > mayor && horizontal[i] > promedioimpares) {
                mayor = horizontal[i];
                columnasmayor++;
            }
        }

        System.out.print("= ");

        return columnasmayor;

    }

}
