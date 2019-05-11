package eg.edu.alexu.csd.datastructure.linkedList.cs55_cs65;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PolynomialSolver IPolynomialSolver = new PolynomialSolver();
        System.out.println("__________________");
        System.out.println("1- Set a polynomial variable\r\n" + "2- Print the value of a polynomial variable\r\n"
                + "3- Add two polynomials\r\n" + "4- Subtract two polynomials\n" + "5- Multiply two polynomials\r\n"
                + "6- Evaluate a polynomial at some point\r\n" + "7- Clear a polynomial variable");
        System.out.println("=========================================================");
        System.out.println("Please choose an action:");

        int yalla;
        yalla = input.nextInt();

        while (yalla != -1){

            if (yalla == 1) {
                System.out.println("Insert the variable name: A, B or C");
                char n;
                n = input.next().charAt(0);
                System.out.println("Insert the polynomial terms in the form:\r\n"
                        + "(coeff1, exponent1), (coeff2, exponent2), ..");

                String lx = input.next();
                int c = 0;
                for (int i = 0; i < lx.length(); i++) {
                    if (lx.charAt(i) == '(') {
                        c++;
                    }
                }

                int[][] terms = new int[c][2];
                boolean h;
                int k = 0, len = lx.length();
                for (int i = 0; i < c; i++) {
                    for (int j = 0; j < 2; j++) {

                        h = false;
                        for (; k < len; k++) {

                            if (lx.charAt(k) == '-') {

                                h = true;
                            }
                            if (Character.isDigit(lx.charAt(k)) && Character.isDigit(lx.charAt(k + 1))
                                    && Character.isDigit(lx.charAt(k + 2))) {

                                terms[i][j] = Character.getNumericValue(lx.charAt(k)) * 100
                                        + Character.getNumericValue(lx.charAt(k + 1)) * 10
                                        + Character.getNumericValue(lx.charAt(k + 2));
                                if (h) {

                                    terms[i][j] = -terms[i][j];
                                }
                                k += 3;
                                break;
                            } else if (Character.isDigit(lx.charAt(k)) && Character.isDigit(lx.charAt(k + 1))) {

                                terms[i][j] = Character.getNumericValue(lx.charAt(k)) * 10
                                        + Character.getNumericValue(lx.charAt(k + 1));
                                if (h) {

                                    terms[i][j] = -terms[i][j];
                                }
                                k += 2;
                                break;
                            } else if (Character.isDigit(lx.charAt(k))) {

                                terms[i][j] = Character.getNumericValue(lx.charAt(k));
                                if (h) {

                                    terms[i][j] = -terms[i][j];
                                }
                                k++;
                                break;
                            }
                        }
                    }
                }
                IPolynomialSolver.setPolynomial(n, terms);
            }
            if (yalla == 2) {
                System.out.println("Insert the variable name: A, B or C : ");
                char n;
                n = input.next().charAt(0);
                String zz = IPolynomialSolver.print(n);
                System.out.println(zz);
            }
            if (yalla == 3) {
                System.out.println("Insert the first operand variable name: A, B or C : ");
                char n1;
                n1 = input.next().charAt(0);
                System.out.println("Insert the Second operand variable name: A, B or C : ");
                char n;
                n = input.next().charAt(0);
                int add[][] = IPolynomialSolver.add(n1, n);
                IPolynomialSolver.setPolynomial('R',add);
                String s= IPolynomialSolver.print('R');
                System.out.println(s);
            }
            if (yalla == 4) {
                System.out.println("Insert the first operand variable name: A, B or C : ");
                char n1;
                n1 = input.next().charAt(0);
                System.out.println("Insert the Second operand variable name: A, B or C : ");
                char n;
                n = input.next().charAt(0);
                int SUB[][] = IPolynomialSolver.subtract(n1, n);
                IPolynomialSolver.setPolynomial('R',SUB);
                String s= IPolynomialSolver.print('R');
                System.out.println(s);
            }
            if (yalla == 5) {
                System.out.println("Insert the first operand variable name: A, B or C : ");
                char n1;
                n1 = input.next().charAt(0);
                System.out.println("Insert the Second operand variable name: A, B or C : ");
                char n;
                n = input.next().charAt(0);
                int mu[][] = IPolynomialSolver.multiply(n1, n);
                IPolynomialSolver.setPolynomial('R',mu);
                String s= IPolynomialSolver.print('R');
                System.out.println(s);
            }
            System.out.println("__________________");
            System.out.println("1- Set a polynomial variable\r\n" + "2- Print the value of a polynomial variable\r\n"
                    + "3- Add two polynomials\r\n" + "4- Subtract two polynomials\n" + "5- Multiply two polynomials\r\n"
                    + "6- Evaluate a polynomial at some point\r\n" + "7- Clear a polynomial variable");
            System.out.println("=========================================================");
            System.out.println("Please choose an action :");
            yalla = input.nextInt();
        }
        input.close();
    }
}
