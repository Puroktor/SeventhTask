package ru.vsu.cs.skofenko;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        showExample("1 2 3 4 5");
        showExample("1 2 3 4 5 6");
        showExample("2 6 24 120 720");
        showExample("3 7 25 121 721");
        showExample("3 2432902008176640000");
        showExample("51090942171709440000 51090942171709440001");
        showExample("-1");
        showExample("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        showExample("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1");
        showExample("51090942171709440000 51090942171709440000 51090942171709440000 51090942171709440000" +
                " 51090942171709440000 51090942171709440000 51090942171709440000 51090942171709440000");
        BigInteger[] mas = input();
        BigInteger sum = solution(mas);
        output(sum);
    }

    private static void showExample(String str){
        System.out.println(str);
        output(solution(stringToBigIntMas(str)));
        System.out.println();
    }

    private static void output(BigInteger integer){
        System.out.println("Сумма: "+integer);
    }

    private static BigInteger solution(BigInteger[] mas){
        BigInteger sum =new BigInteger("0");
        for (BigInteger value : mas) {
            if (isFactorial(value)) {
                sum = sum.add(value);
            }
        }
        return sum;
    }
    private static boolean isFactorial(BigInteger integer){
        BigInteger factorial = new BigInteger("1");
        BigInteger mult = new BigInteger("2");
        BigInteger one = new BigInteger("1");
        while(integer.compareTo(factorial) > 0){
            factorial = factorial.multiply(mult);
            mult=mult.add(one);
        }
        return integer.equals(factorial);
    }

    private static BigInteger[] input() {
        return stringToBigIntMas(new Scanner(System.in).nextLine());
    }

    private static BigInteger[] stringToBigIntMas(String str){
        String[] strMas = str.split(" ");
        BigInteger[] masBig = new BigInteger[strMas.length];
        for(int i=0;i<masBig.length;i++){
            masBig[i]= new BigInteger(strMas[i]);
        }
        return  masBig;
    }
}

