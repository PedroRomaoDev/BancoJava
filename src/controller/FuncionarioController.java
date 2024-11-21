package controller;

import model.FuncionarioModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FuncionarioController {

    // Caminho do arquivo onde os dados dos funcionários serão armazenados
    private static final String ARQUIVO_FUNCIONARIOS = "funcionarios.csv";

    /**
     * Método responsável por salvar um funcionário no arquivo CSV.
     * Se o arquivo não existir, ele será criado com o cabeçalho correspondente.
     *
     * @param funcionario Objeto FuncionarioModel que contém os dados do funcionário.
     */
    public void salvarFuncionario(FuncionarioModel funcionario) {
        try {
            // Verifica a existência do arquivo
            File file = new File(ARQUIVO_FUNCIONARIOS);

            // Se o arquivo não existe, cria o arquivo e escreve o cabeçalho
            if (!file.exists()) {
                file.createNewFile(); // Cria o arquivo vazio
                escreverCabecalho(); // Adiciona o cabeçalho no arquivo
            }

            // Escreve os dados do funcionário no arquivo
            escreverFuncionario(funcionario);
        } catch (IOException e) {
            // Exibe mensagem de erro caso haja problemas na criação ou escrita do arquivo
            System.out.println("Erro ao salvar funcionário: " + e.getMessage());
        }
    }

    /**
     * Método para escrever o cabeçalho no arquivo CSV.
     * O cabeçalho representa os nomes das colunas do arquivo.
     */
    private void escreverCabecalho() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_FUNCIONARIOS, true))) {
            // Define os campos do cabeçalho
            writer.write("IdFuncionario,Cargo,NameFuncionario,CPFFuncionario,dataNascFuncionario,TelefoneFuncionario,enderecoFuncionario, passwordFuncionario");
            writer.newLine(); // Move para a próxima linha após escrever o cabeçalho
        } catch (IOException e) {
            // Exibe mensagem de erro caso ocorra algum problema ao escrever o cabeçalho
            System.out.println("Erro ao escrever cabeçalho no arquivo: " + e.getMessage());
        }
    }

    /**
     * Método para escrever os dados de um funcionário no arquivo CSV.
     * Os dados são convertidos para o formato CSV antes de serem gravados no arquivo.
     *
     * @param funcionario Objeto FuncionarioModel contendo os dados do funcionário.
     */
    private void escreverFuncionario(FuncionarioModel funcionario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_FUNCIONARIOS, true))) {
            // Converte os dados do funcionário para o formato CSV
            String linha = funcionario.getIdFuncionario() + "," + // Código do funcionário
                    funcionario.getCargo() + "," +                 // Cargo
                    funcionario.getNameFuncionario() + "," +       // Nome do funcionário
                    funcionario.getCPFFuncionario() + "," +        // CPF
                    funcionario.getDataNascFuncionario() + "," +   // Data de nascimento
                    funcionario.getTelefoneFuncionario() + "," +   // Telefone de contato
                    funcionario.getEnderecoFuncionario() + "," +   // Endereço
                    funcionario.getPasswordFuncionario();          // Senha

            // Escreve a linha no arquivo CSV
            writer.write(linha);
            writer.newLine(); // Move para a próxima linha após escrever os dados
        } catch (IOException e) {
            // Exibe mensagem de erro caso haja problemas ao escrever os dados no arquivo
            System.out.println("Erro ao escrever funcionário no arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Cria uma instância do controlador
        FuncionarioController controller = new FuncionarioController();

        // Exemplo de como criar e salvar um funcionário
        FuncionarioModel funcionario = new FuncionarioModel(
                "910",             // Código do Funcionário
                "Atendente",         // Cargo
                "William Malvezzi",    // Nome do Funcionário
                "781-901-190-00",  // CPF do Funcionário
                "16/07/1908",      // Data de Nascimento
                "11 98911-1898",   // Telefone de Contato
                "Complexo da Penha",  // Endereço do Funcionário
                "SofiaSantino"         // Senha
        );

        // Chama o método para salvar o funcionário no arquivo CSV
        controller.salvarFuncionario(funcionario);
    }
}
