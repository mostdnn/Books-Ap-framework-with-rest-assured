package api.endpoints;

public class Roots {

    public static String basURL="https://simple-books-api.glitch.me";
    public static String CreateToken=basURL+"/api-clients/";
    public static String status=basURL+"/status";
    public static String getbooks=basURL+"/books";
    public static String getasinglebook=basURL+"/books/{bookId}";
    public static String orders=basURL+"/orders";
    public static String updateorder=basURL+"/orders/{orderId}";
    public static String deleteorder=basURL+"/orders/{orderId}";
}
