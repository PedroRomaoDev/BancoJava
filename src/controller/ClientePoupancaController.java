package controller;

import model.ClientePoupancaModel;

import java.io.*;

public class ClientePoupancaController {

    // Caminho do arquivo que armazena os dados dos clientes poupança
    private static final String CAMINHO_ARQUIVO = "clientes_poupanca.csv";

    /**
     * Salva os dados de um cliente poupança em um arquivo CSV.
     * Se o arquivo não existir ou estiver vazio, um cabeçalho será adicionado.
     *
     * @param clientePoupanca Objeto contendo as informações do cliente poupança.
     */
    public static void salvarClientePoupanca(ClientePoupancaModel clientePoupanca) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) { // Modo de escrita em anexo (append)

            // Verifica se o arquivo está vazio para adicionar o cabeçalho
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.length() == 0) {
                writer.write("Nome,CPF,Agência,Conta,Saldo,Telefone, Endereço, Senha"); // Adiciona o cabeçalho
                writer.newLine();
            }

            // Escreve os dados do cliente no formato CSV
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

            // Confirmação de sucesso
            System.out.println("Conta Poupança salva com sucesso!");
        } catch (IOException e) {
            // Tratamento de erros de escrita no arquivo
            System.err.println("Erro ao salvar Conta Poupança: " + e.getMessage());
        }
    }

    /**
     * Carrega e exibe todos os clientes poupança armazenados no arquivo CSV.
     * Cada linha do arquivo é exibida no console.
     */
    public static void carregarClientesPoupanca() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;

            // Lê cada linha do arquivo até atingir o final
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha); // Exibe a linha lida
            }
        } catch (IOException e) {
            // Tratamento de erros de leitura no arquivo
            System.err.println("Erro ao carregar Conta Poupança: " + e.getMessage());
        }
    }

}
