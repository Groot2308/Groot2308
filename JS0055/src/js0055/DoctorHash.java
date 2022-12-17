/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js0055;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
class DoctorHash {

    public static boolean checkInputCodeDoctor(ArrayList<Doctor> list, String doctorCode) {
        /*loop use access each element from the first element
          to the last element in arraylist*/
        for (int i = 0; i < list.size(); i++) {
            //compare each doctorCode entered with new doctorCode
            if (list.get(i).getCode().equalsIgnoreCase(doctorCode)) {
                return false;
            }
        }
        return true;
    }

    public void addDoctor(ArrayList<Doctor> list) throws IOException {
        System.out.println("--------- Add Doctor ---------");
        String doctorCode;
        do {
            try {
                doctorCode = getInput.getDoctorCode("Enter Code: ", list);
                //check enter new doctor code with entered country code
                if (!checkInputCodeDoctor(list, doctorCode)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("New doctor code is not duplicate entered doctor code!");
            }
        } while (true);
        String Name = getInput.InputIsString("Enter Name: ", list);
        String Specialization = getInput.InputIsString("Enter Specialization: ", list);
        int Availability = getInput.InputIsInteger("Enter Availability: ");
        list.add(new Doctor(doctorCode, Name, Specialization, Availability));
    }

    void updateDoctor(ArrayList<Doctor> list) {
        System.out.println("--------- Update Doctor ---------");
        int count = 0;
        //check doctor in array list not empty
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        do {
            try {
                String updateCode = getInput.getDoctorCode("Enter code update: ", list);
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < list.size(); i++) {
                    //compare doctor code entered in array list with update doctor code
                    if (list.get(i).getCode().equalsIgnoreCase(updateCode) == true) {
                        count++;
                        String xCode = getInput.getDoctorCode("Enter code: ", list);
                        String xName = getInput.InputIsString("Enter name: ", list);
                        String xSpecialization = getInput.InputIsString("Enter Specialization: ", list);
                        int xAvailability = getInput.InputIsInteger("Enter Availability: ");
                        list.get(i).setCode(xCode);
                        list.get(i).setName(xName);
                        list.get(i).setSpecialization(xSpecialization);
                        list.get(i).setAvailability(xAvailability);
                        System.out.println("--Update successful--");
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Doctor code does not exist");
            }
        } while (true);
    }

    public void deleteDoctor(ArrayList<Doctor> list) {
        System.out.println("--------- Delete Doctor -------");
        //check doctor in array list not empty
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        do {
            try {
                int count = 0;
                String code = getInput.getDoctorCode("Enter code: ", list);
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < list.size(); i++) {
                    //compare doctor code entered in array list with delete doctor code
                    if (list.get(i).getCode().equalsIgnoreCase(code) == true) {
                        count++;
                        list.remove(i);
                        System.out.println("--Remove successful--");
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Code does not exist Doctor");
            }
        } while (true);
    }

    void searchDoctor(ArrayList<Doctor> list) {
        System.out.println("---------- Search Doctor --------");
        // check doctor in array list not empty
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        do {
            try {
                String SearchName = getInput.InputIsString("Enter text: ", list);
                int count = 0;
                System.out.println("--------- Result --------------");
                System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
                /*loop use access each element from the first element
                     to the last element in arraylist*/
                for (int i = 0; i < list.size(); i++) {
                    //compare doctor name entered in array list with search doctor name
                    if (list.get(i).getName().equalsIgnoreCase(SearchName) == true) {
                        count++;
                        list.get(i).display();
                    }
                }
                if (count == 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Not found search name doctor!!");
            }
        } while (true);
    }

    
     public void writeToFile(ArrayList<Doctor> list) throws IOException {
        try {
            File file = new File("doctor.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
                for (Doctor doctor : list) {
                    bw.write(doctor.toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();
        } catch (IOException e) {
            System.out.println("Error!!!");
        }
    }

    public void loadToFile(ArrayList<Doctor> list) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("doctor.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] s = line.split(" ");
                String code = s[0].trim();
                String name = s[1].trim();
                String Specialization = s[2].trim();
                int Availability = Integer.parseInt(s[3].trim()); 
                list.add(new Doctor(code, name, Specialization, Availability));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error!!!");
        } finally {
            if (fileReader != null && bufferedReader != null) {
                try {
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Error!!!");
                }
            }
        }
    }
}
