/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Book;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Heller
 */
public class BookFile {
    //atributos
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//cantidad de registros en el archivo
    private int regSize;//tama;o del registro
    private String myFilePath;//ruta

    //constructor
    public BookFile(File file) throws IOException {
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
    public boolean putValue(int position, Book book) throws IOException {
        //primero verificar que sea valida la insercion
        if (position < 0 && position > this.regsQuantity) {
            System.err.println("1001 - Record position is out of bounds");
            return false;
        } else {
            if (book.sizeInBytes() > this.regSize) {
                System.err.println("1002 - Record size is out of bounds");
                return false;
            } else {
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeUTF(book.getType());
                randomAccessFile.write(book.getCopies());
                randomAccessFile.writeUTF(book.getAuthor());
                randomAccessFile.writeUTF(book.getCode());
                randomAccessFile.writeUTF(book.getName());
                randomAccessFile.writeUTF(book.getArea());

                return true;
            }
        }
    }//end method

    //insertar al final del archivo
    public boolean addEndRecord(Book book) throws IOException {
        boolean success = putValue(this.regsQuantity, book);
        if (success) {
            ++this.regsQuantity;
        }
        return success;
    }

    //obtener un libro
    public Book getBook(int position) throws IOException {
        //validar la posicion
        if (position >= 0 && position <= this.regsQuantity) {
            //colocamos el brazo en el lugar adecuado
            randomAccessFile.seek(position * this.regSize);
            //llevamos a cabo la lectura
            Book studentTemp = new Book();
            studentTemp.setType(randomAccessFile.readUTF());
            studentTemp.setCopies(randomAccessFile.read());
            studentTemp.setAuthor(randomAccessFile.readUTF());
            studentTemp.setCode(randomAccessFile.readUTF());
            studentTemp.setName(randomAccessFile.readUTF());
            studentTemp.setArea(randomAccessFile.readUTF());
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

    //eliminar libro
    public boolean deletedBook(String code) throws IOException {
        Book myBooks;
        //buscar el libro
        for (int i = 0; i < this.regsQuantity; i++) {
            //obtener el libro de la posicion actual
            myBooks = this.getBook(i);
            //preguntar si el libro que deseo eliminar 
            if (this.getBook(i) != null) {
                if (myBooks.getCode().equalsIgnoreCase(code)) {
                    //marcar como eliminado
                    myBooks.setName("deleted");
                    return this.putValue(i, myBooks);
                }
            }
        }
        return false;
    }

    //retornar una lista de libro
    public ArrayList<Book> getAllBook() throws IOException {
        ArrayList<Book> booksArray = new ArrayList<Book>();
        for (int i = 0; i < this.regsQuantity; i++) {
            Book sTemp = this.getBook(i);
            if (sTemp != null) {
                booksArray.add(sTemp);
            }
        }//end for
        return booksArray;
    }
}
