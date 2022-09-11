package Request;

import java.util.List;

public class RequestBodies {

    public  static String addEmployee(int id, String firstName, String lastName, String email, List<String> jobs,String breakfast,String lunch,List<String> dinner){
        return "{\n" +
                "        \"id\":"+id+",\n" +
                "        \"first_name\": \""+firstName+"\",\n" +
                "        \"last_name\": \""+lastName+"\",\n" +
                "        \"email\": \""+email+"\",\n" +
                "        \"jobs\":"+jobs+",\n" +
                "        \"favFoods\":{\n" +
                "            \"breakfast\":\""+breakfast+"\",\n" +
                "            \"lunch\":\""+lunch+"\",\n" +
                "            \"dinner\":"+dinner+"\n" +
                "        }\n" +
                "}";
    }

}
