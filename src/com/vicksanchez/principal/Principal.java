package com.vicksanchez.principal;

import com.vicksanchez.modelos.Compra;
import com.vicksanchez.modelos.TarjetaDeCredito;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Bienvenido a tu Shopping Record");
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingresa el límite de tu tarjeta: ");
        double limite = lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);
        System.out.println("Para iniciar tus compras ingresa 1");
        int inicio = lectura.nextInt();

        if (inicio == 1 ){
            int salir = 1;
            while (salir != 0){
                System.out.println("Ingresa la descripción:");
                String descripcion = lectura.next();

                System.out.println("Ingresa la cantidad:");
                double valor = lectura.nextDouble();
                Compra compra = new Compra(valor, descripcion);
                boolean compraRealizada = tarjeta.lanzarCompra(compra);

                if (compraRealizada){
                    System.out.println("Compra Registrada");
                    System.out.println("Escriba 0 para salir o 1 para continuar");
                    salir = lectura.nextInt();
                } else {
                    System.out.println("\n¡Límite alcanzado!");
                    salir = 0;
                }
            }
        }
        System.out.println("\n**********************");
        System.out.println("Compras Realizadas");
        System.out.println("**********************");
        Collections.sort(tarjeta.getListaDeCompras());
        for (Compra compra: tarjeta.getListaDeCompras()){
            System.out.println("\n" + compra.getDescripcion() + " - " + compra.getValor());
        }
        System.out.println("\n**********************");
        System.out.println("Saldo de la tarjeta: " + tarjeta.getSaldo());

    }
}
