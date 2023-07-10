package schools;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private List<Pupil> classGroup;
    private String schoolClassName;

    public SchoolClass(String schoolClassName){
        this.schoolClassName = schoolClassName;
        this.classGroup = new ArrayList<>();
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
    public List<Pupil> getClassGroup(){
        return classGroup;
    }
    public String getSchoolClassName(){
        return schoolClassName;
    }
}
