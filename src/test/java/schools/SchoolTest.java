package schools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.KeyStore;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    private School school;
    private SchoolClass clazzA;

    @BeforeEach
    public void entryDataForTests(){
        school = new School("Żeromskiego");
        clazzA = new SchoolClass("A3");
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
        boolean result = school.getSchoolClasses().containsValue(clazzA);

        // then
        assertTrue(result);
        assertThat(school.getSchoolClasses()).hasSize(1);
    }
    @Test
    public void shouldReturnTrueIfRemovingSchoolClassSuccessful(){
        // given
        school.addClass(clazzA);

        // when
        assertThat(school.getSchoolClasses()).containsValue(clazzA);

        // then
        assertTrue(school.removeClass(clazzA));
        assertThat(school.getSchoolClasses()).hasSize(0);
    }
    @Test
    public void shouldReturnFalseIfRemovingSchoolClassDoNotExist(){
        // given
        school.addClass(clazzA);
        assertThat(school.getSchoolClasses()).containsValue(clazzA);
        school.removeClass(clazzA);

        // when
        assertThat(school.getSchoolClasses().size()).isEqualTo(0);

        // then
        assertFalse(school.removeClass(clazzA));
    }
    @Test
    public void shouldReturnTotalSchoolHeadcount(){
        // given
        school.addClass(clazzA);

        // when
        boolean result = school.getHeadcount(school.getSchoolClasses()) == 1;

        // then
        assertTrue(result);
        assertThat(school.getSchoolClasses().size()).isEqualTo(1);
        // która z tych dwóch asercji powyżej jest lepsza do sprawdzenia żądanej metody?
    }
    @Test
    public void shouldReturnMapOfClassesWithHeadcount(){
        // given
        school.addClass(clazzA);

        // when
        school.getEachClassHeadcount(school.getSchoolClasses());

        //then
     //   assertTrue(schoolClassesWithHeadcountMap.size() == 1);
    }
}