/**
 * @author 黎云龙
 * @class
 */
public class FactoryProduce {
    public static DataBaseFactory getFactory(String s){
        if(s.equalsIgnoreCase("mysql")){
            return new MySqlFactory();
        } else if(s.equalsIgnoreCase("postage")){
            return null;
        }
        return null;
    }

}
