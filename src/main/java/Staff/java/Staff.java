package Staff.java;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.GsonBuilder;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class Staff {

        public static void main(String[] args) {

            Gson gson = new Gson();

            Staff staff = createStaffObject();

            // Java objects to String
            // String json = gson.toJson(staff);

            // Java objects to File
            try (FileWriter writer = new FileWriter("C:\\projects\\staff.json")) {
                gson.toJson(staff, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private static Staff createStaffObject() {

            Staff staff = new Staff();

            staff.setName("");
            staff.setAge(35);
            staff.setPosition(new String[]{"Founder", "CTO", "Writer"});
            Map<String, BigDecimal> salary = new HashMap() {{
                put("2010", new BigDecimal(10000));
                put("2012", new BigDecimal(12000));
                put("2018", new BigDecimal(14000));
            }};
            staff.setSalary(salary);
            staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

            return staff;

        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

    }

