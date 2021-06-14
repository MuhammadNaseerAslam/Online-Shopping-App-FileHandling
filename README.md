# Online-Shopping-App-FileHandling
Assignment # 2
Due Date: Sunday 8 Nov 2020, 11:59 PM on google classroom
Objective: Alerts, ListView and Implicit Intents
Problem: You are requested to design some screens for a shopping which is interested in taking orders
online. Only small size companies use this mall to purchase things. So, this application will be used by
the company representatives who will purchase/make orders on this mall. The screens are given below
with sample data input and output.
Extend your assignment # 1:
All your first 4 screens(xmls) will be unchanged, the java codes will be changed according to the current
requirements. Whenever you were submitting the data from screen 4, it was being printed on screen 5,
now you need to store all the records in a file named as “records.txt”. Also, make a new screen which
will be shown after screen 4, having all the orders in a listview. Let’s call that screen listScreen.
The list screen will have following items on it:
1. A searchView [to search the orders in listview]
2. A menu having two items “edit” and “delete” in it.
3. A listView which will have list orders. A listItem of that listview will have customer Name,
Address and time of order.
4. A floating_action_button to create a new order.
The actions you need to incorporate:
1. Make a class of order having all the fields as data members [mentioned in the screen 3&4],
additionally you need to store the date and time of order creation.
• Choose suitable datatypes of data members.
• Make suitable constructors and setters/getters.
2. Whenever an order is placed it is saved in “orders.txt” [this file has all the orders saved so for].
On the listScreen, the listView will be fed with these orders.
3. On listScreen, whenever a listItem is clicked [onItemClick] a new screen must be initiated which
will show the details of that order. You can user screen # 5 for order detail.
4. On listScreen, whenever a listItem is long clicked [onItemLongClick], a menu should be shown to
edit the order or delete it.
• If user opts to delete the order, you must give an alert to ask whether he is sure to
delete it or not?
• If yes, delete that order from array list.
➢ If the user opts to edit the order, the screen#3 must be initiated, but it should have the
data in its fields to edit. If user presses the next button the screen 4 must be opened to
edit the complete data.5. The user must be able to choose multiple listItems from the list view, if user has chosen more
than 1 [one] item, the edit option must be disabled [you can change the color of edit menu on
this], only you can delete multiple items at a time.
6. Whenever the user types something in searchview, the listview must be updated with the
searched orders. The search can be on address and the name of users.
7. If the user clicks the floating action button [you can learn it from google], the screen#2 will be
opened to create a new order.
8. Now in this phase of assignment, whenever, a new order is placed, a notification must be
launched, a sms must be sent and an email is also sent.
