package schools;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private List<Pupil> classGroup = new ArrayList<>(); // lepiej była by HashMap<Guardian, Pupil>? (dla lepszej weryfikacji ucznia?
    private String schoolClassName;
    private String gradeLevel;

    public SchoolClass(String schoolClassName, String gradeLevel){
        this.schoolClassName = schoolClassName;
        this.gradeLevel = gradeLevel;
        //this.classGroup = new ArrayList<>(); //a jeśli nie dodałabym tej cechy do konstruktora?
    }
    public List<Pupil> getClassGroup(){
        return classGroup;
        // stworzenie nowej ArrayList zabezpieczy przed ryzykiem usunięcia (clear) przez kogoś mojej listy?
        // (jako że zwracam kopię listy a nie oryginał?)
    }
    public boolean addPupil(Pupil pupil, Guardian guardian){
        Guardian newPupilGuardian = pupil.getGuardian();
        if(classGroup.contains(pupil) && newPupilGuardian.equals(guardian) ){
            System.out.println("Pupil is already in the base.");
            return false;
            //dlaczego jak chciałam dać wewnętrznego 'if' w tym if'ie
            // to wymuszało dodatkowe retur przed ostatnią klamrą?
        }
        else{
            this.classGroup.add(pupil);
            pupil.setClassName(this);
            return true;
        }
    }
    public boolean removePupil(Pupil pupil, Guardian guardian){
        Guardian existingPupilGuardian = pupil.getGuardian();
        if(classGroup.contains(pupil) && existingPupilGuardian.equals(guardian)){
            this.classGroup.remove(pupil);
            return true;
        }
        else{
            System.out.println("Pupil either not in the base or requires to verify a guardian.");
            return false;
        }
    }
    public String getSchoolClassName(){
        return schoolClassName;
    }
    public String getGradeLevel(){
        return gradeLevel;
    }
}
