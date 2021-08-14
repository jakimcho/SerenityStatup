package net.jakim.testing.steps.definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import net.jakim.testing.entities.User;

import java.util.Map;

public class Transformers {

    @DataTableType
    public User getUser(DataTable userData) {
        Map<String, String> userDataMap = userData.asMaps().get(0);
        User user = new User();
        user.setFirstName(userDataMap.get("firstName"));
        user.setSurName(userDataMap.get("surName"));
        user.setAge(Integer.parseInt(userDataMap.get("age")));
        return user;
    }
}
