package org.example.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao{
    @Override
    public boolean insere(Membre m) {
        try{
            Connection con =  DatabaseConnection.getConnection();
            PreparedStatement pr = con.prepareStatement("insert into membre values(?,?,?,?,?);");
            pr.setString(1,m.getIdentifiant());
            pr.setString(2,m.getNom());
            pr.setString(3,m.getPrenom());
            pr.setString(4,m.getEmail());
            pr.setString(5,m.getPhone());
            int nrows = pr.executeUpdate();
            if(nrows >0){
                return true;
            }else return false;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<Membre> chargeListIncidents(){
        List<Membre> mlist = new ArrayList<>();
        try{
            Connection con= DatabaseConnection.getConnection();
            PreparedStatement pr = con.prepareStatement("select * from membre");
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                Membre m = new Membre();
                m.setIdentifiant(rs.getString("identifiant"));
                m.setNom(rs.getString("nom"));
                m.setPrenom(rs.getString("prenom"));
                m.setEmail(rs.getString("email"));
                m.setPhone(rs.getString("phone"));
                mlist.add(m);
            }
            return mlist;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
