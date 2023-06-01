package com.kenzie.capstone.service;

import com.kenzie.capstone.service.dao.RecipeDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LambdaRecipeService_Factory implements Factory<LambdaRecipeService> {
  private final Provider<RecipeDao> recipeDaoProvider;

  public LambdaRecipeService_Factory(Provider<RecipeDao> recipeDaoProvider) {
    this.recipeDaoProvider = recipeDaoProvider;
  }

  @Override
  public LambdaRecipeService get() {
    return newInstance(recipeDaoProvider.get());
  }

  public static LambdaRecipeService_Factory create(Provider<RecipeDao> recipeDaoProvider) {
    return new LambdaRecipeService_Factory(recipeDaoProvider);
  }

  public static LambdaRecipeService newInstance(RecipeDao recipeDao) {
    return new LambdaRecipeService(recipeDao);
  }
}
