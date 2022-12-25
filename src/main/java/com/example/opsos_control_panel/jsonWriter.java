package com.example.opsos_control_panel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class jsonWriter {
    public void writing(List<station> stationList){
        try(FileWriter writer = new FileWriter("stations.json", false))
        {
            writer.write("{\n");
            int i = 1;
            for(station st : stationList){
                writer.write("\t\"stationNum_"+i+"\":{\n");
                writer.write("\t\t\"Xcoord\":"+st.getX()+",\n");
                writer.write("\t\t\"Ycoord\":"+st.getY()+",\n");
                if(st.getDescription().length()>0){
                    writer.write("\t\t\"Description\":"+st.getDescription()+",\n");
                }
                writer.write("\t\t\"Type\":"+st.getType()+",\n");
                writer.write("\t}\n");
                i++;
            }
            writer.write("}");

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
