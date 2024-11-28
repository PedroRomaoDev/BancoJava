package controller;

import model.ClienteModel;
import model.ClienteCorrenteModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class QueryCustomerControl {

    private static final String CURRENT_FILE = "current_customers.csv";
    private static final String FILE_SAVINGS = "current_customers.csv";

    public Optional<ClienteCorrenteModel> consultarClienteCorrente(String cpf) {
        return consultarCliente(cpf, CURRENT_FILE, true);
    }

    public Optional<ClienteModel> consultarClientePoupanca(String cpf) {
        return consultarCliente(cpf, FILE_SAVINGS, false).map(cliente -> (ClienteModel) cliente);
    }

    private Optional<ClienteCorrenteModel> consultarCliente(String cpf, String arquivo, boolean isCorrente) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length > 1 && dados[1].equals(cpf)) {
                    if (isCorrente) {
                        return Optional.of(criarClienteCorrente(dados));
                    } else {
                        return Optional.empty();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error accessing the file " + arquivo + ": " + e.getMessage());
        }
        return Optional.empty();
    }

    private ClienteCorrenteModel criarClienteCorrente(String[] dados) {
        return new ClienteCorrenteModel(
                dados[0],
                dados[1],
                dados[2],
                dados[3],
                dados[4],
                dados[5],
                Double.parseDouble(dados[6]),
                dados[7],
                dados[8],
                Double.parseDouble(dados[9]),
                dados[10]
        );
    }

    private ClienteModel createClient(String[] dados) {
        return new ClienteModel(
                dados[0],
                dados[1],
                dados[2],
                dados[3],
                dados[4],
                dados[5],
                dados[6],
                Double.parseDouble(dados[7]),
                dados[8],
                dados[9]
        );
    }
}
