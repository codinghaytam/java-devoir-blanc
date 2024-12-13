package org.example.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDao{
    public boolean inserer(Incident i) {
        try{
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement pr = con.prepareStatement("insert into incident values (?,?,?)");
            pr.setString(1,i.getReference());
            pr.setTimestamp(2,i.getTime());
            pr.setString(3,i.getStatus().toString());
            int rows = pr.executeUpdate();
            if(rows > 0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean inser(Set<Incident> is){
        boolean flag = false;
        for(Incident i : is){
            flag=inserer(i);
            if(!flag){
                return false;
            }
            else{
                continue;
            }
        }
        return true;
    }
}
