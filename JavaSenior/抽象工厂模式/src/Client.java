import java.sql.Date;
import java.util.Scanner;

/**
 * @author 黎云龙
 * @class
 */
public class Client {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        DataBaseFactory dataBaseFactory =  FactoryProduce.getFactory("mysql");
        StudentOperator studentOperator = dataBaseFactory.createStudentOperator();
        System.out.println("请输入你想查询的学生学号：");
        Scanner input = new Scanner(System.in);
        Integer id = input.nextInt();

        Student student =studentOperator.queryStu(id);
        System.out.println(student);

    }

}
