package net.jakim.testing.steps.definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Transpose;
import net.jakim.testing.entities.User;

import java.util.Map;

public class Transformers {

    @DataTableType
    public User getUser(@Transpose DataTable userData) {
        Map<String, String> userDataMap = userData.asMaps().get(0);
        User user = new User();
        user.setFirstName(userDataMap.get("firstName"));
        user.setSurName(userDataMap.get("surName"));
        user.setCity(userDataMap.get("city"));
        user.setPassword(userDataMap.get("password"));
        user.setCountry(userDataMap.get("country"));
        user.setEmail(userDataMap.get("email"));

        return user;
    }

    @ParameterType("Registration|login|yellow")  // regexp
    public String page(String pageName) {  // type, name (from method)
        return pageName;       // transformer function
    }
}
