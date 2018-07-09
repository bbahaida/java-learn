package com.bahaida.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args){
        Timeit.code(Main::readObject);
    }

    public static void fileBuffered(){
        try{

            File f = new File("resources/test.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String s;
            String[] a = new String[3];
            float note = 0,moyenne = 0;
            int i = 0;

            while ((s = br.readLine()) != null){
                a = s.split(";");
                note += Float.parseFloat(a[2]);
                i++;
            }

            moyenne = note/i;

            System.out.println(moyenne);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void zipFileBuffered(){
        File f1,f2;

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream  = null;

        BufferedInputStream bufferedInputStream  = null;
        BufferedOutputStream bufferedOutputStream  = null;

        ZipOutputStream zipOutputStream  = null;

        try {

            f1 = new File("resources/file1.docx");
            fileInputStream = new FileInputStream(f1);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            f2 = new File("resources/output.zip");
            fileOutputStream = new FileOutputStream(f2);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            zipOutputStream = new ZipOutputStream(bufferedOutputStream);

            // zipOutputStream Configuration

            zipOutputStream.setMethod(ZipOutputStream.DEFLATED);
            zipOutputStream.putNextEntry(new ZipEntry(f1.getName()));

            int c;

            while ((c = bufferedInputStream.read())!= -1){
                zipOutputStream.write(c);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                zipOutputStream.close();
                bufferedOutputStream.close();
                fileOutputStream.close();

                bufferedInputStream.close();
                fileInputStream.close();



            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }


    public static void serializeObject(){
        List<Operation> operations = new ArrayList<>();
        Operation op1 = new Operation(1,new Date(),6220.0);
        Operation op2 = new Operation(2,new Date(),12200.0);
        Operation op3 = new Operation(3,new Date(),5550.0);

        operations.add(op1);
        operations.add(op2);
        operations.add(op3);

        try{
            File file = new File("resources/objects.bin");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(operations);

            oos.close();

        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public static void readObject(){
        List<Operation> operations = new ArrayList<>();
        try{
            File file = new File("resources/objects.bin");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            operations = (List<Operation>) ois.readObject();

            operations.forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
