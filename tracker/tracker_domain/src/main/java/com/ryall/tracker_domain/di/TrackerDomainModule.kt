package com.ryall.tracker_domain.di

import com.ryall.core.domain.preferences.Preferences
import com.ryall.tracker_domain.repository.TrackerRepository
import com.ryall.tracker_domain.use_case.CalculateMealNutrients
import com.ryall.tracker_domain.use_case.DeleteTrackedFood
import com.ryall.tracker_domain.use_case.GetFoodsForDate
import com.ryall.tracker_domain.use_case.SearchFood
import com.ryall.tracker_domain.use_case.TrackFood
import com.ryall.tracker_domain.use_case.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCase(preferences: Preferences, repository: TrackerRepository): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}