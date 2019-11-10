import java.sql.*;
class MysqlCon{
    private static Connection con=null;
    public static void main(String args[]){
        MysqlCon connection = new MysqlCon();
        try {
            connection.insertData();
           // connection.getData();
           // connection.updateData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private boolean insertData() throws SQLException {
        String query = "insert into emp" +
                "(sno,name,dob) values"
                + "(?,?,?)";
        PreparedStatement stmt=con.prepareStatement(query);
        stmt.setString(1,"1");
        stmt.setString(2,"Anoop");
        stmt.setString(3,"27-08-1989");
        int i=stmt.executeUpdate();
        if(i > 0) {
            System.out.println("Data inserted successfully");
            return true;
        }
        return false;
    }

    private void getData() throws SQLException {
        String query = "select * from emp";
        PreparedStatement stmt=con.prepareStatement(query);

        ResultSet rs=stmt.executeQuery();
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
    }

    private boolean updateData() throws SQLException {
        String query = "update sarees "
                + "SET sno=?, name=?, dob=? where sno=1";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,"1");
        ps.setString(2,"Anoop Nair");
        ps.setString(3,"27-08-1989");

        int val = ps.executeUpdate();
        if (val == 1) {
            return true;
        }

        return false;
    }

     MysqlCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root");
            System.out.println("connected...");
        }catch(Exception e){ System.out.println(e);}
    }
}