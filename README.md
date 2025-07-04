## Summary

- Product is a super class, where ShippableProduct, ExpirableProduct, represents different types of products (subtypes)
- all shippable products implements the interface shippable which constrains overriding getName and getWeight methods
- the expirableShippableProduct class inherits from the ExpirableProduct, and implements shippable to cover the case if a product has both properties
- Cart and CartItem classes handle the logic of adding items to the cart with a specific quantity
- Customer class represents the user, he has a balance and a cart, and triggers the checkout method, which creates an instance of the checkout class and calls all its methods handling corner cases
- ShippingService class takes a list of Shippable items and creates the Shipment Notice
- App is the entry point, where products and customers are initialized and different scenarios are demonstrated

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
