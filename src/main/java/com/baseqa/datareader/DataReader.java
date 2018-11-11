package com.baseqa.datareader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

public interface DataReader {

    public List<HashMap<String, Object>> readFile(String filePath) throws IOException, URISyntaxException;
}
