package schools;

public class Main {
    public static void main(String[] args) {
        Pupil pupil1 = new Pupil("Ewa", "Laska", "1987");
        Pupil pupil2 = new Pupil("Ida", "Laska", "1987");
        Pupil pupil3 = new Pupil("Ada", "Laska", "1987");
        Pupil pupil4 = new Pupil("Tom", "Laska", "1987");

        Guardian guardian = new Guardian("OLa", "xyz", "address", "898-345-183");
        guardian.addChild(pupil1);
        guardian.addChild(pupil2);
        guardian.addChild(pupil3);
        guardian.addChild(pupil4);


        SchoolClass classA = new SchoolClass("A3");
        classA.addPupil(pupil1,guardian);
        classA.addPupil(pupil2,guardian);
        classA.addPupil(pupil3,guardian);
        classA.addPupil(pupil4,guardian);

        SchoolClass classB = new SchoolClass("B3");
        classB.addPupil(pupil1,guardian);
        classB.addPupil(pupil2,guardian);

        SchoolClass classC = new SchoolClass("C3");
        classC.addPupil(pupil1,guardian);
        classC.addPupil(pupil2,guardian);

        School school1 = new School("Śniadek");
        school1.addClass(classA);
        school1.addClass(classB);
        school1.addClass(classC);
        //school1.addClass(classA);

        school1.print();
        System.out.println(classA.getClassGroup().size());
    }
}
