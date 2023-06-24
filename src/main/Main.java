package main;

import models.Address;
import models.Connection;
import models.GenerateFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, digite o cep que deseja buscar: ");
        String cep = scanner.next();

        Connection connection = new Connection();


        try {
            Address address = connection.searchCep(cep);
            GenerateFile generateFile = new GenerateFile();
            generateFile.generateFileJson(address);
            System.out.println("connection " + address);
        } catch (RuntimeException | IOException e) {
            System.out.println("Não consegui obter o endereço a partir desse CEP");
        }
    }
}