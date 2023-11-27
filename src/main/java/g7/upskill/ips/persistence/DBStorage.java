package g7.upskill.ips.persistence;

import g7.upskill.ips.ListIdDesc;
import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBStorage {

    public void createGene(Gene newGene) {

       String sql = "insert into Gene (id_gene, name, description) values ('" +
               newGene.getId()+ "','" +
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

        String sql = "insert into Artist (id_Artist, location, hometown, name, biography, slug, birthyear, deathyear, thumbnail, " +
                "url, nationality)" +
                " values ('"+ newArtist.getId() + "','" +
                newArtist.getLocation() + "','" +
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

    private String getIdGene(String categoria)
    {


        String default_Value ="NA";
        Object Id_Gene;

        try( Connection connection  = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD))
        {

            Id_Gene=  MyDBUtils.lookup(connection, "id_Gene", "Gene", "name='" + categoria +"'", default_Value);

           return Id_Gene.toString();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return default_Value;
    }



    public static List getAllGenesDB()

    {

        List listGenes = new ArrayList<>();
        Gene gene;

        try( Connection connection  = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD))
        {

         ResultSet rs= MyDBUtils.lookup(connection, "*", "gene");
         while (rs.next())
         {
             gene= new Gene();
             gene.setId(rs.getString("id_Gene"));
             gene.setName(rs.getString("name"));
             gene.setDescription(rs.getString("description"));

             listGenes.add(gene);
         }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listGenes;

    }

    public void createArtwork(Artwork newArtwork) {


       String id_gene= getIdGene(newArtwork.getCategory());


        String sqlInsert = "insert into Artwork (id_Artwork, title, created_at, updated_at, date, thumbnail, url, id_Gene) values ('"+
                newArtwork.getId() + "','" +
                newArtwork.getTitle() + "','" +
                newArtwork.getCreated_at() + "','" +
                newArtwork.getUpdated_at()+ "','" +
                newArtwork.getDate()+ "','" +
                newArtwork.getThumbnail() + "','" +
                newArtwork.getUrl() + "','" +
                id_gene +
                "');";

        System.out.println("insert " + sqlInsert);

        try (Connection connection = MyDBUtils.get_connection(MyDBUtils.db_type.DB_MYSQL,
                MyDBUtils.DB_SERVER,MyDBUtils.DB_PORT,MyDBUtils.DB_NAME,MyDBUtils.DB_USER,MyDBUtils.DB_PWD);){

            MyDBUtils.exec_sql(connection,sqlInsert);
        } catch (SQLException e) {
            System.out.println("exec_sql:" + sqlInsert + " Error: " + e.getMessage());
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
