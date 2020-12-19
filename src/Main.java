import java.sql.*;

public class Main<YEAR> {
    public static final String DB_NAME = "database.db";
    public static final String DB_PATH = "Jdbc:sqlite:C:\\Users\\Noah\\repos\\SQLiteDB\\database.db";
    public static final String TABLE_MOVIES = "movies";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_YEAR= "publishingYear";
    public static final String COLUMN_LENGTH = "length";
    public static final String COLUMN_ACTOR = "actor";

    public static void main(String[] args) throws SQLException {
        try {

        Connection conn = DriverManager.getConnection(DB_PATH);
        Statement statement = conn.createStatement();
        statement.execute("DROP TABLE IF EXISTS " + TABLE_MOVIES);




            statement.execute("CREATE TABLE IF NOT EXISTS "+ TABLE_MOVIES +" (" +
                COLUMN_NAME +  " TEXT, "+
                COLUMN_YEAR +  " INTEGER, " +
                COLUMN_LENGTH +  " TEXT," +
                COLUMN_ACTOR +   " TEXT)");



            statement.execute("INSERT INTO " + TABLE_MOVIES + " (" +
                COLUMN_NAME + ", " +
                 COLUMN_YEAR + ", " +
                COLUMN_LENGTH + ", " +
                COLUMN_ACTOR + ") " +
                "VALUES('Black Panther',2018, '2h 14m','Chadwick Boseman')");

            statement.execute("INSERT INTO " + TABLE_MOVIES + " (" +
                    COLUMN_NAME + ", " +
                    COLUMN_YEAR + ", " +
                    COLUMN_LENGTH + ", " +
                    COLUMN_ACTOR + ") " +
                    "VALUES('Mission Impossible',2019, '2h 27m','Rebecca Ferguson')");

            statement.execute("INSERT INTO " + TABLE_MOVIES + " (" +
                    COLUMN_NAME + ", " +
                    COLUMN_YEAR + ", " +
                    COLUMN_LENGTH + ", " +
                    COLUMN_ACTOR + ") " +
                    "VALUES('Toy Story',2019, '1h 40m','Tom Hanks')");

            statement.execute("INSERT INTO " + TABLE_MOVIES + " (" +
                    COLUMN_NAME + ", " +
                    COLUMN_YEAR + ", " +
                    COLUMN_LENGTH + ", " +
                    COLUMN_ACTOR + ") " +
                    "VALUES('Lady Bird',2017, '1h 34m','Lucas Hedges')");
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_MOVIES);
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getString(COLUMN_YEAR) + " " +
                        results.getString(COLUMN_LENGTH) + " " +
                        results.getString(COLUMN_ACTOR));
            }
            results.close();
            statement.close();

        }

        catch (SQLException e) {
        System.out.println("SQL Exception: " + e.getMessage());
    }
}

            }