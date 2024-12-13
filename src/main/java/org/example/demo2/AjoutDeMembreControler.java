package org.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.UUID;

public class AjoutDeMembreControler {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private void AjoutMembre() {

        MembreDaoImpl MembreDao = new MembreDaoImpl();
        if(nom.getText()!="" && prenom.getText()!="" && email.getText()!="" && phone.getText()!="") {
            Membre m  =new Membre(UUID.randomUUID().toString(),
                    nom.getText(),prenom.getText(),email.getText(),phone.getText());
            MembreDao.insere(m);

        }
    }

}
