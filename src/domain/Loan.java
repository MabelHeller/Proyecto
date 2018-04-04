/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Heller
 */
public class Loan implements Serializable {

    //atributos
    private String idMaterial;
    private String idStudent;
    private String date;
    private Date devolution;
    private String nameStudent;
    private String nameMaterial;

    //constructores
    public Loan(String idBook, String idStudent, String date, Date devolution, String nameStudent, String nameMaterial) {
        this.idMaterial = idBook;
        this.idStudent = idStudent;
        this.date = date;
        this.devolution = devolution;
        this.nameStudent = nameStudent;
        this.nameMaterial = nameMaterial;
    }

    public Loan() {
        this.idMaterial = "";
        this.idStudent = "";
        this.date = "";
        this.devolution = new Date();
        this.nameStudent = "";
        this.nameMaterial = "";
    }

    //metodos accesores

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }
      
    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String fechaD) {
        this.date = fechaD;
    }

    public Date getDevolution() {
        return devolution;
    }

    public void setDevolution(Date devolution) {
        this.devolution = devolution;
    }

    
    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }
   
    @Override
    public String toString() {
        return "Loan{" + "idBook=" + idMaterial + ", idStudent=" + idStudent + ", date=" + date + ", devolution=" + devolution + ", NameStudent=" + nameStudent + ", NameBook=" + nameMaterial + '}';
    }
    //guarda el prestamo de un libro en un archivo serializado
    public boolean saveLoansB(Loan loans) throws IOException, ClassNotFoundException {
        List<Loan> loansList = new ArrayList<Loan>();
        File file = new File("LoansB.txt");
        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));//lee el archivo
            Object aux = objectInputStream.readObject();
            loansList = (List<Loan>) aux;
            objectInputStream.close();
        }
        for (int i = 0; i < loansList.size(); i++) {
            if (loansList.get(i).getIdMaterial().equalsIgnoreCase(loans.getIdMaterial())) {
                return false;
            }//if
        }//for
        loansList.add(loans);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));//escribe
        output.writeUnshared(loansList);//escribe el objeto
        output.close();//cerrar el archivo
        return true;
    }
    //guarda el prestamo de un equipo audiovisual en un archivo serializado
     public boolean saveLoansA(Loan loans) throws IOException, ClassNotFoundException {
        List<Loan> loansList = new ArrayList<Loan>();
        File file = new File("LoansA.txt");
        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));//lee el archivo
            Object aux = objectInputStream.readObject();
            loansList = (List<Loan>) aux;
            objectInputStream.close();
        }
        for (int i = 0; i < loansList.size(); i++) {
            if (loansList.get(i).getIdMaterial().equalsIgnoreCase(loans.getIdMaterial())) {
                return false;
            }//if
        }//for
        loansList.add(loans);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));//escribe
        output.writeUnshared(loansList);//escribe el objeto
        output.close();//cerrar el archivo
        return true;
    }
     //elimina el libro por medio de su codigo
    public void deletedBooks(String idBook) throws IOException, ClassNotFoundException {
        File myFile = new File("LoansB.txt");
        System.out.println("entra");
        List<Loan> loansList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            loansList = (List<Loan>) aux;
            objectInputStream.close();
        }//if
        Book book = null;
        for (int i = 0; i < loansList.size(); i++) {
            System.out.println(loansList.get(i));
            if (loansList.get(i).getIdMaterial().equals(idBook)) {
                loansList.remove(i);
                System.out.println(loansList.size());
            }
        }
        //bookList.add(book);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));//escribe
        output.writeUnshared(loansList);//escribe el objeto
        System.out.println(loansList.size());
        output.close();
    }
    
    //elimina un equipo audiovisual por medio de su codigo
    public void deletedAudiovisual(String idAudiovisual) throws IOException, ClassNotFoundException {
        File myFile = new File("LoansA.txt");
        System.out.println("entra");
        List<Loan> loansList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            loansList = (List<Loan>) aux;
            objectInputStream.close();
        }//if
        Book book = null;
        for (int i = 0; i < loansList.size(); i++) {
            System.out.println(loansList.get(i));
            if (loansList.get(i).getIdMaterial().equals(idAudiovisual)) {
                loansList.remove(i);
                System.out.println(loansList.size());
            }
        }
        //bookList.add(book);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));//escribe
        output.writeUnshared(loansList);//escribe el objeto
        System.out.println(loansList.size());
        output.close();
    }
//obtiene un libro por medio de su codigo
    public Loan getLoans(String idBook) throws IOException, ClassNotFoundException {
        File myFile = new File("Loans.txt");
        List<Loan> loansList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            loansList = (List<Loan>) aux;
            objectInputStream.close();
        } // if(myFile.exists())
        Loan loans = null;
        for (int i = 0; i < loansList.size(); i++) {
            if (loansList.get(i).getIdMaterial().equals(idBook)) {
                loans = loansList.get(i);
                break;
            } // if 
        } // for i
        return loans;
    }

}
