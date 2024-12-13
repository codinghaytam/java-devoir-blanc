package org.example.demo2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Membre {
    private String Identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;

    public boolean equals(Membre obj) {
        if (obj.getIdentifiant().equals(this.getIdentifiant())) {
            return true;
        }else{
            return false;
        }
    }

    public int hashcode(){
        return this.Identifiant.hashCode();
    }

    public Set<Membre> chargeListeMembre(String nomFichier) {
        try{
            Set<Membre> results = new HashSet<>();
            BufferedReader scanner = new BufferedReader(new FileReader(nomFichier));
            String line = "";
            while ((line = scanner.readLine()) != null) {
                String[] row = line.split(",");
                results.add(new Membre(UUID.randomUUID().toString(),row[0],row[1],row[2],row[3]));
            }
            return results;
        }catch (Exception e){
            return null;
        }
    }
}
