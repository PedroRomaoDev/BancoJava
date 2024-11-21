package model;

import java.time.LocalDate;

public class ClientePoupancaModel extends ClienteModel {


    public ClientePoupancaModel(
    	    String name,
    	    String cpf,
    	    LocalDate dataNasc,
    	    String Agencia,
    	    String Conta,
    	    Double Saldo,
    	    String Telefone,
    	    String Endereco,
    	    String password
        ) 
    {


        super	(name,
        	    cpf,
        	    dataNasc,
        	    Agencia,
        	    Conta,
        	    Saldo,
        	    Telefone,
        	    Endereco,
        	    password
        	    );
        
    }


}
