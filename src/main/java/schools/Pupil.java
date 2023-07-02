package schools;

public class Pupil {
    private String name;
    private String surname;
    private String dateOfBirth;
    private SchoolClass schoolClassName;
    private Guardian guardian;

    public Pupil(String name, String surname, String dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public SchoolClass getClassName(){
        return schoolClassName;
    }
    public void setClassName(SchoolClass actualClass){
        this.schoolClassName = actualClass; // actualClass jest ustawione w Class
    }
    public Guardian getGuardian(){
        return guardian;
    }
    public void setGuardian(Guardian guardian){
        this.guardian = guardian; // guardian jest ustawione w Gurdian
    }
}
