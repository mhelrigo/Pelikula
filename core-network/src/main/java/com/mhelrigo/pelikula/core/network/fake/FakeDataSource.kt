package com.mhelrigo.pelikula.core.network.fake

import com.mhelrigo.pelikula.core.network.model.*

object FakeDataSource {
    private val movies = listOf(
        MovieModel(
            id = 278,
            voteCount = 22137,
            popularity = 118.72F,
            voteAverage = 8.7F,
            genreIds = listOf(18, 80),
            backDropPath = "/kXfqcdQKsToO0OUXHcrrNCHDBzO.jpg",
            originalLanguage = "en",
            originalTitle = "The Shawshank Redemption",
            overview = "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
            posterPath = "/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
            releaseDate = "1994-09-23",
            title = "The Shawshank Redemption",
            adult = false,
            video = false
        )
    )

    val topRatedMoviesApiResponse = MovieListApiResponse(
        page = 1,
        results = movies,
        totalPages = 1,
        totalResult = 1
    )

    val popularMoviesApiResponse = MovieListApiResponse(
        page = 1,
        results = movies,
        totalPages = 1,
        totalResult = 1
    )

    val nowPlayingMoviesApiResponse = MovieListApiResponse(
        page = 1,
        results = movies,
        totalPages = 1,
        totalResult = 1
    )

    val movieDetail = MovieDetailApiResponse(
        id = 550,
        budget = 63000000,
        revenue = 100853753,
        runtime = 139,
        voteCount = 3439,
        popularity = 0.5F,
        voteAverage = 7.8F,
        backdropPath = "/fCayJrkfRaCRCTh8GqN30f8oyQF.jpg",
        imdbId = "tt0137523",
        originalTitle = "Fight Club",
        originalLanguage = "en",
        overview = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
        posterPath = "",
        releaseDate = "1999-10-12",
        status = "Released",
        tagline = "How much can you know about yourself if you've never been in a fight?",
        title = "Fight Club",
        genres = listOf(),
        productionCompanies = listOf(),
        productionCountries = listOf(),
        spokenLanguageModels = listOf()
    )

    val creditsApiResponse = CreditsApiResponse(
        movieId = 550, listOf(
            CastModel(
                id = 819,
                gender = 2,
                castId = 4,
                order = 0,
                popularity = 7.861F,
                knownForDepartment = "Acting",
                name = "Edward Norton",
                originalName = "Edward Norton",
                profilePath = "/5XBzD5WuTyVQZeS4VI25z2moMeY.jpg",
                character = "The Narrator",
                creditId = "52fe4250c3a36847f80149f3"
            )
        )
    )

    val movieImagesApiResponse = MovieImagesApiResponse(
        id = 550,
        backdropModels = listOf(
            BackdropModel(
                height = 1439,
                width = 2559,
                filePath = "/rr7E0NoGKxvbkb89eR1GwfoYjpA.jpg"
            )
        ),
        logoModels = listOf(
            LogoModel(
                height = 389,
                width = 1804,
                filePath = "/7Uqhv24pGJs4Ns31NoOPWFJGWNG.png"
            )
        ),
        posterModels = listOf(
            PosterModel(
                height = 900,
                width = 600,
                filePath = "/r3pPehX4ik8NLYPpbDRAh0YRtMb.jpg"
            )
        )
    )

    val movieRecommendationsApiResponse = MovieListApiResponse(
        page = 1,
        results = movies,
        totalPages = 1,
        totalResult = 1
    )
}

