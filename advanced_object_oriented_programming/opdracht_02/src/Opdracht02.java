import studentenadmin.StudentenAdministratie;
import studentenadmingui.StudentenAdministratieFrame;

class Opdracht02 {

    public static void main(String[] args) {
        StudentenAdministratie studentenAdministratie = new StudentenAdministratie();
        new StudentenAdministratieFrame(studentenAdministratie);
    }
}