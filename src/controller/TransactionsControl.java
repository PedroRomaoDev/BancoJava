package controller;

import java.io.*;
import java.util.*;

public class TransactionsControl {
    private static final String EXTRACT_FILE = "extract.csv"; // extrato
    private static final String CURRENT_FILE = "current_accounts.csv"; // conta-corrente
    private static final String FILE_SAVINGS = "savings_accounts.csv"; // conta poupança


    private boolean performTransaction(String tipoConta, String cpf, double valor, boolean isDeposito)
    {
        String pathFile = tipoConta.equalsIgnoreCase("corrente") ? CURRENT_FILE : FILE_SAVINGS;

        try {
            List<String[]> linhas = new ArrayList<>();
            double CurrentBalance = 0;
            boolean userFound = false;


            try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] valores = line.split(",");
                    if (valores[1].equals(cpf)) {
                        userFound = true;

                        CurrentBalance = Double.parseDouble(valores[4]);

                        if (isDeposito) {
                            CurrentBalance += valor;
                        } else {
                            if (CurrentBalance >= valor) {
                                CurrentBalance -= valor;
                            } else {
                                System.out.println("Insufficient balance to make the withdrawal.");
                                return false;
                            }
                        }

                        valores[4] = String.valueOf(CurrentBalance);
                    }
                    linhas.add(valores);
                }
            }

            if (!userFound) {
                System.out.println("User not found.");
                return false;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile))) {
                for (String[] linha : linhas)
                {
                    writer.write(String.join(",", linha));
                    writer.newLine();
                }
            }

            registerExtract(tipoConta, cpf, valor, isDeposito, CurrentBalance);
            System.out.println("Transaction completed successfully!");
            return true;
        }
        catch (IOException e) {
            System.err.println("Error accessing the file: " + e.getMessage());
            return false;
        }
        catch (NumberFormatException e) {
            System.err.println("Error processing numeric values: " + e.getMessage());
            return false;
        }
    }

    // registro d extrato
    private void registerExtract(String tipoConta, String CPF, double Valor, boolean isDeposito, double FinalSaldo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EXTRACT_FILE, true))) {
            String OperationType = isDeposito ? "Depósito" : "Saque";
            String ExtractLine = String.format("%s,%s,%s,%.2f,%.2f,%s",
                    tipoConta, CPF, OperationType, Valor, FinalSaldo, new Date());
            writer.write(ExtractLine);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error registering statement: " + e.getMessage());
        }
    }

    // obter extrato
    public String obterExtrato(String tipoConta, String cpf) {
        StringBuilder extrato = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(EXTRACT_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length > 1 && valores[0].equalsIgnoreCase(tipoConta) && valores[1].equals(cpf)) {
                    extrato.append("Operação: ").append(valores[2])
                            .append("\nValor: R$").append(valores[3])
                            .append("\nSaldo Final: R$").append(valores[4])
                            .append("\nData: ").append(valores[5])
                            .append("\n\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error accessing the extract file: " + e.getMessage());
        }
        return extrato.toString().isEmpty() ? "No extract found." : extrato.toString();
    }

    // Saque
    public boolean withdraw(String tipoConta, String cpf, double valor) {
        return performTransaction(tipoConta, cpf, valor, false);
    }

    // depósito
    public boolean deposit(String tipoConta, String cpf, double valor) {
        return performTransaction(tipoConta, cpf, valor, true);
    }
}

