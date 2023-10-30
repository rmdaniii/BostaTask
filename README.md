# BostaTask
This is a Technical task for Bosta Company.

The app comprises 2 screens, The first is the profile screen, which has the user name and address
pinned at the top and lists all of this user’s albums. You can get user albums by requesting
the albums endpoint and passing the user ID as a parameter.
When you press on any album it navigates to the second screen which is an album details screen.
You request the photos endpoint and pass album ID as a parameter, then list the images in an
Instagram-like grid. Also, there should be a search bar that you can filter within the album by the
image title, when you start typing the screen should show only images related to this
search query.

### Software Stack:
 - Kotlin.
 - Clean Architecture (app, Domain, Data).
 - MVVM.
 - Retrofit.
 - Dependency Injection "Dagger".
 - Coroutines.
