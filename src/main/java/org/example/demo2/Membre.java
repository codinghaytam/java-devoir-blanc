package org.example.demo2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Membre {
    private String Identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private Incident incident;

    public boolean equals(Membre obj) {
        if (obj.getIdentifiant().equals(this.getIdentifiant())) {
            return true;
        }else{
            return false;
        }
    }

    private int hashcode(){
        return this.Identifiant.hashCode();
    }
}
