# Applet

The `runescape.jar` was originally embedded on a webpage using the `<applet>`
element.

The [parameters](./parameters.md) of the client are configured using the
`<param>` element.

Below is an example of how it occurred on the original RuneScape website:

```html
<applet name="RuneScape" id="game" width="100%" height="100%" archive="runescape.jar" code="client.class" mayscript>
  <param name="java_arguments" value="-Xmx256m -Dsun.java2d.noddraw=true">
  <param name="colourid" value="0">
  <param name="worldid" value="1">
  <param name="lobbyid" value="1000">
  <param name="lobbyaddress" value="127.0.0.1">
  <param name="modewhere" value="0">
  <param name="modewhat" value="0">
  <param name="lang" value="0">
  <param name="objecttag" value="0">
  <param name="js" value="1">
  <param name="game" value="0">
  <param name="affid" value="0">
  <param name="advert" value="1">

  <param name="settings" value="wwGlrZHF5gJcZl7tf7KSRh0MZLhiU0gI0xDX6DwZ-Qk">
  <param name="country" value="0">
  <!--[if lt IE 7]>
  <param name=haveie6 value=1>
  <![endif]-->
  <![if gte IE 7]>
  <param name="haveie6" value="0">
  <![endif]>
  <param name="havefirefox" value="0">
  <param name="cookieprefix" value="">
  <param name="cookiehost" value=".runescape.com">
  <param name="cachesubdirid" value="0">
  <param name="crashurl" value="">
  <param name="unsignedurl" value="">
  <param name="sitesettings_member" value="1">
  <param name="frombilling" value="false">
  <param name="sskey" value="">
  <param name="force64mb" value="false">
  <param name="worldflags" value="8">
  <div class="nojava">
    <div>It seems like Java is not installed on your computer</div>Java is a free download that is required to play RuneScape. <a href="http://www.java.com/en/download/index.jsp" target="_blank">Click here to install Java</a>.<br><br>If you believe you already have Java installed then you might get this message if it is disabled. <a href="http://java.com/en/download/help/enable_browser.xml" target="_blank">Click here for instructions on enabling Java</a>.
  </div>
</applet>

```
