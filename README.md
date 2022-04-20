# FridgeManager
This is a Repro for a Application called FridgeManager

## Getting_started

+ Install PGAdmin
+ Create a new Databse called "fridge"
+ set the username and password of your database in the appplication.properties
+ run FridgeManagerApplication
+ visit http://localhost:8080/fridge with a GET Request to get all fridges


## Description of the REST Service Methods

### User

+ Get /user: return all Users
+ Get /user/{id}: returns one user
+ Get /user/fridge/{id}: returns the id of the Fridge of a user
+ Get /user/shoppingList/{id}: returns the id of the Shopping List of a user
+ Delete /user/{id}: deletes one user
+ Post /user: inserts a user, email and password are requiered, the other attributes are optional
+ Post /user/login: requiers the id, email and password of a user to return a user

### Fridge

+ Get /fridge: returns all Fridges
+ Get /fridge/{id}/products: returns all Products of one Fridge


### ShoppingList

+ Get /shoppingList: returns all Shopping Lists
+ Get /shoppingList/{id}/products: returns all Products of one Shopping List

### Product

+ Get /product: returns all Products
+ Get /product/{id}: returns one Product
+ Delete /product/{id}: delets one Product (also from the Fridge or Shopping List)
+ Post /product/fridge/{fridge_id}: inserts a new Product in the Fridge with the id
+ Post /product/shoppingList/{shopping_list_id}: inserts a new Product in the Shopping List with the id

### OpenFoodFacts

+ Get /openfoodfacts/product/{ean}: returns a product with the ean
+ Get /openfoodfacts/{search}: returns a list of products wiht according to the search criteria