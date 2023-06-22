package controller;

import http.HttpRequest;
import http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
