package controller;


import java.io.*;

public class AuthenticatorControl {


    private static final String CURRENT_FILE = "current_customers.csv";
    private static final String FILE_SAVINGS = "savings-customers.csv";
    private static final String EMPLOYEE_FILE = "employees.csv";


    public static boolean Authentication(String cpf, String senha, String tipoConta) {
        String caminhoArquivo = getFilePath(tipoConta);
        if (caminhoArquivo == null) {
            System.err.println("The account type is invalid.");
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Nome") || linha.startsWith("IdFuncionario")) continue;

                String[] dados = linha.split(",");


                String cpfArquivo = getCPF(dados, tipoConta);
                String senhaArquivo = getPassword(dados, tipoConta);

                if (cpfArquivo.equals(cpf) && senhaArquivo.equals(senha)) {
                    System.out.println("Successful authentication for CPF: " + cpf);
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Authentication Error: " + e.getMessage());
        }

        System.out.println("Authentication failed. Incorrect CPF or Password.");
        return false;
    }


    private static String getFilePath(String tipoConta) {
        return switch (tipoConta.toLowerCase()) {
            case "corrente" -> CURRENT_FILE;
            case "poupanca" -> FILE_SAVINGS;
            case "funcionario" -> EMPLOYEE_FILE;
            default -> null;
        };
    }

    private static String getCPF(String[] dados, String tipoConta) {
        return switch (tipoConta.toLowerCase()) {
            case "corrente", "poupanca" -> dados[1].trim();
            case "funcionario" -> dados[3].trim();
            default -> "";
        };
    }


    private static String getPassword(String[] dados, String tipoConta) {
        return switch (tipoConta.toLowerCase()) {
            case "corrente" -> dados[16].trim();
            case "poupanca" -> dados[14].trim();
            case "funcionario" -> dados[13].trim();
            default -> "";
        };
    }


    public static void main(String[] args) {

        String TestCPF = "077.420.561-00";
        String TestPassword = "pedro2012";

        System.out.println("Testing employee authentication:");
        Authentication(TestCPF, TestPassword, "funcionario");

        System.out.println("Testing checking account authentication:");
        Authentication(TestCPF, TestPassword, "corrente");

        System.out.println("Testing savings account authentication:");
        Authentication(TestCPF, TestPassword, "poupanca");
    }
}
