package com.aria.footballapp.utils

import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.data.source.local.entity.LeaguesEntity
import com.aria.footballapp.data.source.local.entity.TeamsEntity

class FakeDataDummy {

    companion object {
        fun generateAllLeague(): ArrayList<LeaguesEntity> {
            val myList: ArrayList<LeaguesEntity> = ArrayList()

            myList.add(
                LeaguesEntity(
                    idLeague = "4328",
                    strLeague = "English Premier League",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/i6o0kh1549879062.png",
                    strDescriptionEN = "The Premier League (often referred to as the English Premier League (EPL) outside England), is the top level of the English football league system. Contested by 20 clubs, it operates on a system of promotion and relegation with the English Football League (EFL).\r\n\r\nThe Premier League is a corporation in which the member clubs act as shareholders. Seasons run from August to May with each team playing 38 matches (playing each other home and away). Most games are played on Saturday and Sunday afternoons. The Premier League has featured 47 English and two Welsh clubs since its inception, making it a cross-border league.\r\n\r\nThe competition was formed as the FA Premier League on 20 February 1992 following the decision of clubs in the Football League First Division to break away from the Football League, founded in 1888, and take advantage of a lucrative television rights deal. The deal was worth £1 billion a year domestically as of 2013–14, with BSkyB and BT Group securing the domestic rights to broadcast 116 and 38 games respectively. The league generates €2.2 billion per year in domestic and international television rights. In 2014–15, teams were apportioned revenues of £1.6 billion, rising sharply to £2.4 billion in 2016–17.\r\n\r\nThe Premier League is the most-watched sports league in the world, broadcast in 212 territories to 643 million homes and a potential TV audience of 4.7 billion people. In the 2014–15 season, the average Premier League match attendance exceeded 36,000, second highest of any professional football league behind the Bundesliga's 43,500. Most stadium occupancies are near capacity. The Premier League ranks second in the UEFA coefficients of leagues based on performances in European competitions over the past five seasons, as of 2018.\r\n\r\nForty-nine clubs have competed since the inception of the Premier League in 1992. Six of them have won the title: Manchester United (13), Chelsea (5), Arsenal (3), Manchester City (3), Blackburn Rovers (1), and Leicester City (1). Following the 2003–04 season, Arsenal acquired the nickname \"The Invincibles\" as they became, and still remain, the only club to complete a Premier League campaign without losing a single game. The record of most points in a season is 100 by Manchester City in 2017–18."
                )
            )

            myList.add(
                LeaguesEntity(
                    idLeague = "4332",
                    strLeague = "Italian Serie A",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/ocy2fe1566216901.png",
                    strDescriptionEN = "Serie A, also called Serie A TIM due to sponsorship by Telecom Italia, is a professional league competition for football clubs located at the top of the Italian football league system and has been operating for over eighty years since the 1929–30 season. It had been organized by Lega Calcio until 2010, but a new league, the Lega Serie A, was created for the 2010–11 season. Serie A is regarded as one of the best football leagues in the world. Serie A was considered the best league in the world in the '90s, and has produced the highest number of European Cup finalists: Italian clubs have reached the final of the competition on a record twenty-six different occasions, winning the title twelve times. Serie A is ranked 4th among European leagues according to UEFA's league coefficient behind the Spanish La Liga, English Premier League and German Bundesliga, which is based on the performance of Italian clubs in the Champions League and the Europa League. It also ranked 5th in world according to the first trends of the 2011 IFFHS rating.\r\n\r\nIn its current format, the Italian Football Championship was revised from having regional and interregional rounds, to a single-tier league from the 1929–30 season onwards. The championship titles won prior to 1929 are officially recognised by FIGC with the same weighting as titles that were subsequently awarded. However, the 1945–46 season, when the league was played over two geographical groups due to the ravages of WWII, is not statistically considered, even if its title is fully official.\r\n\r\nThe league hosts three of the world's most famous clubs as Juventus, Milan and Internazionale, all founding members of the G-14, a group which represented the largest and most prestigious European football clubs; Serie A was the only league to produce three founding members. More players have won the coveted Ballon d'Or award while playing at a Serie A club than any other league in the world. Ahead of Spain's La Liga. Although the actual number of Ballon d'Or won by players in these two leagues is equal at 18 each. Including the FIFA Ballon d'Or. Milan is the second club with the most official international titles in the world (18). Juventus, Italy's most successful club of the 20th century and the most successful Italian team, is tied for fourth in Europe and eighth in the world in the same ranking. The club is the only one in the world to have won all possible official continental competitions and the world title. Internazionale, following their achievements in the 2009–10 season, became the first Italian team to have achieved The Treble."
                )
            )

            myList.add(
                LeaguesEntity(
                    idLeague = "4335",
                    strLeague = "Spanish La Liga",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/7onmyv1534768460.png",
                    strDescriptionEN = "The Primera División,  commonly known as La Liga and as La Liga Santander for sponsorship reasons, is the top professional association football division of the Spanish football league system. Administrated by the Liga de Fútbol Profesional (LFP), La Liga is contested by 20 teams, with the three lowest-placed teams relegated to the Segunda División and replaced by the top two teams in that division plus the winner of a play-off.\r\n\r\nA total of 60 teams have competed in La Liga since its inception. Nine teams have been crowned champions, with Real Madrid winning the title a record 32 times and Barcelona 24 times. Real Madrid dominated the championship from the 1950s through the 1980s. From the 1990s onwards, Barcelona (14 titles) and Real Madrid (7 titles) both dominated, though La Liga also saw other champions, including Atlético Madrid, Valencia, and Deportivo de La Coruña. In more recent years, Atlético Madrid has joined a coalition of now three teams dominating La Liga alongside Real Madrid and Barcelona.\r\n\r\nAccording to UEFA's league coefficient, La Liga has been the top league in Europe over the last five years, and has produced the continent's top-rated club more times (18) than any other league, double that of second-placed Serie A. Its clubs have won the most UEFA Champions League (16), UEFA Europa League (10), UEFA Super Cup (13), and FIFA Club World Cup (5) titles, and its players have accumulated the highest number of (FIFA) Ballon d'Or awards (19).\r\n\r\nLa Liga is one of the most popular professional sports leagues in the world, with an average attendance of 26,741 for league matches in the 2014–15 season. This is the sixth-highest of any domestic professional sports league in the world and the fourth-highest of any professional association football league in the world, behind the Bundesliga, the Premier League, and the Indian Super League."
                )
            )

            myList.add(
                LeaguesEntity(
                    idLeague = "4354",
                    strLeague = "Ukrainian Premier League",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/qprvpy1471773025.png",
                    strDescriptionEN = "The Ukrainian Premier League (Ukrainian: \\\"Прем'єр-ліга\\\") is the highest division of Ukrainian annual football championship. As the Supreme League (Vyshcha Liha) it was formed in 1991 upon discontinuation of the Soviet championship and included the Ukrainian based clubs that competed in the Soviet competitions. In 1996 along with all the professional football leagues of Ukraine, the Supreme League became a member of the Professional Football League of Ukraine.\\r\\n\\r\\nIn 2008 it was reformed into a more autonomous entity of both the Professional League and the Football Federation of Ukraine, officially changing its name to the current one. Its rank was 8th highest in Europe as rated by UEFA as of 2014."
                )
            )

            myList.add(
                LeaguesEntity(
                    idLeague = "4344",
                    strLeague = "Portuguese Primeira Liga",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/cplp641535733210.png",
                    strDescriptionEN = "The Primeira Liga (First League; Portuguese pronunciation: ), formerly called Primeira Divisão), is the top professional association football division of the Portuguese football league system.\r\n\r\nThe Primeira Liga is contested by 18 clubs, but only five of them have won the title. Founded in 1934, the league is in its 81st edition (counting four experimental leagues in the 1930s). It has been dominated by the \"Big Three\": Benfica, Porto and Sporting CP. These three clubs have won a total of 78 titles, with Belenenses and Boavista winning the other two."
                )
            )

            myList.add(
                LeaguesEntity(
                    idLeague = "4355",
                    strLeague = "Russian Football Premier League",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/fg0ad21532769374.png",
                    strDescriptionEN = "The Russian Football Championship (Russian: Чемпионат России по футболу), or Russian Premier League, is the top division professional association football league in Russia. The competition is administered by the Russian Football Premier League. There are 16 teams in the competition. The league has two Champions League qualifying spots given to the top two teams at the end of the season and three Europa League spots are allocated to the third, fourth and fifth teams. The last two teams are relegated to the Russian National Football League at the end of the season. The Russian Premier League was established in 2001 and succeeded the Top Division. The Top Division was run by the Professional Football League of Russia. Creation of the Premier League is considered to give the clubs a greater degree of independence. The league is currently called Rosgosstrakh Russian Football Championship for sponsorship reasons,\\r\\n\\r\\nCSKA Moscow is the current Russian Premier League champion."
                )
            )

            myList.add(
                LeaguesEntity(
                    idLeague = "4330",
                    strLeague = "Scottish Premier League",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/vw72bl1534096708.png",
                    strDescriptionEN = "The Scottish Premiership is the top division of the Scottish Professional Football League, the league competition for professional football clubs in Scotland. The Scottish Premiership was established in July 2013, after the Scottish Professional Football League was formed by a merger of the Scottish Premier League and Scottish Football League. Teams receive three points for a win and one point for a draw. No points are awarded for a loss. Teams are ranked by total points, then goal difference, and then goals scored. At the end of each season, the club with the most points is crowned league champion. If points are equal, the goal difference and then goals scored determine the winner."
                )
            )

            myList.add(
                LeaguesEntity(
                    idLeague = "4396",
                    strLeague = "English League 1",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/vm1qlp1535986713.png",
                    strDescriptionEN = "Football League One (often referred to as League One for short or Sky Bet League 1) is the second-highest division of the Football League and the third tier in the English football league system.\r\n\r\nFootball League One was introduced for the 2004–05 season. It was previously known as the Football League Second Division and prior to the advent of the Premier League, the Football League Third Division.\r\n\r\nAt present (2014–15 season), Oldham Athletic hold the longest tenure in League One, last being out of the division in the 1996–97 season when they were relegated from the Championship. There are currently six former Premier League clubs competing in the League One, namely Barnsley, Bradford City, Coventry City, Oldham Athletic, Sheffield United and Swindon Town.\r\nThere are 24 clubs in Football League One. Each club plays every other club twice (once at home and once away). Three points are awarded for a win, one for a draw and zero for a loss. At the end of the season a table of the final League standings is determined, based on the following criteria in this order: points obtained, goal difference, goals scored, an aggregate of the results between two or more clubs (ranked using the previous three criteria) and, finally, a series of one or more play-off matches.\r\n\r\nAt the end of each season the top two clubs, together with the winner of the play-offs between the clubs which finished in 3rd–6th position, are promoted to Football League Championship and are replaced by the three clubs that finished at the bottom of that division.\r\n\r\nSimilarly, the four clubs that finished at the bottom of Football League One are relegated to Football League Two and are replaced by the top three clubs and the club that won the 4th–7th place play-offs in that division.\r\nSky Sports currently show live League One matches with highlights shown on BBC One on their programme called The Football League Show, which also broadcasts highlights of Football League Championship and Football League Two matches. The show is available on the red button the following Sunday until midday and is available on iPlayer all the following week. Highlights of all games in the Football League are also available to view separately on the Sky Sports website. In Sweden, TV4 Sport has the rights of broadcasting from the league. A couple of league matches during the season of 09/10 including play-off matches and the play-off final to the Championship were shown. In Australia, Setanta Sports Australia broadcasts live Championship matches. In the USA and surrounding countries including Cuba, some Football League Championship, Football League One and Football League Two games are shown on beIN Sport."
                )
            )

            myList.add(
                LeaguesEntity(
                    idLeague = "4334",
                    strLeague = "French Ligue 1",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/8f5jmf1516458074.png",
                    strDescriptionEN = "Ligue 1 (French pronunciation: ​; League 1, formerly known as Division 1), is the French professional league for association football clubs. It is the country's primary football competition and serves as the top division of the French football league system. Ligue 1 is one of two divisions making up the Ligue de Football Professionnel, the other being Ligue 2. Contested by 20 clubs, it operates on a system of promotion and relegation with Ligue 2. Seasons run from August to May, with teams playing 38 games each totaling 380 games in the season. Most games are played on Saturdays and Sundays, with a few games played during weekday evenings. Play is regularly suspended the last weekend before Christmas for two weeks before returning in the second week of January. Ligue 1 is one of the top national leagues, currently ranked sixth in Europe behind the Spanish La Liga, English Premier League, the German Bundesliga, the Portuguese Primeira Liga and the Italian Serie A.\r\n\r\nLigue 1 was inaugurated on 11 September 1932 under the name National before switching to Division 1 after a year of existence. The name lasted until 2002 before switching to its current name. The current champions are Paris Saint-Germain, who won the 4th title of their history in the 2013–14 season.\r\n\r\nLigue 1 is generally regarded as competently run, with good planning of fixtures, complete and consistently enforced rules, timely resolution of issues, and adequate escalation procedures of judicial disputes to national or international institutions. The league has faced three significant corruption scandals in its history (Antibes in 1933, Red Star in the 1950s, and Marseille in 1993) and has preserved its reputation every time through swift and appropriately severe punishment of the guilty parties."
                )
            )

            myList.add(
                LeaguesEntity(
                    idLeague = "4331",
                    strLeague = "German Bundesliga",
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/0j55yv1534764799.png",
                    strDescriptionEN = "The Fußball-Bundesliga  (English: Football Federal League), commonly known as the Bundesliga, is a professional association football league in Germany and the football league with the highest average stadium attendance worldwide. At the top of the German football league system, the Bundesliga is Germany's primary football competition. The Bundesliga is contested by 18 teams and operates on a system of promotion and relegation with the 2. Bundesliga. Seasons run from August to May. Most games are played on Saturdays and Sundays, with a few games played during weekdays. All of the Bundesliga clubs qualify for the DFB-Pokal. The winner of the Bundesliga qualifies for the DFL-Supercup.\r\n\r\nA total of 53 clubs have competed in the Bundesliga since its founding. FC Bayern Munich has won the Bundesliga the most, winning the title 23 times. However, the Bundesliga has seen other champions with Borussia Dortmund, Hamburger SV, Werder Bremen, Borussia Mönchengladbach and VfB Stuttgart most prominent among them. The Bundesliga is one of the top national leagues, currently ranked 3rd in Europe according to UEFA's league coefficient ranking, based on recent European performances. The Bundesliga is the number one football league in the world in terms of average attendance; out of all sports, its average of 45,134 fans per game during the 2011–12 season was the second highest of any sports league in the world. The Bundesliga is broadcast on television in over 200 countries.\r\n\r\nThe Bundesliga was founded in 1962 in Dortmund and the first season started in 1963. The structure and organisation of the Bundesliga along with Germany's other football leagues have undergone frequent changes right up to the present day. The Bundesliga was originally founded by the Deutscher Fußball-Bund (English: German Football Association), but is now operated by the Deutsche Fußball Liga (English: German Football League)."
                )
            )

            return myList
        }

        fun generateAllLastEvent(): ArrayList<EventsEntity> {
            val events : ArrayList<EventsEntity> = ArrayList()

            events.add(
                EventsEntity(
                    idEvent = "602347",
                    idHomeTeam = "134301",
                    idAwayTeam = "133624",
                    idLeague = "4328",
                    strEvent = "Bournemouth vs Watford",
                    intHomeScore = "0",
                    intAwayScore = "3",
                    strHomeGoalDetails = "",
                    strAwayGoalDetails = "43':Abdoulaye Doucoure;65':Troy Deeney;90':Roberto Pereyra;",
                    strHomeYellowCards = "13':Adam Smith;",
                    strAwayYellowCards = "57':Troy Deeney;",
                    strHomeRedCards = "",
                    strAwayRedCards = "",
                    dateEvent = "2020-01-18",
                    strTime = "17:30:00"
                )
            )

            events.add(
                EventsEntity(
                    idEvent = "602347",
                    idHomeTeam = "134301",
                    idAwayTeam = "133624",
                    strEvent = "Bournemouth vs Watford",
                    intHomeScore = "0",
                    intAwayScore = "3",
                    strHomeGoalDetails = "",
                    strAwayGoalDetails = "43':Abdoulaye Doucoure;65':Troy Deeney;90':Roberto Pereyra;",
                    strHomeYellowCards = "13':Adam Smith;",
                    strAwayYellowCards = "57':Troy Deeney;",
                    strHomeRedCards = "",
                    strAwayRedCards = ""
                )
            )

            events.add(
                EventsEntity(
                    idEvent = "602347",
                    idHomeTeam = "134301",
                    idAwayTeam = "133624",
                    strEvent = "Bournemouth vs Watford",
                    intHomeScore = "0",
                    intAwayScore = "3",
                    strHomeGoalDetails = "",
                    strAwayGoalDetails = "43':Abdoulaye Doucoure;65':Troy Deeney;90':Roberto Pereyra;",
                    strHomeYellowCards = "13':Adam Smith;",
                    strAwayYellowCards = "57':Troy Deeney;",
                    strHomeRedCards = "",
                    strAwayRedCards = ""
                )
            )

            events.add(
                EventsEntity(
                    idEvent = "602347",
                    idHomeTeam = "134301",
                    idAwayTeam = "133624",
                    strEvent = "Bournemouth vs Watford",
                    intHomeScore = "0",
                    intAwayScore = "3",
                    strHomeGoalDetails = "",
                    strAwayGoalDetails = "43':Abdoulaye Doucoure;65':Troy Deeney;90':Roberto Pereyra;",
                    strHomeYellowCards = "13':Adam Smith;",
                    strAwayYellowCards = "57':Troy Deeney;",
                    strHomeRedCards = "",
                    strAwayRedCards = ""
                )
            )

            events.add(
                EventsEntity(
                    idEvent = "602347",
                    idHomeTeam = "134301",
                    idAwayTeam = "133624",
                    strEvent = "Bournemouth vs Watford",
                    intHomeScore = "0",
                    intAwayScore = "3",
                    strHomeGoalDetails = "",
                    strAwayGoalDetails = "43':Abdoulaye Doucoure;65':Troy Deeney;90':Roberto Pereyra;",
                    strHomeYellowCards = "13':Adam Smith;",
                    strAwayYellowCards = "57':Troy Deeney;",
                    strHomeRedCards = "",
                    strAwayRedCards = ""
                )
            )

            return events
        }

        fun generateEventNext(): ArrayList<EventsEntity> {
            val events: ArrayList<EventsEntity> = ArrayList()

            events.add(
                EventsEntity(
                    idEvent = "602349",
                    idHomeTeam = "134777",
                    idAwayTeam = "133610",
                    idLeague = "4328",
                    strEvent = "Newcastle vs Chelsea",
                    dateEvent = "2020-01-18",
                    strTime = "17:30:00"
                )
            )

            events.add(
                EventsEntity(
                    idEvent = "602349",
                    idHomeTeam = "134777",
                    idAwayTeam = "133610",
                    idLeague = "4328",
                    strEvent = "Newcastle vs Chelsea",
                    dateEvent = "2020-01-18",
                    strTime = "17:30:00"
                )
            )

            events.add(
                EventsEntity(
                    idEvent = "602349",
                    idHomeTeam = "134777",
                    idAwayTeam = "133610",
                    idLeague = "4328",
                    strEvent = "Newcastle vs Chelsea",
                    dateEvent = "2020-01-18",
                    strTime = "17:30:00"
                )
            )

            events.add(
                EventsEntity(
                    idEvent = "602349",
                    idHomeTeam = "134777",
                    idAwayTeam = "133610",
                    idLeague = "4328",
                    strEvent = "Newcastle vs Chelsea",
                    dateEvent = "2020-01-18",
                    strTime = "17:30:00"
                )
            )

            events.add(
                EventsEntity(
                    idEvent = "602349",
                    idHomeTeam = "134777",
                    idAwayTeam = "133610",
                    idLeague = "4328",
                    strEvent = "Newcastle vs Chelsea",
                    dateEvent = "2020-01-18",
                    strTime = "17:30:00"
                )
            )

            return events
        }

        fun generateTeam(): ArrayList<TeamsEntity> {
            val teams: ArrayList<TeamsEntity> = ArrayList()

            teams.add(
                TeamsEntity(
                    idTeam = "133604",
                    strTeam = "Arsenal",
                    strStadium = "https://www.thesportsdb.…ium/qpuxrr1419371354.jpg",
                    strTeamBadge = 	"https://www.thesportsdb.…dge/a1af2i1557005128.png",
                    strStadiumLocation = "Holloway, London"
                )
            )

            teams.add(
                TeamsEntity(
                    idTeam = "133604",
                    strTeam = "Arsenal",
                    strStadium = "https://www.thesportsdb.…ium/qpuxrr1419371354.jpg",
                    strTeamBadge = 	"https://www.thesportsdb.…dge/a1af2i1557005128.png",
                    strStadiumLocation = "Holloway, London"
                )
            )

            teams.add(
                TeamsEntity(
                    idTeam = "133604",
                    strTeam = "Arsenal",
                    strStadium = "https://www.thesportsdb.…ium/qpuxrr1419371354.jpg",
                    strTeamBadge = 	"https://www.thesportsdb.…dge/a1af2i1557005128.png",
                    strStadiumLocation = "Holloway, London"
                )
            )

            teams.add(
                TeamsEntity(
                    idTeam = "133604",
                    strTeam = "Arsenal",
                    strStadium = "https://www.thesportsdb.…ium/qpuxrr1419371354.jpg",
                    strTeamBadge = 	"https://www.thesportsdb.…dge/a1af2i1557005128.png",
                    strStadiumLocation = "Holloway, London"
                )
            )

            teams.add(
                TeamsEntity(
                    idTeam = "133604",
                    strTeam = "Arsenal",
                    strStadium = "https://www.thesportsdb.…ium/qpuxrr1419371354.jpg",
                    strTeamBadge = 	"https://www.thesportsdb.…dge/a1af2i1557005128.png",
                    strStadiumLocation = "Holloway, London"
                )
            )

            return teams
        }
    }
}