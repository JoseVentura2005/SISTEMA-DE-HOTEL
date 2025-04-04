/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDB {
    

    private static final String URL = "jdbc:mysql://localhost:3306/hotel_tarea2025";
   private static final String USUARIO = "cuenta_hotel";
     private static final String PASSWORD = "JoseVentura2005##";
    
    private static HikariDataSource dataSource;
    
    static{
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USUARIO);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10); //Máximo de conexiones simultáneas
        config.setMinimumIdle(5); //Mínimo de conexiones en espera
        config.setIdleTimeout(3000); //Tiempo máximo inactivo antes de cerrar la conexión
        config.setMaxLifetime(200000);//Tiempo máximo de vida de una conexión
        config.setConnectionTimeout(60000); //Timeout para obtener conexión 
        
        dataSource = new HikariDataSource(config);                
    }
    
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    
    public static void closePool(){
        if(dataSource != null){
            dataSource.close();
        }
    }   
    
}

    

