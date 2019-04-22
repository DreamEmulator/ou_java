import studentenadmin.StudentenAdministratie;
import studentenadmingui.StudentenAdministratieFrame;

class Opdracht01 {

    public static void main(String[] args) {
        StudentenAdministratie studentenAdministratie = new StudentenAdministratie();
        new StudentenAdministratieFrame(studentenAdministratie);
    }
}