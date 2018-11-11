package com.baseqa.test;

import com.baseqa.annotations.TestInfo;
import com.baseqa.dataprovider.DataGenerator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseQATest {

    @Test(dataProviderClass = DataGenerator.class, dataProvider = "")
    @TestInfo(file = "testdata.csv")
    public void sampleTest() {

    }
}
