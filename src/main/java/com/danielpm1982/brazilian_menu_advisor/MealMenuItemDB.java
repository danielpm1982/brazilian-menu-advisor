package com.danielpm1982.brazilian_menu_advisor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class MealMenuItemDB {
    protected static Map<MealType, List<MealMenuItem>> getMealMenuItemsFromDB(final Double DISCOUNT) {
        List<MealMenuItem> mealMenuItemsAppetizerList = new ArrayList<>(Arrays.asList(
                new MealMenuItem(UUID.randomUUID(), "Pão de Queijo", MealType.APPETIZER, """
                        Cheesy bread rolls made from tapioca flour !
                        """, BigDecimal.valueOf(20.5), BigDecimal.valueOf(20.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Coxinha", MealType.APPETIZER, """
                        Fried dough filled with shredded chicken, shaped like a drumstick !
                        """, BigDecimal.valueOf(10.5), BigDecimal.valueOf(10.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Pastel", MealType.APPETIZER, """
                        Fried pastry filled with various ingredients like cheese, meat, or vegetables !
                        """, BigDecimal.valueOf(30.5), BigDecimal.valueOf(30.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Bolinho de Bacalhau", MealType.APPETIZER, """
                        Codfish fritters, often served with a side of lime !
                        """, BigDecimal.valueOf(50.5), BigDecimal.valueOf(50.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP))
        ));
        List<MealMenuItem> mealMenuItemsPrincipalDishList = new ArrayList<>(Arrays.asList(
                new MealMenuItem(UUID.randomUUID(), "Churrasco", MealType.PRINCIPAL_DISH, """
                        Brazilian barbecue featuring various cuts of meat, typically served with chimichurri sauce !
                        """, BigDecimal.valueOf(100.5), BigDecimal.valueOf(100.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Escondidinho", MealType.PRINCIPAL_DISH, """
                        A layered dish made with mashed cassava or potatoes and a filling of meat or seafood !
                        """, BigDecimal.valueOf(130.5), BigDecimal.valueOf(130.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Carne de Sol", MealType.PRINCIPAL_DISH, """
                        This dish consists of sun-dried beef that is typically salted and then grilled or pan-fried. Served with sides like mashed cassava (aipim) or rice, along with a fresh salad. Carne de Sol is especially popular in the northeastern region of Brazil and is known for its robust flavor and tender texture !
                        """, BigDecimal.valueOf(150.5), BigDecimal.valueOf(150.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP))
        ));
        List<MealMenuItem> mealMenuItemsSideDishList = new ArrayList<>(Arrays.asList(
                new MealMenuItem(UUID.randomUUID(), "Baião de Dois", MealType.SIDE_DISH, """
                        A rice and bean dish, often made with cheese and spices !
                        """, BigDecimal.valueOf(22.5), BigDecimal.valueOf(22.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Feijoada", MealType.SIDE_DISH, """
                        A hearty black bean stew with various cuts of pork and beef, traditionally served with rice !
                        """, BigDecimal.valueOf(32.5), BigDecimal.valueOf(32.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Batata Frita", MealType.SIDE_DISH, """
                        Fried potatoes, often served as a side with various dishes !
                        """, BigDecimal.valueOf(15.5), BigDecimal.valueOf(15.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP))
        ));
        List<MealMenuItem> mealMenuItemsBeverageList = new ArrayList<>(Arrays.asList(
                new MealMenuItem(UUID.randomUUID(), "Guaraná", MealType.BEVERAGE, """
                        A popular soft drink made from the guaraná fruit, known for its energizing properties !
                        """, BigDecimal.valueOf(6.5), BigDecimal.valueOf(6.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Açaí na Tigela", MealType.BEVERAGE, """
                        A smoothie bowl made from açaí berries, often topped with granola and fruits !
                        """, BigDecimal.valueOf(9.5), BigDecimal.valueOf(9.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Café Brasileiro", MealType.BEVERAGE, """
                        Strong Brazilian coffee, often served in small cups !
                        """, BigDecimal.valueOf(2.5), BigDecimal.valueOf(2.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP))
        ));
        List<MealMenuItem> mealMenuItemsDessertList = new ArrayList<>(Arrays.asList(
                new MealMenuItem(UUID.randomUUID(), "Brigadeiro", MealType.DESSERT, """
                        Chocolate truffles made with condensed milk, cocoa powder, and chocolate sprinkles !
                        """, BigDecimal.valueOf(3.5), BigDecimal.valueOf(3.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Pudim", MealType.DESSERT, """
                        A creamy caramel flan, popular for its smooth texture !
                        """, BigDecimal.valueOf(5.5), BigDecimal.valueOf(5.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP)),
                new MealMenuItem(UUID.randomUUID(), "Pavê", MealType.DESSERT, """
                        Pavê is a Brazilian layered dessert made with biscuits soaked in coffee or chocolate syrup, alternating with creamy fillings like chocolate or vanilla. It's typically chilled and topped with chocolate shavings or nuts, making it a popular treat for celebrations and gatherings !
                        """, BigDecimal.valueOf(11.5), BigDecimal.valueOf(11.5 * (1 - DISCOUNT)).setScale(2, RoundingMode.HALF_UP))
        ));
        Map<MealType, List<MealMenuItem>> mealMenuItemsMap = new LinkedHashMap<>();
        mealMenuItemsMap.put(MealType.APPETIZER, mealMenuItemsAppetizerList);
        mealMenuItemsMap.put(MealType.PRINCIPAL_DISH, mealMenuItemsPrincipalDishList);
        mealMenuItemsMap.put(MealType.SIDE_DISH, mealMenuItemsSideDishList);
        mealMenuItemsMap.put(MealType.BEVERAGE, mealMenuItemsBeverageList);
        mealMenuItemsMap.put(MealType.DESSERT, mealMenuItemsDessertList);
        return mealMenuItemsMap;
    }
}
