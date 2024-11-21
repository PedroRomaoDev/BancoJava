package model;

import java.time.LocalDate;

public class ClienteCorrenteModel extends ClienteModel {

    private double limite; 
    private LocalDate DateVencimento; 

    public ClienteCorrenteModel(    		
    		String NameClient, 
    		String CPFClient, 
    		String dataNascClient, 
    		String EnderecoClient,
    		String Agencia, 
    		String Conta, 
    		Double Saldo,
            String TelefoneClient, 
            String passwordClient,
            double limite, 
            String dataVencimento) {
     

        super(NameClient, CPFClient, dataNascClient, EnderecoClient, Agencia, Conta, TelefoneClient, Saldo,
        		passwordClient, dataVencimento);

        this.limite = limite;
        this.DateVencimento = parseDataVencimento(dataVencimento);
    }

 
    private LocalDate parseDataVencimento(String dataVencimento) {
        return LocalDate.parse(dataVencimento);
    }

  
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public LocalDate getDataVencimento() {
        return DateVencimento;
    }

    public void setDataVencimento(LocalDate DateVencimento) {
        this.DateVencimento = DateVencimento;
    }
}