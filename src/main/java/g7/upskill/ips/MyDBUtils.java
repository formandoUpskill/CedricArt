package g7.upskill.ips;


import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Properties;
import java.util.StringTokenizer;

public class MyDBUtils {

    public static  String DB_SERVER;
    public static  String DB_PORT;
    public static  String DB_NAME;

    public static String DB_USER;
    public static String DB_PWD;

    Properties config;
    public MyDBUtils()
    {
        try {
            this.config= new Properties();
            FileReader file = new FileReader("resources/config/CedricArt.config");
            config.load(file);
            DB_SERVER = this.config.getProperty("DB_SERVER");
            DB_PORT = this.config.getProperty("DB_PORT");
            DB_NAME  = this.config.getProperty("DB_NAME");
            DB_PWD = this.config.getProperty("DB_PWD");
            DB_USER = this.config.getProperty("DB_USER");

            file.close();
        } catch (IOException e) {
            System.out.println("Config file not found "+  e.getMessage());
        }

        System.out.println("DB_SERVER " + DB_SERVER);
    }


    public static LocalDateTime covertSqlDateToLocalDateTime(Date sqlDate) {

        // Step 1: Convert java.sql.Date to java.util.Date
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());

        // Step 2: Create Instant from java.util.Date
        Instant instant = utilDate.toInstant();

        // Step 3: Convert Instant to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());


        return localDateTime;

    }

    public static String cleanString(String original) {
        if (original != null) {
            String replaced = original.replace("’", "\\’")
                    .replace("\"", "\\\"")
                    .replace("'", "\\'");

            return replaced;
        }
        return null;
    }

    public enum db_type {DB_MYSQL, DB_SQLSERVER, DB_SQLITE}

    private static String get_connection_string (db_type type, String server, String port, String db, String user, String pwd){
        switch (type){
            case DB_MYSQL: return  "jdbc:mysql://"+ server +":"+ port+"/"+db;
        }
        return null;
    }

    /**
     *
     * @param type
     * @param server
     * @param port
     * @param db
     * @param user
     * @param pwd
     * @return
     * @throws SQLException
     */
    public static Connection get_connection(db_type type, String server, String port, String db, String user, String pwd) throws SQLException

    {
        String connString = get_connection_string(type,server,port,db,user,pwd);

        Connection conn = DriverManager.getConnection(connString,user,pwd);
        return conn;
    }

    /**
     * executa na BD o comando (não query) armazenado na string sqlCmd, que associada à conexão enviada como parâmetro.
     * @param conn
     * @param sqlCmd
     * @return Devolve o número de registos afetado pela execução do comando ou -1, em caso de erro.
     */
    public static int exec_sql (Connection conn,String sqlCmd) throws SQLException
    {

        Statement statement = conn.createStatement();
        int n_regs = statement.executeUpdate(sqlCmd);
        return n_regs;

    }

    /**
     * @author Maria Spínola
     * @param conn
     * @param sqlCmd
     * @return
     * @throws SQLException
     */
    public static ResultSet exec_query(Connection conn,String sqlCmd) throws SQLException
    {
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sqlCmd);
        return rs;
    }

    /**
     * Crie os métodos públicos que devolvem a string contendo o comando SELECT corretamente construído a partir dos valores
     * enviados a cada função. Apenas o parâmetro fields tem de ter conteúdo não nulo e não vazio:
     * o
     * get_select_command(field)
     * o
     * get_select_command(fields, tables, where_cond)
     * o
     * get_select_command(fields, tables, where_cond, order_by)
     * o
     * get_select_command(fields, tables, where_cond, group_by, having, order_by)
     */


    public static String get_select_command(String field){
        return "SELECT " + field;
    }

    /**
     * get_select_command("id_pessoa, nome AS fullName", "pessoa", "sexo='m'", "apelido, nome")
     * @param fields
     * @param tables
     * @param where_cond
     * @return
     */
    public static String get_select_command(String fields, String tables, String where_cond)
    {
        return "SELECT "+ fields+ " FROM " + tables + " WHERE " + where_cond;

    }


    public static String get_select_command(String fields, String table)
    {
        return "SELECT "+ fields+ " FROM " + table ;

    }

    public static String get_select_command(String fields, String tables, String where_cond, String order_by)
    {
        return (get_select_command(fields,tables, where_cond) + " ORDER BY " + order_by);
    }

    public static String get_select_command(String fields, String tables, String where_cond,
                                            String group_by, String having, String order_by)
    {
        return (get_select_command(fields,tables, where_cond) + " GROUP BY "
                + group_by + " HAVING " + having + " ORDER BY " + order_by);
    }


    /**
     *
     * @param conn
     * @param table
     * @param where
     * @return
     * @throws SQLException
     */

    public static boolean exist(Connection conn, String table, String where) throws SQLException
    {

        String cmdSQL= get_select_command("count(*)", table, where);
        ResultSet rs = exec_query(conn,cmdSQL);

        return rs.next() && rs.getInt(1) != 0;

    }



    public static ResultSet lookup(Connection conn, String field, String table) throws SQLException
    {
        String cmdSQL = get_select_command(field, table);

        ResultSet rs = exec_query(conn, cmdSQL);

        return rs;
    }


    /**
     * Crie o método público Object lookup que devolve o valor do campo field existente na tabela
     * ou o valor de default, caso não exista o registo.
     * @param conn
     * @param field
     * @param table
     * @param where_cond
     * @param default_value
     * @return
     *
     * Exemplo int cod_cor = 194;
     * String color_description = lookup(conn, "colorName", "TColor", "id_cor=" + cod_cor, "NO COLOR FOUND")
     */
    public static Object lookup(Connection conn, String field, String table, String where_cond,String default_value) throws SQLException
    {
        String cmdSQL = get_select_command(field, table, where_cond);

        ResultSet rs = exec_query(conn, cmdSQL);

        if (rs.next())
            return rs.getObject(1);

        return default_value;
    }

    /**
     *
     * @param conn
     * @param field
     * @param table
     * @param where_cond
     * @param group_by
     * @param having
     * @param default_value
     * @return
     * @throws SQLException
     */

    public static Object lookup(Connection conn, String field, String table,
                                String where_cond, String group_by, String having, String default_value) throws SQLException
    {
        String cmdSQL = get_select_command(field, table, where_cond,group_by,having, field);
        ResultSet rs = exec_query(conn, cmdSQL);

        if (rs.next())
            return rs.getObject(1);

        return default_value;
    }
}
