package my.app.finnkinoviewer;

import java.util.ArrayList;

class Theatres {
    private String name;
    private int id;
    private static ArrayList <Theatres> theatres = null;

    public void Theatres() {
    }

    public void setTheatres(String name, int id) {
        this.name = name;
        this.id = id;
        if (theatres == null) {
            theatres = new ArrayList <Theatres>();
        }
        theatres.add(this);
    }

    public static int getTheatreId(String theatre) {
        Theatres temp = new Theatres();
        for (int i = 0; i < theatres.size(); i++) {
            temp = theatres.get(i);
            if (theatre.matches(temp.name)) {
                return (temp.id);
            }
        }
        return(0);
    }

}
