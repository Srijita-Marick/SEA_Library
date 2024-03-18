package LibraryProjectPackage.util;

import LibraryProjectPackage.Data;
import LibraryProjectPackage.objects.AdultMember;
import LibraryProjectPackage.objects.ChildMember;
import LibraryProjectPackage.objects.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MemberRecords {

    public static boolean save(File file, Data data) {
        try(FileWriter fw = new FileWriter(file)){
            fw.write("Members\n");
            for (Member member:data.getAllMembers()){
                if (member instanceof AdultMember adultMember){
                    fw.write(String.format("ADULT,%s,%s,%s,%s%n",adultMember.getID(),adultMember.getName(),adultMember.getFines(),adultMember.getBorrowed().size()));
                }
                else if (member instanceof ChildMember childMember){
                    fw.write(String.format("CHILDREN,%s,%s,%s%n",childMember.getID(),childMember.getName(),childMember.getBorrowed().size()));
                }
            }
            fw.flush();
            return true;
        }catch(IOException e){
            return false;
        }

    }public static void load(File file) {
    }


}
