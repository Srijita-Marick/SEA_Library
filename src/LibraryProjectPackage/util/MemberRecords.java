package LibraryProjectPackage.util;

import LibraryProjectPackage.Data;
import LibraryProjectPackage.objects.AdultMember;
import LibraryProjectPackage.objects.ChildMember;
import LibraryProjectPackage.objects.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MemberRecords {

    public static boolean save(File file, Data data) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("Members\n");
            for (Member member : data.getAllMembers()) {
                if (member instanceof AdultMember adultMember) {
                    fw.write(String.format("ADULT,%s,%s,%s", adultMember.getID(), adultMember.getName(), adultMember.getFines()));
                    for (String book : adultMember.getBorrowed()) {
                        fw.write(String.format(",%s", book));
                    }
                    fw.write("\n");
                } else if (member instanceof ChildMember childMember) {
                    fw.write(String.format("CHILDREN,%s,%s", childMember.getID(), childMember.getName()));
                    for (String book : childMember.getBorrowed()) {
                        fw.write(String.format(",%s", book));
                    }
                    fw.write("\n");
                }
            }
            fw.flush();
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public static Data load(File file) {
        Data data = new Data();
        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            if (!line.equals("Members")) {
                System.err.println("File did not have correct header, so loading failed.");
                return null;
            }
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] parts = line.split(",");
                String type = parts[0];
                int id = Integer.parseInt(parts[1]);
                String name = parts[2];

                if (type.equals("ADULT")){
                    data.storeNewAdultMember(id,name);
                    AdultMember adultMember = (AdultMember) (data.getMembersById(id)).getFirst();
                    double fines =  Double.parseDouble(parts[3]);
                    adultMember.setFines(fines);
                    for (int i=4;i<parts.length;i++){
                        adultMember.addBookToMember(parts[i]);
                    }
                } else if (type.equals("CHILD")) {
                    data.storeNewChildMember(id,name);
                    ChildMember childMember = (ChildMember) (data.getMembersById(id)).getFirst();
                    for (int i=3;i<parts.length;i++){
                        childMember.addBookToMember(parts[i]);
                    }
                }

            }
        } catch (IOException e) {
            System.err.println("Incorrect file format. Loading failed.");
            return null;
        }
        return data;
    }

}