val popularMoviesApiResponse =
    "{\"page\":1,\"results\":[{\"adult\":false,\"backdrop_path\":\"/kXfqcdQKsToO0OUXHcrrNCHDBzO.jpg\",\"genre_ids\":[18,80],\"id\":278,\"original_language\":\"en\",\"original_title\":\"The Shawshank Redemption\",\"overview\":\"Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.\",\"popularity\":118.72,\"poster_path\":\"/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg\",\"release_date\":\"1994-09-23\",\"title\":\"The Shawshank Redemption\",\"video\":false,\"vote_average\":8.7,\"vote_count\":22137},{\"adult\":false,\"backdrop_path\":\"/90ez6ArvpO8bvpyIngBuwXOqJm5.jpg\",\"genre_ids\":[35,18,10749],\"id\":19404,\"original_language\":\"hi\",\"original_title\":\"दिलवाले दुल्हनिया ले जायेंगे\",\"overview\":\"Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.\",\"popularity\":39.983,\"poster_path\":\"/2CAL2433ZeIihfX1Hb2139CX0pW.jpg\",\"release_date\":\"1995-10-19\",\"title\":\"Dilwale Dulhania Le Jayenge\",\"video\":false,\"vote_average\":8.7,\"vote_count\":3791},{\"adult\":false,\"backdrop_path\":\"/htuuuEwAvDVECMpb0ltLLyZyDDt.jpg\",\"genre_ids\":[18,80],\"id\":238,\"original_language\":\"en\",\"original_title\":\"The Godfather\",\"overview\":\"Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.\",\"popularity\":110.343,\"poster_path\":\"/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"release_date\":\"1972-03-14\",\"title\":\"The Godfather\",\"video\":false,\"vote_average\":8.7,\"vote_count\":16458},{\"adult\":false,\"backdrop_path\":\"/loRmRzQXZeqG78TqZuyvSlEQfZb.jpg\",\"genre_ids\":[18,36,10752],\"id\":424,\"original_language\":\"en\",\"original_title\":\"Schindler's List\",\"overview\":\"The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.\",\"popularity\":68.406,\"poster_path\":\"/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg\",\"release_date\":\"1993-12-15\",\"title\":\"Schindler's List\",\"video\":false,\"vote_average\":8.6,\"vote_count\":13107},{\"adult\":false,\"backdrop_path\":\"/poec6RqOKY9iSiIUmfyfPfiLtvB.jpg\",\"genre_ids\":[18,80],\"id\":240,\"original_language\":\"en\",\"original_title\":\"The Godfather Part II\",\"overview\":\"In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba.\",\"popularity\":66.44,\"poster_path\":\"/hek3koDUyRQk7FIhPXsa6mT2Zc3.jpg\",\"release_date\":\"1974-12-20\",\"title\":\"The Godfather Part II\",\"video\":false,\"vote_average\":8.6,\"vote_count\":9929},{\"adult\":false,\"backdrop_path\":\"/bxSBOAD8AuMHYMdW3jso9npAkgt.jpg\",\"genre_ids\":[10751,18],\"id\":667257,\"original_language\":\"es\",\"original_title\":\"Cosas imposibles\",\"overview\":\"Matilde is a woman who, after the death of her husband - a man who constantly abused her - finds her new best friend in Miguel, her young, insecure, disoriented and even dealer neighbor\",\"popularity\":19.094,\"poster_path\":\"/t2Ew8NZ8Ci2kqmoecZUNQUFDJnQ.jpg\",\"release_date\":\"2021-06-17\",\"title\":\"Impossible Things\",\"video\":false,\"vote_average\":8.5,\"vote_count\":266},{\"adult\":false,\"backdrop_path\":\"/Ab8mkHmkYADjU7wQiOkia9BzGvS.jpg\",\"genre_ids\":[16,10751,14],\"id\":129,\"original_language\":\"ja\",\"original_title\":\"千と千尋の神隠し\",\"overview\":\"A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family.\",\"popularity\":95.199,\"poster_path\":\"/39wmItIWsg5sZMyRUHLkWBcuVCM.jpg\",\"release_date\":\"2001-07-20\",\"title\":\"Spirited Away\",\"video\":false,\"vote_average\":8.5,\"vote_count\":13283},{\"adult\":false,\"backdrop_path\":\"/3RMLbSEXOn1CzLoNT7xFeLfdxhq.jpg\",\"genre_ids\":[10749,16],\"id\":372754,\"original_language\":\"ja\",\"original_title\":\"同級生\",\"overview\":\"Rihito Sajo, an honor student with a perfect score on the entrance exam and Hikaru Kusakabe, in a band and popular among girls, would have never crossed paths. Until one day they started talking at the practice for their school’s upcoming chorus festival. After school, the two meet regularly, as Hikaru helps Rihito to improve his singing skills. While they listen to each other’s voice and harmonize, their hearts start to beat together.\",\"popularity\":14.098,\"poster_path\":\"/cIfRCA5wEvj9tApca4UDUagQEiM.jpg\",\"release_date\":\"2016-02-20\",\"title\":\"Dou kyu sei – Classmates\",\"video\":false,\"vote_average\":8.5,\"vote_count\":251},{\"adult\":false,\"backdrop_path\":\"/mMtUybQ6hL24FXo0F3Z4j2KG7kZ.jpg\",\"genre_ids\":[10749,16,18],\"id\":372058,\"original_language\":\"ja\",\"original_title\":\"君の名は。\",\"overview\":\"High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.\",\"popularity\":174.937,\"poster_path\":\"/q719jXXEzOoYaps6babgKnONONX.jpg\",\"release_date\":\"2016-08-26\",\"title\":\"Your Name.\",\"video\":false,\"vote_average\":8.5,\"vote_count\":9019},{\"adult\":false,\"backdrop_path\":\"/qqHQsStV6exghCM7zbObuYBiYxw.jpg\",\"genre_ids\":[18],\"id\":389,\"original_language\":\"en\",\"original_title\":\"12 Angry Men\",\"overview\":\"The defense and the prosecution have rested and the jury is filing into the jury room to decide if a young Spanish-American is guilty or innocent of murdering his father. What begins as an open and shut case soon becomes a mini-drama of each of the jurors' prejudices and preconceptions about the trial, the accused, and each other.\",\"popularity\":33.366,\"poster_path\":\"/ppd84D2i9W8jXmsyInGyihiSyqz.jpg\",\"release_date\":\"1957-04-10\",\"title\":\"12 Angry Men\",\"video\":false,\"vote_average\":8.5,\"vote_count\":6634},{\"adult\":false,\"backdrop_path\":\"/TU9NIjwzjoKPwQHoHshkFcQUCG.jpg\",\"genre_ids\":[35,53,18],\"id\":496243,\"original_language\":\"ko\",\"original_title\":\"기생충\",\"overview\":\"All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.\",\"popularity\":81.416,\"poster_path\":\"/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg\",\"release_date\":\"2019-05-30\",\"title\":\"Parasite\",\"video\":false,\"vote_average\":8.5,\"vote_count\":14312},{\"adult\":false,\"backdrop_path\":\"/jtAI6OJIWLWiRItNSZoWjrsUtmi.jpg\",\"genre_ids\":[10749],\"id\":724089,\"original_language\":\"en\",\"original_title\":\"Gabriel's Inferno: Part II\",\"overview\":\"Professor Gabriel Emerson finally learns the truth about Julia Mitchell's identity, but his realization comes a moment too late. Julia is done waiting for the well-respected Dante specialist to remember her and wants nothing more to do with him. Can Gabriel win back her heart before she finds love in another's arms?\",\"popularity\":13.58,\"poster_path\":\"/x5o8cLZfEXMoZczTYWLrUo1P7UJ.jpg\",\"release_date\":\"2020-07-31\",\"title\":\"Gabriel's Inferno: Part II\",\"video\":false,\"vote_average\":8.5,\"vote_count\":1433},{\"adult\":false,\"backdrop_path\":\"/w2uGvCpMtvRqZg6waC1hvLyZoJa.jpg\",\"genre_ids\":[10749],\"id\":696374,\"original_language\":\"en\",\"original_title\":\"Gabriel's Inferno\",\"overview\":\"An intriguing and sinful exploration of seduction, forbidden love, and redemption, Gabriel's Inferno is a captivating and wildly passionate tale of one man's escape from his own personal hell as he tries to earn the impossible--forgiveness and love.\",\"popularity\":15.515,\"poster_path\":\"/oyG9TL7FcRP4EZ9Vid6uKzwdndz.jpg\",\"release_date\":\"2020-05-29\",\"title\":\"Gabriel's Inferno\",\"video\":false,\"vote_average\":8.5,\"vote_count\":2280},{\"adult\":false,\"backdrop_path\":\"/l6hQWH9eDksNJNiXWYRkWqikOdu.jpg\",\"genre_ids\":[14,18,80],\"id\":497,\"original_language\":\"en\",\"original_title\":\"The Green Mile\",\"overview\":\"A supernatural tale set on death row in a Southern prison, where gentle giant John Coffey possesses the mysterious power to heal people's ailments. When the cell block's head guard, Paul Edgecomb, recognizes Coffey's miraculous gift, he tries desperately to help stave off the condemned man's execution.\",\"popularity\":85.852,\"poster_path\":\"/velWPhVMQeQKcxggNEU8YmIo52R.jpg\",\"release_date\":\"1999-12-10\",\"title\":\"The Green Mile\",\"video\":false,\"vote_average\":8.5,\"vote_count\":14341},{\"adult\":false,\"backdrop_path\":\"/nMKdUUepR0i5zn0y1T4CsSB5chy.jpg\",\"genre_ids\":[18,28,80,53],\"id\":155,\"original_language\":\"en\",\"original_title\":\"The Dark Knight\",\"overview\":\"Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.\",\"popularity\":91.072,\"poster_path\":\"/qJ2tW6WMUDux911r6m7haRef0WH.jpg\",\"release_date\":\"2008-07-14\",\"title\":\"The Dark Knight\",\"video\":false,\"vote_average\":8.5,\"vote_count\":28178},{\"adult\":false,\"backdrop_path\":\"/v5CEt88iDsuoMaW1Q5Msu9UZdEt.jpg\",\"genre_ids\":[10749,18],\"id\":730154,\"original_language\":\"ja\",\"original_title\":\"きみの瞳が問いかけている\",\"overview\":\"A tragic accident lead to Kaori's blindness, but she clings to life and the smaller pleasures it can still afford her. She meets Rui and begins to talk to him. Rui was once a promising kickboxer, but something happened in his past. Kaori's smile brings out a change in Rui. However, the two are connected in more than one way. Rui attempts to do what is right.\",\"popularity\":52.961,\"poster_path\":\"/cVn8E3Fxbi8HzYYtaSfsblYC4gl.jpg\",\"release_date\":\"2020-10-23\",\"title\":\"Your Eyes Tell\",\"video\":false,\"vote_average\":8.5,\"vote_count\":348},{\"adult\":false,\"backdrop_path\":\"/suaEOtk1N1sgg2MTM7oZd2cfVp3.jpg\",\"genre_ids\":[53,80],\"id\":680,\"original_language\":\"en\",\"original_title\":\"Pulp Fiction\",\"overview\":\"A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.\",\"popularity\":71.778,\"poster_path\":\"/fIE3lAGcZDV1G6XM5KmuWnNsPp1.jpg\",\"release_date\":\"1994-09-10\",\"title\":\"Pulp Fiction\",\"video\":false,\"vote_average\":8.5,\"vote_count\":23707},{\"adult\":false,\"backdrop_path\":\"/x4biAVdPVCghBlsVIzB6NmbghIz.jpg\",\"genre_ids\":[37],\"id\":429,\"original_language\":\"it\",\"original_title\":\"Il buono, il brutto, il cattivo\",\"overview\":\"While the Civil War rages on, three men – a quiet loner, a ruthless hitman, and a Mexican bandit – comb the American Southwest in search of a strongbox containing \$200,000 in stolen gold.\",\"popularity\":58.657,\"poster_path\":\"/bX2xnavhMYjWDoZp1VM6VnU1xwe.jpg\",\"release_date\":\"1966-12-23\",\"title\":\"The Good, the Bad and the Ugly\",\"video\":false,\"vote_average\":8.5,\"vote_count\":6836},{\"adult\":false,\"backdrop_path\":\"/lXhgCODAbBXL5buk9yEmTpOoOgR.jpg\",\"genre_ids\":[12,14,28],\"id\":122,\"original_language\":\"en\",\"original_title\":\"The Lord of the Rings: The Return of the King\",\"overview\":\"Aragorn is revealed as the heir to the ancient kings as he, Gandalf and the other members of the broken fellowship struggle to save Gondor from Sauron's forces. Meanwhile, Frodo and Sam take the ring closer to the heart of Mordor, the dark lord's realm.\",\"popularity\":293.182,\"poster_path\":\"/rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg\",\"release_date\":\"2003-12-01\",\"title\":\"The Lord of the Rings: The Return of the King\",\"video\":false,\"vote_average\":8.5,\"vote_count\":20099},{\"adult\":false,\"backdrop_path\":\"/oJmBWLUCKbgra8D9ZrLE1nBic5v.jpg\",\"genre_ids\":[35,18,10749],\"id\":13,\"original_language\":\"en\",\"original_title\":\"Forrest Gump\",\"overview\":\"A man with a low IQ has accomplished great things in his life and been present during significant historic events—in each case, far exceeding what anyone imagined he could do. But despite all he has achieved, his one true love eludes him.\",\"popularity\":65.583,\"poster_path\":\"/saHP97rTPS5eLmrLQEcANmKrsFl.jpg\",\"release_date\":\"1994-06-23\",\"title\":\"Forrest Gump\",\"video\":false,\"vote_average\":8.5,\"vote_count\":23234}],\"total_pages\":514,\"total_results\":10270}"

