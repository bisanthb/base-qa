package com.baseqa.test;

import com.baseqa.annotations.TestInfo;
import com.baseqa.dataprovider.DataGenerator;
import org.testng.annotations.Test;
import java.util.HashMap;

public class BaseQATest {

    @Test(dataProviderClass = DataGenerator.class, dataProvider = "csvDataProvider")
    @TestInfo(file = "/testdata.csv")
    public void sampleTest(String testCase, HashMap<String, Object> testData) {
        System.out.println("testCase name is :: "+ testCase);
        System.out.println("testCase data is :: "+ testData);
    }
}
