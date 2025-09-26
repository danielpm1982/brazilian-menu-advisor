package com.danielpm1982.brazilian_menu_advisor;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) {
        final double DISCOUNT = 0.15;
        List<MealMenuItem> mealMenuItemSuggestionList = new ArrayList<>();
        Arrays.stream(MealType.values()).
                forEach(mealType -> mealMenuItemSuggestionList.add(MealMenuItemSupplier.getRandomInstance(mealType, DISCOUNT)));
        System.out.println("\nSuggestion of complete meal with "+Math.round(DISCOUNT*100)+"% discount:\n");
        mealMenuItemSuggestionList.forEach(mealMenuItem-> System.out.println("Product_code: "+mealMenuItem.id()+"\nProduct_name: "+mealMenuItem.name()+"\nProduct_type: "+mealMenuItem.type()+"\nProduct_description: "+mealMenuItem.description()+"Original_price: US$ "+mealMenuItem.price().setScale(2, RoundingMode.HALF_UP)+"\nDiscounted_price: US$ "+mealMenuItem.priceDiscounted().setScale(2, RoundingMode.HALF_UP)+"\n"));
        System.out.println("\nSuggestion of complete meal with "+Math.round(DISCOUNT*100)+"% discount in JSON format:\n");
        Gson gson = new Gson();
        String meanManuItemJson = gson.toJson(mealMenuItemSuggestionList);
        System.out.println(meanManuItemJson);
        System.out.println("\n*********************\nTotal price of meal: US$ "+ BigDecimal.valueOf(mealMenuItemSuggestionList.stream().mapToDouble(mealMenuItem -> mealMenuItem.priceDiscounted().doubleValue()).sum()).setScale(2, RoundingMode.HALF_UP));
    }
}
