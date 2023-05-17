public class Runner {
    public static void main(String[] args) {
        //Database'e bağlan
        JDBCUtils.connecToDatabase();
        //Statement oluşturma
        JDBCUtils.createStatement();
        //Query Çalıştır(execute())
        String sql="CREATE TABLE workers(worker_id VARCHAR(20), worker_name VARCHAR (20), worker_salary INT);";
        JDBCUtils.execute(sql);
    }
}
