Feature: luma is a shopping website

  Scenario: to oder a dress from womens category and place the order
    Given user will enter the url in chrome browser
    When user will click the sign in button
    And user will enter the emailaddress in the email id filed
    And user will enter the password in the password field
    Then user will click the signin button and we can continue the shopping
    When user will click the category of women
    And user will select the tops option from the women category
    And user will select the jacket and it will display the collection of jacket
    When user will select the particular product
    And user will select the size and color of the jacket
    And user will click the add to cart button
    When once product is added user will click the cart
    And user will click the checkout button and it navigate to shipping page
    And user  will check the shipping address and user will click next button
    And it navigate to the payment page and user will check the payment method and click place order button
    When user will click mens category
    And user will click the tops from mens category
    And user will click the jacket options from tops and it will show the collections of mens jacket
    And user will select particular product from the mens jacket collection
    And user will select the size and color of the jacket men
    And user will click the add to cart buttonn
    And user will click the cart button
    And user will click edit button but to edit the quantity
    And once user done with edit and user will click the update options and it will navigate to shipping page
    And user will check the shipping address and click next button and it will navigate to payment page
    And once user check the payment options and user will click the place oder button
    And user will click print receipt button and it navigate to next page page
    And in next page user will click print button
    And user will enter file name and user will click save button
    

