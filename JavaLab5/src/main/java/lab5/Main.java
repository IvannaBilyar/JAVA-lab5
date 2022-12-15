package lab5;

import database.DBManager;
import database.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) throws SQLException {

        Teacher t1 = new Teacher.Builder()
                .setTeacherId(1)
                .setName("Olha")
                .setSurname("Ivanko")
                .setBirthday(LocalDate.of(1994, 9, 12))
                .setDateOfEmployment(LocalDate.of(2017, 12, 5))
                .setLanguage("Chinese").build();
        Teacher t2 = new Teacher.Builder()
                .setTeacherId(2)
                .setName("Sergiy").setSurname("Maksymenko")
                .setBirthday(LocalDate.of(1982, 4, 23))
                .setDateOfEmployment(LocalDate.of(2012, 10, 16))
                .setLanguage("Italian").build();
        Teacher t3 = new Teacher.Builder()
                .setTeacherId(3)
                .setName("Maryna")
                .setSurname("Svitla")
                .setBirthday(LocalDate.of(1997, 11, 20))
                .setDateOfEmployment(LocalDate.of(1920, 9, 2))
                .setLanguage("Polish").build();
        Teacher t4 = new Teacher.Builder()
                .setTeacherId(4)
                .setName("Maksym")
                .setSurname("Hnatyuk")
                .setBirthday(LocalDate.of(1985, 6, 19))
                .setDateOfEmployment(LocalDate.of(2010, 8, 10))
                .setLanguage("Japanese").build();
        Teacher t5 = new Teacher.Builder()
                .setTeacherId(5)
                .setName("Inna")
                .setSurname("Shevchenko")
                .setBirthday(LocalDate.of(1996, 8, 18))
                .setDateOfEmployment(LocalDate.of(2018, 11, 25))
                .setLanguage("English").build();

        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teachers.add(t4);
        teachers.add(t5);

        ForeignLanguageSchool s1 = new ForeignLanguageSchool.Builder()
                .setSchoolId(1)
                .setCapacity(50)
                .setAddress("Melnikova Ul., bld. 47")
                .setTeachersList(teachers).build();
        ForeignLanguageSchool s2 = new ForeignLanguageSchool.Builder()
                .setSchoolId(2)
                .setCapacity(70)
                .setAddress("Ukrainka Ul., bld. 23")
                .setTeachersList(teachers).build();

        DBManager dbManager = new DBManager();
        Service service = new Service(dbManager);

        service.createTableFLSchools();
        service.createTableTeachers();
        service.dropTables();

    }
}



