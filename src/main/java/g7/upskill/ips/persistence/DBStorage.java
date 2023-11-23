package g7.upskill.ips.persistence;

import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.model.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DBStorage {

    public void createGene(Gene newGene) {

       String sql = "insert into Gene (name, description) values ('" +
               newGene.getName() + "','" +
               newGene.getDescription() + "');";

        System.out.println("insert " + sql);

        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){

            MyDBUtils.exec_sql(connection,sql);
        } catch (SQLException e) {
            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
        }
    }

    public void createArtist(Artist newArtist) {

        String sql = "insert into Artist (location, hometown, name, biography, slug, birthyear, deathyear, thumbnail, " +
                "url, nationality)" +
                " values ('"+ newArtist.getLocation() + "','" +
                newArtist.getHometown() + "','" +
                newArtist.getName() + "','" +
                newArtist.getBiography() + "','" +
                newArtist.getSlug() + "','" +
                newArtist.getBirthyear() + "','" +
                newArtist.getDeathyear() + "','" +
                newArtist.getThumbnail() + "','" +
                newArtist.getUrl() + "','" +
                newArtist.getNationality() +
                "');";

        System.out.println("insert " + sql);

        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){

            MyDBUtils.exec_sql(connection,sql);
        } catch (SQLException e) {
            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
        }
    }

    public void createArtwork(Artwork newArtwork) {

        String sql = "insert into artwork (title, date, thumbnail, url) values ('"+
                newArtwork.getTitle() + "','" +
                newArtwork.getDate() + "','" +
                newArtwork.getThumbnail() + "','" +
                newArtwork.getUrl() +
                "');";

        System.out.println("insert " + sql);

        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){

            MyDBUtils.exec_sql(connection,sql);
        } catch (SQLException e) {
            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
        }
    }

    public void createCountry(Country newCountry) {

        String sql = "insert into country (country_code, nationality) values ('"+
                newCountry.getCountry_code() + "','" +
                newCountry.getNationality() +
                "');";

        System.out.println("insert " + sql);

        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){

            MyDBUtils.exec_sql(connection,sql);
        } catch (SQLException e) {
            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
        }
    }

    public void createExhibition(Exhibition newExhibition) {

        String sql = "insert into exhibition (end_at, start_at, image, description, name, url) values ('"+
                newExhibition.getEnd_at() + "','" +
                newExhibition.getStart_at() + "','" +
                newExhibition.getImage() + "','" +
                newExhibition.getDescription() + "','" +
                newExhibition.getName() + "','" +
                newExhibition.getUrl() +
                "');";

        System.out.println("insert " + sql);

        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){

            MyDBUtils.exec_sql(connection,sql);
        } catch (SQLException e) {
            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
        }
    }

    public void createGallerist(Gallerist newGallerist) {

        String sql = "insert into gallerist (start_at, end_at) values ('"+
                newGallerist.getEnd_at()+ "','" +
                newGallerist.getStart_at() +
                "');";

        System.out.println("insert " + sql);

        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){

            MyDBUtils.exec_sql(connection,sql);
        } catch (SQLException e) {
            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
        }
    }

    public void createCoordinator(Coordinator newCoordinator) {

        String sql = "insert into coordinator (start_at, end_at) values ('" +
                newCoordinator.getStart_at() + "','" +
                newCoordinator.getEnd_at() +
                "');";

        System.out.println("insert " + sql);

        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){

            MyDBUtils.exec_sql(connection,sql);
        } catch (SQLException e) {
            System.out.println("exec_sql:" + sql + " Error: " + e.getMessage());
        }
    }
}
