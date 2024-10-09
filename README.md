
# Shopping Cart Application

This is a simple Shopping Cart web application built using **Java Servlets** and **JSP**. The project demonstrates the essential operations involved in an e-commerce system such as adding items to the cart, updating quantities, and checking out.

## Features

- Browse available products
- Add items to the shopping cart
- Update item quantity in the cart
- Remove items from the cart
- View cart summary
- Checkout functionality

## Technologies Used

- **Java**: Backend logic
- **Servlets**: Handling HTTP requests and responses
- **JSP**: For rendering dynamic content
- **HTML/CSS**: For frontend UI
- **JDBC**: Database connection for storing product and order information
- **MySQL**: Database for product and order data

## Setup

### Prerequisites

To run this project, you need to have:

- Java Development Kit (JDK) installed
- Apache Tomcat server installed
- MySQL Database

### Database Setup

1. Create a MySQL database named `db`.
2. Run the SQL scripts located in the `database` directory to create the necessary tables for products and orders.
3. Update the database configuration in the project to connect to your MySQL database.

```java
// Example DB configuration in Java
String url = "jdbc:mysql://localhost:3306/Shoppy/Home.jsp";
String username = "root";
String password = "your_password";
```

### Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/user-siva/shopping-cart.git
   ```

2. Import the project into your favorite IDE (like IntelliJ IDEA or Eclipse).
3. Configure the Apache Tomcat server in your IDE.
4. Run the application on the server.
5. Access the application in your browser at `http://localhost:8080/Shoppy/Home.jsp`.

## How to Use

1. Browse the product list.
2. Add items to your cart by specifying the quantity.
3. View and modify your cart at any time.
4. Checkout when ready, and confirm your order.

## Future Enhancements

- Add user authentication for personalized cart management.
- Include payment gateway integration.
- Implement discount and promo code functionalities.

