package g7.upskill.ips.persistence;

import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.model.Gene;

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
}
