# wm-cache$

 [![Join the chat at https://gitter.im/wm-caches/Lobby](https://badges.gitter.im/wm-caches/Lobby.svg)](https://gitter.im/wm-caches/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

![Alt text](/wm.png?raw=true "Norfolk Air")

# DE Hack U 5 Student Repository #

![Alt text](/de.jpg?raw=true "Norfolk Air")

# Summary #

Our goal coming into HackU5 was to utilize big data to make lives better for residents in Hampton Roads. We decided to use data from Homes.com, The City of Norfolk, Yelp and MyLocalCrime.com to help Norfolk residents find a home that they want to live in. We designed an Android application called **Homey** which has a similar User Experience to the popular dating app Tinder to find houses in the Norfolk area that match a user's tastes.

#Products:#
[Homes.com Public API](https://github.com/NickRance/homesapi2/)

[Norfolk AIR WebScraper](https://github.com/NickRance/norfolkairscraper)

Homey

## Homes.com Public API ##
![Alt text](/homes.jpg?raw=true "Norfolk Air")

In order to do any data project one must start with a data set. For this hackathon we decided to use the home listings from Homes.com. We wrote a public API to allow Hampton Roads Developers to use Homes.com listings in their projects. 

### API Specifications ###
**URL: homesapi.herokuapp.com**

#### /homes ####

The /homes endpoint allows you to search for a number of houses by zipcode

GET Parameters

| Param        | Data Type           | Description  |
| ------------- |:-------------:| -----:|
| number      | integer | The number of homes to return|
| zipcode      | integer      |   The zipcode(s) that you want to search homes in |

Return Values

| Field        | Data Type           | Description  |
| ------------- |:-------------:| -----:|

#### /matches ####

The /matches endpoint returns a number of matches based on our recommendation engine
GET Parameters

| Param        | Data Type           | Description  |
| ------------- |:-------------:| -----:|
| number      | integer | The number of matches to return|

Return Values

| Field        | Data Type           | Description  |
| ------------- |:-------------:| -----:|
| street_address      | string | The address of the street|
| postal_code      | integer      |   The zipcode of the home |
| city      | string      |   City of the house |
| state      | string      |   State the house is located in |
| main_uri      | string      |   Url to the Homes.com listing |
| price      | integer      |   The price of the house |
| primary_image      | string      |   Url to the primary image of the house |
| crime_url      | string      |   Url to recent crimes near the listing |
| food_score      | integer      |   Average Yelp rating  |
| restaurant_search_url      | string      |  Url to Yelp search showing restaurants |

TODO: Show the results schema for the /homes api

## Norfolk AIR Scrape r##

![Alt text](/norfolk_air.png?raw=true "Norfolk Air")
![Alt text](/400%20granby%20json.PNG?raw=true)



Norfolk Air is a web portal created by the City of Norfolk to allow residents of Norfolk to lookup information such as nearby schools, transit options and flood zone information. We wrote a web scraper that allows you to programmatically gather all the information the city of Norfolk has about an address. No solution existed to programmatically extract this data prior to this.

TODO: Create a public API and database for all properties in Norfolk.
## Homey ##

Homey is an app that allows users to find houses in the Norfolk area through a card matching User Experience. It pulls the most important information from the Norfolk AIR Scraper, Homes.com, Yelp and other endpoints to help future homeowners easily create a list of homes on which to perform further research.

Build AndTinderDemo in Android Studio

## Gitter ##
Join us on gitter to talk about our project and help us build products that enhance Norfolk.
[Gitter](https://gitter.im/wm-caches/Lobby)
