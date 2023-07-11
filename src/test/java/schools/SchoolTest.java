package schools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// staramy sie nie mieszac asercji i nie uzywamy * - eliminacja tego jest do ustawienia w formatterze
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

    /**
     * uwaga ogolna - za mala probla danych testowych i ich przypadkow. Czy na pewno dobrze zadzialaja metody liczace ucznikow jak bedzie ich wiecej niz 1 w klasie
     * i wiecej klas? Na razie nie ma takiej pewnosci.
     * A co te klasy maja zwrocic jak nie ma zadnej klasy?
     * Czy w ogole mozna utworzyc szkole bez klasy?
     * Czy mozna dodac klase bez zadnego ucznia?
     *
     * Jakiekolwiek sa odpowiedzi na ww pytania powinny byc dla nich testy.
     */
    @Test
    // dobrze by nazwy reprezentowaly efekt biznesowy a nie techniczny. Oczywiscie czasem sie nie da ale akurat tutaj
    // jest mozliwosc opisania efektu biznesowego
    public void shouldNotLetAddTheSameClassMoreThanOne(){
        // given
        school.addClass(clazzA);
        // jak bedzie taka operacja robiona na klasach to musimy je zwrocic
        // a z opisu w klasie School nie wynika, ze to jest oczekiwane

        // assertThat(school.howManyClasses()).isEqual(1);

        // when
        boolean result = school.addClass(clazzA);

        // then
        assertFalse(result);
        // assertThat(school.howManyClasses()).isEqual(1);
    }
    @Test
    public void shouldAddNewClassToSchool(){
        // given
        school.addClass(clazzA);
        // assertThat(school.howManyClasses()).isEqual(0);

        // when
        // to nie jest najszczesliwsza logika
        // lepiej by bylo dodac
        // school.hasClass(clazzA);
        boolean result = school.getSchoolClasses().containsValue(clazzA);

        // then

        // to sprawdzenie jest ok
        assertTrue(result);
        assertThat(school.getSchoolClasses()).hasSize(1);
    }
    @Test
    public void shouldRemoveExistingClass(){
        // given
        school.addClass(clazzA);

        // when
        // o nie jest test tego co bylo opisane wyzej - to jest nadal element given i lepiej by bylo zrobic to przez
        // hasClass
        assertThat(school.getSchoolClasses()).containsValue(clazzA);

        // then
        // to jest when i lepiej by wygladalo
        var result = school.removeClass(clazzA);

        // then wlasciwe - do poprawy asercja na assertThat()
        assertTrue(result);
        assertThat(school.getSchoolClasses()).hasSize(0);
    }
    @Test
    public void shouldNotRemoveClassIfNotInSchoolAndLetContinue(){
        // given
        // tu bym nic nie robila, bo wtedy na pewno szkola nie ma klasy

        // when
        var result = school.removeClass(clazzA);

        // then
        assertFalse(result);
    }
    @Test
    public void shouldReturnTotalSchoolHeadcount(){
        // given
        school.addClass(clazzA);

        // when
        // cos tutaj jest nie w porzadku - getHeadcount nie powinna miec argumentu
        // tak byloby lepiej
        // var resultAk = school.getHeadcount();
        boolean result = school.getHeadcount(school.getSchoolClasses()) == 1;

        // then
        assertTrue(result);
        assertThat(school.getSchoolClasses().size()).isEqualTo(1);
        // która z tych dwóch asercji powyżej jest lepsza do sprawdzenia żądanej metody?

        // wg mnie taka :)
        // assertThat(resultAk).isEqual(1);
    }
    @Test
    public void shouldReturnHeadcountPerClass(){
        // given
        school.addClass(clazzA);

        // when
        var result = school.getEachClassHeadcount(school.getSchoolClasses());

        //then
//        assertTrue(schoolClassesWithHeadcountMap.size() == 1);
        assertThat(result).isNotNull()
                .hasSize(1);
    }
}