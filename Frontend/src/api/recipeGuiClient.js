import BaseClass from "../util/baseClass";
import axios from 'axios'

/**
 * Client to call the MusicPlaylistService.
 *
 * This could be a great place to explore Mixins. Currently the client is being loaded multiple times on each page,
 * which we could avoid using inheritance or Mixins.
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes#Mix-ins
 * https://javascript.info/mixins
 */
export default class RecipeGuiClient extends BaseClass {

    constructor(props = {}){
        super();
        const methodsToBind = ['clientLoaded', 'testPut', 'getRecipeByDR', 'getRecipeById', 'createRecipe'];
        this.bindClassMethods(methodsToBind, this);
        this.props = props;
        this.clientLoaded(axios);
    }

    /**
     * Run any functions that are supposed to be called once the client has loaded successfully.
     * @param client The client that has been successfully loaded.
     */
    clientLoaded(client) {
        this.client = client;
        if (this.props.hasOwnProperty("onReady")){
            this.props.onReady();
        }
    }

    /**
     * Gets the concert for the given ID.
     * @param id Unique identifier for a concert
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The concert
     */
    async testPut(errorCallback) {

          try {
            const response = await this.client.put(`/recipe/rating`, {
                recipeId: recipeId,
                newRating: rating,

            });
            return response.data;
          } catch (error) {
            this.handleError("getRecipe", error, errorCallback);
          }
    }

    async getRecipeById(id, errorCallback) {
        console.log("hitting here");
      try {
        const response = await this.client.get(`/recipe/${id}`);
        return response.data;
      } catch (error) {
        this.handleError("getRecipe", error, errorCallback);
      }
    }

    async getRecipeByDR(gluten, dairy, egg, vegetarian, vegan, errorCallback) {
        try {
            const isGlutenFree = gluten;
            const isDairyFree = dairy;
            const isEggFree = egg;
            const isVegetarian = vegetarian;
            const isVegan = vegan;
            const response = await this.client.get(`/recipe/dietaryRestriction/${isGlutenFree}/${isDairyFree}/${isEggFree}/${isVegetarian}/${isVegan}`);
            return response.data;
        } catch (error) {
            this.handleError("getRecipe", error, errorCallback)
        }
    }


    async createRecipe(title, ingredients, steps, gluten, dairy, egg, vegetarian, vegan, errorCallback) {
        try {
            const response = await this.client.post(`recipe`, {
                title: title,
                ingredients: [ingredients],
                steps: [steps],
                isGlutenFree: gluten,
                isDairyFree: dairy,
                isEggFree: egg,
                isVegetarian: vegetarian,
                isVegan: vegan,
            });
            return response.data;
        } catch (error) {
            this.handleError("createRecipe", error, errorCallback);
        }
    }

    /**
     * Helper method to log the error and run any error functions.
     * @param error The error received from the server.
     * @param errorCallback (Optional) A function to execute if the call fails.
     */
    handleError(method, error, errorCallback) {
        console.error(method + " failed - " + error);
        if (error.response.data.message !== undefined) {
            console.error(error.response.data.message);
        }
        if (errorCallback) {
            errorCallback(method + " failed - " + error);
        }
    }
}