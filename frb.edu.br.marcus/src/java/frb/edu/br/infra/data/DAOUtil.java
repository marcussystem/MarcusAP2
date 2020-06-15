package frb.edu.br.infra.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 1920530342
 */
public abstract class DAOUtil {
    private Connection cx = null;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        if(this.cx == null){
            String url = "jdbc:mysql://localhost:3306/locadora?zeroDateTimeBehavior=convertToNull";
            String password = "";
            String user = "srv_locadora";
            String drive;
            drive = "com.mysql.jdbc.Driver";
            
            Class.forName(drive);
            cx = DriverManager.getConnection(url, user, password);
        }
        return cx;
    }
    
    public void getCloseConnection() throws SQLException{
        if(this.cx != null){
            this.cx.close();
            this.cx = null;
        }
    }
    
    public Statement getStatement() throws ClassNotFoundException, SQLException{
        return this.getConnection().createStatement();
    }
    
    public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        return this.getConnection().prepareStatement(sql);
    }
}
