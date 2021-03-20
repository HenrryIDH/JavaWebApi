package ar.com.eduit.curso.java.web.test;

import ar.com.eduit.curso.java.web.jdbc.connectors.Connector;
import java.sql.Connection;
import java.sql.ResultSet;

public class TestConnection {

    public static void main(String[] args) {
        try (
                Connection conn = Connector.getConnection(); 
                ResultSet rs = conn.createStatement().executeQuery("select version()")) {
            if (rs.next()) {
                System.out.println(rs.getString(1));
            } else {
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar!");
            System.out.println(e);

        }
    }
}
