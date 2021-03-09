package co.edu.ufps.web;

import org.junit.jupiter.api.Test;

import java.io.File;

class Test1 {

    public static void main(String[] args) {
        File image = new File("/perro.png");
        System.out.println("path: " + image.getPath());
        System.out.println("pathAbsoluto: " + image.getAbsolutePath());
    }
}
