package com.danielpm1982.brazilian_menu_advisor;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    private static final double DISCOUNT = 0.15;
    void main() {
        Map<MealType, Integer> mealTypeQtyRequestMap = getMealTypeQtyRequestMap();
        List<MealMenuItem> mealMenuItemSuggestionList = getMealMenuItemSuggestionList(mealTypeQtyRequestMap);
        printMealMenuItemSuggestionList(mealMenuItemSuggestionList);
        printMealMenuItemSuggestionListJson(mealMenuItemSuggestionList);
        printTotalPrice(mealMenuItemSuggestionList);
    }
    // gets the requests from the client, as a Map<MealType, Integer>, for each meal type (simulates the user inputs from a GUI screen)
    // must not be all zero quantity
    @SuppressWarnings("Duplicates")
    private static Map<MealType, Integer> getMealTypeQtyRequestMap(){
        final int APPETIZER_QTY = 3;
        final int PRINCIPAL_DISH_QTY = 2;
        final int SIDE_DISH_QTY = 4;
        final int BEVERAGE_QTY = 5;
        final int DESSERT_QTY = 3;
        Map<MealType, Integer> mealTypeQtyRequestMap = new LinkedHashMap<>();
        mealTypeQtyRequestMap.put(MealType.APPETIZER, APPETIZER_QTY);
        mealTypeQtyRequestMap.put(MealType.PRINCIPAL_DISH, PRINCIPAL_DISH_QTY);
        mealTypeQtyRequestMap.put(MealType.SIDE_DISH, SIDE_DISH_QTY);
        mealTypeQtyRequestMap.put(MealType.BEVERAGE, BEVERAGE_QTY);
        mealTypeQtyRequestMap.put(MealType.DESSERT, DESSERT_QTY);
        return mealTypeQtyRequestMap;
    }
    // gets all suggestions of meal menu items, as a List<MealMenuItem>, for all meal types
    private static List<MealMenuItem> getMealMenuItemSuggestionList(Map<MealType,Integer> mealTypeQtyMap) {
        List<MealMenuItem> mealMenuItemSuggestionList = new LinkedList<>();
        mealTypeQtyMap.forEach((mealType, qty) -> IntStream.range(0, qty).
                forEach(x->mealMenuItemSuggestionList.add(MealMenuItemSupplier.getRandomInstance(mealType, DISCOUNT))));
        return mealMenuItemSuggestionList;
    }
    // displays all suggestions of meal menu items, as a String
    private static void printMealMenuItemSuggestionList(List<MealMenuItem> mealMenuItemList){
        IO.println("\nSuggestion of complete meal with "+Math.round(DISCOUNT*100)+"% discount:\n");
        mealMenuItemList.forEach(mealMenuItem-> IO.println("Product_code: "+mealMenuItem.id()+
                "\nProduct_name: "+mealMenuItem.name()+"\nProduct_type: "+mealMenuItem.type()+"\nProduct_description: "+
                mealMenuItem.description()+"Original_price: US$ "+mealMenuItem.price().setScale(2, RoundingMode.HALF_UP)+
                "\nDiscounted_price: US$ "+mealMenuItem.priceDiscounted().setScale(2, RoundingMode.HALF_UP)+"\n"));
    }
    // displays all suggestions of meal menu items, as a JSON
    private static void printMealMenuItemSuggestionListJson(List<MealMenuItem> mealMenuItemList){
        IO.println("\nSuggestion of complete meal with "+Math.round(DISCOUNT*100)+"% discount in JSON format:\n");
        Gson gson = new Gson();
        String mealMenuItemSuggestionListJson = gson.toJson(mealMenuItemList);
        IO.println(mealMenuItemSuggestionListJson);
    }
    // displays the total price for all suggestions of meal menu items
    private static void printTotalPrice(List<MealMenuItem> mealMenuItemList){
        IO.println("\n*********************\nTotal price of meal: US$ "+
                BigDecimal.valueOf(mealMenuItemList.stream().mapToDouble(mealMenuItem -> mealMenuItem.priceDiscounted().
                        doubleValue()).sum()).setScale(2, RoundingMode.HALF_UP));
    }
}

/*
This class gets a client order, as the number of random meals he wishes for each meal type - supposing the client doesn't know
what meal items to ask. That numeric order is used to retrieve random meal suggestions from the internal in-memory DB. All suggested
meals are then displayed as a String and as JSON, also showing the total price the customer should pay.

This project is simply to test the import and use of the Gson dependency when using Gradle.
*/
