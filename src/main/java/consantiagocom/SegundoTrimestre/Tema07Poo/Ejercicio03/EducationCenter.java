package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio03;

import java.util.Arrays;

public class EducationCenter {
    private final String name;
    private Student[] students;
    private int numStudents;

    public EducationCenter(String name, int inicialCapacity) {
        this.name = name;
        students = new Student[inicialCapacity];
        numStudents = 0;
    }

    public String getName() {
        return name;
    }
    public Student newStudent(String name, String surname, String dateBirth, String group, String phoneNumber){
        Student student = new Student(name, surname, dateBirth,group,phoneNumber);
        if(numStudents == students.length)
            extendArray();
        students[numStudents] = student;
        numStudents++;
        return student;
    }
    public boolean eraseStudent(String nia){
        int position = searchPositionStudentByNia(nia);
        if(position >= 0){
            students[position] = students[numStudents - 1];
            students[numStudents - 1] = null;
            numStudents--;
            return true;
        }
        return false;
    }
    public Student[] searchStudentByGroup(String group){
        int cont = 0;
        Student[] result = null;
        for(int i = 0; i < numStudents; i++){
            if(students[i].getGroup().equals(group))
                cont++;
        }
        if(cont > 0) {
            result = new Student[cont];

            for(int i = 0; i < numStudents; i++){
                if(students[i].getGroup().equals(group)) {
                    result[cont] = students[i];
                    cont++;
                }
            }
        }
        return result;

    }
    public Student searchByNia(String nia){
        int position = searchPositionStudentByNia(nia);
        if(position >= 0)
            return students[position];
        return null;
    }
    public int searchPositionStudentByNia(String nia){
        for(int i = 0; i < numStudents; i++){
            if(students[i].getNia().equals(nia)){
                return i;
            }
        }
        return -1;
    }
    public Student[] searchStudentBySurname(String surname){
        int cont = 0;
        Student[] result = null;
        for(int i = 0; i < numStudents; i++){
            if(students[i].getSurname().startsWith(surname))
                cont++;
        }
        if(cont > 0) {
            result = new Student[cont];

            for(int i = 0; i < numStudents; i++){
                if(students[i].getSurname().startsWith(surname)) {
                    result[cont] = students[i];
                    cont++;
                }
            }
        }
        return result;

    }
    private void extendArray(){
        Student[] extendedArray = new Student[students.length * 2];
        for(int i = 0; i < students.length; i++){
            extendedArray[i] = students[i];
        }
        students = extendedArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EducationCenter that = (EducationCenter) o;

        if (numStudents != that.numStudents) return false;
        if (!name.equals(that.name)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Arrays.hashCode(students);
        result = 31 * result + numStudents;
        return result;
    }

    @Override
    public String toString() {
        return "EducationCenter{" +
                "name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                ", numStudents=" + numStudents +
                '}';
    }
}
