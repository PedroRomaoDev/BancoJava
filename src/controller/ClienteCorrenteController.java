package controller;

import model.ClienteCorrenteModel;

import java.io.*;

public class ClienteCorrenteController {

    // Caminho do arquivo que armazena os dados dos clientes correntes
    private static final String CAMINHO_ARQUIVO = "clientes_corrente.csv";

    /**
     * Salva os dados de um cliente corrente em um arquivo CSV.
     * Se o arquivo não existir ou estiver vazio, um cabeçalho será adicionado.
     *
     * @param clienteCorrente Objeto contendo as informações do cliente corrente.
     */
    public static void salvarClienteCorrente(ClienteCorrenteModel clienteCorrente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) { // Modo de escrita em anexo (append)

            // Verifica se o arquivo está vazio para adicionar o cabeçalho
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.length() == 0) {
                writer.write("NameClient,CPFClient,Agencia,Conta,Saldo,TelefoneClient,Limite,dataVencimento, passwordClient"); // Adiciona o cabeçalho
                writer.newLine();
            }

            // Escreve os dados do cliente no formato CSV
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

            // Confirmação de sucesso
            System.out.println("Cliente Corrente salvo com sucesso.");
        } catch (IOException e) {
            // Tratamento de erros durante a escrita no arquivo
            System.err.println("Erro ao salvar Conta Corrente: " + e.getMessage());
        }
    }

    /**
     * Carrega e exibe todos os clientes correntes armazenados no arquivo CSV.
     * Cada linha do arquivo é exibida no console.
     */
    public static void carregarClientesCorrente() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;

            // Lê cada linha do arquivo até atingir o final
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha); // Exibe a linha lida
            }
        } catch (IOException e) {
            // Tratamento de erros durante a leitura do arquivo
            System.err.println("Erro ao carregar clientes correntes: " + e.getMessage());
        }
    }

}
