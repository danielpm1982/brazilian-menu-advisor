package com.danielpm1982.brazilian_menu_advisor;
import java.util.*;

public class MealMenuItemSupplier {
    public static MealMenuItem getRandomInstance(final MealType mealType, final Double DISCOUNT) {
        return getShuffledMealMenuItemListFromDB(mealType, DISCOUNT).stream().findAny().
                orElseThrow(()->new RuntimeException("No Menu Items found for Meal Type: "+mealType+" at the DB !"));
    }
    private static List<MealMenuItem> getShuffledMealMenuItemListFromDB(final MealType mealType, final Double DISCOUNT){
        List<MealMenuItem> mealMenuItemList = MealMenuItemDB.getMealMenuItemsFromDB(DISCOUNT).get(mealType);
        Collections.shuffle(mealMenuItemList);
        return mealMenuItemList;
    }
}
