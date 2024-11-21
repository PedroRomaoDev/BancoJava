package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FuncionarioModel {
    private String IdFuncionario;
    private String Cargo;
    private String NameFuncionario;
    private String CPFFuncionario;
    private LocalDate dataNascFuncionario;
    private String TelefoneFuncionario;
    private String enderecoFuncionario;
    private String passwordFuncionario;

    
    public FuncionarioModel(
    		String IdFuncionario, 
    		String Cargo, 
    		String NameFuncionario, 
    		String CPFFuncionario,
            String dataNascFuncionario, 
            String TelefoneFuncionario, 
            String enderecoFuncionario,
            String passwordFuncionario
            ) 
    		{
        this.IdFuncionario = IdFuncionario;
        this.Cargo = Cargo;
        this.NameFuncionario = NameFuncionario;
        this.CPFFuncionario = CPFFuncionario;
        this.dataNascFuncionario = parsedataNascFuncionario(dataNascFuncionario);
        this.TelefoneFuncionario = TelefoneFuncionario;
        this.enderecoFuncionario = enderecoFuncionario;
        this.passwordFuncionario = passwordFuncionario;
    }

 
    private LocalDate parsedataNascFuncionario(String dataNascFuncionario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(dataNascFuncionario, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data de nascimento inválida. Use o formato dd/MM/yyyy.");
        }
    }

    //get and set -> IdFuncionario
    public String getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(String IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }
    ///////////////////////////////////////////////////
    
    //get and set -> Cargo
    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    /////////////////////////////////////////////////
    
    //get and set -> NameFuncionario
    public String getNameFuncionario() {
        return NameFuncionario;
    }

    public void setNameFuncionario(String NameFuncionario) {
        this.NameFuncionario = NameFuncionario;
    }
    ////////////////////////////////////////////////
    
    //get and set -> CPFFuncionario
    public String getCPFFuncionario() {
        return CPFFuncionario;
    }

    public void setCPFFuncionario(String CPFFuncionario) {
        this.CPFFuncionario = CPFFuncionario;
    }
    /////////////////////////////////////////////////////
    
    //get and set -> Data de Nascimento Funcionario
    public LocalDate getDataNascFuncionario() {
        return dataNascFuncionario;
    }

    public void setDataNascFuncionario(String dataNascFuncionario) {
        this.dataNascFuncionario = parsedataNascFuncionario(dataNascFuncionario);
    }
    //////////////////////////////////////////////////////////
    
    //get and set TelefoneContato
    public String getTelefoneFuncionario() {
        return TelefoneFuncionario;
    }

    public void setTelefoneFuncionario(String TelefoneFuncionario) {
        this.TelefoneFuncionario = TelefoneFuncionario;
    }
    ///////////////////////////////////////////////////////////////
    
    //get and set -> Endereço Funcionario
    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }
    /////////////////////////////////////////////////////////////
    
    
    //get and set Senha Funcionario
    public String getPasswordFuncionario() {
        return passwordFuncionario;
    }

    public void setPasswordFuncionario(String passwordFuncionario) {
        this.passwordFuncionario = passwordFuncionario;
    }
    //////////////////////////////////////////
}