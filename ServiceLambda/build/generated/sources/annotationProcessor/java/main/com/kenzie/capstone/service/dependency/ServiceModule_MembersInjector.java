package com.kenzie.capstone.service.dependency;

import com.kenzie.capstone.service.LambdaRecipeService;
import com.kenzie.capstone.service.dao.RecipeDao;
import dagger.MembersInjector;
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
public final class ServiceModule_MembersInjector implements MembersInjector<ServiceModule> {
  private final Provider<RecipeDao> recipeDaoProvider;

  public ServiceModule_MembersInjector(Provider<RecipeDao> recipeDaoProvider) {
    this.recipeDaoProvider = recipeDaoProvider;
  }

  public static MembersInjector<ServiceModule> create(Provider<RecipeDao> recipeDaoProvider) {
    return new ServiceModule_MembersInjector(recipeDaoProvider);
  }

  @Override
  public void injectMembers(ServiceModule instance) {
    injectProvideLambdaRecipeService(instance, recipeDaoProvider.get());
  }

  public static LambdaRecipeService injectProvideLambdaRecipeService(ServiceModule instance,
      RecipeDao recipeDao) {
    return instance.provideLambdaRecipeService(recipeDao);
  }
}
