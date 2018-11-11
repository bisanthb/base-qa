package com.baseqa.datareader;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class CsvDataReader implements DataReader{

    public List<HashMap<String, Object>> readFile(String filePath) throws IOException, URISyntaxException {
        CSVReader reader = new CSVReader(new FileReader(new File(getClass().getResource(filePath).toURI())),',');
        List<HashMap<String, Object>> testData = new ArrayList<>();
        String[] line = reader.readNext();
        HashMap<String, Object> header = new LinkedHashMap<>();
        if(line==null || line.length ==0) {
            throw new RuntimeException("test data file is empty");
        }
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

}