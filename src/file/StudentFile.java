/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Student;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heller
 */
public class StudentFile {
    //atributos

    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//cantidad de registros en el archivo
    private int regSize;//tama;o del registro
    private String myFilePath;//ruta

    //constructor
    public StudentFile(File file) throws IOException {
        //almaceno la ruta
        myFilePath = file.getPath();
        //indico el tama;o maximo
        this.regSize = 140;
        //una validacion sencilla
        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName() + "is an invalid file");
        } else {
            //crear la nueva instancia de RAF
            randomAccessFile = new RandomAccessFile(file, "rw");//en este archivo vamos a poder escribir y leer
            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int) Math.ceil((double) randomAccessFile.length() / (double) regSize);
        }
    }

    //MUY IMPORTANTE cerrar nuestros archivos
    public void close() throws IOException {
        randomAccessFile.close();
    }

    //indicar la cantidad de registros de nuestro archivo
    public int fileSize() {
        return this.regsQuantity;
    }

    //insertar un nuevo resgistro en una posicion especifica
    public boolean putValue(int position, Student student) throws IOException {
        //primero verificar que sea valida la insercion
        if (position < 0 && position > this.regsQuantity) {
            System.err.println("1001 - Record position is out of bounds");
            return false;
        } else {
            if (student.sizeInBytes() > this.regSize) {
                System.err.println("1002 - Record size is out of bounds");
                return false;
            } else {
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeUTF(student.getName());
                randomAccessFile.writeUTF(student.getCareer());
                randomAccessFile.writeUTF(student.getId());
                randomAccessFile.writeUTF(student.getYear());
                return true;
            }
        }
    }//end method

    //insertar al final del archivo
    public boolean addEndRecord(Student student) throws IOException {
        boolean success = putValue(this.regsQuantity, student);
        if (success) {
            ++this.regsQuantity;
        }
        return success;
    }

    //obtener un estudiante
    public Student getStudent(int position) throws IOException {
        //validar la posicion
        if (position >= 0 && position <= this.regsQuantity) {
            //colocamos el brazo en el lugar adecuado
            randomAccessFile.seek(position * this.regSize);
            //llevamos a cabo la lectura
            Student studentTemp = new Student();
            studentTemp.setName(randomAccessFile.readUTF());
            studentTemp.setCareer(randomAccessFile.readUTF());
            studentTemp.setId(randomAccessFile.readUTF());
            studentTemp.setYear(randomAccessFile.readUTF());

            if (studentTemp.getName().equalsIgnoreCase("deleted")) {
                return null;
            } else {
                return studentTemp;
            }
        } else {
            System.out.println("1003-position is out of brounds");
            return null;
        }
    }

    //eliminar estudiante
    public boolean deletedStudent(String id) throws IOException {
        Student myStudents;
        //buscar el estudiante
        for (int i = 0; i < this.regsQuantity; i++) {
            //obtener el estudiante de la posicion actual
            myStudents = this.getStudent(i);
            //preguntar si el estudiante que deseo eliminar 
            if (this.getStudent(i) != null) {
                if (myStudents.getId().equalsIgnoreCase(id)) {
                    //marcar como eliminado
                    myStudents.setName("deleted");
                    return this.putValue(i, myStudents);
                }
            }
        }
        return false;
    }

    //retornar una lista de estudiantes
    public ArrayList<Student> getAllStudent() throws IOException {
        ArrayList<Student> studentsArray = new ArrayList<Student>();
        for (int i = 0; i < this.regsQuantity; i++) {
            Student sTemp = this.getStudent(i);
            if (sTemp != null) {
                studentsArray.add(sTemp);
            }
        }//end for
        return studentsArray;
    }

}
