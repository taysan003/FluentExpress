package com.express.base;
/*import au.com.bytecode.opencsv.CSVReader;*/

import com.opencsv.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class CsvDataProvider {

    @DataProvider(name = "CsvDataProvider")
    public static Iterator<Object[]> provideData(Method method) {
        List<Object[]> list = new ArrayList<>();
       /* String pathname_2 = "G:/PortnovSchool/FluentExpressAuto/src/test/resources/test_data/LoginTest_negativeLogInTest.csv";*/
        String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test_data"
                + File.separator + method.getDeclaringClass().getSimpleName() + "_" + method.getName() + ".csv";
        File file = new File(pathname);
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();
            if (keys != null) {
                String[] dataParts;
                while ((dataParts = reader.readNext()) != null)
                {
                    Map<String, String> testData = new HashMap<String, String>();
                    for (int i = 0; i < keys.length; i++) {
                        testData.put(keys[i], dataParts[i]);

                    }
                    list.add(new Object[]{testData});
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + pathname + "was not found.\n" + e.getStackTrace().toString());
        } catch (IOException e) {
            throw new RuntimeException("Could not read " + pathname + "file.\n" + e.getStackTrace().toString());
        }
        return list.iterator();
    }

}
