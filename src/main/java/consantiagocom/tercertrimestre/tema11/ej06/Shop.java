package consantiagocom.tercertrimestre.tema11.ej06;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Shop {
    private ArrayList<Rent> rents = new ArrayList<>();
    private ArrayList <Movie> movies = new ArrayList<>();
    private ArrayList <VideoGame> videoGames = new ArrayList<>();
    private ArrayList <Multimedia> multimedia = new ArrayList<>();
    private ArrayList <Member> members = new ArrayList<>();

    public Shop(){
        rents = new ArrayList<>();
        videoGames = new ArrayList<>();
        movies = new ArrayList<>();
        multimedia = new ArrayList<>();
        members = new ArrayList<>();
    }

    /**
     * add movie
     * @param movieName
     * @param format
     * @param author
     * @param calendar
     * @param duration
     * @param actor
     * @param actress
     * @return
     */
    protected int addMovie(String movieName, String format,
                            String author, GregorianCalendar calendar, int duration,
                            String actor,String actress){
        int ret;
        if(confirmIfMediaExists(author, movieName) == 0){
            return 0;
        }
        movies.add(new Movie(movieName,author,
                Multimedia.TYPE.valueOf(format),calendar,duration,actor,actress));
        return 1;
    }

    /**
     * Add game
     * @param movieName
     * @param format
     * @param author
     * @param calendar
     * @param platform
     * @return
     */
    protected  int addGame(String movieName, String format,
                           String author, GregorianCalendar calendar, String platform){
        int ret;
        if(confirmIfMediaExists(author, movieName) == 0){
            return 0;
        }
        videoGames.add(new VideoGame(movieName,author,
                Multimedia.TYPE.valueOf(format),calendar,platform));
        return 1;
    }

    /**
     * Add new member with age confirmation
     * @param nif
     * @param name
     * @param birthdate
     * @param city
     * @return
     */
    protected  int addMemeber(String nif, String name, GregorianCalendar birthdate,String city){
        if(confirmIfMemberExists(nif) == 0){
            return 0;
        }
        GregorianCalendar now = new GregorianCalendar();
        int year = now.get(GregorianCalendar.YEAR);
        int month = now.get(GregorianCalendar.MONTH);
        int day = now.get(GregorianCalendar.DAY_OF_MONTH);
        now.set(year,month,day);
        if(birthdate.getTimeInMillis()-now.getTimeInMillis() /1000 / 60 / 24 /365 < 18)
            return 2;
        members.add(new Member(nif,name,birthdate,city));
        return 1;
    }

    /**
     * Confirm if Media exsists
     * @param author
     * @param title
     * @return
     */
    protected  int confirmIfMediaExists(String author,String title){
        if(multimedia.isEmpty())
            return 0;
        for (Multimedia value : multimedia) {
            if ((value.confirmMedia(author, title)))
                return 0;
        }
        return 1;
    }

    /**
     * Confirm if memeber exists
     * @param nif
     * @return
     */
    protected  int confirmIfMemberExists(String nif){
        if(members.isEmpty())
            return 0;
        for (Member member : members) {
            if (member.getNif().equalsIgnoreCase(nif))
                return 0;
        }
        return 1;
    }

    /**
     * Show all multimedia
     * @return
     */
    protected String showMultimedia(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < multimedia.size() ;i++){
            sb.append(multimedia.get(i));
        }
        return sb.toString();
    }

}
