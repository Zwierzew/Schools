package schools;

import java.util.ArrayList;
import java.util.List;

public class Guardian {
    private String name;
    private String surname;
    private String address;
    private String contact;
    private List<Pupil> children;

    public Guardian(String name, String surname, String address, String contact){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.contact = contact;
        this.children = new ArrayList<>(); //a jesli nie dodałabym tej cechy do konstruktora?
    }

    public void addChild(Pupil pupil){
        this.children.add(pupil);
        pupil.setGuardian(this);
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getAddress(){
        return address;
    }
    public String getContact(){
        return contact;
    }
}
