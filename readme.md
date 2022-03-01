#### Question and Answer

**What kind of architecture did you use?**  
I use MVVM (Model View ViewModel) + Clean Architecture.
I use View and ViewModel for Presenter Layer, Use Case/ Interactor and Entity for Domain Layer and Repository Pattern for Data Layer.

**What libraries did you add to the app? What are they used for? if you not rely the other library tell us why?**  
I use several library in this project.
-   Core-ktx for core library
-   Koin for dependency injection
-   Glide for handling and show image
-   Gson for converting json to object or vice versa
-   Retrofit2 and Okhttp3 for handling network related stuff
-   Lifecycle for Viewmodel, Livedata, etc
-   Appcompat, material and constraintlayout for layouting ui
-   Junit and Espresso for testing (but unfortunately I am not yet using it because the time is up)

**How long did you spend on the test?**  
I spend about 24 hours or maybe over 30 hours.

**If you had more time, what further improvements or new features would you add?**  
I want complete all feature like randomize item, fixing search behaviour, add loading (use shimmer), 
try again page if error, check date converter, and using coordinator layout for blog page

Then I want to implement new feature like splash screen, apps logo, better ui, detect wifi or internet connection problem,
About and Licenses page, use local data (use Room), implement unit and ui testing.

**Which parts of your submission are you most proud of? And why? little advice, dont answer whole project, use one what you think it special.**  
I am using several new technique in this project (at least it's new for me). I am using sealed class for implement recyclerview multiple viewtype.
Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance. 
All direct subclasses of a sealed class are known at compile time. [(see source)](https://kotlinlang.org/docs/sealed-classes.html)

The benefits are:
-   Using a sealed class for your adapterDataList will reduce the need to have an else statement in the `getItemViewType` method as well as make it slightly less error prone.
-   By defining your own base view holder as a sealed class, you can avoid the need to throw an `IllegalArgumentException` in the `onBindViewHolder` and make this a little less error prone as well.
    [(see comment section in this page)](https://medium.com/@ivancse.58/android-and-kotlin-recyclerview-with-multiple-view-types-65285a254393)
    
I use different model for different architecture layer (Presenter, Domain and Data). Why we need this? Because it is aligned with separation of concern in Clean Architecture.
Different layer needs different data model. For example we define createdDate: Int (unix timestamp) for Data Model. Then we need createdDate: Date in Domain Model for
easy date manipulation. Then we need createdDate: String for Presenter Model so the View part can easily show the data.

I am using data mapper utility to convert from one model to another model. Last, I learn where I must put the logic for combine the data from blog and candidate api.
Maybe some of developer will doing this in use case/ interactor. But I do this in view model, because from several article that I read,
the viewmodel can get the data from several use case. I think This logic is not part of bussiness so I am not handle it in use case but in view model.
If the apps scale up and we have many use case and the page request to combine several data. Then we can easily pull data from several use case and combine at
viewmodel for that page and we do not need to change the domain layer (use case).

**Which parts did you spend the most time with? What did you find most difficult?**  
Maybe, I spend most of the time to learning and understand new knowledge. I know this is a test and it is a common sense to do it quick and good.
But, I want this project to be unique. Maybe, I can do it quick but I think the quality of my project is not in the level of unique.
So, I decide to do this test to learn something new so this project become unique (again.. at least unique for me).
Then, I make this project different from all of my previous project.

The difficult part is to understand something new. I need some times to understand new knowledge and implement it. 
I think other people needs time to understand new konowledge too and that is normal. It is difficult but I am happy that I can understand 
new knowledge and technique then implement that knowledge in this project.

**How did you find the test overall? If you have any suggestions on how we can improve the test or our API, we'd love to hear them, please elaborate more about this.**  
The requirement is okay. I am understand the requirements. But the time is limited to 3 days so I must give up several features.
My suggestions are:
-   Change the test time from 3 days to 5 days. Some developer will do the test in weekdays. Maybe, They do not have enough time to make their best project.
    Maybe, They still working for their current company and they do not have spare time to do this test.
-   I found that data in the api is not complete, candidate id start from 1 but address, email and experience api is start from 0. I do not know if this is intentional or not.
-   The address data is confusing for common knowledge.
    For example:

        address: " Jl Patehan Kidul 34, Jawa Tengah"
        city: "Yogyakarta"
        state: "Jawa Tengah"
        zip_code: 55133
    
    I do not know if the address is full address or just street address. If this full address, why address not show the city data.
    But, if this is just a street name, why it is show Jawa Tengah?
    So, you can make the address holding street name like this:
    
        address: "Jl Patehan Kidul 34"
        city: "Yogyakarta"
        state: "Yogyakarta"
        zip_code: 55133
    
    or the address holding the full address like this:

        address: "Jl Patehan Kidul 34, Yogyakarta, Yogyakarta 55133"
        city: "Yogyakarta"
        state: "Yogyakarta"
        zip_code: 55133

    I assume that current api use street name, so I combine all data to make full address.
-   For this requirement:
    Search Candidate and Blog in toolbar, it will auto execute without user tap search, filter the list based user keyword. (filter user title, filter blog title, filter candidate name it will mixed)
    I do not know the "filter user title" so I ignore it.

**The last question, quality or quantity?**  
I think we must handle both of them. Sometimes, I prefer quantity over quality but sometimes I prefer quality over quantity. 
It depends on the situation. But usually I prefer quality other than quantity.