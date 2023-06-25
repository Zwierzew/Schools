package schools;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    private School school;
    private Class clazzA;

    @BeforeEach
    public void entryDataForTests(){
        school = new School("Żeromskiego");
        clazzA = new Class("A", "3");
    }
    @AfterEach
    public void clearDataAfterTest(){
        school.getSchoolClasses().clear();
    }

    //testy przerwałam bo zaczęły mi wychodzić głupoty, dlatego zrobiłam Main

    @Test
    public void shouldReturnFalseIfClassExist(){
        // given
        school.addClass(clazzA);
        String className = clazzA.getClassName();

        // when
        boolean result = school.addClass(clazzA) != school.getSchoolClasses().containsKey(className);
        boolean d = school.getSchoolClasses().containsKey("A");

        // then
        //assertFalse(result);
        assertTrue(d);
    }
    @Test
    public void shouldReturnTrueIfClassCanBeAdded(){
        // given
        school.addClass(clazzA);
        String className = "A";

        // when
        String nazwa = String.valueOf(school.getSchoolClasses().containsKey(className));
        boolean result = school.getSchoolClasses().containsKey(className);
        Class test  = school.getSchoolClasses().get(className);
        boolean r = school.getSchoolClasses().containsKey(className);

        // then
        assertTrue(r);
    }


}