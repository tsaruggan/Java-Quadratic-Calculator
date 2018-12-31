/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadraticcalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Saruggan
 */
public class QuadraticCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c;  //user indicated quadratic coefficients

        System.out.println("Welcome to quadratic formula calculator.\nPlease enter the values for a, b and c for the quadratic that takes the form f(x)= ax^2 + bx +c. ");

        System.out.print("a value: ");
        a = input.nextDouble();

        System.out.print("b value: ");
        b = input.nextDouble();

        System.out.print("c value: ");
        c = input.nextDouble();

        double dis; //discriminant

        dis = Math.pow(b, 2) - (a * 4 * c); 

        double x1 = 0, x2 = 0; //roots

        if (dis > 0) { //ensures real roots 
            x1 = ((b * (-1)) + (Math.sqrt(dis))) / (2 * a);
            x2 = ((b * (-1)) - (Math.sqrt(dis))) / (2 * a);
        }

        double yIn = c;  // y intercept

        double vX, vY; // vertex

        vX = ((-1) * b) / (2 * a); //finds middle x of both roots
        vY = a * Math.pow((b / ((2) * a)), 2) * (-1) + c;  //compelting the square, could also plug in X val

        System.out.println("");

        System.out.print("Vertex: ");
        System.out.println(point(vX, vY));

        System.out.print("Y-Intercept: ");
        System.out.println(point(0, yIn));

        System.out.print("Roots: ");
        if (dis < 0) { //no possible roots
            System.out.print("N/A");
        } else if (x1 == x2) {  //only one root
            System.out.println(point(x1, 0));
        } else { //two roots
            System.out.print(point(x1, 0));
            System.out.print(",");
            System.out.println(point(x2, 0));
        }
        System.out.println("");

        int z = 1; //ensure loop continues
        double findX1 = 0, findX2 = 0, findY = 0, newC = 0, newDis = 0;

        System.out.println("");
        while (z == 1) {
            System.out.print("Find a point. Select x or y: "); //prompts for known x or y
            String f = input.next(); 

            if (f.equals("x") || f.equals("X")) { //find y value
                System.out.print("x= ");  //prompt for known x value
                findX1 = input.nextDouble();

                findY = (a * Math.pow(findX1, 2)) + (b * findX1) + c; //plug x into equation

                System.out.println("(x,y)=" + point(findX1, findY));
                System.out.println("");

            } else if (f.equals("y") || f.equals("Y")) { //find x value
                System.out.print("y= ");  //prompt for known y value
                findY = input.nextDouble();

                newC = c - findY; //equate equation to known y value then bring to other side, equation equals zero
                newDis = Math.pow(b, 2) - (a * 4 * newC); //find new dsicriminant

                if (newDis > 0) { //ensures real roots of new equation 
                    findX1 = ((b * (-1)) + (Math.sqrt(newDis))) / (2 * a);
                    findX2 = ((b * (-1)) - (Math.sqrt(newDis))) / (2 * a);
                }

                if (newDis < 0) { //no roots
                    System.out.println("(x,y)= N/A");
                } else if (findX1 == findX2) { // one root
                    System.out.println("(x,y)=" + point(findX1, findY));
                } else { //two roots
                    System.out.print("(x,y)=" + point(findX1, findY));
                    System.out.print(",");
                    System.out.println("(x,y)=" + point(findX2, findY));
                }
                System.out.println("");

            } else { //if incorrect prompt given 
                System.out.println("Input error. Select either x or y. ");
                System.out.println("");
            }

        };

        System.out.println("");
    }

    static String point(double x, double y) { //coordinate point formatting
        String point;

        DecimalFormat decimal = new DecimalFormat("0.00"); //roudns to two decimals 
        point = "(" + decimal.format(x) + "," + decimal.format(y) + ")"; //print

        return point; //return back to main method as formatted (x.00,y.00)
    }

}
