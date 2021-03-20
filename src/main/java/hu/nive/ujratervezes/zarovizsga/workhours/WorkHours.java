package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class WorkHours {


    public String minWork(String file) {
        Path path = Path.of(file);
        try {
            List<String> employees = Files.readAllLines(path);
            int minHour = Integer.MAX_VALUE;
            String result = null;
            for (String employee : employees) {

                String[] temp = employee.split(",");
                if (temp.length == 3) {


                    String name = temp[0];
                    int hour;
                    try {
                       hour = Integer.parseInt(temp[1]);
                    }
                    catch (Exception e) {
                        continue;
                    }
                    String date = temp[2];
                    if (hour < minHour) {
                        minHour = hour;
                        result = name + hour + date;
                    }
                }
            }
            return result;

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }


    }
}
