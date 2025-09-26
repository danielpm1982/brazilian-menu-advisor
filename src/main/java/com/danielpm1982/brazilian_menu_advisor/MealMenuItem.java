package com.danielpm1982.brazilian_menu_advisor;
import java.math.BigDecimal;
import java.util.UUID;

public record MealMenuItem(UUID id, String name, MealType type, String description, BigDecimal price,
                       BigDecimal priceDiscounted) {
}
