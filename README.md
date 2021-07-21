# Twitrends
Tool to Analyze Twitter Trending Topics, Hashtags or Keyword with 2D and 3D visualisation

Analysing twitter trending topic that observes user characteristics of a certain trending topic/hashtags. Some indication of trending hash tag is considered curious:
- mainly promoted by relatively new accounts 
- most of them are having few followers
- some of them tweet an unusual amount of tweet per user

All of these indicator are just a hunch, no solid base.

*Note: Twitrends is new updated from the original tool called ["curious-trends"](https://github.com/wibisono/curious-trends) created by Wibisono*

Built using:
* [udash.io](http://udash.io) framework
* [udash g8](https://github.com/UdashFramework/udash.g8) scaffolding as starting point.
* [twitter4s](https://github.com/DanielaSfregola/twitter4s) for twitter client.

*WARNING*

Still experimental:
- no persistence, no rate limit throttling so you might hit free rate limit 
- hashtags were just appended everytime you open another trends link
- trying to push data from backend to frontend for updates, but when tracking keywords that are not frequently mentioned you might endup with blank page with no data.

# Installation

- You have to install [scala](https://www.scala-sbt.org/download.html) on your machine.

- And then download or clone the repository:

Type:

    git clone https://github.com/horiz0ec3/Twitrends.git

See full installation [here](https://xploitlab.com/twitrends)

# Starting App

First configure twitter settings:
* Open *twitter.conf* file
* Setup your twitter API keys in that file.

Perpare the build with:

    sbt compileStatics
    
Then you can run:

    sbt run
    
    
http://localhost:9000/#/trends/[hashtag] to see current state of curious trend of [hashtag], should be pushing live update from backend. Everytime you open this endpoint with additional hashtag it will accumulate, and the more you did this you might hit twitter Rate limit for your API. Either that or memory limit at some point, current implementation has no backend/persistence support.

http://localhost:9000/assets/2d/  to see 2d visualization using d3 js. Improper integration with d3 js assuming you run this without modification on port 9000 on localhost. Still don't know how to properly use udash for this.

http://localhost:9000/assets/3d/  the 3d visualization. For both of these visualization, no live update/push from backend, it's pull based you need to refresh to get the latest data.


This is an example of normal generic trending topics user characteristics looks like (ramos after dirty wins of Real madrid):
![image](https://i.imgur.com/aq1KBgm.png)


Meanwhile, visualization of retweet graph using d3.js 3d force graph:

![image](https://i.imgur.com/QSBRKwB.jpg)

# Thanks to:

* [Adianto Wibisono](https://github.com/wibisono/) The first creator of this tool
