package g7.upskill.ips.persistence;

import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.model.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DBStorage {

    public void createGene(Gene newGene) {

       String sql = "insert into Gene (name, description) values ('"+ newGene.getName() + "','" + newGene.getDescription() + "');";

        System.out.println("insert " + sql);

        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){

            MyDBUtils.exec_sql(connection,sql);
        } catch (SQLException e) {
            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
        }
    }

//    public void createArtist(Artist newArtist) {
//
//        String sql = "insert into artist (name, description) values ('"+ newArtist.getName() + "','" + newArtist.getDescription() + "');";
//
//        System.out.println("insert " + sql);
//
//        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
//                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){
//
//            MyDBUtils.exec_sql(connection,sql);
//        } catch (SQLException e) {
//            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
//        }
//    }
//
//    public void createArtwork(Artwork newArtwork) {
//
//        String sql = "insert into artwork (name, description) values ('"+ newArtwork.getName() + "','" + newArtwork.getDescription() + "');";
//
//        System.out.println("insert " + sql);
//
//        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
//                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){
//
//            MyDBUtils.exec_sql(connection,sql);
//        } catch (SQLException e) {
//            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
//        }
//    }
//
//    public void createCountry(Country newCountry) {
//
//        String sql = "insert into country (name, description) values ('"+ newCountry.getName() + "','" + newCountry.getDescription() + "');";
//
//        System.out.println("insert " + sql);
//
//        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
//                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){
//
//            MyDBUtils.exec_sql(connection,sql);
//        } catch (SQLException e) {
//            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
//        }
//    }
//
//    public void createExhibition(Exhibition newExhibition) {
//
//        String sql = "insert into exhibition (name, description) values ('"+ newExhibition.getName() + "','" + newExhibition.getDescription() + "');";
//
//        System.out.println("insert " + sql);
//
//        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
//                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){
//
//            MyDBUtils.exec_sql(connection,sql);
//        } catch (SQLException e) {
//            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
//        }
//    }
//
//    public void createGallerist(Gallerist newGallerist) {
//
//        String sql = "insert into gallerist (name, description) values ('"+ newGallerist.getName() + "','" + newGallerist.getDescription() + "');";
//
//        System.out.println("insert " + sql);
//
//        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
//                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){
//
//            MyDBUtils.exec_sql(connection,sql);
//        } catch (SQLException e) {
//            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
//        }
//    }
}
