Project 01
The social networking website is an online community designed to make social life more active and stimulating. 
The social network can help one maintain existing relationships with people and share  messages, and establish new ones by reaching out to people one has never met before. 


The social networking site must provide the following functionalities:  
User registration and authentication  
User Login 
User profile management  
Connect with other users (follow/friend)   
Post content (text, images, videos)  
Comment on posts   
Like/react to posts  
Search for users, posts, and content  

**JEREMY NOTES**
- Individual Assignment
- Check pre-training Social Media API for reference on what request types are needed for each requirement
- The way the project runs is that the Spring API is run and listens on its port, then the React application runs and sends requests to the Spring API
    - In order to do this, you need to add a CORS (Cross-Origin Resource Sharing) annotation to your Spring API. Specifically, add @CrossOrigin to your Controller so it's listening to requests from an external source
    - You probably also need Axios on your frontend in order to send requests to the backend. Requests are sent on localhost/8080/{endpoint} (8080 is the default port your backend runs/listens on)
    - He wants something like a mySQL database for your actual database, which is not the database used for the Spring API. When you integrate this, mySQL databases listen on port 3306 by default
- BACKEND
    - Features covered by Spring Social Media API
        - User registration and authentication (register account)
            - Look into JWT (JSON web tokens). when someone logs in and is authenticated, a jwt token is created that stays with that user for all requests until they sign out
        - User Login (account login)
        - Post content (create message)
    - Features not covered by Spring Social Media API (you need to adjust the project)
        - User profile management (bare minimum: add functions to account allowing user to update username and password)
        - Comment on posts
            - Comments on posts should be stored as an array that you iterate over with something like the map() function
        - Like/react to posts 
            - not sure if this needs to be its own entity in the database or I should add likes as a feature to an existing entity
        - Search for users, posts and content**
    **The API has a feature to get messages by their id, but nothing to search for something based on its contents 
        - (might be a simple adjustment, like instead of searching by id I search things looking for a substring, but I won't know until I do it)
        - IDEA: Create functions for both account and messages that grab lists of everything containing a certain substring. For accounts, grab every account whose username contains the substring, whereas for messages it grabs every message whose messageText contains the substring. On the frontend, searching will either contain both, or the user will have the option to search for either accounts or messages (for now, just get these functions working for account and for message). To make the searches as broad as possible, make sure they're not case-sensitive by adjusting both the searched text and the text being searched so that comparisons are easier (internet recommends converting to uppercase). Obviously not perfect, since a search that's just the letter 'a' would return too much, but hopefully it does enough
- DATABASE ADJUSTMENTS
    - New entities
        - Likes
        - Reactions
        - Followers/Friends?
- FRONTEND IDEAS
    - Headings that link to different pages of the site (home, profile, messages, friends, etc)
        - Maybe add style features to underline the headers when they're hovered over
        - UPDATE: Jasdhir has given a basic navbar component and style sheet for this purpose. Use it as a reference material for your own navigation bar
    - Posts should at the very least include the contents of the post and the user who created the post
        - The Spring project does not do this already, but postedBy references account_id, so that might facilitate it