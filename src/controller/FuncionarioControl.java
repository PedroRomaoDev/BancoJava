package controller;

import model.FuncionarioModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FuncionarioControl {

    private static final String EMPLOYEE_FILE = "employees.csv";

    public void saveEmployee(FuncionarioModel funcionario) {
        try {
            File file = new File(EMPLOYEE_FILE);

            if (!file.exists()) {
                file.createNewFile();
                escreverCabecalho();
            }

            writeEmployee(funcionario);
        } catch (IOException e) {
            System.out.println("Error saving employee: " + e.getMessage());
        }
    }

    private void escreverCabecalho() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_FILE, true))) {
            writer.write("IdFuncionario,Cargo,NameFuncionario,CPFFuncionario,dataNascFuncionario,TelefoneFuncionario,enderecoFuncionario,passwordFuncionario");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing header to file: " + e.getMessage());
        }
    }

    private void writeEmployee(FuncionarioModel funcionario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_FILE, true))) {
            String linha = funcionario.getIdFuncionario() + "," +
                    funcionario.getCargo() + "," +
                    funcionario.getNameFuncionario() + "," +
                    funcionario.getCPFFuncionario() + "," +
                    funcionario.getDataNascFuncionario() + "," +
                    funcionario.getTelefoneFuncionario() + "," +
                    funcionario.getEnderecoFuncionario() + "," +
                    funcionario.getPasswordFuncionario();
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing employee data to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FuncionarioControl controller = new FuncionarioControl();

        FuncionarioModel funcionario = new FuncionarioModel(
                "910",
                "Gerente",
                "William Malvezzi",
                "781-901-190-00",
                "16/07/1908",
                "11 98911-1898",
                "Complexo da Penha",
                "pedro2012"
        );

        controller.saveEmployee(funcionario);
    }
}
