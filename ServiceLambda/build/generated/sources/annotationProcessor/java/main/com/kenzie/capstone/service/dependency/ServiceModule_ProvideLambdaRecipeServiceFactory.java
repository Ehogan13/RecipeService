package com.kenzie.capstone.service.dependency;

import com.kenzie.capstone.service.LambdaRecipeService;
import com.kenzie.capstone.service.dao.RecipeDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ServiceModule_ProvideLambdaRecipeServiceFactory implements Factory<LambdaRecipeService> {
  private final ServiceModule module;

  private final Provider<RecipeDao> recipeDaoProvider;

  public ServiceModule_ProvideLambdaRecipeServiceFactory(ServiceModule module,
      Provider<RecipeDao> recipeDaoProvider) {
    this.module = module;
    this.recipeDaoProvider = recipeDaoProvider;
  }

  @Override
  public LambdaRecipeService get() {
    return provideLambdaRecipeService(module, recipeDaoProvider.get());
  }

  public static ServiceModule_ProvideLambdaRecipeServiceFactory create(ServiceModule module,
      Provider<RecipeDao> recipeDaoProvider) {
    return new ServiceModule_ProvideLambdaRecipeServiceFactory(module, recipeDaoProvider);
  }

  public static LambdaRecipeService provideLambdaRecipeService(ServiceModule instance,
      RecipeDao recipeDao) {
    return Preconditions.checkNotNullFromProvides(instance.provideLambdaRecipeService(recipeDao));
  }
}
