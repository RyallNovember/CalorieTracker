package com.ryall.tracker_data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.ryall.tracker_data.local.entity.TrackedFoodEntity
import com.ryall.tracker_domain.model.MealType
import com.ryall.tracker_domain.model.TrackedFood
import java.time.LocalDate

//make sure this doesnt break anything because of date = LocalDate.of(year, month, dayOfMonth)
@RequiresApi(Build.VERSION_CODES.O)
fun TrackedFoodEntity.toTrackedFood(): TrackedFood {
    return TrackedFood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
        id = id
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun TrackedFood.toTrackedFoodEntity(): TrackedFoodEntity {
    return TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        type = mealType.name,
        amount = amount,
        dayOfMonth = date.dayOfMonth,
        month = date.monthValue,
        year = date.year,
        calories = calories,
        id = id
    )
}