# My News

My News is a native Android Application written in Kotlin. It is a demo project that uses APIs from [newsapi.org](https://newsapi.org/) and [openweathermap.org](https://openweathermap.org/) to display list of top headlines and current weather of Sydney city.

The news detail page shows more details about the news and allows user to share the news.

The About Me page shows the application's name, logo and version number. Also, it includes the developer name and two icons which allow users to compose email to developer or open developer's LinkedIn page.

## Installation
Clone this repository and import into **Android Studio**
```bash
https://github.com/chhetrir4hul/my-news.git
```

## Configuration
### Keystores:
`apiKey.properties` is also pushed to repository on purpose to make it easy to run application without having to make any changes. This file should be added in `.gitignore` file.

Edit `apiKey.properties` in project root directory with the following info if you want to use your own API keys:
```gradle
NEWS_API_KEY = "INSERT_NEWS_API_KEY_HERE"
WEATHER_API_KEY = "INSERT_OPEN_WEATHER_MAP_API_KEY_HERE"
```


## Architecture
My News application uses Android MVVM architecture with Android Architecture Components. The following are the key Android libraries used:

* Retrofit and okHttp3 (Making network calls)
* Glide (Image loading library)
* Hilt (Dependency injection)
* Navigation component
* Kotlin Coroutines
* Truth
* MockWebServer
* Mockito


## Developers
This project is developed by [Rahul Chhetri](https://github.com/chhetrir4hul)