package model;

import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class ClienteModel {
	 String IdCliente;
	 String NameClient;
	 String CPFClient;
    LocalDate dataNascClient;
     String Agencia;
     String Conta;
     Double Saldo;
     String TelefoneClient;
     String EnderecoClient;
     String passwordClient;


    public ClienteModel(
    		String IdCliente, 
    		String NameClient, 
    		String CPFClient, 
    		String dataNascClient, 
    		String EnderecoClient,
    		String Agencia, 
    		String Conta, 
    		Double Saldo,
            String TelefoneClient, 
            String passwordClient) {
    	this.IdCliente=IdCliente;
        this.NameClient = NameClient;
        this.CPFClient = CPFClient;
        this.dataNascClient = parsedataNascClient(dataNascClient);
        this.EnderecoClient= EnderecoClient;
        this.Agencia = Agencia;
        this.Conta = Conta;
        this.Saldo = Saldo;
        this.TelefoneClient = TelefoneClient;
        this.passwordClient = passwordClient;
    }


	public ClienteModel(String name, String cpf, LocalDate dataNasc, String agencia2, String conta2, Double saldo2,
			String telefone, String endereco, String password) {
		// TODO Auto-generated constructor stub
	}


	private LocalDate parsedataNascClient(String dataNascClient) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataNascClient, formatter);
    }
    
    //get and set -> IdClient
    public String getIdCliente() {
        return IdCliente;
    }


    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }
    /////////////////////////////////////////////////////////   
    
    //get and set -> NOME
    public String getNameClient() {
        return NameClient;
    }
    public void setNameClient(String NameClient) {
        this.NameClient = NameClient;
    }
    /////////////////////////////////
    
    //get and set CPF CLIENT
    public String getCPFClient() {
        return CPFClient;
    }
    public void setCPFClient(String CPFClient) {
        this.CPFClient = CPFClient;
    }
    ////////////////////////////////
    
    //get and set Data de nascimento Cliente
    public LocalDate getdataNascClient() {
        return dataNascClient;
    }
    public void setdataNascClient(String dataNascClient) {
        this.dataNascClient = parsedataNascClient(dataNascClient);
    }
    
    //get and set Endereço Cliente
    public String getEnderecoClient() {
        return EnderecoClient;
    }
    public void setEnderecoClient(String EnderecoClient) {
        this.EnderecoClient = EnderecoClient;
    }
    ////////////////////////////////////////////////////////

    //get and set Agencia
    public String getAgencia() {
        return Agencia;
    }
    public void setAgencia(String Agencia) {
        this.Agencia = Agencia;
    }
    //////////////////////////////////
    
    //get and set -> Conta
    public String getConta() {
        return Conta;
    }
    public void setConta(String Conta) {
        this.Conta = Conta;
    }
    /////////////////////////////////////////
    
    //get and set Saldo
    public Double getSaldo(){
        return Saldo;
    }
    public void setSaldo(Double Saldo){
        this.Saldo = Saldo;
    }
    /////////////////////////////////
    
    //get and set -> Telefone Cliente
    public String getTelefoneClient() {
        return TelefoneClient;
    }
    
    public void setTelefoneClient(String TelefoneClient) {
        this.TelefoneClient = TelefoneClient;
    }
    /////////////////////////////
    
    //get and set senha Cliente
    public String getPasswordClient() {
        return passwordClient;
    }
    public void setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
    }
    /////////////////////////

}
