package com.baseqa.dataprovider;

import com.baseqa.annotations.TestInfo;
import com.baseqa.datareader.CsvDataReader;
import com.baseqa.datareader.DataReader;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

public class DataGenerator {


    @DataProvider(name = "csvDataProvider")
    public Object[][] getData(Method method) throws IOException, URISyntaxException {

        Annotation[] annotations = method.getDeclaredAnnotations();
        if(annotations == null || annotations.length == 0)
            throw new RuntimeException();

        TestInfo testInfo = null;

        for(Annotation ann : annotations) {
            if(ann instanceof TestInfo)
                testInfo = (TestInfo)ann;
        }

        if(testInfo == null)
            return new Object[0][0];

        DataReader reader = new CsvDataReader();
        List<HashMap<String, Object>> data = reader.readFile(testInfo.file());

        return parse(data);
    }

    private Object[][] parse(List<HashMap<String, Object>> data) {

        if(data==null || data.size()==0)
            return new Object[0][0];
        Object[][] testData = new Object[data.size()][2];
        int i = 0;
        for(HashMap<String, Object> entry : data) {
            testData[i][0] = entry.get("testcase");
            entry.remove("testcase");
            testData[i][1] = entry;
            i++;
        }
        return testData;
    }
}
