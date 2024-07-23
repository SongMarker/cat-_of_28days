import java.util.ArrayList;

public class Place {
    static ArrayList<String> place = new ArrayList<>();

    static void showPlace(){
        place.add("공원");
        place.add("학교");
        place.add("시장");
        place.add("시청");
        place.add("군대");
        place.add("연구소");

        for(int i = 0; i < place.size() ; i++)
        {
            System.out.println(place.get(i));
        }
    }


}


