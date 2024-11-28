package controller;

import model.ClientePoupancaModel;

import java.io.*;

public class ClientePoupancaControl {

    private static final String FILE_PATH = "current_customers.csv";

    public static void saveCustomerSavings(ClientePoupancaModel clientePoupanca) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            File arquivo = new File(FILE_PATH);
            if (arquivo.length() == 0) {
                writer.write("Nome,CPF,Agência,Conta,Saldo,Telefone, Endereço, Senha");
                writer.newLine();
            }

            writer.write(clientePoupanca.getNameClient() + "," +
                    clientePoupanca.getCPFClient() + "," +
                    clientePoupanca.getAgencia() + "," +
                    clientePoupanca.getConta() + "," +
                    clientePoupanca.getSaldo() + "," +
                    clientePoupanca.getTelefoneClient() + "," +
                    clientePoupanca.getEnderecoClient() + "," +
                    clientePoupanca.getTelefoneClient() + "," +
                    clientePoupanca.getPasswordClient());
            writer.newLine();

            System.out.println("Savings account saved successfully!");
        } catch (IOException e) {
            System.err.println("Error when saving Savings Account: " + e.getMessage());
        }
    }

    public static void loadCustomersSavings() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading Savings Account: " + e.getMessage());
        }
    }
}
