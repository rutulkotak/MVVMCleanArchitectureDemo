**Basic Code demo to cover:**
* MVVM
* Clean Architecture
* Coroutines
* Repository pattern
* Local data source ( Room )
* Remote data source ( Retrofit )
* DI
  - Dagger2 ( master branch )
  - Hilt ( using_hilt branch )
* Android Test
  - DAO test
  - More to add
* Local Test
  - Livedata test
  - ViewModel test
  - Test doubles ( FakeRepository )

**Structure:**
* Presentation
  - View
  - ViewModel
* Domain
  - Usecase
  - Repository Interface
* Data
  - Repository Implementation
  - Data Sources

Quick Intro:
* LiveData
  - Android LiveData is lifecycle aware, observable data holder class
  - As its name suggest, we use to get live data
  - In another words, to get real time updates form the data source
  - Define a LiveData instance
     var count = MutableLiveData<Int>()
  - Update a LiveData instance
    count.value = 0
  - Obaseve a LiveData instance
    viewModel.count.observe(this, observer{ // Update UI })

**Diagram:**
![Github_MVVM_Clean_Architecture_Flow](https://github.com/rutulkotak/MVVMCleanArchitectureDemo/assets/3943212/41510971-54af-4260-85db-22d7ea9d8b64)

