package com.apitore.api.org.jsoup.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apitore.banana.response.org.jsoup.LinkResponseEntity;
import com.apitore.banana.response.org.jsoup.TextResponseEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @author Keigo Hattori
 */
@RestController
@RequestMapping(value = "/jsoup")
public class JsoupController {

  private final Logger LOG = Logger.getLogger(JsoupController.class);

  final String NOTES = "Jsoup Web scraper.<BR />"
      + "Response<BR />"
      + "&nbsp; Github: <a href=\"https://github.com/keigohtr/apitore-response-parent/tree/master/jsoup-response\">jsoup-response</a><BR />";

  final String NOTES1 = NOTES
      + "&nbsp; Class: com.apitore.banana.response.org.jsoup.TextResponseEntity<BR />";

  final String NOTES2 = NOTES
      + "&nbsp; Class: com.apitore.banana.response.org.jsoup.LinkResponseEntity<BR />";


  @RequestMapping(value="/open/url2text", method=RequestMethod.GET)
  @ApiIgnore
  public ResponseEntity<TextResponseEntity> url2text(
      @RequestParam("url") String url
      ) {

    TextResponseEntity model = new TextResponseEntity();
    Long startTime = System.currentTimeMillis();

    LOG.info(url);
    String text="";
    int i=0;
    while (i<5) {
      try {
        text = Jsoup.connect(url).get().text();
        break;
      } catch (Exception ex) {
        i++;
        System.err.println("  "+i+" try again.");
      }
    }

    model.setText(text);
    Long endTime = System.currentTimeMillis();
    Long processTime = endTime-startTime;
    model.setStartTime(startTime.toString());
    model.setEndTime(endTime.toString());
    model.setProcessTime(processTime.toString());
    return new ResponseEntity<TextResponseEntity>(model,HttpStatus.OK);
  }

  /**
   * 公開用API
   * Dummyメソッド
   *
   * @param model
   * @param q
   * @return
   */
  @RequestMapping(value = {"/url2text"}, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
  @ApiOperation(value="URL to TEXT", notes=NOTES1)
  public TextResponseEntity url2text(
      @ApiParam(value = "Access Token", required = true)
      @RequestParam("access_token")  String access_token,
      @ApiParam(value = "URL", required = true)
      @RequestParam("url")      String url)
  {
    return new TextResponseEntity();
  }


  @RequestMapping(value="/open/url2html", method=RequestMethod.GET)
  @ApiIgnore
  public ResponseEntity<TextResponseEntity> url2html(
      @RequestParam("url") String url
      ) {

    TextResponseEntity model = new TextResponseEntity();
    Long startTime = System.currentTimeMillis();

    LOG.info(url);
    String text="";
    int i=0;
    while (i<5) {
      try {
        text = Jsoup.connect(url).get().html();
        break;
      } catch (Exception ex) {
        i++;
        System.err.println("  "+i+" try again.");
      }
    }

    model.setText(text);
    Long endTime = System.currentTimeMillis();
    Long processTime = endTime-startTime;
    model.setStartTime(startTime.toString());
    model.setEndTime(endTime.toString());
    model.setProcessTime(processTime.toString());
    return new ResponseEntity<TextResponseEntity>(model,HttpStatus.OK);
  }

  /**
   * 公開用API
   * Dummyメソッド
   *
   * @param model
   * @param q
   * @return
   */
  @RequestMapping(value = {"/url2html"}, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
  @ApiOperation(value="Extract HTML from URL", notes=NOTES1)
  public TextResponseEntity url2html(
      @ApiParam(value = "Access Token", required = true)
      @RequestParam("access_token")  String access_token,
      @ApiParam(value = "URL", required = true)
      @RequestParam("url")      String url)
  {
    return new TextResponseEntity();
  }


  @RequestMapping(value="/open/url2href", method=RequestMethod.GET)
  @ApiIgnore
  public ResponseEntity<LinkResponseEntity> url2href(
      @RequestParam("url") String url
      ) {

    LinkResponseEntity model = new LinkResponseEntity();
    Long startTime = System.currentTimeMillis();

    LOG.info(url);
    List<String> links = model.getLinks();
    Document document = null;
    int i=0;
    while (i<5) {
      try {
        document = Jsoup.connect(url).get();
        break;
      } catch (Exception ex) {
        i++;
        System.err.println("  "+i+" try again.");
      }
    }
    if (document != null) {
      Elements elm = document.select("a[href]");
      for (Element e: elm) {
        String anchar = e.attr("abs:href");
        if (!links.contains(anchar))
          links.add(anchar);
      }
    }

    model.setLinks(links);
    Long endTime = System.currentTimeMillis();
    Long processTime = endTime-startTime;
    model.setStartTime(startTime.toString());
    model.setEndTime(endTime.toString());
    model.setProcessTime(processTime.toString());
    return new ResponseEntity<LinkResponseEntity>(model,HttpStatus.OK);
  }

  /**
   * 公開用API
   * Dummyメソッド
   *
   * @param model
   * @param q
   * @return
   */
  @RequestMapping(value = {"/url2href"}, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
  @ApiOperation(value="Extract href links from URL", notes=NOTES2)
  public LinkResponseEntity url2href(
      @ApiParam(value = "Access Token", required = true)
      @RequestParam("access_token")  String access_token,
      @ApiParam(value = "URL", required = true)
      @RequestParam("url")      String url)
  {
    return new LinkResponseEntity();
  }


  @RequestMapping(value="/open/url2src", method=RequestMethod.GET)
  @ApiIgnore
  public ResponseEntity<LinkResponseEntity> url2src(
      @RequestParam("url") String url
      ) {

    LinkResponseEntity model = new LinkResponseEntity();
    Long startTime = System.currentTimeMillis();

    LOG.info(url);
    List<String> links = model.getLinks();
    Document document = null;
    int i=0;
    while (i<5) {
      try {
        document = Jsoup.connect(url).get();
        break;
      } catch (Exception ex) {
        i++;
        System.err.println("  "+i+" try again.");
      }
    }
    if (document != null) {
      Elements elm = document.select("img");
      for (Element e: elm) {
        String anchar = e.attr("abs:src");
        if (!links.contains(anchar))
          links.add(anchar);
      }
    }

    model.setLinks(links);
    Long endTime = System.currentTimeMillis();
    Long processTime = endTime-startTime;
    model.setStartTime(startTime.toString());
    model.setEndTime(endTime.toString());
    model.setProcessTime(processTime.toString());
    return new ResponseEntity<LinkResponseEntity>(model,HttpStatus.OK);
  }

  /**
   * 公開用API
   * Dummyメソッド
   *
   * @param model
   * @param q
   * @return
   */
  @RequestMapping(value = {"/url2src"}, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
  @ApiOperation(value="Extract img src links from URL", notes=NOTES2)
  public LinkResponseEntity url2src(
      @ApiParam(value = "Access Token", required = true)
      @RequestParam("access_token")  String access_token,
      @ApiParam(value = "URL", required = true)
      @RequestParam("url")      String url)
  {
    return new LinkResponseEntity();
  }

}
