package com.kenzie.capstone.service.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.kenzie.capstone.service.LambdaRecipeService;
import com.kenzie.capstone.service.dao.RecipeDao;
import dagger.internal.DoubleCheck;
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
public final class DaggerServiceComponent implements ServiceComponent {
  private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  private Provider<RecipeDao> provideRecipeDaoProvider;

  private Provider<LambdaRecipeService> provideLambdaRecipeServiceProvider;

  private DaggerServiceComponent(DaoModule daoModuleParam, ServiceModule serviceModuleParam) {

    initialize(daoModuleParam, serviceModuleParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final DaoModule daoModuleParam, final ServiceModule serviceModuleParam) {
    this.provideDynamoDBMapperProvider = DoubleCheck.provider(DaoModule_ProvideDynamoDBMapperFactory.create(daoModuleParam));
    this.provideRecipeDaoProvider = DoubleCheck.provider(DaoModule_ProvideRecipeDaoFactory.create(daoModuleParam, provideDynamoDBMapperProvider));
    this.provideLambdaRecipeServiceProvider = DoubleCheck.provider(ServiceModule_ProvideLambdaRecipeServiceFactory.create(serviceModuleParam, provideRecipeDaoProvider));
  }

  @Override
  public LambdaRecipeService provideLambdaRecipeService() {
    return provideLambdaRecipeServiceProvider.get();
  }

  public static final class Builder {
    private DaoModule daoModule;

    private ServiceModule serviceModule;

    private Builder() {
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }

    public Builder serviceModule(ServiceModule serviceModule) {
      this.serviceModule = Preconditions.checkNotNull(serviceModule);
      return this;
    }

    public ServiceComponent build() {
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      if (serviceModule == null) {
        this.serviceModule = new ServiceModule();
      }
      return new DaggerServiceComponent(daoModule, serviceModule);
    }
  }
}
