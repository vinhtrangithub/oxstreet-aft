package oxstreet.dao;

import oxstreet.utils.Utilities;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SearchDAO {
    private String emailAddress;
    private String password;
    private String search;
    private String expectedResult;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }
    public SearchDAO(String email, String password, String searchValue, String expectedResult) {
        this.emailAddress = email;
        this.password = password;
        this.search = searchValue;
        this.expectedResult = expectedResult;
    }

    public static SearchDAO readAllData(String file) throws IOException {
        String emailAddress = "";
        String password = "";
        String searchValue = "";
        String expectedResult = "";


        try {
            FileReader fileReader = new FileReader(System.getProperty("user.dir") + "/data/" + file);
            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                emailAddress =  row[0];
                password = row[1];
                searchValue = row[2];
                expectedResult = row[3];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new SearchDAO(emailAddress, password, searchValue, expectedResult);
    }
}
