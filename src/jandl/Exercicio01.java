package jandl;

import javax.swing.SwingUtilities;

//import jandl.wizard.Data;
import jandl.wizard.WizardBase;
import jandl.wizard.WizardFactory;
//import jandl.wizard.WizardText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Exercicio01 {

public static void main(String[] args) {               
            
    //Primeira Janela
    WizardBase wb1 = WizardFactory.createBase("Bem vindo ao cálculo IMC"); 
    wb1.setImage("!/resources/calcular-o-imc2.jpg");
                
    //Segunda Janela
    String[] tag = { "Nome", "Sobrenome", "Sexo" };
    String[] label = { "Digite o seu nome:", "Digite o seu sobrenome:", "Digite o seu sexo:" };
    WizardBase wb2 = WizardFactory.createField("Cadastro", tag, label, label);
    wb2.setImage("!/resources/balanca2.png");
                
    //Terceira Janela
    WizardBase wb3 = WizardFactory.createText("Resultados", "distancia.txt");
                
    //Quarta Janela                
    String[] tag2 = { "Altura", "Peso" };
    String[] label2 = { "Digite a sua altura:", "Digite o seu peso:" };
    WizardBase wb4 = WizardFactory.createField("Cálculo IMC", tag2, label2, label2);   
    wb4.setImage("!/resources/balanca2.png");
                
    //Quinta Janela
    WizardBase wb5 = WizardFactory.createText("Resultados", "distancia.txt");

    // Encadeamento
    wb1.nextWizard(wb2);
    wb2.nextWizard(wb3);
    wb3.nextWizard(wb4);
    wb4.nextWizard(wb5);
                
    // Pre e Pos processamento
    //wb2.addPostProcessor((wiz) -> wb2PostProcessor(wiz));
    //wb3.addPreProcessor((wiz) -> wb3PreProcessor(wiz));
                
    // Acionamento da aplicacao
    SwingUtilities.invokeLater(() -> wb1.setVisible(true));
    
    //Teste banco de dados
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM Clientes";
    ResultSet rs = stmt.executeQuery(query);
}

private Connection getConnection() {
    if (con == null) {
        String urlJDBC = "jdbc:mysql://localhost:3306/mysql";
        try {
            con = DriverManager.getConnection(urlJDBC, "root", "123456a!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this. ex.toString(),
                "Erro", JOptionPane.ERROR_MESSAGE);
            }              
        }
    return con;
}                