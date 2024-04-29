package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class UserTests {

    @Test
    public void printFanCodeCityUsers() {
        Response usersResponse = RestAssured.get("http://jsonplaceholder.typicode.com/users");

        if (usersResponse.getStatusCode() != 200) {
            System.out.println("Failed to retrieve user information");
            return;
        }

        List<Map<String, Object>> users = usersResponse.jsonPath().getList("$");

        for (Map<String, Object> user : users) {
            if (isInFanCodeCity(user)) {
                printUserDetails(user);
            }
        }
    }

    private boolean isInFanCodeCity(Map<String, Object> user) {
        Map<String, Object> address = (Map<String, Object>) user.get("address");
        if (address == null) return false;

        Map<String, Object> geo = (Map<String, Object>) address.get("geo");
        if (geo == null) return false;

        String latitudeStr = (String) geo.get("lat");
        String longitudeStr = (String) geo.get("lng");
        if (latitudeStr == null || longitudeStr == null) return false;

        double latitude, longitude;
        try {
            latitude = Double.parseDouble(latitudeStr);
            longitude = Double.parseDouble(longitudeStr);
        } catch (NumberFormatException e) {
            return false;
        }

        return latitude >= -40 && latitude <= 5 && longitude >= 5 && longitude <= 100;
    }

    private void printUserDetails(Map<String, Object> user) {
        int userId = (int) user.get("id");
        System.out.println("User ID: " + userId);
        printCompletedTaskPercentage(userId);
    }

    private void printCompletedTaskPercentage(int userId) {
        Response todosResponse = RestAssured.get("http://jsonplaceholder.typicode.com/todos?userId=" + userId);

        if (todosResponse.getStatusCode() != 200) {
            System.out.println("Failed to retrieve todo tasks for User ID: " + userId);
            return;
        }

        List<Map<String, Object>> todos = todosResponse.jsonPath().getList("$");
        long completedTasks = todos.stream().filter(todo -> (boolean) todo.get("completed")).count();
        double completedTaskPercentage = todos.size() > 0 ? (completedTasks * 100.0) / todos.size() : 0;
        System.out.println("Completed Task Percentage for User ID " + userId + ": " + completedTaskPercentage + "%");
    }
}
