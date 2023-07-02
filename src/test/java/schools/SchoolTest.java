package schools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    private School school;
    private SchoolClass clazzA;

    @BeforeEach
    public void entryDataForTests(){
        school = new School("Żeromskiego");
        clazzA = new SchoolClass("A", "3");
        Guardian guardian = new Guardian("Jan", "Kowalski", "Kielecka 18, 26-009 Kielce", "789-987-876");
        Pupil pupil1 = new Pupil("Ewa", "Odra", "2001");
        clazzA.addPupil(pupil1, guardian);
    }
    @AfterEach
    public void clearDataAfterTest(){
        school.getSchoolClasses().clear();
    }

    @Test
    public void shouldReturnFalseIfClassExist(){
        // given
        school.addClass(clazzA);

        // when
        boolean result = school.addClass(clazzA);

        // then
        assertFalse(result);
    }
    @Test
    public void shouldReturnTrueIfClassCanBeAdded(){
        // given
        school.addClass(clazzA);

        // when
//        boolean result = school.getSchoolClasses().get(clazzA.getSchoolClassName()) == clazzA;
//        boolean result2 = school.getSchoolClasses().containsKey(clazzA.getSchoolClassName());
//        boolean result3 = school.getSchoolClasses().containsValue(clazzA);

        // then
//        assertTrue(result); // test nie przechodzi - nie rozumiem dlaczego? (próbowałam różne kompibacje z boolean i key)
//        assertTrue(result2); //jw.
        //assertTrue(result3); //jw.
        //assertTrue(school.addClass(clazzA)); //to działa
        assertThat(school.getSchoolClasses()).hasSize(1); // size = 0, dlaczego? (w Main klasy są dodawane)

        //jak sprawdzić czy udało się dodać klasę do mapy?
    }
    @Test
    public void shouldReturnTrueIfRemovingSchoolClassSuccessful(){
        // given
        school.addClass(clazzA); // addClass nie dodaje klasy

        // when
        school.removeClass(clazzA);
        // then
        assertThat(school.getSchoolClasses()).hasSize(0); // remove działa - zwraca messgage if class do not exist
    }
    @Test
    public void shouldReturnFalseIfRemovingSchoolClassDoNotExist(){
        // given
        school.addClass(clazzA);
        school.removeClass(clazzA); // podało message - powyższa komenda nie dodała klasy

        // when

        // then
        assertFalse(school.removeClass(clazzA));
    }
    @Test
    public void shouldReturnTotalSchoolHeadcount(){
        // given
        school.addClass(clazzA); //jw.

        // when
        school.getHeadcount(school.getSchoolClasses());

        // then
        assertThat(school.getSchoolClasses().size()).isEqualTo(1);
    }
    @Test
    public void shouldReturnClassesHeadcountAsMap(){
        // given
        school.addClass(clazzA);

        // when
        Map<String, Integer> schoolClassesMap = school.getEachClassHeadcount(school.getSchoolClasses());

        //then
        assertTrue(clazzA.getClassGroup().size() == 1);
        assertTrue(schoolClassesMap.size() == 1);

    }
}