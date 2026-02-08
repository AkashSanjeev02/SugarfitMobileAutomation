//package Utility;
//
//import static io.restassured.RestAssured.given;
//
//import java.util.List;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//
//public class RestAssuredUtility {
//
//    /**
//     * Calls performance API and returns average app load time in milliseconds
//     */
//    public static double getAverageAppLoadTime() {
//
//        Response response =
//                RestAssured.given()
//                        .baseUri("https://api.yourapp.com")
//                        .basePath("/performance/loadtime")
//                        .when()
//                        .get()
//                        .then()
//                        .statusCode(200)
//                        .extract()
//                        .response();
//
//        List<Integer> loadTimes =
//                response.jsonPath().getList("appLoadTimes");
//
//        if (loadTimes == null || loadTimes.isEmpty()) {
//            throw new RuntimeException("❌ No app load time data returned from API");
//        }
//
//        return loadTimes.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .orElseThrow(() ->
//                        new RuntimeException("❌ Unable to calculate average load time"));
//    }
//}