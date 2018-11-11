package com.baseqa.datareader;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class CsvDataReader implements DataReader{

    public List<HashMap<String, Object>> readFile(String filePath) throws IOException, URISyntaxException {
//        CSVReader reader = new CSVReader(new FileReader(filePath),',');
        CSVReader reader = new CSVReader(new FileReader(new File(getClass().getResource(filePath).toURI())),',');
        List<HashMap<String, Object>> testData = new ArrayList<>();
        String[] line = reader.readNext();
        HashMap<String, Object> header = new LinkedHashMap<>();
        for(String key : line) {
            header.put(key, null);
        }

        while((line = reader.readNext())!=null) {
            Iterator<String> it = header.keySet().iterator();
            HashMap<String, Object> data = new LinkedHashMap<>();
            for(String key : line) {
                data.put(it.next(), key);
            }
            testData.add(data);
        }

        return testData;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        DataReader reader = new CsvDataReader();
//        List<HashMap<String, Object>> data = reader.readFile("/Users/bisanth.b/Documents/codebase-ext/base-qa/src/test/resources/testdata.csv");
        List<HashMap<String, Object>> data = reader.readFile("/testdata.csv");
        System.out.println(data);
    }
}