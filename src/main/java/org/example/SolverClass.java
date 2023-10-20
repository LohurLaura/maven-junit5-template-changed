package org.example;

public class SolverClass {
        public static int equations(int a, int b, int c){
            int d= b*b - 4*a*c;
             if (d<0){
             return 0;
             }
             else if (d==0){
                 return 1;
            }
             else {
                 return 2;
            }
    }
}