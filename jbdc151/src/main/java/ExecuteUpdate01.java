import java.sql.*;

public class ExecuteUpdate01 {

    public static void main(String[] args) throws SQLException {

        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Selim0504");

        Statement statement =connection.createStatement();
        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan number_of_employees değerlerini 16000 olarak UPDATE ediniz

        String sql="UPDATE companies SET number_of_employees=16000 WHERE number_of_employees <" +
                "(SELECT AVG(number_of_employees) FROM companies)";
         int updateEdilenSatirSayisi=statement.executeUpdate(sql);
        System.out.println("updateEdilenSatirSayisi = " + updateEdilenSatirSayisi);

        //update sonrası datayı okumak için DQL(select) kullanıypuruz
        String sql2="SELECT * FROM companies";
        ResultSet resultSet=statement.executeQuery(sql2);
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1)+"--"+resultSet.getObject(2)+"--"+resultSet.getObject(3));

        }



        connection.close();
        statement.close();

    }
}