val movieDetailApiResponse =
    "{\"adult\":false,\"backdrop_path\":\"/rr7E0NoGKxvbkb89eR1GwfoYjpA.jpg\",\"belongs_to_collection\":null,\"budget\":63000000,\"genres\":[{\"id\":550,\"name\":\"Drama\"}],\"homepage\":\"http://www.foxmovies.com/movies/fight-club\",\"id\":550,\"imdb_id\":\"tt0137523\",\"original_language\":\"en\",\"original_title\":\"Fight Club\",\"overview\":\"A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \\\"fight clubs\\\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.\",\"popularity\":90.85,\"poster_path\":\"/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg\",\"production_companies\":[{\"id\":508,\"logo_path\":\"/7PzJdsLGlR7oW4J0J5Xcd0pHGRg.png\",\"name\":\"Regency Enterprises\",\"origin_country\":\"US\"},{\"id\":711,\"logo_path\":\"/tEiIH5QesdheJmDAqQwvtN60727.png\",\"name\":\"Fox 2000 Pictures\",\"origin_country\":\"US\"},{\"id\":4700,\"logo_path\":\"/A32wmjrs9Psf4zw0uaixF0GXfxq.png\",\"name\":\"The Linson Company\",\"origin_country\":\"US\"},{\"id\":20555,\"logo_path\":\"/hD8yEGUBlHOcfHYbujp71vD8gZp.png\",\"name\":\"Taurus Film\",\"origin_country\":\"DE\"},{\"id\":54051,\"logo_path\":null,\"name\":\"Atman Entertainment\",\"origin_country\":\"\"},{\"id\":54052,\"logo_path\":null,\"name\":\"Knickerbocker Films\",\"origin_country\":\"US\"}],\"production_countries\":[{\"iso_3166_1\":\"DE\",\"name\":\"Germany\"},{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"release_date\":\"1999-10-15\",\"revenue\":100853753,\"runtime\":139,\"spoken_languages\":[{\"english_name\":\"English\",\"iso_639_1\":\"en\",\"name\":\"English\"}],\"status\":\"Released\",\"tagline\":\"Mischief. Mayhem. Soap.\",\"title\":\"Fight Club\",\"video\":false,\"vote_average\":8.432,\"vote_count\":24806}"

