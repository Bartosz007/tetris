package helper;


import builder.TableBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JSONOperations {
    private String file;

    public JSONOperations(String file) {
        this.file = file;
    }

    public ArrayList<TableBuilder> readFile(){

        ArrayList<TableBuilder> tableBuilders = new ArrayList<>();

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(this.file);
        } catch (IOException e) {
            System.out.println("Bład czytania pliku");

        }


        String line;
        JSONObject jsonObject;
        Object obj;
        BufferedReader bfr = new BufferedReader(fileReader);

        try {
            while((line = bfr.readLine()) != null){

                obj = new JSONParser().parse(line);

                jsonObject = (JSONObject)obj;

                tableBuilders.add(new TableBuilder(
                        (int)(long)jsonObject.get("score"),
                        (String)jsonObject.get("name")));

            }
        } catch (IOException e) {
            System.out.println("BlaD ODCZYTU Z PLIKU!");

        } catch (ParseException e) {

            System.out.println("BlaD parse!");
            e.printStackTrace();
        }

        return tableBuilders;
    }

    public void saveToFile(TableBuilder tableBuilder) {


        ArrayList<TableBuilder> tableBuilders = readFile();
        tableBuilders.add(tableBuilder);

        Collections.sort(tableBuilders,new SortByScore());


        try {

            PrintWriter pw = new PrintWriter(file);
            JSONObject jsonObject;

            for (TableBuilder tb:tableBuilders) {

                jsonObject = new JSONObject();
                jsonObject.put("score", tb.getScore());
                jsonObject.put("name", tb.getName());

                pw.println(jsonObject.toJSONString());

            }

            System.out.println("Saved in File");
            pw.flush();
            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nie odnaleziono pliku");
        }


    }


}
