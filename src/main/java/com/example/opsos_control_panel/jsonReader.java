package com.example.opsos_control_panel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jsonReader {
    private List<station> stationList;
    public List<station> readStations(){
        stationList = new ArrayList<>();
        File file = new File("stations.json");
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            boolean check = false;
            station st = new station();
            while ((line = br.readLine()) != null) {
                int count =0;
                if(line.contains("stationNum_")){
                    check = true;
                    continue;
                }else if(line.contains("}")){
                    check = false;
                    st = new station();
                    continue;
                }
                if(check == true){
                    String[] keyVal = parseLine(line);
                    switch (keyVal[0]){
                        case "Xcoord":
                            st.setX(Double.parseDouble(keyVal[1]));
                            break;
                        case "Ycoord":
                            st.setY(Double.parseDouble(keyVal[1]));
                            break;
                        case "Description":
                            st.setDescription(keyVal[1]);
                            break;
                        case "Type":
                            st.setType(Integer.parseInt(keyVal[1]));
                            stationList.add(st);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stationList;
    }

    private String[] parseLine(String line) {
        String[] sArr = line.split(":");
        sArr[0] = deleteSymbols(sArr[0]);
        sArr[1] = deleteSymbols(sArr[1]);

        return sArr;
    }

    private String deleteSymbols(String str) {
        str = str.replace("\t","");
        str = str.replace("\n","");
        str = str.replace("\"","");
        str = str.replace(",","");
        return str;
    }
}