val creditsApiResponse = "{\n" +
        "  \"id\": 500,\n" +
        "  \"cast\": [\n" +
        "    {\n" +
        "      \"adult\": false,\n" +
        "      \"gender\": 2,\n" +
        "      \"id\": 819,\n" +
        "      \"known_for_department\": \"Acting\",\n" +
        "      \"name\": \"Edward Norton\",\n" +
        "      \"original_name\": \"Edward Norton\",\n" +
        "      \"popularity\": 7.861,\n" +
        "      \"profile_path\": \"/5XBzD5WuTyVQZeS4VI25z2moMeY.jpg\",\n" +
        "      \"cast_id\": 4,\n" +
        "      \"character\": \"The Narrator\",\n" +
        "      \"credit_id\": \"52fe4250c3a36847f80149f3\",\n" +
        "      \"order\": 0\n" +
        "    }\n" +
        "  ]\n" +
        "}"

val movieiMagesApiResponse =
    "{\"backdrops\":[{\"aspect_ratio\":1.778,\"height\":1439,\"iso_639_1\":null,\"file_path\":\"/rr7E0NoGKxvbkb89eR1GwfoYjpA.jpg\",\"vote_average\":5.396,\"vote_count\":12,\"width\":2559}],\"id\":550,\"logos\":[{\"aspect_ratio\":4.638,\"height\":389,\"iso_639_1\":\"en\",\"file_path\":\"/7Uqhv24pGJs4Ns31NoOPWFJGWNG.png\",\"vote_average\":5.172,\"vote_count\":1,\"width\":1804}],\"posters\":[{\"aspect_ratio\":0.667,\"height\":900,\"iso_639_1\":\"pt\",\"file_path\":\"/r3pPehX4ik8NLYPpbDRAh0YRtMb.jpg\",\"vote_average\":5.318,\"vote_count\":3,\"width\":600}]}"

val movieRecommendationApiResponse =
    "{\"page\":1,\"results\":[{\"adult\":false,\"backdrop_path\":\"/suaEOtk1N1sgg2MTM7oZd2cfVp3.jpg\",\"id\":278,\"title\":\"Pulp Fiction\",\"original_language\":\"en\",\"original_title\":\"Pulp Fiction\",\"overview\":\"A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.\",\"poster_path\":\"/fIE3lAGcZDV1G6XM5KmuWnNsPp1.jpg\",\"media_type\":\"movie\",\"genre_ids\":[53,80],\"popularity\":69.92,\"release_date\":\"1994-09-10\",\"video\":false,\"vote_average\":8.489,\"vote_count\":23823}],\"total_pages\":1,\"total_results\":1}"