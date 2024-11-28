package controller;

import model.ClienteCorrenteModel;

import java.io.*;

public class ClienteCorrenteControl {

    private static final String FILE_PATH = "current_customers.csv";

    public static void saveCustomerCurrent(ClienteCorrenteModel clienteCorrente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            File arquivo = new File(FILE_PATH);
            if (arquivo.length() == 0) {
                writer.write("NameClient,CPFClient,Agencia,Conta,Saldo,TelefoneClient,Limite,dataVencimento,passwordClient");
                writer.newLine();
            }

            writer.write(clienteCorrente.getNameClient() + "," +
                    clienteCorrente.getCPFClient() + "," +
                    clienteCorrente.getAgencia() + "," +
                    clienteCorrente.getConta() + "," +
                    clienteCorrente.getSaldo() + "," +
                    clienteCorrente.getLimite() + "," +
                    clienteCorrente.getDataVencimento() + "," +
                    clienteCorrente.getEnderecoClient() + "," +
                    clienteCorrente.getPasswordClient());
            writer.newLine();

            System.out.println("Current Customer successfully saved.");
        } catch (IOException e) {
            System.err.println("Error when saving Current Account: " + e.getMessage());
        }
    }

    public static void loadCustomersCurrent() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading customer's current account: " + e.getMessage());
        }
    }
}
