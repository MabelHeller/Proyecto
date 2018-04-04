/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import gui.InsertBook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Heller
 */
public class Book extends Material implements Serializable {
    //atributos
    private String type;
    private int copies;
    private String author;
    File file = new File("Books.dat");
    public List<Book> bookList = new ArrayList<Book>();
    public List<Book> quantityList = new ArrayList<Book>();
    int cont = 0;

    //constructores
    public Book(String type, int copies, String author, String code, String name, String area) {
        super(code, name, area);
        this.type = type;
        this.copies = copies;
        this.author = author;
    }

    public Book() {
        super();
        this.type = "";
        this.copies = 0;
        this.author = "";
    }

    //metodos accesores
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + "Books{" + "type=" + type + ", copies=" + copies + ", author=" + author + '}';
    }
//guarda el libro en un archivo serializado
    public boolean saveBooks(Book book) throws IOException, ClassNotFoundException {
        InsertBook insert = new InsertBook();
        List<Book> bookList = new ArrayList<Book>();
        File file = new File("Books.txt");
        //book.setCode(""+getCode());
        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));//lee el archivo
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }//if
        //book.setCode("ISBN"+getCode());
        for (int i = 0; i < bookList.size(); i++) {
            
            if (bookList.get(i).getCode().equalsIgnoreCase(book.getCode())) {
                return false;
            }//if
        }//for
        //book.setCode(""+getCode());
        bookList.add(book);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));//escribe
        output.writeUnshared(bookList);//escribe el objeto
        output.close();//cerrar el archivo
        return true;
    }
    //valor en bytes de cada atributo del objeto
    public int sizeInBytes() {
        return this.getType().length() * 2 + 4 + this.getAuthor().length() * 2 + this.getCode().length() * 2 + this.getName().length() * 2 + this.getArea().length() * 2;
    }
//elimina un libro por medio del nombre en el archivo serializado
    public void deletedBooks(String name) throws IOException, ClassNotFoundException {
        File myFile = new File("Books.txt");
        System.out.println("entra");
        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }//if
        Book book = null;
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
            if (bookList.get(i).getName().equals(name)) {
                System.out.println("entra2");
                bookList.remove(i);
                System.out.println(bookList.size());
            }
        }
        //bookList.add(book);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));//escribe
        output.writeUnshared(bookList);//escribe el objeto
        System.out.println(bookList.size());
        output.close();
    }
//obtiene un libro por medio del codigo ingresado
    public Book getBook(String code) throws IOException, ClassNotFoundException {
        File myFile = new File("Books.txt");
        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        } // if(myFile.exists())
        Book book = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCode().equals(code)) {
                book = bookList.get(i);
                break;
            } // if 
        } // for i
        return book;
    }
}//fin clase
